package ru.spbau.jvm.scala.tree

trait MyIterable[A] {
  def size: Int
  def isEmpty: Boolean = size == 0
  def nonEmpty: Boolean = !isEmpty

  def iterator: MyIterator[A]
  def foreach[U](f: A => U): Unit

  def foldLeft[B](z: B)(op: (B, A) => B): B = {
    var result = z
    this foreach (x => result = op(result, x))
    result
  }

  def foldRight[B](z: B)(op: (A, B) => B): B = reversed.foldLeft(z)((x, y) => op(y, x))

  def forall(p: A => Boolean): Boolean = foldLeft(true)(_ && p(_))

  // for internal use
  protected[this] def reversed: List[A] = {
    var elems: List[A] = Nil
    foreach (elems ::= _)
    elems
  }
}
