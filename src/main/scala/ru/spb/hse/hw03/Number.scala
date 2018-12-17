package ru.spb.hse.hw03

sealed trait Number

object Number {
  sealed trait NonPositive extends Number
  sealed trait NonNegative extends Number

  object Zero extends NonPositive with NonNegative

  case class Plus[Prev <: NonNegative](prev: Prev) extends NonNegative
  case class Minus[Prev <: NonPositive](prev: Prev) extends NonPositive

  val zero: Zero.type = Zero

  val one = Plus(zero)
  val two = Plus(one)
  val three = Plus(two)
  val four = Plus(three)

  val minusOne = Minus(zero)
  val minusTwo = Minus(minusOne)
}
