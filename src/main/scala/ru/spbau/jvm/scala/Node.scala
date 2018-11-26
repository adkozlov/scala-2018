package ru.spbau.jvm.scala

sealed class Node[+A] {

  def split(implicit ordering: Ordering[_  <: A], x: _ <: A): (Node[A], Node[A]) =
    this match {
      case Empty => (Empty, Empty)
      case Value(l, r, v, y) =>
        if (ordering(v, x)) {
          val (l1, r1): (Node[A], Node[A]) = l.split(ordering, x)
          (l1, Value(r1, r, v, y))
        } else {
          val (l1, r1): (Node[A], Node[A]) = r.split(ordering, x)
          (Value(l, l1, v, y), r1)
        }
    }

  def merge(implicit  ordering: Ordering[_ <: A],
            other: _ <: Node[A]): Node[A] =
    (this, other) match {
      case (Empty, _) => other
      case (_, Empty) => this
      case (Value(ll, lr, lx, ly), Value(rl, rr, rx, ry)) =>
        if (ly < ry)
          Value(this.merge(ordering, rl), rr, rx, ry)
        else
          Value(ll, lr.merge(ordering, other), lx, ly)
    }
}

case object Empty extends Node[Nothing]
case class Value[A](l: Node[A], r: Node[A], x: A, y: Int) extends Node[A]