package ru.spbau.jvm.scala.mycollection

abstract sealed class MyList[+A] {
  def isEmpty: Boolean
}

case class Cons[A](value: A, tail: MyList[A]) extends MyList[A] {
  override def isEmpty: Boolean = false
}

object ListNil extends MyList {
  override def isEmpty: Boolean = true
}
