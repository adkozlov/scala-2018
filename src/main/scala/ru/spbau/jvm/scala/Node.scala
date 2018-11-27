package ru.spbau.jvm.scala

import scala.util.Random

sealed abstract class Node[+A] {
  def makeTreap: Node[A]
}

case object Empty extends Node[Nothing] {
  override def makeTreap: Node[Nothing] = this
}

final case class Value[+A](l: Node[A], r: Node[A], x: A, y: Int) extends Node[A] {
  override def makeTreap: Node[A] = copy()
}

object Node {
  def empty[A]():Node[A] = Empty.makeTreap

  def of[A](x: A): Node[A] = Value(Empty, Empty, x, Random.nextInt()).makeTreap

  def split[A](t: Node[A], v: A)(implicit ordering: Ordering[A]): (Node[A], Node[A]) =
    t match {
      case Empty => (Empty, Empty)
      case Value(l, r, x, y) =>
        import ordering._
        if (v < x) {
          val (l1, r1): (Node[A], Node[A]) = split(l, v)
          (l1, Value(r1, r, x, y))
        } else {
          val (l1, r1): (Node[A], Node[A]) = split(r, v)
          (Value(l, l1, x, y), r1)
        }
    }

  def merge[A](that: Node[A], other: Node[A]): Node[A] =
    (that, other) match {
      case (Empty, _) => other
      case (_, Empty) => that
      case (Value(ll, lr, lx, ly), Value(rl, rr, rx, ry)) =>
        if (ly < ry)
          Value(merge(that, rl), rr, rx, ry)
        else
          Value(ll, merge(lr, other), lx, ly)
    }

  def add[A](t: Node[A], e: A)(implicit ordering: Ordering[A]): Node[A] = {
    if (contains(t, e))
      return t
    val (lt, rt) = split(t, e)(ordering)
    merge(merge(lt, of(e)), rt).makeTreap
  }

  def clear[A](): Node[A] = Empty.makeTreap

  def contains[A](t: Node[A], e: A)(implicit ordering: Ordering[A]): Boolean = t match {
    case Empty => false
    case Value(l, r, x, _) =>
      import ordering._
      if (e == x) true
      else if (e < x) contains(l, e)
      else contains(r, e)
  }

  def flatMap[A, B](t: Node[A], f: A => Node[B])(implicit ordering: Ordering[B]): Node[B] = t match {
    case Empty => Empty
    case Value(_, _, _, _) =>
      var res: Node[B] = Empty
      forEach[A](t, e =>
        forEach[B](f(e), z =>
          res = Node.add(res, z)(ordering)
        )
      )
      res
  }

  def forEach[A](t: Node[A], f: A => Unit): Unit = t match {
    case Empty => Unit
    case Value(l, r, x, _) =>
      forEach(l, f)
      f(x)
      forEach(r, f)
  }

  def map[A, B](t: Node[A], f: A => B)(implicit ordering: Ordering[B]): Node[B] = t match {
    case Empty => Empty
    case Value(_, _, _, _) =>
      var res: Node[B] = Empty
      forEach[A](t, x => res = add(res, f(x))(ordering))
      res
  }

  def remove[A](t: Node[A], e: A)(implicit ordering: Ordering[A]): Node[A] = t match {
    case Empty => Empty
    case Value(l, r, x, y) =>
      import ordering._
      if (e == x) merge(l, r).makeTreap
      else if (e < x) Value(remove(l, e), r, x, y).makeTreap
      else Value(l, remove(r, e), x, y).makeTreap
  }

  def size[A](t: Node[A]): Int = t match {
    case Empty => 0
    case Value(l, r, _, _) => 1 + size(l) + size(r)
  }
}