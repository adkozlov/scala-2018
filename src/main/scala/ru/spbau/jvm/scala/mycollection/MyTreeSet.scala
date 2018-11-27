package ru.spbau.jvm.scala.mycollection

import scala.reflect.ClassTag

class MyTreeSet[A: ClassTag](implicit ordering: Ordering[A]) extends Set[A] {

  import MyTreeSet._
  import ordering.mkOrderingOps

  private var root: TreeNode[A] = Nil

  private var treeSize: Int = 0

  override def iterator: Iterator[A] = new TreeSetIterator(root)

  override def contains(key: A): Boolean = find(root, key) match {
    case Branch(_, _, _) => true
    case Nil => false
  }

  override def +=(elem: A): MyTreeSet.this.type = {
    add(elem)
    this
  }

  override def -=(elem: A): MyTreeSet.this.type = {
    remove(elem)
    this
  }

  def add(key: A): Boolean = {
    val result = !contains(key)
    if (result)
      treeSize += 1
    val (t1, t2) = split(key, root)
    root = merge(merge(t1, Branch(Nil, key, Nil)), t2)
    result
  }

  def remove(key: A): Boolean = {
    if (contains(key))
      treeSize -= 1
    else
      return false
    val (t1, _) = split(key, root)
    val (_, t2) = split(key, root, pivotToLeft = true)
    root = merge(t1, t2)
    true
  }

  override def map[B: ClassTag](f: A => B)(implicit ordering: Ordering[B]): MyTreeSet[B] = {
    val res = new MyTreeSet[B]
    foreach(elem => res += f(elem))
    res
  }

  override def empty(): MyTreeSet[A] = new MyTreeSet[A]

  override def flatMap[B: ClassTag](f: A => Iterable[B])(implicit ordering: Ordering[B]): MyTreeSet[B] = {
    val result = new MyTreeSet[B]
    foreach(elem => result ++= f(elem))
    result
  }

  override def size: Int = treeSize

  override def toArray: Array[A] = {
    val array = new Array[A](treeSize)
    var i = 0
    foreach(elem => {
      array(i) = elem
      i += 1
    })
    array
  }

  override def clear(): Unit = {
    root = Nil
    treeSize = 0
  }

  override def filter(p: A => Boolean): MyTreeSet[A] = {
    val result = new MyTreeSet[A]()
    foreach(elem => {
      if (p(elem))
        result += elem
    })
    result
  }

  def withFilter(p: A => Boolean): WithFilter = new WithFilter(p)

  private def find(node: TreeNode[A], key: A): TreeNode[A] = node match {
    case Branch(left, value, right) =>
      if (value == key) node
      else if (key > value) find(right, key)
      else find(left, key)
    case Nil => node
  }

  class WithFilter(val p: A => Boolean) {
    def flatMap[B: ClassTag](f: A => Iterable[B])(implicit ordering: Ordering[B]): MyTreeSet[B] =
      filter(p).flatMap(f)

    def foreach[U](f: A => U): Unit = filter(p).foreach(f)

    def map[B: ClassTag](f: A => B)(implicit ordering: Ordering[B]): MyTreeSet[B] = filter(p).map(f)

    def withFilter(q: A => Boolean): WithFilter = new WithFilter(elem => p(elem) && q(elem))
  }

}


object MyTreeSet {
  private def merge[A](t1: TreeNode[A], t2: TreeNode[A]): TreeNode[A] = (t1, t2) match {
    case (Nil, _) => t2
    case (_, Nil) => t1
    case (b1@Branch(l1, x1, r1), b2@Branch(l2, x2, r2)) =>
      if (b1.priority > b2.priority) Branch(l1, x1, merge(r1, b2))
      else Branch(merge(b1, l2), x2, r2)
  }

  private def split[A](pivot: A, tree: TreeNode[A], pivotToLeft: Boolean = false)
                      (implicit ordering: Ordering[A]): (TreeNode[A], TreeNode[A]) = {
    val comparator = if (pivotToLeft) ordering.gteq _ else ordering.gt _
    tree match {
      case Nil => (Nil, Nil)
      case Branch(l, x, r) =>
        if (comparator(pivot, x)) {
          val (t1, t2) = split(pivot, r, pivotToLeft)
          (Branch(l, x, t1), t2)
        } else {
          val (t1, t2) = split(pivot, l, pivotToLeft)
          (t1, Branch(t2, x, r))
        }
    }
  }


  abstract sealed class TreeNode[+A]

  case class Branch[A](var left: TreeNode[A], value: A, right: TreeNode[A]) extends TreeNode[A] {
    val priority: Int = scala.util.Random.nextInt
  }

  class TreeSetIterator[A](root: TreeNode[A]) extends Iterator[A] {

    private var stack: MyList[TreeNode[A]] = ListNil

    {
      goToNext(root)
    }

    override def hasNext: Boolean = !stack.isEmpty

    override def next(): A = stack match {
      case ListNil => throw new NoSuchElementException
      case Cons(value, tail) =>
        stack = tail
        val Branch(_, x, right) = value
        goToNext(right)
        x
    }

    def goToNext(node: TreeNode[A]): Unit = node match {
      case Nil =>
      case Branch(l, _, _) =>
        stack = Cons(node, stack)
        goToNext(l)
    }
  }

  object Nil extends TreeNode

}
