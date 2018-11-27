package ru.spb.hse.hw02

trait Collection[T] {
  def isEmpty: Boolean = size != 0

  def size: Int


  def forall(p: T => Boolean): Boolean = {
    val it: Iterator[T] = iterator
    while (it.hasNext) {
      if (!p(it.next)) {
        return false
      }
    }
    true
  }

  def exists(p: T => Boolean): Boolean = {
    val it: Iterator[T] = iterator
    while (it.hasNext) {
      if (p(it.next)) {
        return true
      }
    }
    false
  }

  def count(p: T => Boolean): Int = {
    val it: Iterator[T] = iterator
    var count: Int = 0
    while (it.hasNext) {
      if (p(it.next)) {
        count += 1
      }
    }
    count
  }

  def forEach(f: T => Unit): Unit = {
    val it: Iterator[T] = iterator
    while (it.hasNext) {
      f(it.next)
    }
  }


  def fold[S >: T](z: T)(op: (T, T) => T): T = foldLeft[T](z)(op)

  def foldLeft[S](z: S)(op: (S, T) => S): S = {
    val it: Iterator[T] = iterator
    var result: S = z
    while (it.hasNext) {
      result = op(result, it.next)
    }
    result
  }

  def foldRight[S](z: S)(op: (T, S) => S): S = {
    def accumulator(it: Iterator[T]): S =
      if (it.hasNext) {
        val current: T = it.next
        op(current, accumulator(it))
      } else {
        z
      }

    accumulator(iterator)
  }


  def add(element: T): Boolean

  def contains(element: T): Boolean

  def remove(element: T): Boolean


  def toLinkedList: LinkedList[T]

  def iterator: Iterator[T]
}
