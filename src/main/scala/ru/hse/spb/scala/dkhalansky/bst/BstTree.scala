package ru.hse.spb.scala.dkhalansky.bst
import internal._

final class BinarySearchTree[A](tree: RedBlackTree[A])(
    implicit val ordering: Ordering[A]) {

  override def toString() = tree.toString()

  def contains(element: A) = !RedBlackTree.elem(element, tree).isEmpty

  def apply(element: A) = contains(element)

  def foreach(action: A => Unit): Unit = {
    def foreachRBT(tree: RedBlackTree[A]): Unit = tree match {
      case Leaf =>
      case Node(_, leftTree, value, rightTree) =>
        foreachRBT(leftTree)
        action(value)
        foreachRBT(rightTree)
    }
    foreachRBT(tree)
  }

  def map[B](function: A => B)(
      implicit ordering: Ordering[B]): BinarySearchTree[B] = {
    def mapRBT(tree: RedBlackTree[A]): RedBlackTree[B] = tree match {
      case Leaf => Leaf
      case Node(color, leftTree, value, rightTree) =>
        Node(color, mapRBT(leftTree), function(value), mapRBT(rightTree))
    }
    new BinarySearchTree(mapRBT(tree))
  }

  def flatMap[B](function: A => BinarySearchTree[A]): BinarySearchTree[A] = {
    var acc: RedBlackTree[A] = Leaf
    this.foreach { (el: A) =>
      function(el).foreach { (el: A) =>
        acc = RedBlackTree.insert(el, acc)
      }
    }
    new BinarySearchTree(acc)
  }

  def fold[B](function: (A, B) => B, accum: B): B = {
    var acc = accum
    for (v <- this) {
      acc = function(v, acc)
    }
    acc
  }

  def withFilter(predicate: A => Boolean): BinarySearchTree[A] = {
    var acc: RedBlackTree[A] = Leaf
    this.foreach { (el: A) =>
      if (predicate(el)) {
        acc = RedBlackTree.insert(el, acc)
      }
    }
    new BinarySearchTree(acc)
  }

  def +(elem: A): BinarySearchTree[A] = {
    new BinarySearchTree(RedBlackTree.insert(elem, tree))
  }

  def -(elem: A): BinarySearchTree[A] = {
    new BinarySearchTree(RedBlackTree.delete(elem, tree))
  }

}

object BinarySearchTree {

  def apply[T](elements: T*)(
      implicit ordering: Ordering[T]): BinarySearchTree[T] = {
    var tree: RedBlackTree[T] = Leaf
    for (e <- elements) {
      tree = RedBlackTree.insert(e, tree)
    }
    new BinarySearchTree(tree)
  }

  def empty[T](implicit ordering: Ordering[T]): BinarySearchTree[T] =
    new BinarySearchTree(Leaf)

}
