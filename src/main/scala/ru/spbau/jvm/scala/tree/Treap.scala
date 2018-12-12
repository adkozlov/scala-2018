package ru.spbau.jvm.scala.tree

import scala.annotation.tailrec
import scala.util.Random

class Treap[T](implicit ord: Ordering[T]) {
  private var _size = 0
  private var root: Node = _

  def addAll(treap: Treap[T]): Unit = {
    treap.foreach(it => add(it))
  }

  def size: Int = _size

  def add(key: T): Boolean = {
    if (contains(key)) {
      false
    } else {
      changeRoot(add(root, new Node(key)))
      _size += 1
      true
    }
  }

  def remove(key: T): Boolean = {
    if (!contains(key)) {
      false
    } else {
      val node = find(root, key)
      val mergeResult = merge(node.left, node.right)
      if (node.parent != null) {
        val parent = node.parent
        if (node == parent.right) {
          parent.right = mergeResult
        } else {
          parent.left = mergeResult
        }
      } else {
        changeRoot(mergeResult)
      }
      _size -= 1
      true
    }
  }

  def foreach[R](function: T => R): Unit = {
    val iter = iterator
    while (iter.hasNext) {
      function(iter.next)
    }
  }

  def map[R](function: T => R)(implicit ord: Ordering[R]): Treap[R] = {
    val result = Treap[R]()
    foreach(it => result.add(function(it)))
    result
  }

  def flatMap[R](function: T => Treap[R])(implicit ord: Ordering[R]): Treap[R] = {
    val result = Treap[R]()
    foreach(it => result.addAll(function(it)))
    result
  }

  def contains(key: T): Boolean = find(root, key) != null

  def isEmpty: Boolean = size == 0

  def iterator: Iterator = new Iterator

  private def add(node: Node, newKey: Node): Node = {
    if (node == null) {
      newKey
    } else if (node.priority < newKey.priority) {
      val (left, _, right) = split(node, newKey.key)
      newKey.right = right
      newKey.left = left
      newKey
    } else if (ord.gt(newKey.key, node.key)) {
      node.right = add(node.right, newKey)
      node
    } else {
      node.left = add(node.left, newKey)
      node
    }
  }

  private def changeRoot(newRoot: Node): Unit = {
    root = newRoot
    if (root != null) {
      root.parent = null
    }
  }

  @tailrec
  private def find(node: Node, key: T): Node = {
    if (node == null || ord.equiv(key, node.key)) {
      node
    } else if (ord.gt(key, node.key)) {
      find(node.right, key)
    } else {
      find(node.left, key)
    }
  }

  private def split(node: Node, key: T): (Node, Node, Node) = {
    if (node == null) {
      (null, null, null)
    } else if (ord.gt(key, node.key)) {
      val (left, equal, right) = split(node.right, key)
      node.right = left
      (node, equal, right)
    } else if (ord.equiv(key, node.key)) {
      val (left, right) = (node.left, node.right)
      node.left = null
      node.right = null
      (left, node, right)
    } else {
      val (left, equal, right) = split(node.left, key)
      node.left = right
      (left, equal, node)
    }
  }

  private def merge(left: Node, right: Node): Node = (left, right) match {
    case (null, _) => right
    case (_, null) => left
    case _ =>
      if (left.priority > right.priority) {
        left.right = merge(left.right, right)
        left
      } else {
        right.left = merge(left, right.left)
        right
      }
  }

  class Iterator private[Treap] {
    private var nextNode: Node = if (Treap.this.root == null) null else Treap.this.root.leftLeaf

    def hasNext: Boolean = nextNode != null

    def next: T = {
      if (nextNode == null) {
        null
      }
      val result = nextNode.key
      nextNode = if (nextNode.right != null) nextNode.right.leftLeaf else nextNode.rightParent
      result
    }
  }

  private class Node(val key: T) {
    val priority: Int = Random.nextInt

    var parent: Node = _
    private var _left: Node = _
    private var _right: Node = _

    def left: Node = _left

    def right: Node = _right


    def left_=(node: Node): Unit = {
      if (node != null) {
        node.parent = this
      }
      _left = node
    }

    def right_=(node: Node): Unit = {
      if (node != null) {
        node.parent = this
      }
      _right = node
    }

    @tailrec
    final def leftLeaf: Node = if (left == null) this else left.leftLeaf

    @tailrec
    final def rightParent: Node = if (parent != null && parent.right == this) parent.rightParent else parent
  }

}

object Treap {
  def apply[T](keys: T*)(implicit ord: Ordering[T]): Treap[T] = {
    val result = new Treap[T]()
    keys.foreach(result.add)
    result
  }

  def empty[T](implicit ord: Ordering[T]): Treap[T] = Treap[T]()
}