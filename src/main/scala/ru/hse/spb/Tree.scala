package ru.hse.spb

import scala.collection.mutable
import scala.util.Random

class TreeNode[T <: Comparable[T]](val key: T) {
  val heapKey: Int = TreeNode.random.nextInt()
  var left: TreeNode[T] = _
  var right: TreeNode[T] = _

  def print(): Unit = {
    if (left != null) {
      left.print()
    }
    println("(" + key + ", " + heapKey + ")")
    if (right != null) {
      right.print()
    }
  }
}

object TreeNode {

  val random = new Random()

  def merge[T <: Comparable[T]](leftNode: TreeNode[T], rightNode: TreeNode[T]): TreeNode[T] = {
    (leftNode, rightNode) match {
      case (node, null) => node
      case (null, node) => node
      case _ if leftNode.heapKey < rightNode.heapKey =>
        leftNode.right = merge(leftNode.right, rightNode)
        leftNode
      case _ =>
        rightNode.left = merge(leftNode, rightNode.left)
        rightNode
    }
  }

  def split[T <: Comparable[T]](node: TreeNode[T], element: T, equalLeft: Boolean = false): (TreeNode[T], TreeNode[T]) = {
    if (node == null) {
      (null, null)
    } else if (node.key.compareTo(element) < 0 || node.key.compareTo(element) == 0 && equalLeft) {
      val (leftNode, rightNode) = split(node.right, element, equalLeft)
      node.right = leftNode
      (node, rightNode)
    } else {
      val (leftNode, rightNode) = split(node.left, element, equalLeft)
      node.left = rightNode
      (leftNode, node)
    }
  }

  def find[T <: Comparable[T]](node: TreeNode[T], element: T): TreeNode[T] = {
    val (left, middleRight) = split(node, element)
    val (middle, right) = split(middleRight, element, equalLeft = true)
    TreeNode.merge(TreeNode.merge(left, middle), right)
    middle
  }
}

class Tree[T <: Comparable[T]] {
  var root: TreeNode[T] = _

  def contains(elem: T): Boolean = TreeNode.find(root, elem) != null

  def subsetOf(that: Tree[T]): Boolean = {
    var result = false
    foreach(elem => result &= that(elem))
    result
  }

  def add(elem: T): Boolean = {
    if (contains(elem)) {
      return true
    }
    val (left, right) = TreeNode.split(root, elem)
    TreeNode.merge(TreeNode.merge(left, new TreeNode(elem)), right)
    false
  }

  def remove(elem: T): Boolean = {
    val (left, middleRight) = TreeNode.split(root, elem)
    val (middle, right) = TreeNode.split(middleRight, elem, equalLeft = true)
    TreeNode.merge(left, right)
    middle != null
  }

  def foreach[R](f: T => R): Unit = for (elem <- this) f(elem)

  def retain(p: T => Boolean): Unit = foreach(elem => if (!p(elem)) remove(elem))

  def copy(): Tree[T] = empty() ++= this

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

  def empty(): Tree[T] = new Tree[T]()

  def clear(): Unit = diff(this)

  def intersect(that: Tree[T]): Tree[T] = {
    val result = copy()
    result.retain(elem => that.contains(elem))
    result
  }

  def & : Tree[T] => Tree[T] = intersect

  def union(that: Tree[T]): Tree[T] = copy ++= that

  def | : Tree[T] => Tree[T] = union

  def diff(that: Tree[T]): Tree[T] = copy --= that

  def &~ : Tree[T] => Tree[T] = diff

  def apply(elem: T): Boolean = contains(elem)

  def update(elem: T, value: Boolean): Unit = if (value) add(elem) else remove(elem)
}

object Tree {
  def update[T](elem: T, newValue: T): Unit = println(elem, newValue)
}

object Main {
  def main(args: Array[String]): Unit = {
    val tree = new Tree[Integer]()
    tree(5)
    tree(6) = true
    val set = new mutable.TreeSet[Integer]()
    set += 5
    set += 6
    set(5) = false
    set(7) = true
    println(set)
  }
}