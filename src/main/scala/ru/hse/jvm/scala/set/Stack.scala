package ru.hse.jvm.scala.set

import java.util.NoSuchElementException

sealed abstract class Stack[+K] {
  def isEmpty: Boolean
  def isNotEmpty: Boolean = !isEmpty
  def top: K
  def pop(): Stack[K]
  def add[V >: K](value: V) = StackNode(value, this)
}

case object StackNil extends Stack[Nothing] {
  override def isEmpty: Boolean = true

  override def top: Nothing = throw new NoSuchElementException

  override def pop(): Stack[Nothing] = throw new NoSuchElementException
}

case class StackNode[K](value: K, rest: Stack[K]) extends Stack[K] {
  override def isEmpty: Boolean = false

  override def top: K = value

  override def pop(): Stack[K] = rest
}
