package ru.hse.nat

sealed trait Nat

object Nat {

  sealed trait Pos <: Nat

  sealed trait Neg <: Nat

  case object Zero extends Pos with Neg

  case class Succ[Prev <: Pos](prev: Prev) extends Pos

  case class Pred[Next <: Neg](next: Next) extends Neg

  val _0: Zero.type = Zero
  val _1 = Succ(_0)
  val _2 = Succ(_1)
  val _3 = Succ(_2)
  val _4 = Succ(_3)
  val _5 = Succ(_4)
  val _6 = Succ(_5)
  val _7 = Succ(_6)
  val _8 = Succ(_7)
  val _9 = Succ(_8)
  val _10 = Succ(_9)
  val _11 = Succ(_10)
  val _12 = Succ(_11)
  val _13 = Succ(_12)
  val _14 = Succ(_13)
  val _15 = Succ(_14)

  val m1 = Pred(_0)
  val m2 = Pred(m1)
  val m3 = Pred(m2)
  val m4 = Pred(m3)
}
