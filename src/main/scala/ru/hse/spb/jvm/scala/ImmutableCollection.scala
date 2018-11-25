package ru.hse.spb.jvm.scala

trait ImmutableCollection[E, Collection <: ImmutableCollection[E, Collection]] {
  def size: Int

  def isEmpty: Boolean = size == 0

  def contains(e: Any): Boolean

  def iterator: MyIterator[E]

  def toArray: Array[E]

  def add(e: E): Collection

  def remove(e: Any): Collection

  def forEach(f: E => Unit): Unit = {
    val it = iterator
    while (it.hasNext) {
      f.apply(it.next)
    }
  }

  def containsAll(c: ImmutableCollection[_, _]): Boolean = {
    val it = c.iterator
    while (it.hasNext) {
      if (!contains(it.next)) {
        return false
      }
    }
    true
  }

  def addAll(c: ImmutableCollection[_ <: E, _]): Collection

  def removeAll(c: ImmutableCollection[_, _]): Collection

  def removeIf(filter: _ >: E => Boolean): Collection

  def retainAll(c: ImmutableCollection[_, _]): Collection
}
