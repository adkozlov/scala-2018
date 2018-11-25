package ru.hse.scala.nedikov.tree

import scala.util.Random

sealed abstract class Treap[+A] {
  val size: Int = 0
}

case object TreapEmpty extends Treap[Nothing]

case class TreapNode[+A](key: A, priority: Int, left: Treap[A], right: Treap[A]) extends Treap[A] {
  def this(key: A) = this(key, Random.nextInt(), TreapEmpty, TreapEmpty)

  override val size: Int = left.size + right.size + 1

}

object TreapNode {
  def apply[A](key: A): Treap[A] = new TreapNode[A](key)
}

object Treap {
  private def compareInt(x: Int, y: Int): Int = math.signum(x - y)
  private def compare[A](x: A, y: A)(implicit ord: Ordering[A]): Int = math.signum(ord.compare(x, y))

  def split[A](treap: Treap[A], key: A)(implicit ord: Ordering[A]): (Treap[A], Treap[A]) = {
    split(treap, key, compare[A])
  }

  def splitGreater[A](treap: Treap[A], key: A)(implicit ord: Ordering[A]): (Treap[A], Treap[A]) = {
    split(treap, key, (x: A, y: A) => math.signum(ord.compare(x, y) + 1))
  }

  private def split[A](treap: Treap[A], key: A, compare: (A, A) => Int): (Treap[A], Treap[A]) = treap match {
    case TreapEmpty                      => (TreapEmpty, TreapEmpty)
    case TreapNode(key2, p, left, right) => compare(key, key2) match {
      case 1 =>
        val (tl, tr) = split(right, key, compare)
        (TreapNode(key2, p, left, tl), tr)
      case _ =>
        val (tl, tr) = split(left, key, compare)
        (tl, TreapNode(key2, p, tr, right))
    }
  }

  def merge[A](treap1: Treap[A], treap2: Treap[A]): Treap[A] = treap1 match {
    case TreapEmpty => treap2
    case TreapNode(k1, p1, l1, r1) => treap2 match {
      case TreapEmpty => treap1
      case TreapNode(k2, p2, l2, r2) => compareInt(p1, p2) match {
        case 1 => TreapNode(k1, p1, l1, merge(r1, treap2))
        case _ => TreapNode(k2, p2, merge(treap1, l2), r2)
      }
    }
  }

  def add[A](treap: Treap[A], value: A)(implicit ord: Ordering[A]): Treap[A] = {
    val (l, r) = split(treap, value)
    merge(l, merge(TreapNode(value), r))
  }

  def remove[A](treap: Treap[A], value: A)(implicit ord: Ordering[A]): Treap[A] = {
    val (l, c) = split(treap, value)
    val (_, r) = splitGreater(c, value)
    merge(l, r)
  }

  def contains[A](treap: Treap[A], value: A)(implicit ord: Ordering[A]): Boolean = treap match {
    case TreapEmpty                     => false
    case TreapNode(key, _, left, right) => compare(value, key) match {
      case 0  => true
      case 1  => contains(right, value)
      case -1 => contains(left, value)
    }
  }
}
