package ru.spb.hse.hw02

import scala.util.Random

class Treap[T](implicit ordering: Ordering[T]) extends Collection[T] {

  private class Node(val x: T) {
    val y: Int = Random.nextInt()
    var size: Int = 1
    var right: Node = _
    var left: Node = _
  }

  private object Node {
    private def split(node: Node, value: T, equalInLeft: Boolean = false): (Node, Node) = {
      if (node == null) {
        return (null, null)
      }
      if ((equalInLeft && ordering.lteq(node.x, value)) || (!equalInLeft && ordering.lt(node.x, value))) {
        val (left, right) = Node.split(node.right, value, equalInLeft)
        node.right = left
        update(node)
        (node, right)
      } else {
        val (left, right) = Node.split(node.left, value, equalInLeft)
        node.left = right
        update(node)
        (left, node)
      }
    }

    private def merge(left: Node, right: Node): Node = {
      (left, right) match {
        case (null, null) => null
        case (lt, null) => lt
        case (null, rt) => rt
        case (_, _) =>
          if (left.y < right.y) {
            left.right = merge(left.right, right)
            update(left)
            left
          } else {
            right.left = merge(left, right.left)
            update(right)
            right
          }
      }
    }

    private def update(node: Node): Unit = {
      if (node == null) {
        return
      }
      node.size = 1 + getSize(node.left) + getSize(node.right)
    }

    def getSize(node: Node): Int = {
      if (node == null) {
        return 0
      }
      node.size
    }

    def exist(node: Node, value: T): Boolean = {
      if (node == null) {
        return false
      }
      if (ordering.lt(value, node.x)) {
        exist(node.left, value)
      } else if (ordering.equiv(value, node.x)) {
        true
      } else {
        exist(node.right, value)
      }
    }

    def insert(node: Node, value: T): Node = {
      if (exist(node, value)) {
        return node
      }
      val newNode: Node = new Node(value)
      val (left, right) = split(node, value)
      merge(merge(left, newNode), right)
    }

    def erase(node: Node, value: T): Node = {
      if (!exist(node, value)) {
        return node
      }
      var (left, right) = split(node, value, equalInLeft = true)
      left = split(left, value)._1
      merge(left, right)
    }

    def toLinkedList(node: Node): LinkedList[T] = {
      val list: LinkedList[T] = new LinkedList[T]
      if (node == null) {
        return list
      }
      list.addAll(toLinkedList(node.left))
      list.add(node.x)
      list.addAll(toLinkedList(node.right))
      list
    }
  }

  private var root: Node = _


  override def size: Int = Node.getSize(root)


  override def add(element: T): Boolean = {
    if (!Node.exist(root, element)) {
      root = Node.insert(root, element)
      return true
    }
    false
  }

  override def contains(element: T): Boolean = Node.exist(root, element)

  override def remove(element: T): Boolean = {
    if (Node.exist(root, element)) {
      root = Node.erase(root, element)
      return true
    }
    false
  }


  override def toLinkedList: LinkedList[T] = Node.toLinkedList(root)

  override def iterator: Iterator[T] = toLinkedList.iterator


  def map[S](f: T => S)(implicit ordering: Ordering[S]): Treap[S] = {
    val newTreap: Treap[S] = new Treap[S]
    forEach(element => newTreap.add(f(element)))
    newTreap
  }

  def flatMap[S](f: T => Collection[S])(implicit ordering: Ordering[S]): Treap[S] = {
    val newTreap: Treap[S] = new Treap[S]
    forEach(element => {
      f(element).forEach(innerElement => newTreap.add(innerElement))
    })
    newTreap
  }
}
