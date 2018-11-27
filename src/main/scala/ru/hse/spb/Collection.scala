package ru.hse.spb

trait Collection[T] {
  def add(element: T) : Boolean

  def addAll(collection: Collection[T]) : Boolean = {
    var result = false
    for (element <- collection) {
      result |= add(element)
    }
    result
  }

  def clear()

  def contains(element: T) : Boolean

  def containsAll(collection: Collection[T]) : Boolean = {
    for (element <- collection) {
      if (!contains(element)) {
        return false
      }
    }
    true
  }

  def isEmpty: Boolean = {
    size == 0
  }

  def iterator() : Iterator[T]

  def remove(element: T): Boolean

  def removeAll(collection: Collection[T]) : Boolean = {
    var result = false
    for (element <- collection) {
      result |= remove(element)
    }
    result
  }

  def size() : Int

  def foreach(function :  T => Unit) : Unit = {
    val it = iterator()
    while (it.hasNext) {
      function.apply(it.next())
    }
  }
}
