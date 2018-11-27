package ru.hse.spb

class LinkedList[T] extends Collection[T] {
  private class LinkedListNode(_value: T) {
      val value: T = _value
      var next: LinkedListNode = _
  }

  private class LinkedLisTIterator extends Iterator[T] {
    var currentNode: LinkedListNode = head
    override def hasNext: Boolean = {
      currentNode != null
    }

    override def next(): T = {
      if (!hasNext) {
        throw new UnsupportedOperationException("no next element in list")
      }
      val result = currentNode.value
      currentNode = currentNode.next
      result
    }
  }

  private var head: LinkedListNode = _
  private var _size: Int = 0
  private var _iterator: LinkedLisTIterator = _

  override def add(element: T): Boolean = {
    val node = new LinkedListNode(element)
    node.next = head
    head = node
    _size += 1
    true
  }

  def getHead: T = head.value

  override def clear(): Unit = {
    head = null
    _size=  0
  }

  override def contains(element: T): Boolean = {
    var node = head
    while (node != null) {
      if (node.value.equals(element)) {
        return true
      }
      node = node.next
    }
    false
  }

  override def iterator(): Iterator[T] = {
    if (_iterator == null) {
      _iterator = new LinkedLisTIterator()
    }
    _iterator
  }

  override def remove(element: T): Boolean = {
    var node = head
    if (head.value.equals(element)) {
      head = head.next
      _size -= 1
      return true
    }
    while (node.next != null) {
      if (node.next.value.equals(element)) {
        node.next = node.next.next
        _size -= 1
        return true
      }
      node = node.next
    }
    false
  }

  override def size(): Int = _size
}
