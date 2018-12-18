package ru.hse.spb

sealed trait Number

object Number {

  case object Zero extends Number

  case class Succ[T <: Number](previousNumber: T) extends Number
}
