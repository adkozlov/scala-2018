package ru.spbau.jvm.scala.avl

private sealed abstract class Tree[+A]

private case object TreeNil extends Tree[Nothing] {}

private case class TreeNode[+A] private (key: A, left: Tree[A], right: Tree[A]) extends Tree[A] {
  def this(key: A) = this(key, TreeNil, TreeNil)
}

private object TreeNode {
  def find[A](element: A)(tree: Tree[A])(implicit ordering: Ordering[A]): Option[Tree[A]] = tree match {
    case TreeNil => None
    case TreeNode(key, left, right) =>
      ordering.compare(element, key) match {
        case 0 => Some(tree)
        case r if r < 0 => find(element)(left)
        case _ => find(element)(right)
      }
  }

  def insert[A](element: A)(tree: Tree[A])(implicit ordering: Ordering[A]): Either[Tree[A], String] = tree match {
    case TreeNil => Left(new TreeNode(element))
    case TreeNode(key, left, right) =>
      ordering.compare(element, key) match {
        case 0 => Right("Such key already is in tree")
        case r if r < 0 => insert(element)(left) match {
          case Left(newLeft) => Left(new TreeNode(key, newLeft, right))
          case Right(message) => Right(message)
        }
        case _ => insert(element)(right) match {
          case Left(newRight) => Left(new TreeNode(key, left, newRight))
          case Right(message) => Right(message)
        }
      }
  }

  def size[A](tree: Tree[A]): Int = tree match {
    case TreeNil => 0
    case TreeNode(_, left, right) => size(left) + size(right) + 1
  }

  def depth[A](tree: Tree[A]): Int = tree match {
    case TreeNil => 0
    case TreeNode(_, left, right) => 1 + Math.max(depth(left), depth(right))
  }

  def min[A](tree: Tree[A]): Option[A] = tree match {
    case TreeNil => None
    case TreeNode(key, TreeNil, _) => Some(key)
    case TreeNode(_, left, _) => min(left)
  }

  def max[A](tree: Tree[A]): Option[A] = tree match {
    case TreeNil => None
    case TreeNode(key, _, TreeNil) => Some(key)
    case TreeNode(_, _, right) => max(right)
  }

  def nearestLower[A](tree: Tree[A]): Option[A] = tree match {
    case TreeNil => None
    case TreeNode(_, left, _) => max(left)
  }

  def nearestUpper[A](tree: Tree[A]): Option[A] = tree match {
    case TreeNil => None
    case TreeNode(_, _, right) => min(right)
  }

  def empty[A]: Tree[A] = TreeNil
}