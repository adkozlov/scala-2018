package ru.spbau.jvm.scala.bst

import java.util.Random


sealed trait Tree[T <: Comparable[T]] {
  def size: Int

  def isEmpty: Boolean = size == 0

  def +(element: T): Tree[T]

  def ++(other: Tree[T]): Tree[T] = foldLeft(other)((tree: Tree[T], t: T) => tree + t)

  def -(element: T): Tree[T]

  def --(other: Tree[T]): Tree[T] = other.foldLeft(this)((tree: Tree[T], t: T) => tree - t)

  def empty: Tree[T] = EmptyTree()

  def contains(element: T): Boolean

  def apply(element: T): Boolean = contains(element)

  def foreach(f: T => Unit): Unit

  def map[U <: Comparable[U]](f: T => U): Tree[U] = foldLeft(Tree[U])((tree, element) => tree + f(element))

  def &(other: Tree[T]): Tree[T] = withFilter((t: T) => other(t))

  def intersect(other: Tree[T]): Tree[T] = this & other

  def |(other: Tree[T]): Tree[T] = this ++ other

  def union(other: Tree[T]): Tree[T] = this ++ other

  def &~(other: Tree[T]): Tree[T] = (this -- other) ++ (other -- this)

  def diff(other: Tree[T]): Tree[T] = this &~ other

  def flatMap[U <: Comparable[U]](f: T => Tree[U]): Tree[U] = foldLeft(Tree[U])((tree, element) => tree ++ f(element))

  def withFilter(p: T => Boolean): Tree[T] = foldLeft(empty)((tree: Tree[T], t: T) => if (p(t)) tree + t else tree)

  def foldLeft[U](acc: U)(f: (U, T) => U): U

  def split(key: T): (Tree[T], Tree[T])

  def merge(greaterTree: Tree[T]): Tree[T]
}

object Tree {
  def apply[T <: Comparable[T]]: Tree[T] = EmptyTree[T]()
  def apply[T <: Comparable[T]](elements : T*) : Tree[T] = elements.foldLeft(Tree[T])((tree: Tree[T], t: T) => tree + t)
}

case class Node[T <: Comparable[T]](leftChild: Tree[T], rightChild: Tree[T], key: T, priority: Int) extends Tree[T] {
  private val numberOfElements = leftChild.size + rightChild.size + 1

  override def size: Int = numberOfElements

  override def +(element: T): Tree[T] = {
    val (left, right) = split(element)
    Node(left, right, element)
  }

  override def -(element: T): Tree[T] = {
    val (left, right) = split(element)
    left.merge(right)
  }

  override def contains(element: T): Boolean = {
    val compare = element.compareTo(key)
    compare match {
      case 0 => true
      case x if x < 0 => leftChild.contains(element)
      case _ => rightChild.contains(element)
    }
  }

  override def foreach(f: T => Unit): Unit = {
    leftChild.foreach(f)
    f(key)
    rightChild.foreach(f)
  }

  override def split(keyToSplit: T): (Tree[T], Tree[T]) = {
    def splitLeft: (Tree[T], Tree[T]) = {
      val (leftTree, rightTree) = leftChild.split(keyToSplit)
      (leftTree, rightTree.merge(Node(empty, rightChild, key, priority)))
    }

    def splitRight: (Tree[T], Tree[T]) = {
      val (leftTree, rightTree) = rightChild.split(keyToSplit)
      (Node(leftChild, empty, key, priority).merge(leftTree), rightTree)
    }

    val compare = keyToSplit.compareTo(key)
    compare match {
      case 0 => (leftChild, rightChild)
      case x if x < 0 => splitLeft
      case _ => splitRight
    }
  }

  override def merge(greaterTree: Tree[T]): Tree[T] = {
    greaterTree match {
      case EmptyTree() => this
      case Node(left, right, otherKey, prior) if prior < priority => Node(merge(left), right, otherKey, prior)
      case _ => Node(leftChild, rightChild.merge(greaterTree), key, priority)
    }
  }

  override def foldLeft[U](acc: U)(f: (U, T) => U): U = {
    rightChild.foldLeft(f(leftChild.foldLeft(acc)(f), key))(f)
  }

  override def toString: String = {
    val result: StringBuilder = new StringBuilder
    result.append("(")
    result.append(leftChild.toString)
    result.append(") " + key + " (")
    result.append(rightChild.toString)
    result.append(")")
    result.toString
  }
}

object Node {
  val random: Random = new Random()

  def apply[T <: Comparable[T]](leftChild: Tree[T], rightChild: Tree[T], key: T): Node[T] =
    new Node[T](leftChild, rightChild, key, random.nextInt())

  def apply[T <: Comparable[T]](key: T): Node[T] =
    new Node[T](EmptyTree[T](), EmptyTree[T](), key, random.nextInt())
}

case class EmptyTree[T <: Comparable[T]]() extends Tree[T] {

  override def +(element: T): Tree[T] = Node(element)

  override def -(element: T): Tree[T] = this

  override def contains(element: T): Boolean = false

  override def foreach(f: T => Unit): Unit = Unit

  override def map[U <: Comparable[U]](f: T => U): Tree[U] = EmptyTree[U]()

  override def flatMap[U <: Comparable[U]](f: T => Tree[U]): Tree[U] = EmptyTree[U]()

  override def split(key: T): (Tree[T], Tree[T]) = (empty, empty)

  override def merge(greaterTree: Tree[T]): Tree[T] = greaterTree

  override def size: Int = 0

  override def foldLeft[U](acc: U)(f: (U, T) => U): U = acc

  override def toString: String = "Empty"
}