package ru.spbau.jvm.scala.tree

class AVLTreeSet[A] private (private val tree: AVLTree[A] = AVLNil)(implicit ordA: Ordering[A]) extends MySet[A, AVLTreeSet[A]] {
  private lazy val size_ = AVLTree.count(tree)

  def iterator: MyIterator[A] = new AVLTreeIterator()

  override def contains(value: A): Boolean = AVLTree.contains(tree)(value)

  override def add(value: A): AVLTreeSet[A] =
    if (contains(value)) this
    else new AVLTreeSet(AVLTree.insert(tree)(value))

  override def remove(value: A): AVLTreeSet[A] =
    if (contains(value)) new AVLTreeSet(AVLTree.remove(tree)(value))
    else this

  override def size: Int = size_

  def map[B](f: A => B)(implicit ordB: Ordering[B]): MySet[B, AVLTreeSet[B]] =
    foldLeft(AVLTreeSet.empty[B])((set, elem) => set + f(elem))

  def flatMap[B](f: A => MyBaseSet[B])(implicit ordB: Ordering[B]): MySet[B, AVLTreeSet[B]] =
    foldLeft(AVLTreeSet.empty[B])((set, elem) => set ++ f(elem))

  def filter(p: A => Boolean): AVLTreeSet[A] =
    foldLeft(AVLTreeSet.empty[A])((set, elem) => if (p(elem)) set + elem else set)

  def foreach[U](f: A => U): Unit = {
    val it = iterator
    while (it.hasNext) {
      f(it.next)
    }
  }

  override def empty: AVLTreeSet[A] = new AVLTreeSet()

  override def intersect(other: MyBaseSet[A]): AVLTreeSet[A] = filter(other.contains)

  override def union(other: MyBaseSet[A]): AVLTreeSet[A] = addAll(other)

  override def diff(other: MyBaseSet[A]): AVLTreeSet[A] = this -- other

  class AVLTreeIterator extends MyIterator[A] {
    private var stack: MyList[AVLTree[A]] = MyNil

    {
      goLeft(tree)
    }

    private def goLeft(tree: AVLTree[A]): Unit = {
      var node = tree
      while (node != AVLNil) {
        stack = MyCons(node, stack)
        val AVLNode(_, left: AVLTree[A], _) = node
        node = left
      }
    }

    def hasNext: Boolean = stack.nonEmpty

    def next: A = stack match {
      case MyNil => throw new NoSuchElementException()
      case MyCons(node, st) =>
        stack = st
        node match {
          case AVLNil => throw new IllegalStateException()
          case AVLNode(key, _, right) =>
            goLeft(right)
            key
        }

    }
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[AVLTreeSet[A]]

  override def equals(other: Any): Boolean = other match {
    case that: AVLTreeSet[A] =>
      (that canEqual this) &&
        size_ == that.size_ &&
        tree == that.tree
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(size_, tree)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

object AVLTreeSet {
  def empty[A](implicit ordA: Ordering[A]): AVLTreeSet[A] = new AVLTreeSet[A]()

  def from[A](values: A*)(implicit ordA: Ordering[A]): AVLTreeSet[A] = empty ++ values

  def from[A](set: AVLTreeSet[A])(implicit ordA: Ordering[A]): AVLTreeSet[A] = empty ++ set

  def fromSeq[A](seq: Seq[A])(implicit ordA: Ordering[A]): AVLTreeSet[A] = empty ++ seq
}