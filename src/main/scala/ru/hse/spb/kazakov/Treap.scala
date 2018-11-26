package ru.hse.spb.kazakov

import java.util.ConcurrentModificationException

class Treap[A](implicit ordering: Ordering[_ >: A]) extends Collection[A] {
  private var _size = 0
  private var root: Node = _
  private var state = 0

  def size: Int = _size

  override def clear(): Unit = {
    root = null
    _size = 0
    state += 1
  }

  override def contains(value: A): Boolean = {
    val (left, equal, right) = split(root, value)
    root = mergeAll(left, equal, right)
    equal != null
  }

  override def add(value: A): Boolean = {
    val (less, equal, greaterOrEq) = split(root, value)
    root = mergeAll(less, equal, new Node(value), greaterOrEq)
    _size += 1
    state += 1
    true
  }

  override def remove(value: A): Boolean = {
    val (less, equal, greaterOrEq) = split(root, value)
    root = merge(less, greaterOrEq)

    state += 1
    if (equal != null) {
      _size -= 1
      true
    } else {
      false
    }
  }

  override def iterator: Iterator[A] = new TreapIterator

  private def split(node: Node, value: A): (Node, Node, Node) = {
    if (node == null) {
      return (null, null, null)
    }

    val compareResult = ordering.compare(value, node.value)
    if (compareResult > 0) {
      val (less, equal, greaterOrEq) = split(node.right, value)
      node.right = less
      (node, equal, greaterOrEq)
    } else if (compareResult < 0) {
      val (less, equal, greaterOrEq) = split(node.left, value)
      node.left = greaterOrEq
      (less, equal, node)
    } else {
      val less = node.left
      val greaterOrEq = node.right
      node.left = null
      node.right = null
      (less, node, greaterOrEq)
    }
  }

  private def mergeAll(nodes: Node*): Node = nodes.foldRight[Node](null) {
    merge
  }

  private def merge(less: Node, greater: Node): Node = (less, greater) match {
    case (null, _) => greater
    case (_, null) => less
    case _ =>
      if (less.priority <= greater.priority) {
        less.right = merge(less.right, greater)
        less
      } else {
        greater.left = merge(less, greater.left)
        greater
      }
  }

  def map[B](fun: (_ >: A) => B)(
      implicit ordering: Ordering[B]): Treap[B] = {
    val result = new Treap[B]()(ordering)
    foreach(e => result.add(fun.apply(e)))
    result
  }

  def flatMap[B](fun: (_ >: A) => Treap[B])(implicit ordering: Ordering[B]): Treap[B] = {
    val result = new Treap[B]()(ordering)
    foreach(e => result.addAll(fun.apply(e)))
    result
  }

  def filter(predicate: (_ >: A) => Boolean): Treap[A] = {
    val result = new Treap[A]
    foreach(e => if (predicate.apply(e)) result.add(e))
    result
  }

  def withFilter(predicate: A => Boolean): Treap[A] = filter(predicate)

  override def equals(any: Any): Boolean = {
    if (any == null || !any.isInstanceOf[Treap[A]]) {
      return false
    }
    val treap = any.asInstanceOf[Treap[A]]
    toLinkedList == treap.toLinkedList
  }

  override def hashCode(): Int = toLinkedList.hashCode()

  private def toLinkedList: LinkedList[A] = {
    val list = new LinkedList[A]

    def dfs(node: Node): Unit = {
      if (node == null) {
        return
      }
      dfs(node.left)
      list.add(node.value)
      dfs(node.right)
    }

    dfs(root)
    list
  }

  private final class Node(val value: A) {
    val priority: Int = scala.util.Random.nextInt
    var left: Node = _
    var right: Node = _
  }

  class TreapIterator extends Iterator[A] {
    private val listIterator = toLinkedList.iterator
    private var collectionState = state
    private var canRemove = false
    private var prevValue: A = _

    override def hasNext: Boolean = listIterator.hasNext

    override def next(): A = {
      if (isCollectionModified) {
        throw new ConcurrentModificationException
      }

      canRemove = true
      prevValue = listIterator.next()
      prevValue
    }

    override def remove(): Unit = {
      if (isCollectionModified) {
        throw new ConcurrentModificationException
      }
      if (!canRemove) {
        throw new NoSuchElementException
      }

      canRemove = false
      collectionState += 1
      state += 1
      Treap.this.remove(prevValue)
    }

    private def isCollectionModified = collectionState != state

  }
  
}
