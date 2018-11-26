package ru.hse.spb.jvm.scala

class SimpleList[E] extends MutableCollection[E, SimpleList[E]] {
  private var _size = 0
  private var _root: ListNode = _

  override def size: Int = _size

  override def contains(e: E): Boolean = ???

  override def iterator: MyIterator[E] = new ListIterator

  override def add(e: E): Boolean = {
    _size += 1
    _root = new ListNode(e, _root)
    true
  }

  override def remove(e: E): Boolean = ???

  override def -=(key: E): SimpleList[E] = ???

  override def +=(key: E): SimpleList[E] = ???

  class ListNode private[SimpleList](value: E, next: ListNode = null) {
    val _value: E = value
    val _next: ListNode = next
  }

  class ListIterator extends MyIterator[E] {
    var currentNode: ListNode = _
    var currentIndex: Int = -1

    override def next: E = {
      if (!hasNext) {
        throw new UnsupportedOperationException("There is no next element")
      }
      currentNode = if (currentNode eq null) _root else currentNode._next
      currentIndex += 1
      currentNode._value
    }

    override def hasNext: Boolean = currentIndex + 1 < size
  }

}
