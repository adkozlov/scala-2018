package homework.scala.set

object Set {
  def apply[A](values: A*)(implicit ordering: Ordering[A]): Tree[A] = {
    var tree: Tree[A] = Leaf()
    for (value <- values) {
      tree = tree.insert(value)
    }
    tree
  }

  def apply[A]: Tree[A] = Leaf()
}


sealed trait Tree[A] {
  def height: Int

  def balance: Int

  def size: Int

  def isEmpty: Boolean = size == 0

  def contains(element: A)(implicit ord: Ordering[A]): Boolean

  def foldLeft[U](acc: U)(f: (U, A) => U): U

  def foreach(f: A => Unit): Unit

  def map[U <: Comparable[U]](f: A => U): Tree[U] = foldLeft[Tree[U]](Leaf())((tree, element) => tree.insert(f(element)))

  def withFilter(predicate: A => Boolean)(implicit ord: Ordering[A]): Tree[A] = foldLeft[Tree[A]](Leaf())((tree: Tree[A], element: A) => if (predicate(element)) tree.insert(element) else tree)

  private[set] def insert(element: A)(implicit ord: Ordering[A]): Node[A]

  def | (tree: Tree[A])(implicit ord: Ordering[A]): Tree[A] = {
    var newTree : Tree[A] = new Leaf[A]
    foreach(element => newTree = newTree.insert(element))
    tree.foreach(element => newTree = newTree.insert(element))
    newTree
  }

  def & (tree: Tree[A])(implicit ord: Ordering[A]): Tree[A] = withFilter(element => tree.contains(element))
}

case class Leaf[A]() extends Tree[A] {
  override def foreach(f: A => Unit): Unit = Unit

  override def foldLeft[U](acc: U)(f: (U, A) => U): U = acc

  override def height: Int = 0

  override def balance: Int = 0

  override def size: Int = 0

  override def equals(obj: Any): Boolean = obj.isInstanceOf[Leaf[A]]

  override def contains(element: A)(implicit ord: Ordering[A]): Boolean = false

  private[set] override def insert(element: A)(implicit ord: Ordering[A]): Node[A] = new Node[A](element, Leaf(), Leaf())
}

case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A] {
  override def height: Int = Math.max(left.height, right.height) + 1

  override def balance: Int = left.height - right.height

  override def size: Int = left.size + right.size + 1

  override def equals(obj: Any): Boolean = obj match {
    case Node(v, l, r) => value == v && l.equals(left) && r.equals(right)
    case _ => false
  }

  override def contains(element: A)(implicit ord: Ordering[A]): Boolean =
    if (value == element) true else if (ord.lt(value, element)) right.contains(element) else left.contains(element)

  private[set] override def insert(element: A)(implicit ord: Ordering[A]): Node[A] = if (value == element) this else if (ord.lt(value, element)) Node(value, left, right.insert(element)).balanceTree else Node(value, left.insert(element), right).balanceTree

  override def foreach(func: A => Unit): Unit = {
    left.foreach(func)
    func(value)
    right.foreach(func)
  }

  override def foldLeft[U](acc: U)(func: (U, A) => U): U = right.foldLeft(func(left.foldLeft(acc)(func), value))(func)

  private def balanceTree: Node[A] = {
    if (balance == -2 && right.balance > 0)
      return Node[A](value, left, right.asInstanceOf[Node[A]].rightRotate()).leftRotate()
    if (balance == -2)
      return leftRotate()
    if (balance == 2 && left.balance < 0)
      return Node[A](value, left, right.asInstanceOf[Node[A]].leftRotate()).rightRotate()
    if (balance == 2)
      return rightRotate()
    this
  }

  private def leftRotate(): Node[A] = right match {
    case Node(valueChild, lChild, rChild) => Node[A](valueChild, Node[A](value, left, lChild), rChild)
    case _ => this
  }

  private def rightRotate(): Node[A] = left match {
    case Node(valueChild, lChild, rChild) => Node[A](valueChild, lChild, Node[A](value, rChild, right))
    case _ => this
  }
}