import scala.annotation.tailrec

sealed trait Tree[+T] {
  def size: Int

  def depth: Int

  def foreach(action: T => Unit): Unit

  def map[P](mapper: T => P)(implicit ordering: Ordering[P]): Tree[P]

  def flatMap[P](mapper: T => Tree[P])(implicit ordering: Ordering[P]): Tree[P]
}

final case class Node[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override val size: Int = left.size + right.size + 1
  override val depth: Int = Math.max(left.depth, right.depth) + 1
  val diff: Int = left.depth - right.depth

  override def foreach(action: T => Unit): Unit = {
    left.foreach(action)
    action(value)
    right.foreach(action)
  }

  override def map[P](mapper: T => P)(implicit ordering: Ordering[P]): Tree[P] = {
    var result = Tree()
    for (i <- this) {
      result = Tree.add(mapper(i), result)
    }
    result
  }

  override def flatMap[P](mapper: T => Tree[P])(implicit ordering: Ordering[P]): Tree[P] = {
    var result = Tree()
    for {
      i <- this
      j <- mapper(i)
    } result = Tree.add(j, result)

    result
  }
}

case object Leaf extends Tree[Nothing] {
  override val size = 0
  override val depth = 0

  override def foreach(action: Nothing => Unit): Unit = {}

  override def map[P](mapper: Nothing => P)(implicit ordering: Ordering[P]): Tree[P] = this

  override def flatMap[P](mapper: Nothing => Tree[P])(implicit ordering: Ordering[P]): Tree[P] = this
}

object Tree {

  def apply[T](values: T*)(implicit ordering: Ordering[T]): Tree[T] = {
    var result: Tree[T] = Leaf
    for (elem <- values) {
      result = Tree.add(elem, result)
    }
    result
  }

  def add[T](toAdd: T, tree: Tree[T])(implicit ordering: Ordering[T]): Tree[T] = {
    tree match {
      case Leaf => Node(toAdd, Leaf, Leaf)
      case tree@Node(value, left, right) =>
        import ordering._
        val result = if (toAdd == value) {
          tree
        } else if (toAdd < value) {
          val newLeft = add(toAdd, left)
          Node(value, newLeft, right)
        } else {
          val newRight = add(toAdd, right)
          Node(value, left, newRight)
        }

        balance(result)
    }
  }

  @tailrec
  def contains[T](toFind: T, tree: Tree[T])(implicit ordering: Ordering[T]): Boolean =
    tree match {
      case Leaf => false
      case Node(value, left, right) =>
        import ordering._
        if (value == toFind) {
          true
        } else if (toFind < value) {
          contains(toFind, left)
        } else {
          contains(toFind, right)
        }
    }

  def remove[T](toRemove: T, tree: Tree[T])(implicit ordering: Ordering[T]): Tree[T] = tree match {
    case Node(value, left, right) if value == toRemove =>

      if (left.depth < right.depth) {
        Tree.mostLeft(right) match {
          case Some(closest) => Node(closest, left, remove(closest, right))
          case None => left
        }
      } else {
        Tree.mostRight(left) match {
          case Some(closest) => Node(closest, remove(closest, left), right)
          case None => right
        }
      }

    case Node(value, left, right) =>
      import ordering._
      val treeWithoutElem = if (toRemove < value) {
        Node(value, remove(toRemove, left), right)
      } else {
        Node(value, left, remove(toRemove, right))
      }

      balance(treeWithoutElem)
  }

  /**
    * Notation for this balance method is taken from
    * [here](https://ru.wikipedia.org/wiki/%D0%90%D0%92%D0%9B-%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE)
    */
  private def balance[T](tree: Node[T]): Tree[T] = tree match {

    case Node(_, left, right) if Math.abs(left.depth - right.depth) <= 1 => tree

    case Node(aVal, l, b@Node(bVal, c, r))
      if b.depth - l.depth == 2 && c.depth <= r.depth => Node(bVal, Node(aVal, l, c), r)

    case Node(aVal, b@Node(bVal, l, c), r)
      if b.depth - r.depth == 2 && c.depth <= l.depth => Node(bVal, l, Node(aVal, c, r))

    case Node(aVal, l, b@Node(bVal, c@Node(cVal, m, n), r))
      if b.depth - l.depth == 2 && c.depth > r.depth => Node(cVal, Node(aVal, l, m), Node(bVal, n, r))

    case Node(aVal, b@Node(bVal, l, c@Node(cVal, m, n)), r)
      if b.depth - r.depth == 2 && c.depth > l.depth => Node(cVal, Node(bVal, l, m), Node(aVal, n, r))

    case _ => throw new IllegalArgumentException(s"Invalid tree $tree, cannot perform rotation!")
  }

  @tailrec
  private def mostLeft[T](tree: Tree[T]): Option[T] = tree match {
    case Node(_, left: Node[T], _) => mostLeft(left)
    case Node(elem, Leaf, _) => Some(elem)
    case Leaf => None
  }

  @tailrec
  private def mostRight[T](tree: Tree[T]): Option[T] = tree match {
    case Node(_, _, right: Node[T]) => mostRight(right)
    case Node(elem, _, Leaf) => Some(elem)
    case Leaf => None
  }

}

object Main {
  def main(args: Array[String]): Unit = {
    var tree: Tree[Int] = Leaf
    tree = Tree.add(10, tree)
    tree = Tree.add(20, tree)
    tree = Tree.add(1, tree)
    tree = Tree.add(3, tree)

    println(tree)
  }
}