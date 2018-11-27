package ru.spbau.jvm.scala.mycollection

trait Iterator[+A] {
  def hasNext: Boolean

  def next(): A

  def forall(p: A => Boolean): Boolean = {
    var res = true
    while (res && hasNext) res = p(next())
    res
  }

  def exists(p: A => Boolean): Boolean = {
    var res = false
    while (!res && hasNext) res = p(next())
    res
  }

  def find(p: A => Boolean): Option[A] = {
    while (hasNext) {
      val a = next()
      if (p(a)) return Some(a)
    }
    None
  }

  def foldLeft[B](z: B)(op: (A, B) => B): B = {
    var res: B = z
    foreach(x => res = op(x, res))
    res
  }

  def foreach[B](f: A => B): Unit = while (hasNext) f(next())

  def reduceLeft[B >: A](op: (A, B) => B): B = {
    if (isEmpty)
      throw new UnsupportedOperationException("ReduceLeft for 0 elements")

    val first = next()
    if (!hasNext)
      return first

    var res: B = first
    while (hasNext)
      res = op(next(), res)
    res
  }

  def isEmpty: Boolean = !hasNext
}
