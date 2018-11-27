package ru.spb.hse.hw02

class LinkedList[T](implicit ordering: Ordering[T]) extends Collection[T] {

  private class LinkedListIterator(private var currentNode: Node) extends Iterator[T] {
    override def hasNext: Boolean = currentNode != null

    override def next: T = {
      val value: T = currentNode.value
      currentNode = currentNode.next
      value
    }
  }

  case class Node(value: T, var next: Node = null)

  private var head: Node = _
  private var tail: Node = _
  private var currentSize: Int = 0


  def getHead: Node = head


  override def size: Int = currentSize


  override def add(value: T): Boolean = {
    val newNode: Node = Node(value)
    if (head == null) {
      head = newNode
    } else {
      tail.next = newNode
    }
    tail = newNode
    currentSize += 1
    true
  }

  override def contains(value: T): Boolean = {
    val it: Iterator[T] = iterator
    while (it.hasNext) {
      if (ordering.equiv(value, it.next)) {
        return true
      }
    }
    false
  }

  override def remove(value: T): Boolean = {
    if (head == null) {
      return false
    }

    var atLeastOne: Boolean = false

    var current: Node = head
    while (current != null && ordering.equiv(value, current.value)) {
      current = current.next
      currentSize -= 1
      atLeastOne = true
    }
    head = current

    var prev: Node = null
    while (current != null) {
      while (current != null && ordering.equiv(value, current.value)) {
        current = current.next
        currentSize -= 1
        atLeastOne = true
      }

      if (prev != null) {
        prev.next = current
      }
      if (current != null) {
        tail = current
      }

      prev = current
      current = current.next
    }
    atLeastOne
  }


  override def toLinkedList: LinkedList[T] = {
    val newList: LinkedList[T] = new LinkedList[T]()
    forall(element => newList.add(element))
    newList
  }

  override def iterator: Iterator[T] = new LinkedListIterator(head)


  def addAll(elements: LinkedList[T]): Unit = {
    elements.forEach(element => add(element))
  }
}

object LinkedList {
  def apply[T](elements: T*)(implicit ordering: Ordering[T]): LinkedList[T] = {
    val list: LinkedList[T] = new LinkedList[T]()
    elements.foreach(list.add)
    list
  }
}
