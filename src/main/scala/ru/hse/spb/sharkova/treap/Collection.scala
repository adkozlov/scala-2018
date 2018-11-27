package ru.hse.spb.sharkova.treap

trait Collection[T] {

  def contains(key: T): Boolean

  def containsAll(collection: Collection[_ <: T]): Boolean = {
    var returnValue = true
    foreach(it => returnValue &= contains(it))
    returnValue
  }

  def containsAll(keys: T*): Boolean = {
    var returnValue = true
    keys.foreach(it => returnValue &= contains(it))
    returnValue
  }

  def add(key: T): Unit

  def addAll(collection: Collection[_ <: T]): Unit = collection.foreach(it => add(it))

  def addAll(keys: T*): Unit = keys.foreach(add)

  def clear(): Unit

  def size: Int

  def isEmpty: Boolean = size == 0

  def iterator: Iterator[T]

  def foreach[S](function: (_ >: T) => S): Unit = {
    val iter = iterator
    while (iter.hasNext) {
      function.apply(iter.next())
    }
  }
}
