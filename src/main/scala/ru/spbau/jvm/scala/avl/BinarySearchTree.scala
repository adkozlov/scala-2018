package ru.spbau.jvm.scala.avl

sealed class BinarySearchTree[A] private (tree: Tree[A])(implicit val ordering: Ordering[A]) {
  def this()(implicit ord: Ordering[A]) = this(TreeNode.empty)(ord)

  def find(element: A): Option[BinarySearchTree[A]] = TreeNode.find(element)(tree) match {
    case Some(subtree) => Some(new BinarySearchTree(subtree))
    case _ => None
  }

  def contains(element: A): Boolean = find(element).isDefined

  def insert(element: A): Either[BinarySearchTree[A], String] = TreeNode.insert(element)(tree) match {
    case Left(newTree) => Left(new BinarySearchTree(newTree))
    case Right(message) => Right(message)
  }

  def removeKey(key: A): Either[BinarySearchTree[A], String] = TreeNode.removeKey(key)(tree) match {
    case Left(newTree) => Left(new BinarySearchTree(newTree))
    case Right(message) => Right(message)
  }

  def size: Int = TreeNode.size(tree)
  def depth: Int = TreeNode.depth(tree)

  def min: Option[A] = TreeNode.min(tree)
  def max: Option[A] = TreeNode.max(tree)

  def nearestLower: Option[A] = TreeNode.nearestLower(tree)
  def nearestUpper: Option[A] = TreeNode.nearestUpper(tree)
}