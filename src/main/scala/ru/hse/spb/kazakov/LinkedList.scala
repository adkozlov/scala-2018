package ru.hse.spb.kazakov

import java.util.{ConcurrentModificationException, NoSuchElementException}

class LinkedList[A] extends Collection[A] {
  private var state = 0
  private var _size = 0
  private val tail: Node = new Node
  private val head = new Node(right = tail)
  tail.left = head

  override def size: Int = _size

  override def contains(value: A): Boolean = {
    val _iterator = iterator
    while (_iterator.hasNext) {
      if (value == _iterator.next()) {
        return true
      }
    }
    false
  }

  override def add(value: A): Boolean = {
    val node = new Node(tail.left, tail, value)
    tail.left.right = node
    tail.left = node
    _size += 1
    state += 1
    true
  }

  override def remove(value: A): Boolean = {
    state += 1
    val _iterator = iterator
    while (_iterator.hasNext) {
      if (value == _iterator.next()) {
        _iterator.remove()
        return true
      }
    }
    false
  }

  override def clear(): Unit = {
    head.right = tail
    tail.left = head
    _size = 0
    state += 1
  }

  override def iterator: Iterator[A] = new LinkedListIterator

  override def equals(that: Any): Boolean = {
    if (!that.isInstanceOf[LinkedList[A]]) {
      return false
    }

    val list = that.asInstanceOf[LinkedList[A]]
    if (list.size != size) {
      return false
    }

    val _iterator = iterator
    val thatIterator = list.iterator
    while (_iterator.hasNext) {
      if (_iterator.next() != thatIterator.next()) {
        return false
      }
    }

    true
  }

  override def hashCode(): Int = {
    var hash = 0
    var index = 0
    foreach { e =>
      hash += scala.math.pow(e.hashCode(), index + 1).toInt
      index += 1
    }
    hash
  }

  private final class LinkedListIterator extends Iterator[A] {
    private var current: Node = head
    private var _next = head.right
    private var collectionState = state

    override def hasNext: Boolean = _next != tail

    override def next(): A = {
      if (isCollectionModified) {
        throw new ConcurrentModificationException
      }
      if (!hasNext) {
        throw new NoSuchElementException
      }
      current = _next
      _next = _next.right
      current.value
    }

    override def remove(): Unit = {
      if (isCollectionModified) {
        throw new ConcurrentModificationException
      }
      if (current == head || current == null) {
        throw new NoSuchElementException
      }

      current.left.right = current.right
      current.right.left = current.left

      current = null
      collectionState += 1
      state += 1
      _size -= 1
    }

    private def isCollectionModified = collectionState != state
  }

  private final class Node(
      var left: Node = null,
      var right: Node = null,
      val value: A = null.asInstanceOf[A]
  )

}
