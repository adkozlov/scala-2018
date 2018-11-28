package ru.hse.iterable

trait Iterable[+A] {
  def iterator: Iterator[A]

  def foreach[U](f: A => U): Unit = iterator.foreach(f)

  def map[B](f: A => B): Iterable[B] = new Iterable[B] {
    override def iterator: Iterator[B] = Iterable.this.iterator map f
  }

  def flatMap[B](f: A => Iterable[B]): Iterable[B] = new Iterable[B] {
    override def iterator: Iterator[B] = Iterable.this.iterator flatMap f.andThen(iterable => iterable.iterator)
  }

  def filter(p: A => Boolean): Iterable[A] = new Iterable[A] {
    override def iterator: Iterator[A] = Iterable.this.iterator filter p
  }

  def withFilter(p: A => Boolean): Iterable[A] = filter(p)

  def forall(p: A => Boolean): Boolean =
    iterator.forall(p)

  def exists(p: A => Boolean): Boolean =
    iterator.exists(p)

  def find(p: A => Boolean): Option[A] =
    iterator.find(p)

  def isEmpty: Boolean =
    !iterator.hasNext

  def foldLeft[B](z: B)(op: (B, A) => B): B =
    iterator.foldLeft(z)(op)

  def foldRight[B](z: B)(op: (A, B) => B): B =
    iterator.foldRight(z)(op)

  def size: Int =
    foldLeft(0)((n, _) => n + 1)
}
