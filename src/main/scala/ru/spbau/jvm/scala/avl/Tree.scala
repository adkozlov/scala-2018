package ru.spbau.jvm.scala.avl

sealed abstract class Tree[+A] {
  abstract def foreach(action: A => Unit)

  abstract def map[P](action: A => P): Tree[P]
}

object Tree {
  def depth[A](t: Tree[A]): Int = t match {
    case NIL => 0
    case Node(_, l, r) => 1 + math.max(depth(l), depth(r))
  }

  def diff[A](t: Tree[A]): Int = t match {
    case NIL => 0
    case Node(_, l, r) => depth(l) - depth(r)
  }


  def insert[A: Ordering](tree: Tree[A])(newVal: A)(implicit ord: Ordering[A]): Tree[A] = repair(
    tree match {
      case NIL => Node(newVal, NIL, NIL)
      case Node(v, l, r) => ord.compare(newVal, v) match {
        case 0 => tree
        case -1 => Node(v, insert(l)(newVal), r)
        case 1 => Node(v, l, insert(r)(newVal))
      }
    }
  )

  def contains[T: Ordering](key: T, tree: Tree[T])(implicit ord: Ordering[T]): Boolean = tree match {
    case Node(v, l, r) =>
      ord.compare(v, key) match {
        case 0 => true
        case 1 => contains(key, l)
        case -1 => contains(key, r)
      }
    case NIL => false
  }

  def remove[A: Ordering](key: A, tree: Tree[A])(implicit ord: Ordering[A]): Tree[A] = repair(
    tree match {
      case tree@Node(v, NIL, NIL) => {
        if (ord.equiv(v, key)) NIL
        else tree
      }

      case tree@Node(v, l, NIL) => {
        ord.compare(v, key) match {
          case 0 => l
          case 1 => Node(v, remove(key, l), NIL)
          case -1 => tree
        }
      }

      case tree@Node(b, NIL, r) => {
        ord.compare(b, key) match {
          case 0 => r
          case 1 => tree
          case -1 => Node(b, NIL, remove(key, r))
        }
      }
      case Node(b, l, r) => ord.compare(b, key) match {
        case 0 => {
          val m = min(r)
          Node(m, l, remove(m, r))
        }
        case 1 => Node(b, remove(key, l), r)
        case -1 => Node(b, l, remove(key, r))
      }
      case NIL => NIL
    }
  )


  def min[A: Ordering](t: Tree[A]): A = t match {
    case NIL => throw new IllegalArgumentException("Max of AVLNil")
    case Node(v, NIL, _) => v
    case Node(_, l, _) => min(l)
  }


  def max[A: Ordering](t: Tree[A]): A = t match {
    case NIL => throw new IllegalArgumentException("Max of AVLNil")
    case Node(v, _, NIL) => v
    case Node(_, _, r) => max(r)
  }

  def map[A, P](action: A => P)(tree: Tree[A]): Tree[P] = tree match {
    case NIL => NIL
    case Node(v, l, r) => Node(action(v), map(action)(l), map(action)(r))
  }


  /*
   * balance
   */
  private def rightRotate[A](tree: Tree[A]): Tree[A] = tree match {
    case Node(x, Node(z, l, m), r) => {
      Node(z, l, Node(x, m, r))
    }
    case _ => throw new IllegalArgumentException("invalid tree")
  }

  def leftRotate[A](tree: Tree[A]): Tree[A] = tree match {
    case Node(x, l, Node(z, m, r)) => {
      Node(z, Node(x, l, m), r)
    }
    case _ => throw new IllegalArgumentException("invalid tree")
  }

  def rightLeftRotate[A](tree: Tree[A]): Tree[A] = tree match {
    case Node(v, l, r) =>
      val newRight = rightRotate(r)
      leftRotate(Node(v, l, newRight))
    case _ => throw new IllegalStateException()
  }

  def leftRightRotate[A](tree: Tree[A]): Tree[A] = tree match {
    case Node(v, l, r) =>
      val newLeft = leftRotate(l)
      rightRotate(Node(v, newLeft, r))
    case _ => throw new IllegalStateException()
  }


  def repair[A](tree: Tree[A]): Tree[A] = {
    if (tree == NIL) {
      return tree
    }
    val Node(_, l, r) = tree
    diff(tree) match {
      case d if d >= -1 && d <= 1 => tree
      case _ == 2 =>
        val d = diff(l)
        if (d > 0) {
          rightRotate(tree)
        } else if (d < 0) {
          leftRightRotate(tree)
        } else tree
      case _ == -2 =>
        val d = diff(r)
        if (d < 0) {
          leftRotate(tree)
        } else if (d > 0) {
          rightLeftRotate(tree)
        } else tree
      case _ => throw new IllegalArgumentException("invalid tree")
    }
  }
}


case object NIL extends Tree[Nothing] {
  override def foreach(action: Nothing => Unit): Unit = {}

  override def map[P](action: Nothing => P): Tree[P] = NIL
}

case class Node[+A] private(key: A,
                            left: Tree[A],
                            right: Tree[A]) extends Tree[A] {
  def this(label: A) = this(label, NIL, NIL)

  override def foreach(action: A => Unit): Unit = {
    left.foreach(action)
    action(key)
    right.foreach(action)
  }

  override def map[P](action: A => P): Tree[P] = Tree.map(action)(this)
}

