package ru.hse.jvm.scala.set

sealed abstract class AVLTree[+K] {
  val height: Int
  val balance: Int
  val size: Int

  def add[V >: K](newKey: V)(implicit keyOrdering: Ordering[V]): AVLTree[V] =
    (this match {
      case AVLNil => AVLNode(AVLNil, newKey, AVLNil)
      case AVLNode(left, key, right) => keyOrdering.compare(newKey, key) match {
        case c if negative(c) => AVLNode(left.add(newKey), key, right)
        case 0 => this
        case c if positive(c) => AVLNode(left, key, right.add(newKey))
      }
    }).rebalance()

  def erase[V >: K](deletedKey: V)(implicit keyOrdering: Ordering[V]): AVLTree[K] =
    (this match {
      case AVLNil => this
      case AVLNode(left, key, right) => keyOrdering.compare(deletedKey, key) match {
        case c if negative(c) => AVLNode(left.erase(deletedKey), key, right)
        case 0 => left match {
          case AVLNil => right
          case _ =>
            val prev = left.max()
            AVLNode(left.removeMax(), prev, right)
        }
        case c if positive(c) => AVLNode(left, key, right.erase(deletedKey))
      }
    }).rebalance()

  def contains[V >: K](searchedKey: V)(implicit keyOrdering: Ordering[V]): Boolean = this match {
    case AVLNil => false
    case AVLNode(left, key, right) => keyOrdering.compare(searchedKey, key) match {
      case c if negative(c) => left.contains(searchedKey)
      case 0 => true
      case c if positive(c) => right.contains(searchedKey)
    }
  }

  protected def rebalance(): AVLTree[K] = this match {
    case AVLNode(left, key, right) => balance match {
      case -2 => if (right.balance <= 0) this.rotateLeft() else this.rotateRightLeft()
      case 2 => if (left.balance >= 0) this.rotateRight() else this.rotateLeftRight()
      case b if -1 <= b && b <= 1 => this
      case _ => throw new IllegalStateException()
    }
    case AVLNil => this
  }

  def max(): K = this match {
    case AVLNode(_, key, AVLNil) => key
    case AVLNode(_, _, right) => right.max()
    case _ => throw new NoSuchElementException
  }

  protected def removeMax(): AVLTree[K] = this match {
    case AVLNode(left, _, AVLNil) => left
    case AVLNode(left, key, right) => AVLNode(left, key, right.removeMax())
    case _ => throw new NoSuchElementException
  }

  protected def rotateLeft(): AVLTree[K] = this match {
    case AVLNode(outerLeft, outerKey, AVLNode(left, key, right)) =>
      AVLNode(AVLNode(outerLeft, outerKey, left), key, right)
    case _ => throw new IllegalStateException
  }

  protected def rotateRight(): AVLTree[K] = this match {
    case AVLNode(AVLNode(left, key, right), outerKey, outerRight) =>
      AVLNode(left, key, AVLNode(right, outerKey, outerRight))
    case _ => throw new IllegalStateException
  }

  protected def rotateRightLeft(): AVLTree[K] = this match {
    case AVLNode(left, key, right) =>
      AVLNode(left, key, right.rotateRight()).rotateLeft()
    case _ => throw new IllegalStateException
  }

  protected def rotateLeftRight(): AVLTree[K] = this match {
    case AVLNode(left, key, right) =>
      AVLNode(left.rotateLeft(), key, right).rotateRight()
    case _ => throw new IllegalStateException
  }

  protected def positive(c: Int): Boolean = if (c > 0) true else false
  protected def negative(c: Int): Boolean = if (c < 0) true else false
}

case object AVLNil extends AVLTree[Nothing] {
  override val height: Int = 0
  override val balance: Int = 0
  override val size: Int = 0
}

case class AVLNode[K](left: AVLTree[K], key: K, right: AVLTree[K]) extends AVLTree[K] {
  override val height: Int = 1 + math.max(left.height, right.height)
  override val balance: Int = left.height - right.height
  override val size: Int = 1 + left.size + right.size
}


