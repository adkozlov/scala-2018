package ru.hse.spb.jvm.scala

trait MutableCollection[E, Collection <: MutableCollection[E, Collection]] {
  def size: Int

  def isEmpty: Boolean = size == 0

  def contains(e: E): Boolean

  def iterator: MyIterator[E]

  def toArray(array: Array[E]): Array[E] = {
    var i = 0
    val it = iterator
    while (it.hasNext) {
      array(i) = it.next
      i += 1
    }
    array
  }

  def add(e: E): Boolean

  def remove(e: E): Boolean

  def -=(key: E): Collection

  def +=(key: E): Collection

  def foreach(f: E => Unit): Unit = {
    val it = iterator
    while (it.hasNext) {
      f.apply(it.next)
    }
  }

  def containsAll(c: MutableCollection[E, _]): Boolean = {
    val it = c.iterator
    while (it.hasNext) {
      if (!contains(it.next)) {
        return false
      }
    }
    true
  }

  def foldLeft[B](z: B)(op: (B, E) => B): B = {
    var acc = z
    val it = iterator
    while (it.hasNext) {
      acc = op(acc, it.next)
    }
    acc
  }

  def addAll(collection: MutableCollection[_ <: E, _]): Boolean = {
    var isChanged = false
    for (element <- collection) {
      isChanged = add(element)
    }
    isChanged
  }

  def removeAll(collection: MutableCollection[E, _]): Boolean = {
    var isChanged = false
    for (element <- collection) {
      isChanged = remove(element)
    }
    isChanged
  }

  def removeIf(filter: E => Boolean): Boolean = {
    val toDelete = new SimpleList[E]
    for (element <- this) {
      if (filter(element)) {
        toDelete.add(element)
      }
    }
    removeAll(toDelete)
  }

  def retainAll(collection: MutableCollection[E, _]): Boolean = {
    val toDelete = new SimpleList[E]
    for (element <- this) {
      if (!collection.contains(element)) {
        toDelete.add(element)
      }
    }
    removeAll(toDelete)
  }
}
