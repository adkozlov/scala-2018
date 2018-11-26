package ru.hse.jvm.util

import scala.util.Random

class Treap[T : Manifest](implicit ord: Ordering[T]) {
  private val random = new Random()
  private var root : Node = _
  private var size : Int = 0

  private class Node(val x : T, var left : Node = null, var right : Node = null) {
    val y : Int = random.nextInt()
  }

  private def mergeNodes(a : Node, b : Node) : Node = {
    if (a == null) {
      return b
    }
    if (b == null) {
      return a
    }
    if (a.y < b.y) {
      a.right = mergeNodes(a.right, b)
      a
    } else {
      b.left = mergeNodes(a, b.left)
      b
    }
  }

  private def splitNodeLeft(a : Node, k : T): (Node, Node) = {
    if (a == null) {
      return (null, null)
    }
    if (ord.compare(a.x, k) > 0) {
      val result = splitNodeLeft(a.left, k)
      a.left = result._2
      (result._1, a)
    } else {
      val result = splitNodeLeft(a.right, k)
      a.right = result._1
      (a, result._2)
    }
  }

  private def splitNodeRight(a : Node, k : T): (Node, Node) = {
    if (a == null) {
      return (null, null)
    }
    if (ord.compare(a.x, k) >= 0) {
      val result = splitNodeRight(a.left, k)
      a.left = result._2
      (result._1, a)
    } else {
      val result = splitNodeRight(a.right, k)
      a.right = result._1
      (a, result._2)
    }
  }

  private def findNode(current : Node, value : T) : Node = {
    if (current == null) {
      return null
    }
    if (current.x == value) {
      return current
    }
    if (ord.compare(current.x, value) > 0) {
      findNode(current.left, value)
    } else {
      findNode(current.right, value)
    }
  }

  def insert(value : T) : Unit = {
    if (findNode(root, value) != null) {
      return
    }
    size += 1
    val result = splitNodeLeft(root, value)
    root = mergeNodes(mergeNodes(result._1, new Node(value)), result._2)
  }

  def remove(value : T) : Unit = {
    val ab = splitNodeRight(root, value)
    val bc = splitNodeLeft(ab._2, value)
    if (bc._1 != null) {
      size -= 1
    }
    root = mergeNodes(ab._1, bc._2)
  }

  def isEmpty : Boolean = root == null
  def getSize : Int = size
  def contains(value : T) : Boolean = findNode(root, value) != null

  def toArray : Array[T] = {
    var arrayIndex : Int = 0
    val array : Array[T] = new Array[T](size)

    def dfs(current : Node): Unit = {
      if (current == null) {
        return
      }
      dfs(current.left)
      array(arrayIndex) = current.x
      arrayIndex += 1
      dfs(current.right)
    }

    dfs(root)
    array
  }

  def iterator : ru.hse.jvm.Iterator[T] = new ru.hse.jvm.Iterator[T] {
    private val array = toArray
    private var index : Int = 0

    override def hasNext: Boolean = index != array.length

    override def next: T = {
      if (!hasNext) {
        throw new NoSuchElementException
      }
      index += 1
      array(index - 1)
    }
  }
}
