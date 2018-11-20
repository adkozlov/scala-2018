package ru.spbau.jvm.scala.tree

sealed abstract class AVLTree[+A] {
  val height: Int
  def balance: Int
}

case object AVLNil extends AVLTree[Nothing] {
  override val height: Int = 0
  override def balance: Int = 0
}

case class AVLNode[+A](key: A, left: AVLTree[A], right: AVLTree[A]) extends AVLTree[A] {
  def this(value: A) = this(value, AVLNil, AVLNil)

  override val height: Int = 1 + math.max(left.height, right.height)

  override def balance: Int = right.height - left.height
}

object AVLTree {
  private def rotateLeft[A](tree: AVLTree[A])(implicit ord: Ordering[A]): AVLTree[A] = tree match {
    case AVLNode(a, p, AVLNode(b, q, r)) => AVLNode(b, AVLNode(a, p, q), r)
    case _ => throw new IllegalStateException()
  }

  private def rotateRight[A](tree: AVLTree[A])(implicit ord: Ordering[A]): AVLTree[A] = tree match {
    case AVLNode(a, AVLNode(b, p, q), r) => AVLNode(b, p, AVLNode(a, q, r))
    case _ => throw new IllegalStateException()
  }

  private def bigRotateLeft[A](tree: AVLTree[A])(implicit ord: Ordering[A]): AVLTree[A] = tree match {
    case AVLNode(key, left, right) =>
      val newRight = rotateRight(right)
      rotateLeft(AVLNode(key, left, newRight))
    case _ => throw new IllegalStateException()
  }

  private def bigRotateRight[A](tree: AVLTree[A])(implicit ord: Ordering[A]): AVLTree[A] = tree match {
    case AVLNode(key, left, right) =>
      val newLeft = rotateLeft(left)
      rotateRight(AVLNode(key, newLeft, right))
    case _ => throw new IllegalStateException()
  }

  private def balance[A](tree: AVLTree[A])(implicit ord: Ordering[A]): AVLTree[A] = tree match {
    case AVLNil => AVLNil
    case AVLNode(key, left, right) => tree.balance match {
      case 2 => if (right.balance < 0) bigRotateLeft(tree) else rotateLeft(tree)
      case -2 => if (left.balance > 0) bigRotateRight(tree) else rotateRight(tree)
      case _ => tree
    }
  }

  def insert[A](tree: AVLTree[A])(value: A)(implicit ord: Ordering[A]): AVLTree[A] = {
    val res = tree match {
      case AVLNil => AVLNode(value, AVLNil, AVLNil)
      case AVLNode(key, left, right) => compare(value, key) match {
        case 0 => tree
        case -1 => AVLNode(key, insert(left)(value), right)
        case 1 => AVLNode(key, left, insert(right)(value))
      }
    }
    balance(res)
  }

  private def findMin[A](tree: AVLTree[A]): A = tree match {
    case AVLNil => throw new IllegalStateException()
    case AVLNode(key, AVLNil, _) => key
    case AVLNode(_, left, _) => findMin(left)
  }

  private def removeMin[A](tree: AVLTree[A])(implicit ord: Ordering[A]): AVLTree[A] = tree match {
    case AVLNil => throw new IllegalArgumentException()
    case AVLNode(_, AVLNil, right) => right
    case AVLNode(key, left, right) => balance(AVLNode(key, removeMin(left), right))
  }

  def remove[A](tree: AVLTree[A])(value: A)(implicit ord: Ordering[A]): AVLTree[A] = tree match {
    case AVLNil => AVLNil
    case AVLNode(key, left, right) => compare(value, key) match {
      case -1 => AVLNode(key, remove(left)(value), right)
      case 1 => AVLNode(key, left, remove(right)(value))
      case 0 => right match {
        case AVLNil => left
        case _ => balance(AVLNode(findMin(right), left, removeMin(right)))
      }
    }
  }

  def contains[A](tree: AVLTree[A])(value: A)(implicit ord: Ordering[A]): Boolean = tree match {
    case AVLNode(key, left, right) => compare(value, key) match {
      case -1 => contains(left)(value)
      case 1 => contains(right)(value)
      case 0 => true
    }
    case AVLNil => false
  }

  def count[A](tree: AVLTree[A]): Int = tree match {
    case AVLNil => 0
    case AVLNode(_, left, right) => 1 + count(left) + count(right)
  }

  private def compare[A](x: A, y: A)(implicit ord: Ordering[A]): Int = math.signum(ord.compare(x, y))

}