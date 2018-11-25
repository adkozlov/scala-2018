package ru.hse.spb

import scala.util.Random

class Tree[T](implicit ord: Ordering[T]) {

  class TreeIterator {

    private var nextNode: TreeNode = _

    def this(rootNode: TreeNode) = {
      this
      if (rootNode != null) {
        nextNode = rootNode.getLeftestDescendant
      }
    }

    def hasNext: Boolean = nextNode != null

    def next(): T = {
      if (!hasNext) throw new NoSuchElementException("next on empty iterator")
      val result = nextNode.key
      nextNode = if (nextNode.hasRightChild) nextNode.right.getLeftestDescendant else nextNode.getRightAncestor
      result
    }
  }

  private class TreeNode(val key: T) {

    private val heapKey: Int = TreeNode.random.nextInt()
    var left: TreeNode = _
    var right: TreeNode = _
    var parent: TreeNode = _

    private[Tree] def getLeftestDescendant: TreeNode = if (left == null) this else left.getLeftestDescendant

    private[Tree] def isLeftChild: Boolean = parent != null && ord.gt(parent.key, key)

    private[Tree] def isRightChild: Boolean = parent != null && ord.lt(parent.key, key)

    private[Tree] def hasRightChild: Boolean = right != null

    private[Tree] def getRightAncestor: TreeNode = if (isRightChild) parent.getRightAncestor else parent
  }

  private object TreeNode {

    private val random = new Random()

    private def setParent(node: TreeNode, parent: TreeNode): Unit = if (node != null) node.parent = parent

    private[Tree] def merge(leftNode: TreeNode, rightNode: TreeNode): TreeNode = {
      (leftNode, rightNode) match {
        case (node, null) => node
        case (null, node) => node
        case _ if leftNode.heapKey < rightNode.heapKey =>
          leftNode.right = merge(leftNode.right, rightNode)
          setParent(leftNode.right, leftNode)
          leftNode
        case _ =>
          rightNode.left = merge(leftNode, rightNode.left)
          setParent(rightNode.left, rightNode)
          rightNode
      }
    }

    private[Tree] def split(node: TreeNode, element: T, equalLeft: Boolean = false): (TreeNode, TreeNode) = {
      if (node == null) {
        (null, null)
      } else if (ord.lt(node.key, element) || (ord.equiv(node.key, element) && equalLeft)) {
        val (leftNode, rightNode) = split(node.right, element, equalLeft)
        node.right = leftNode
        setParent(node.right, node)
        setParent(rightNode, null)
        (node, rightNode)
      } else {
        val (leftNode, rightNode) = split(node.left, element, equalLeft)
        node.left = rightNode
        setParent(node.left, node)
        setParent(leftNode, null)
        (leftNode, node)
      }
    }

    private[Tree] def find(node: TreeNode, element: T): TreeNode = {
      val (left, middleRight) = split(node, element)
      val (middle, right) = split(middleRight, element, equalLeft = true)
      TreeNode.merge(TreeNode.merge(left, middle), right)
      middle
    }
  }

  private var root: TreeNode = _

  private var size_ = 0

  def size: Int = size_

  def isEmpty: Boolean = size == 0

  def iterator: TreeIterator = new TreeIterator(root)

  def contains(elem: T): Boolean = TreeNode.find(root, elem) != null

  def subsetOf(that: Tree[T]): Boolean = {
    var result = true
    foreach(elem => result &= that(elem))
    result
  }

  def add(elem: T): Boolean = {
    if (contains(elem)) {
      return false
    }
    val (left, right) = TreeNode.split(root, elem)
    root = TreeNode.merge(TreeNode.merge(left, new TreeNode(elem)), right)
    size_ += 1
    true
  }

  def remove(elem: T): Boolean = {
    val (left, middleRight) = TreeNode.split(root, elem)
    val (middle, right) = TreeNode.split(middleRight, elem, equalLeft = true)
    root = TreeNode.merge(left, right)
    if (middle != null) size_ += 1
    middle != null
  }

  def retain(predicate: T => Boolean): Unit = {
    foreach(elem => if (!predicate(elem)) remove(elem))
  }

  def copy: Tree[T] = Tree.empty ++= this

  def +(elem: T): Tree[T] = copy += elem

  def -(elem: T): Tree[T] = copy -= elem

  def ++ : Tree[T] => Tree[T] = union

  def -- : Tree[T] => Tree[T] = diff

  def +=(elem: T): Tree[T] = {
    add(elem)
    this
  }

  def -=(elem: T): Tree[T] = {
    remove(elem)
    this
  }

  def ++=(that: Tree[T]): Tree[T] = {
    that.foreach(elem => add(elem))
    this
  }

  def --=(that: Tree[T]): Tree[T] = {
    that.foreach(elem => remove(elem))
    this
  }

  def clear(): Unit = --=(this)

  def intersect: Tree[T] => Tree[T] = copy &= _

  def & : Tree[T] => Tree[T] = intersect

  def &=(that: Tree[T]): Tree[T] = {
    retain(elem => that.contains(elem))
    this
  }

  def union(that: Tree[T]): Tree[T] = copy ++= that

  def | : Tree[T] => Tree[T] = union

  def |= : Tree[T] => Tree[T] = ++=

  def diff(that: Tree[T]): Tree[T] = copy --= that

  def &~ : Tree[T] => Tree[T] = diff

  def &~= : Tree[T] => Tree[T] = --=

  def apply(elem: T): Boolean = contains(elem)

  def update(elem: T, value: Boolean): Unit = if (value) add(elem) else remove(elem)

  def foreach[R](action: T => R): Unit = {
    val iter = iterator
    while (iter.hasNext) {
      action(iter.next())
    }
  }

  def withFilter(predicate: T => Boolean): Tree[T] = {
    val result = Tree.empty
    foreach(elem => if (predicate(elem)) result += elem)
    result
  }

  def map[R](function: T => R)(implicit ord: Ordering[R]): Tree[R] = {
    val result = Tree[R]()
    foreach(result += function(_))
    result
  }

  def flatMap[R](function: T => Tree[R])(implicit ord: Ordering[R]): Tree[R] = {
    val result = Tree[R]()
    foreach(elem => result ++= function(elem))
    result
  }
}

object Tree {

  def apply[T](elements: T*)(implicit ord: Ordering[T]): Tree[T] = {
    val result = new Tree[T]
    elements.foreach(result.add)
    result
  }

  def empty[T](implicit ord: Ordering[T]): Tree[T] = new Tree[T]()

}
