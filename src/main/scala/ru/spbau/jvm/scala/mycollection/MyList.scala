package ru.spbau.jvm.scala.mycollection

abstract sealed class MyList[+A] {
  def empty(): Boolean
}

case class Cons[A](value: A, tail: MyList[A]) extends MyList[A] {
  override def empty(): Boolean = false
}

object ListNil extends MyList {
  override def empty(): Boolean = true
}
