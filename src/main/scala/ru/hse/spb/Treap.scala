package ru.hse.spb

import scala.util.Random

class Treap[T] (implicit order: Ordering[T]) extends Collection[T] {
    private val random = new Random()

    private class Node (_value: T, _left: Node = null, _right: Node = null) {
        val y: Int = random.nextInt()
        var left: Node = _left
        var right: Node = _right
        var parent: Node = _
        def value: T = _value
    }

    private class TreapIterator extends Iterator[T] {
        private var node:Node = root
        private val list:LinkedList[Node] = new LinkedList[Node]()
        while (node != null) {
            list.add(node)
            node = node.left
        }

        override def hasNext: Boolean = {
            list.size() > 0
        }

        override def next(): T = {
            var node = list.getHead
            list.remove(node)
            val result = node.value
            if (node.right != null) {
                node = node.right
                while (node != null) {
                    list.add(node)
                    node = node.left
                }
            }
            result
        }
    }

    private var root: Node = _
    private var _iterator: TreapIterator = _

    override def add(element: T): Boolean = {
        if (contains(element)) {
            return false
        }
        val newNode = new Node(element)
        val (left, right) = split(root, element)
        root = merge(merge(left, newNode), right)
        _size += 1
        true
    }

    override def clear(): Unit = {
        root = null
        _size = 0
    }

    override def contains(element: T): Boolean = {
        var node = root
        while (node != null) {
            if (node.value.equals(element)) {
                return true
            }
            if (order.compare(node.value, element) < 0) {
                node = node.left
            } else {
                node = node.right
            }
        }
        false
    }

    override def iterator(): Iterator[T] = {
        if (_iterator == null) {
            _iterator = new TreapIterator()
        }
        _iterator
    }

    override def remove(element: T): Boolean = {
        if (!contains(element)) {
            return false
        }
        _size -= 1
        root = removeFromNode(root, element)
        true
    }
    private def removeFromNode(node: Node, element: T): Node = {
        if (node.value.equals(element)) {
            return merge(node.left, node.right)
        }
        if (order.compare(node.value, element) < 0) {
            node.left = removeFromNode(node.left, element)
        } else {
            node.right = removeFromNode(node.right, element)
        }
        node
    }

    private var _size = 0
    override def size(): Int = _size

    private def split(node: Node, x: T): (Node, Node) = {
        if (node == null) {
            return (null, null)
        }
        if (order.compare(node.value, x) < 0) {
            val (left, right) = split(node.left, x)
            if (right != null) {
                right.parent = node
            }
            node.left = right
            return (left, node)
        }
        val (left, right) = split(node.right, x)
        if (left != null) {
            left.parent = node
        }
        node.right = left
        (node, right)
    }

    private def merge(left: Node, right: Node): Node = {
        if (left == null) {
            return right
        }
        if (right == null) {
            return left
        }
        if (left.y > right.y) {
            left.right = merge(left.right, right)
            if (left.right != null) {
                left.right.parent = left
            }
            return left
        }
        right.left = merge(left, right.left)
        if (right.left != null) {
            right.left.parent = right
        }
        right
    }
}
