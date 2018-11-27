package ru.spbau.jvm.scala

import scala.util.Random

object Treap {

  def of[A](x: A):Treap[A] = Value(Empty, Empty, x, Random.nextInt())

  def empty[A]:Treap[A] = Empty[A]
}

sealed class Treap[A <: Ordered[A]]() extends ImmutableCollection[A] {

  def split(x: _ <: A): (Treap[A], Treap[A]) =
    this match {
      case Empty => (Empty[A], Empty[A])
      case Value(l, r, v, y) =>
        if (v < x) {
          val (l1, r1): (Treap[A], Treap[A]) = l.split(x)
          (l1, Value(r1, r, v, y))
        } else {
          val (l1, r1): (Treap[A], Treap[A]) = r.split(x)
          (Value(l, l1, v, y), r1)
        }
    }

  def merge(other: _ <: Treap[A]): Treap[A] =
    (this, other) match {
      case (Empty, _) => other
      case (_, Empty) => this
      case (Value(ll, lr, lx, ly), Value(rl, rr, rx, ry)) =>
        if (ly < ry)
          Value(this.merge(rl), rr, rx, ry)
        else
          Value(ll, lr.merge(other), lx, ly)
    }

  override def add(e: _ <: A): Treap[A] = {
    val (lt, rt) = this.split(e)
    lt.merge(Treap.of(e)).merge(rt)
  }

  override def clear(): Treap[A] = Empty[A]

  override def contains(e: _ <: A): Boolean = this match {
    case Empty => false
    case Value(l, r, x, _) => e compare x match {
      case 0 => true
      case i if i < 0 => l contains e
      case i if i > 0 => r contains e
    }
  }

  override def flatMap[B](f: A => ImmutableCollection[B]): ImmutableCollection[B] = this match {
    case Empty => Empty[B]
    case Value(_, _, _, _) =>
      var res: Treap[B] = Empty[B]
      this.forEach(x =>
        f(x).forEach(z =>
          res = res.add(z)
        )
      )
      res
  }

  override def forEach[U](f: A => Unit): Unit = this match {
    case Empty => Unit
    case Value(l, r, x, _) =>
      l.forEach(f)
      f(x)
      r.forEach(f)
  }

  override def map[B](f: A => B): Treap[B] = this match {
    case Empty => Empty[B]
    case Value(_, _, _, _) =>
      var res: Treap[B] = Empty[B]
      this.forEach(x => res = res.add(f(x)))
      res
  }

  override def remove(e: _ <: A): Treap[A] = this match {
    case Empty => Empty[A]
    case Value(l, r, x, y) => e compare x match {
      case 0 => l merge r
      case i if i < 0 => Value(l.remove(e), r, x, y)
      case i if i > 0 => Value(l, r.remove(e), x, y)
    }
  }

  override def size: Int = this match {
    case Empty => 0
    case Value(l, r, _, _) => 1 + l.size + r.size
  }
}

case object Empty extends Treap[Nothing]
case class Value[A](l: Treap[A], r: Treap[A], x: A, y: Int) extends Treap[A]