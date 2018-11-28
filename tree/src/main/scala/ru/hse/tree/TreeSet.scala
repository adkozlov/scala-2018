package ru.hse.tree

import ru.hse.iterable
import ru.hse.stack.Stack
import ru.hse.utils.Utils

import scala.reflect.ClassTag

/**
  * Scapegoat tree set implementation
  *
  * @param alpha parameter of the Scapegoat tree
  * @tparam A element type
  */
class TreeSet[A] private(val alpha: Double,
                         private var root: TreeSet.Tree[A],
                         private var treeSize: Int,
                         private var maxSize: Int)(implicit val ordering: Ordering[A], val tag: ClassTag[A])
  extends MutableSet[A] {

  import TreeSet._
  import ordering.mkOrderingOps

  def this(alpha: Double = 0.57)(implicit ordering: Ordering[A], tag: ClassTag[A]) {
    this(alpha, TreeSet.Empty, 0, 0)
  }

  override def iterator: iterable.Iterator[A] = root.iterator

  override def +=(elem: A): TreeSet.this.type = {
    root = insert(elem, root)
    if (violatesBalance(elem)) {
      root = rebuild()
      maxSize = treeSize
    } else {
      maxSize = math.max(treeSize, maxSize)
    }
    this
  }

  override def -=(elem: A): TreeSet.this.type = {
    root = delete(elem, root)
    if (treeSize <= alpha * maxSize) {
      root = rebuild()
      maxSize = treeSize
    }
    this
  }

  override def contains(elem: A): Boolean = contains(elem, root)

  def fromIterable[B](sequence: iterable.Iterable[B], size: Int)
                     (implicit ordering: Ordering[B], tag: ClassTag[B]): TreeSet[B] = {
    new TreeSet[B](alpha, build(toArray(sequence, size), 0, size), size, size)
  }

  def map[B](f: A => B)(implicit ordering: Ordering[B], tag: ClassTag[B]): TreeSet[B] = {
    new TreeSet[B](alpha, root map f, treeSize, maxSize)
  }

  def flatMap[B](f: A => TreeSet[B])(implicit ordering: Ordering[B], tag: ClassTag[B]): TreeSet[B] = {
    val sequence: iterable.Iterable[B] = TreeSet.super.flatMap(f)
    fromIterable(sequence, TreeSet.super.flatMap(f).size)
  }

  override def filter(p: A => Boolean): TreeSet[A] = {
    val sequence: iterable.Iterable[A] = TreeSet.super.filter(p)
    fromIterable(sequence, TreeSet.super.filter(p).size)
  }

  private def toArray[B](sequence: iterable.Iterable[B], size: Int)(implicit tag: ClassTag[B]): Array[B] = {
    val elements = new Array[B](size)
    sequence.foldLeft(0)({
      (i: Int, elem: B) => {
        elements(i) = elem
        i + 1
      }
    })
    elements
  }

  def toArray: Array[A] = toArray[A](this, treeSize)

  private def violatesBalance(elem: A): Boolean = {
    var height: Int = 0
    var current = root
    while (true) {
      current match {
        case Empty =>
          return height > Math.floor(Utils.logarithm(1 / alpha, treeSize.toDouble))
        case Node(value, left, right) =>
          current = if (elem < value) left
          else if (elem > value) right
          else Empty
      }
      height += 1
    }
    throw new RuntimeException("out of infinite loop")
  }

  private def insert(elem: A, root: Tree[A]): Tree[A] = {
    root match {
      case Empty =>
        treeSize += 1
        Node(elem, Empty, Empty)
      case Node(value, left, right) =>
        if (elem < value)
          Node(value, insert(elem, left), right)
        else if (elem > value)
          Node(value, left, insert(elem, right))
        else
          root
    }
  }

  private def merge(left: Tree[A], right: Tree[A]): Tree[A] = {
    left match {
      case Empty => right
      case Node(value, leftLeft, leftRight) => Node(value, leftLeft, merge(leftRight, right))
    }
  }

  private def delete(elem: A, root: Tree[A]): Tree[A] = {
    root match {
      case Empty => Empty
      case Node(value, left, right) =>
        if (elem < value) {
          Node(value, delete(elem, left), right)
        } else if (elem > value) {
          Node(value, left, delete(elem, right))
        } else {
          treeSize -= 1
          merge(left, right)
        }
    }
  }

  private def build[B](nodes: Array[B], l: Int, r: Int)(implicit ordering: Ordering[B]): Tree[B] = {
    if (r - l == 0) {
      Empty
    } else if (r - l == 1) {
      Node(nodes(l), Empty, Empty)
    } else {
      val m = (l + r) / 2
      Node(nodes(m), build(nodes, l, m), build(nodes, m, r))
    }
  }

  private def rebuild(): Tree[A] = {
    build(toArray, 0, treeSize)
  }

  private def contains(elem: A, root: Tree[A]): Boolean = {
    root match {
      case Empty => false
      case Node(value, left, right) =>
        if (elem < value)
          contains(elem, left)
        else if (elem > value)
          contains(elem, right)
        else true
    }
  }
}

object TreeSet {

  abstract sealed class Tree[+A] extends iterable.Iterable[A] {
    /** The behavior of this method is undefined in case of modification during iteration. */
    override def iterator: iterable.Iterator[A] = new iterable.Iterator[A] {

      private val stack = new Stack[Node[A]]

      private var current = leftmost(Tree.this)

      private def leftmost(root: Tree[A]): Tree[A] = {
        root match {
          case Empty => Empty
          case root@Node(_, left, right) =>
            if (left == Empty) {
              root
            } else {
              stack.push(root)
              leftmost(left)
            }
        }
      }

      override def hasNext: Boolean = current != null

      override def next(): A = {
        current match {
          case Empty => Iterator.empty.next()
          case Node(value, _, right) =>
            current = if (right != Empty) leftmost(right) else stack.pop()
            value
        }
      }
    }

    def map[B](f: A => B)(implicit ordering: Ordering[B]): Tree[B] = this match {
      case Empty => Empty
      case Node(value, left, right) => Node(f(value), left map f, right map f)
    }
  }

  case class Node[A](value: A, left: Tree[A], right: Tree[A])(implicit ordering: Ordering[A]) extends Tree[A]

  object Empty extends Tree
}
