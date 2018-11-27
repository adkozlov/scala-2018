package ru.spbau.jvm.scala

case class Treap[A](root: Node[A] = Node.empty())(implicit ordering: Ordering[A]) {

  def add(e: A): Treap[A] = Treap(Node.add(root, e)(ordering))

  def addAll(c: Treap[A]): Treap[A] = {
    var res = this
    c.forEach(e => res = res.add(e))
    res
  }

  def clear(): Treap[A] = Treap()

  def contains(e: A): Boolean = Node.contains(root, e)(ordering)

  def containsAll(c: Treap[A]): Boolean = {
    var res = true
    c.forEach(res &= contains(_))
    res
  }

  def flatMap[B](f: A => Treap[B])(implicit orderingB: Ordering[B]): Treap[B] =
    Treap(Node.flatMap[A, B](root, x => f(x).root)(orderingB))(orderingB)

  def forEach(f: A => Unit): Unit = Node.forEach(root, f)

  def isEmpty:Boolean = size == 0

  def map[B](f: A => B)(implicit orderingB: Ordering[B]): Treap[B] =
    Treap(Node.map(root, f)(orderingB))(orderingB)

  def remove(e: A): Treap[A] = Treap(Node.remove(root, e)(ordering))

  def removeAll(c: Treap[A]): Treap[A] = {
    var res = this
    c.forEach(e => res = res.remove(e))
    res
  }

  def size: Int = Node.size(root)
}
