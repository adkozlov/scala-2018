package ru.spbau.jvm.scala.avltree

abstract sealed class AvlTree[+T] {
  def height: Int

  def balanced(): Boolean

  def foreach(f: T => Unit): Unit

  def map[B](f: T => B)(implicit ord: Ordering[B]): AvlTree[B]

  def flatMap[B](f: T => AvlTree[B])(implicit ord: Ordering[B]): AvlTree[B]

  def max(): T

  def min(): T
}

case object AvlNil extends AvlTree[Nothing] {
  override def height: Int = 0

  override def balanced() = true

  override def foreach(f: Nothing => Unit): Unit = {}

  override def map[B](f: Nothing => B)(implicit ord: Ordering[B]): AvlTree[B] = AvlNil

  override def flatMap[B](f: Nothing => AvlTree[B])(implicit ord: Ordering[B]): AvlTree[B] = AvlNil

  def max(): Nothing = throw new IllegalStateException()

  def min(): Nothing = throw new IllegalStateException()
}

final case class AvlNode[+T](value: T, left: AvlTree[T], right: AvlTree[T]) extends AvlTree[T] {
  override def height: Int = math.max(left.height, right.height) + 1

  override def balanced(): Boolean = {
    if (!left.balanced()
      | !right.balanced()
      | math.abs(left.height - right.height) > 1) false
    else true
  }

  override def foreach(f: T => Unit): Unit = {
    left.foreach(f)
    f(value)
    right.foreach(f)
  }

  override def map[B](f: T => B)(implicit ord: Ordering[B]): AvlTree[B] = {
    var res: AvlTree[B] = AvlNil
    val func = (v: T) => res = AvlTree.insert(f(v), res)
    foreach(func)
    res
  }

  override def flatMap[B](f: T => AvlTree[B])(implicit ord: Ordering[B]): AvlTree[B] = {
    var res: AvlTree[B] = AvlNil
    val func = (v: T) => f(v).foreach(x => res = AvlTree.insert(x, res))
    foreach(func)
    res
  }

  override def max(): T = right match {
    case AvlNil => value
    case rright => rright.max()
  }

  def min(): T = left match {
    case AvlNil => value
    case lleft => lleft.min()
  }
}

object AvlTree {
  def apply[A](elems: A*)(implicit ord: Ordering[A]): AvlTree[A] = {
    var res: AvlTree[A] = AvlNil
    for (elem <- elems) {
      res = AvlTree.insert(elem, res)
    }
    res
  }

  def insert[A](elem: A, tree: AvlTree[A])(implicit ord: Ordering[A]): AvlTree[A] = tree match {
    case AvlNil => AvlNode(elem, AvlNil, AvlNil)
    case AvlNode(v, l, r) => ord.compare(v, elem) match {
      case -1 => rotate(AvlNode[A](v, l, insert(elem, r)))
      case _ => rotate(AvlNode[A](v, insert(elem, l), r))
    }
  }

  def removeMin[A](tree: AvlTree[A])(implicit ord: Ordering[A]): AvlTree[A] = tree match {
    case AvlNil => throw new IllegalStateException()
    case AvlNode(v, l, r) => l match {
      case AvlNil => r
      case _ => rotate(AvlNode(v, removeMin(l), r))
    }
  }

  def remove[A](elem: A, tree: AvlTree[A])(implicit ord: Ordering[A]): AvlTree[A] = rotate(tree match {
    case AvlNil => AvlNil
    case AvlNode(v, l, r) => ord.compare(v, elem) match {
      case -1 => AvlNode(v, l, remove(elem, r))
      case 1 => AvlNode(v, remove(elem, l), r)
      case 0 => r match {
        case AvlNil => l
        case _ => rotate(AvlNode(r.min(), l, removeMin(r)))
      }
    }
  })

  def contains[A](elem: A, tree: AvlTree[A])(implicit ord: Ordering[A]): Boolean = tree match {
    case AvlNil => false
    case AvlNode(v, l, r) => ord.compare(v, elem) match {
      case 0 => true
      case -1 => contains(elem, r)
      case 1 => contains(elem, l)
    }
  }

  def rotate[A](tree: AvlTree[A]): AvlTree[A] = tree match {
    case AvlNil => AvlNil

    case AvlNode(v, l, r) if !l.balanced() => AvlNode(v, rotate(l), r)

    case AvlNode(v, l, r) if !r.balanced() => AvlNode(v, l, rotate(r))

    case AvlNode(v, l, r@AvlNode(rv, rl, rr))
      if l.height + 1 < r.height && rl.height <= rr.height =>
      AvlNode(rv, AvlNode(v, l, rl), rr) //simple left rotation

    case AvlNode(v, l@AvlNode(lv, ll, lr), r)
      if r.height + 1 < l.height && lr.height <= ll.height =>
      AvlNode(lv, ll, AvlNode(v, lr, r)) //simple right rotation

    case AvlNode(v, l, r@AvlNode(rv, rl@AvlNode(rlv, rll, rlr), rr))
      if l.height + 1 < r.height && rl.height > rr.height =>
      AvlNode(rlv, AvlNode(v, l, rll), AvlNode(rv, rlr, rr)) //double left rotation

    case AvlNode(v, l@AvlNode(lv, ll, lr@AvlNode(lrv, lrl, lrr)), r)
      if r.height + 1 < l.height && lr.height > ll.height =>
      AvlNode(lrv, AvlNode(lv, ll, lrl), AvlNode(v, lrr, r)) // double right rotation

    case node => node
  }

  def foldl[A, B](f: (A, B) => A, ini: A, tree: AvlTree[B]): A = tree match {
    case AvlNil => ini
    case AvlNode(v, l, r) => val lini = foldl(f, ini, l)
      foldl(f, f(lini, v), r)
  }
}