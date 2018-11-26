package ru.spbau.jvm.scala.avl

sealed class AvlTree[A] private[AvlTree](tree: Tree[A])(implicit val ordering: Ordering[A]) {
  def this()(implicit ord: Ordering[A]) = this(AvlNode.empty)(ord)

  def this(elements: Array[A])(implicit ord: Ordering[A]) = {
    this()
    elements.foreach(this.+)
  }

  def key: Option[A] = AvlNode.key(tree)

  def find(element: A): Option[AvlTree[A]] = AvlNode.find(element)(tree) match {
    case Some(subtree) => Some(new AvlTree(subtree))
    case _ => None
  }

  def contains(element: A): Boolean = find(element).isDefined

  def +(element: A): Either[String, AvlTree[A]] = AvlNode.insert(element)(tree) match {
    case Left(message) => Left(message)
    case Right(newTree) => Right(new AvlTree(newTree))
  }

  def -(key: A): Either[String, AvlTree[A]] = AvlNode.removeKey(key)(tree) match {
    case Left(message) => Left(message)
    case Right(newTree) => Right(new AvlTree(newTree))
  }

  def ++(otherBST: AvlTree[A]): AvlTree[A] = {
    var mergedTree = this
    otherBST.foreach(key => {
      mergedTree = mergedTree + key match {
        case Right(newTree) => newTree
        case _ => mergedTree
      }
    })
    mergedTree
  }

  def inorder: Seq[A] = AvlNode.inorder(tree)

  def size: Int = AvlNode.size(tree)
  def height: Int = AvlNode.height(tree)

  def min: Option[A] = AvlNode.min(tree)
  def max: Option[A] = AvlNode.max(tree)

  def predecessor: Option[A] = AvlNode.predecessor(tree)
  def successor: Option[A] = AvlNode.successor(tree)

  def map[B: Ordering](function: A => B): AvlTree[B] = new AvlTree(AvlNode.map(function)(tree))
  def foreach(action: A => Unit): Unit = AvlNode.foreach(action)(tree)
  def withFilter(predicate: A => Boolean): AvlTree[A] = new AvlTree(AvlNode.withFilter(predicate)(tree))

  def foldRight[B: Ordering](function: (A, B) => B)(initial: B): B = inorder.foldRight[B](initial)(function)
  def foldLeft[B: Ordering](function: (B, A) => B)(initial: B): B = inorder.foldLeft[B](initial)(function)
}

object AvlTree {
  def apply[A: Ordering](element: A): AvlTree[A] = new AvlTree[A](AvlNode[A](element))
  def apply[A: Ordering](elements: A*): AvlTree[A] = {
    val tree = new AvlTree[A]()
    elements.foreach(tree +)
    tree
  }

  def unapplySeq[A: Ordering](tree: AvlTree[A]): Option[Seq[A]] = Some(tree.inorder)
}