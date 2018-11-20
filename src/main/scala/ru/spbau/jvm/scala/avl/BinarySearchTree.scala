package ru.spbau.jvm.scala.avl

sealed class BinarySearchTree[A] private[BinarySearchTree] (tree: Tree[A])(implicit val ordering: Ordering[A]) {
  def this()(implicit ord: Ordering[A]) = this(TreeNode.empty)(ord)

  def this(elements: Array[A])(implicit ord: Ordering[A]) = {
    this()
    elements.foreach(this.+)
  }

  def find(element: A): Option[BinarySearchTree[A]] = TreeNode.find(element)(tree) match {
    case Some(subtree) => Some(new BinarySearchTree(subtree))
    case _ => None
  }

  def contains(element: A): Boolean = find(element).isDefined

  def +(element: A): Either[BinarySearchTree[A], String] = TreeNode.insert(element)(tree) match {
    case Left(newTree) => Left(new BinarySearchTree(newTree))
    case Right(message) => Right(message)
  }

  def -(key: A): Either[BinarySearchTree[A], String] = TreeNode.removeKey(key)(tree) match {
    case Left(newTree) => Left(new BinarySearchTree(newTree))
    case Right(message) => Right(message)
  }

  def ++(otherBST: BinarySearchTree[A]): BinarySearchTree[A] = {
    var mergedTree = this
    otherBST.foreach(key => {
      mergedTree = mergedTree + key match {
        case Left(newTree) => newTree
        case _ => mergedTree
      }
    })
    mergedTree
  }

  def inorder: Seq[A] = TreeNode.inorder(tree)

  def size: Int = TreeNode.size(tree)
  def depth: Int = TreeNode.depth(tree)

  def min: Option[A] = TreeNode.min(tree)
  def max: Option[A] = TreeNode.max(tree)

  def nearestLower: Option[A] = TreeNode.nearestLower(tree)
  def nearestUpper: Option[A] = TreeNode.nearestUpper(tree)

  def map[B: Ordering](function: A => B): BinarySearchTree[B] = new BinarySearchTree(TreeNode.map(function)(tree))
  def foreach(action: A => Unit): Unit = TreeNode.foreach(action)(tree)
  def withFilter(predicate: A => Boolean): BinarySearchTree[A] = new BinarySearchTree(TreeNode.withFilter(predicate)(tree))

  def foldRight[B: Ordering](function: (A, B) => B)(initial: B): B = inorder.foldRight[B](initial)(function)
  def foldLeft[B: Ordering](function: (B, A) => B)(initial: B): B = inorder.foldLeft[B](initial)(function)
}

object BinarySearchTree {
  def apply[A: Ordering](element: A): BinarySearchTree[A] = new BinarySearchTree[A](new TreeNode[A](element))
  def apply[A: Ordering](elements: A*): BinarySearchTree[A] = {
    val tree = new BinarySearchTree[A]()
    elements.foreach(tree +)
    tree
  }

  def unapplySeq[A: Ordering](tree: BinarySearchTree[A]): Option[Seq[A]] = Some(tree.inorder)
}