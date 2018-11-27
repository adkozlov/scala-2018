package ru.spbau.jvm.scala

trait ImmutableCollection[+A] {
  def add(e: _ <: A): ImmutableCollection[A]

  def addAll(c: ImmutableCollection[_ <: A]): ImmutableCollection[A] = {
    var res = this
    c.forEach(e => res = res.add(e))
    res
  }

  def clear(): ImmutableCollection[A]

  def contains(e: _ <: A): Boolean

  def containsAll(c: ImmutableCollection[_ <: A]): Boolean = {
    var res = true
    c.forEach(res &= contains(_))
    res
  }

  def flatMap[B](f: A => ImmutableCollection[B]): ImmutableCollection[B]

  def forEach[U](f: A => Unit): Unit

  def isEmpty:Boolean = size == 0

  def map[B](f: A => B): ImmutableCollection[B]

  def remove(e: _ <: A): ImmutableCollection[A]

  def removeAll(c: ImmutableCollection[_ <: A]): ImmutableCollection[A] = {
    var res = this
    c.forEach(e => res = res.remove(e))
    res
  }

  def size: Int
}
