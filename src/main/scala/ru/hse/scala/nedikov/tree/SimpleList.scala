package ru.hse.scala.nedikov.tree

abstract sealed class SimpleList[+A] {
  def nonEmpty:Boolean

  def ::[B >: A](value: B): SimpleList[B] = ru.hse.scala.nedikov.tree.::(value, this)
}

case object Nil extends SimpleList[Nothing] {
  override def nonEmpty: Boolean = false
}

final case class ::[A](head: A, tail: SimpleList[A]) extends SimpleList[A] {
  override def nonEmpty: Boolean = true
}