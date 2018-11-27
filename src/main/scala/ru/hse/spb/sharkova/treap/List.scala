package ru.hse.spb.sharkova.treap

class List[T] extends Collection[T] {
  private var tail: Node = _
  private var head: Node = _
  private var listSize: Int = 0


  override def add(key: T): Unit = {
    val node = new Node(tail, null, key)
    if (head == null) {
      head = node
      tail = node
    } else {
      node.prev.next = node
      tail = node
    }

    listSize += 1
  }

  override def contains(key: T): Boolean = {
    val iterator = new ListIterator
    while (iterator.hasNext) {
      if (iterator.next() == key) {
        return true
      }
    }

    false
  }

  override def clear(): Unit = {
    head = null
    tail = null
    listSize = 0
  }

  override def size: Int = listSize

  override def equals(obj: Any): Boolean = {
    if (obj == null || !obj.isInstanceOf[List[T]]) {
      return false
    }

    val list = obj.asInstanceOf[List[T]]
    if (listSize != list.listSize) {
      return false
    }

    var node = head
    var otherNode = list.head
    while (node != null && otherNode != null) {
      if (node.value != otherNode.value) {
        return false
      }
      node = node.next
      otherNode = otherNode.next
    }
    true
  }

  override def hashCode(): Int = {
    var hash = 1
    var node = head
    while (node != null) {
      hash = 31 * hash + node.value.hashCode()
      node = node.next
    }
    hash
  }

  override def iterator: Iterator[T] = new ListIterator

  private final class Node(var prev: Node = null,
                           var next: Node = null,
                           val value: T = null.asInstanceOf[T])

  private final class ListIterator extends Iterator[T] {
    private var nextNode: Node = head

    override def hasNext: Boolean = nextNode != null

    override def next(): T = {
      if (!hasNext) {
        throw new NoSuchElementException
      }

      val returnValue = nextNode.value
      nextNode = nextNode.next

      returnValue
    }
  }
}
