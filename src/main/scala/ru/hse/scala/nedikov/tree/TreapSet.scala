package ru.hse.scala.nedikov.tree

class TreapSet[A] private(private val treap: Treap[A] = TreapEmpty)
                         (implicit ord: Ordering[A]) extends ImmutableCollection [A, TreapSet[A]] {

  override def count: Int = treap.size

  override def contains(value: A): Boolean = Treap.contains(treap, value)

  override def containsAll(from: ImmutableCollection[A, TreapSet[A]]): Boolean =
    from.foldLeft(true)((b, elem) => b && contains(elem))

  override def add(value: A): TreapSet[A] =
    if (contains(value)) this else TreapSet(Treap.add(treap, value))

  override def addAll(from: ImmutableCollection[A, TreapSet[A]]): TreapSet[A] =
    from.foldLeft(this)(_ + _)

  override def remove(value: A): TreapSet[A] =
    if (contains(value)) TreapSet(Treap.remove(treap, value)) else this

  override def removeAll(from: ImmutableCollection[A, TreapSet[A]]): TreapSet[A] =
    from.foldLeft(this)(_ - _)

  override def copyToArray(array: Array[A], start: Int): Unit = {
    var i: Int = start
    forEach((value: A) => {
      array(i) = value
      i = i + 1
    })
  }

  def map[B](f: A => B)(implicit ordB: Ordering[B]): TreapSet[B] =
    foldLeft(TreapSet.empty[B])(_ + f(_))

  def flatMap[B](f: A => TreapSet[B])(implicit ordB: Ordering[B]): TreapSet[B] =
    foldLeft(TreapSet.empty[B])(_ ++ f(_))

  def filter(f: A => Boolean): TreapSet[A] =
    foldLeft(TreapSet.empty[A])((set, v) => if (f(v)) set + v else set)


  override def toIterator: MyIterator[A] = new TreapIterator

  private class TreapIterator extends MyIterator[A] {
    var stack: SimpleList[TreapNode[A]] = Nil

    {
      fillStackFromLeft(treap)
    }

    def fillStackFromLeft(treap: Treap[A]): Unit = treap match {
      case TreapEmpty =>
      case t @ TreapNode(_, _, left, _) =>
        stack = t::stack
        fillStackFromLeft(left)
    }

    override def hasNext: Boolean = stack.nonEmpty

    override def next: A = stack match {
      case Nil      => throw new NoSuchElementException
      case z::tail =>
    stack = tail
    fillStackFromLeft(z.right)
    z.key
    }
  }

}

object TreapSet {
  private def apply[A](treap: Treap[A])(implicit ord: Ordering[A]) = new TreapSet(treap)

  def empty[A](implicit ord: Ordering[A]): TreapSet[A] = new TreapSet(TreapEmpty)

  def from[A](values: A*)(implicit ord: Ordering[A]): TreapSet[A] = values.foldLeft(empty[A])(_ + _)
  def apply[A](values: A*)(implicit ord: Ordering[A]): TreapSet[A] = values.foldLeft(empty[A])(_ + _)
}
