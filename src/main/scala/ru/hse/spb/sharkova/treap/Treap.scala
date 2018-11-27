package ru.hse.spb.sharkova.treap

import scala.util.Random

class Treap[T](implicit ordering: Ordering[_ >: T]) extends Collection[T] {
  private var root: Node = _
  private var treapSize: Int = 0


  override def add(key: T): Unit = {
    if (contains(key)) {
      return
    }

    val newNode = new Node(key = key)
    val (left, right) = split(root, key)
    root = merge(merge(left, newNode), right)
    treapSize += 1
  }

  override def contains(key: T): Boolean = {
    var node = root
    while (node != null) {
      if (node.key == key) {
        return true
      } else if (ordering.compare(key, node.key) < 0) {
        node = node.left
      } else {
        node = node.right
      }
    }

    false
  }

  def remove(key: T): Unit = {
    if (!contains(key)) {
      throw new NoSuchElementException
    }

    val (left, right) = split(root, key)
    root = merge(left, right)
    treapSize -= 1
  }

  def removeAll(collection: Collection[_ <: T]): Unit = collection.foreach(it => remove(it))

  def removeAll(keys: T*): Unit = keys.foreach(remove)

  override def clear(): Unit = {
    root = null
    treapSize = 0
  }

  override def size: Int = treapSize

  override def equals(obj: Any): Boolean = {
    if (obj == null || !obj.isInstanceOf[Treap[T]]) {
      return false
    }

    toList.equals(obj.asInstanceOf[Treap[T]].toList)
  }

  override def hashCode(): Int = {
    toList.hashCode()
  }

  override def iterator: Iterator[T] = new TreapIterator

  // higher order functions

  def map[S](function: T => S)(implicit ordering: Ordering[S]): Treap[S] = {
    val treap = new Treap[S]()(ordering)
    foreach(it => treap.add(function.apply(it)))
    treap
  }

  def flatMap[S](function: T => Treap[S])(implicit ordering: Ordering[S]): Treap[S] = {
    val treap = new Treap[S]()(ordering)
    foreach(it => treap.addAll(function.apply(it)))
    treap
  }

  def filter(predicate: T => Boolean): Treap[T] = {
    val treap = new Treap[T]()
    foreach(it => if (predicate(it)) treap.add(it))
    treap
  }

  def withFilter(predicate: T => Boolean): WithFilter = new WithFilter(predicate)

  def foldRight[S](initial: S)(function: (T, S) => S): S = {
    var returnValue = initial
    val reversedList = toList.reverse
    reversedList.foreach(it => returnValue = function(it, returnValue))
    returnValue
  }

  private def split(node: Node, key: T): (Node, Node) = {
    if (node == null) {
      (null, null)
    } else if (ordering.compare(key, node.key) < 0) {
      val (left, right) = split(node.left, key)
      node.left = right
      (left, node)
    } else if (ordering.compare(key, node.key) > 0){
      val (left, right) = split(node.right, key)
      node.right = left
      (node, right)
    } else {
      (node.left, node.right)
    }
  }

  private def merge(left: Node, right: Node): Node = (left, right) match {
    case (null, _) => right
    case (_, null) => left
    case _ =>
      if (left.priority <= right.priority) {
        left.right = merge(left.right, right)
        left
      } else {
        right.left = merge(left, right.left)
        right
      }
  }

  // for functions that don't operate on nulls
  private def traverse(node: Node, function: T => Unit): Unit = {
    if (node == null) {
      return
    }

    traverse(node.left, function)
    function(node.key)
    traverse(node.right, function)
  }

  private def toList: List[T] = {
    val list = new List[T]
    traverse(root, list.add)
    list
  }

  class WithFilter(predicate: T => Boolean) {
    def map[S](function: T => S)(implicit ordering: Ordering[S]): Treap[S] = filter(predicate).map(function)

    def flatMap[S](function: T => Treap[S])(implicit ordering: Ordering[S]): Treap[S] =
      filter(predicate).flatMap(function)

    def foreach[S](function: T => Unit): Unit = filter(predicate).foreach(function)

    def withFilter(p: T => Boolean): WithFilter = new WithFilter(it => predicate(it) && p(it))
  }

  private final class Node(var left: Node = null,
                           var right: Node = null,
                           var key: T,
                           val priority: Int = Random.nextInt())

  private final class TreapIterator extends Iterator[T] {
    private val listIterator = toList.iterator

    override def hasNext: Boolean = listIterator.hasNext

    override def next(): T = listIterator.next()
  }
}
