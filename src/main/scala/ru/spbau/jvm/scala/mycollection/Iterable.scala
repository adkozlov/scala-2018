package ru.spbau.jvm.scala.mycollection

trait Iterable[+A] {
  def iterator: Iterator[A]

  def foreach[B](f: A => B): Unit = iterator.foreach(f)

  def forall(p: A => Boolean): Boolean = iterator.forall(p)

  def exists(p: A => Boolean): Boolean = iterator.exists(p)

  def find(p: A => Boolean): Option[A] = iterator.find(p)

  def isEmpty: Boolean = !iterator.hasNext

  def foldLeft[B](z: B)(op: (A, B) => B): B = iterator.foldLeft(z)(op)

  def reduceLeft[B >: A](op: (A, B) => B): B = iterator.reduceLeft(op)
}
