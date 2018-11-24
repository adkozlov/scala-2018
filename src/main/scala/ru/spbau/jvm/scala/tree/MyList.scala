package ru.spbau.jvm.scala.tree

// абсолютный идиотизм запрещать использование List'а из stdlib в месте,
//   где нужен тупой стек
sealed abstract class MyList[+A] {
  def nonEmpty: Boolean
}

object MyNil extends MyList[Nothing] {
  override def nonEmpty: Boolean = false
}

case class MyCons[A](value: A, tail: MyList[A]) extends MyList[A] {
  override def nonEmpty: Boolean = true
}


