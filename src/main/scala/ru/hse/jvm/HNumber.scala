package ru.hse.jvm

sealed trait HNumber

object HNumber {

  sealed trait Pos <: HNumber
  sealed trait Neg <: HNumber

  case class Succ[T <: Pos](less: T) extends Pos
  case class Pred[T <: Neg](more: T) extends Neg

  case object Zero extends Pos with Neg

  val _0 : Zero.type = Zero
  val _1 = Succ(_0)
  val _2 = Succ(_1)
  val _3 = Succ(_2)
  val _4 = Succ(_3)

  val m1 = Pred(_0)
  val m2 = Pred(m1)
}
