package ru.hse.jvm

sealed trait HNumber

object HNumber {

  case class Succ[T <: HNumber](less: T) extends HNumber

  case object Zero extends HNumber

  val _0: Zero.type = Zero
  val _1 = Succ(_0)
  val _2 = Succ(_1)
  val _3 = Succ(_2)
}