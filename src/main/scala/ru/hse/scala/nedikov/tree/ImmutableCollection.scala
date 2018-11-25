package ru.hse.scala.nedikov.tree

trait ImmutableCollection[A, Collection <: ImmutableCollection[A, Collection]] {
  def isEmpty: Boolean = count == 0
  def count: Int
  def contains(value: A): Boolean
  def containsAll(from: ImmutableCollection[A, Collection]): Boolean
  def copyToArray(array: Array[A]): Unit = copyToArray(array, 0)
  def copyToArray(array: Array[A], start: Int): Unit
  def add(value: A): Collection
  def addAll(from: ImmutableCollection[A, Collection]): Collection
  def remove(value: A): Collection
  def removeAll(from: ImmutableCollection[A, Collection]): Collection
  def toIterator: MyIterator[A]


  def +(value: A): Collection = add(value)
  def ++(value: ImmutableCollection[A, Collection]): Collection = addAll(value)

  def -(value: A): Collection = remove(value)
  def --(values: ImmutableCollection[A, Collection]): Collection = removeAll(values)

  def forEach[U](f: A => U): Unit = {
    val it = toIterator
    while (it.hasNext) {
      f(it.next)
    }
  }

  def foldLeft[B](initial: B)(op: (B, A) => B): B = {
    var accumulator = initial
    forEach((value: A) => accumulator = op(accumulator, value))
    accumulator
  }
}
