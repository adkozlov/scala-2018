package ru.hse.spb

import scala.util.Random

class BST[T: Manifest](implicit order: Ordering[T]) {
  private var root: TreeNode = _
  private var size: Int = 0

  def getSize: Int = size

  private val random = new Random()

  /**
    * Treap functions
    */
  private def split(data: T, node: TreeNode,
                    compare: (Int, Int) => Boolean = Ordering.Int.gt): (TreeNode, TreeNode) = {
    if (node == null) return (null, null)
    if (compare(order.compare(node.data, data), 0)) {
      val (l, r) = split(data, node.left, compare)
      node.left = r
      (l, node)
    } else {
      val (l, r) = split(data, node.right, compare)
      node.right = l
      (node, r)
    }
  }

  private def merge(left: TreeNode, right: TreeNode): TreeNode = {
    if (left == null) return right
    if (right == null) return left
    if (left.priority < right.priority) {
      left.right = merge(left.right, right)
      left
    } else {
      right.left = merge(left, right.left)
      right
    }
  }

  /**
    * BST functions
    */
  private def contains(data: T, node: TreeNode = root): Boolean = {
    if (node == null) return false
    if (node.data == data) return true
    if (order.compare(node.data, data) > 0) contains(data, node.left)
    else contains(data, node.right)
  }

  def contains(data: T): Boolean = contains(data, root)

  def add(data: T): Unit = {
    if (contains(data)) return
    val (l, r) = split(data, root)
    root = merge(merge(l, new TreeNode(data, random.nextInt())), r)
    size += 1
  }

  def delete(data: T): Unit = {
    val (l1, r1) = split(data, root, Ordering.Int.gteq)
    val (l2, r2) = split(data, r1)
    if (l2 != null) size -= 1
    root = merge(l1, r2)
  }

  private def inOrder(node: TreeNode, keys: Array[T], i: Int): Int = {
    if (node == null) return i
    val n = inOrder(node.left, keys, i)
    keys(n) = node.data
    inOrder(node.right, keys, n + 1)
  }

  def toArray: Array[T] = {
    val array: Array[T] = new Array[T](size)
    inOrder(root, array, 0)
    array
  }

  def iterator: Iterator[T] = new Iterator[T] {
    private var i: Int = 0
    private val out = toArray

    override def hasNext: Boolean = i < getSize

    override def next: T = {
      if (!hasNext) throw new RuntimeException("No next element")
      i += 1
      out(i - 1)
    }
  }

  def foreach(f: T => Unit): Unit = {
    val it = iterator
    while (it.hasNext) f(it.next)
  }

  def map[TO: Manifest](f: T => TO)(implicit order: Ordering[TO]): BST[TO] = {
    val bst = new BST[TO]()
    foreach(i => bst.add(f(i)))
    bst
  }

  def flatMap[TO: Manifest](f: T => BST[TO])(implicit order: Ordering[TO]): BST[TO] = {
    val bst = new BST[TO]()
    foreach(i => f(i).foreach(n => bst.add(n)))
    bst
  }

  private class TreeNode(val data: T, val priority: Int,
                         var left: TreeNode = null, var right: TreeNode = null)

}

object BST {
  def apply[T: Manifest](data: T*)(implicit order: Ordering[T]): BST[T] = {
    val bst = new BST[T]()
    data.foreach(bst.add)
    bst
  }
}