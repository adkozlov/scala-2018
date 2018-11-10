package ru.spbau.jvm.scala.calculator

abstract class Result[T] {
  val value: T
}

object Result {
  def unapply[T](arg: Result[T]): Option[T] = Some(arg.value)
}

case class IntResult(override val value: Int) extends Result[Int]

case class BoolResult(override val value: Boolean) extends Result[Boolean]