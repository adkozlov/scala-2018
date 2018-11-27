package ru.hse.iterable

trait Iterator[+A] {

  import Iterator.empty

  def hasNext: Boolean

  def next(): A

  def isEmpty: Boolean = !hasNext

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

  def foldLeft[B](z: B)(op: (B, A) => B): B = {
    var result = z
    this foreach (x => result = op(result, x))
    result
  }

  def foldRight[B](z: B)(op: (A, B) => B): B = {
    if (Iterator.this.isEmpty)
      return z
    val next = Iterator.this.next()
    op(next, foldRight(z)(op))
  }

  def foreach[U](f: A => U): Unit = while (hasNext) f(next())

  def map[B](f: A => B): Iterator[B] = new Iterator[B] {
    def hasNext: Boolean = Iterator.this.hasNext

    def next() = f(Iterator.this.next())
  }

  def flatMap[B](f: A => Iterator[B]): Iterator[B] = new Iterator[B] {
    private var cur: Iterator[B] = empty

    private def nextCur() {
      cur = f(Iterator.this.next())
    }

    def hasNext: Boolean = {
      while (!cur.hasNext) {
        if (!Iterator.this.hasNext)
          return false
        nextCur()
      }
      true
    }

    def next(): B = (if (hasNext) cur else empty).next()
  }

  def filter(p: A => Boolean): Iterator[A] = new Iterator[A] {
    private var nextValue: A = _
    private var nextDefined: Boolean = false

    def hasNext: Boolean = nextDefined || {
      do {
        if (!Iterator.this.hasNext) return false
        nextValue = Iterator.this.next()
      } while (!p(nextValue))
      nextDefined = true
      true
    }

    def next(): A = if (hasNext) {
      nextDefined = false
      nextValue
    } else empty.next()
  }
}

object Iterator {
  val empty: Iterator[Nothing] = new Iterator[Nothing] {
    def hasNext: Boolean = false

    def next(): Nothing = throw new NoSuchElementException("next on empty iterator")
  }
}
