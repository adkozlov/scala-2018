package ru.hse.spb.hlist

sealed trait Number

object Number {
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

  val _M1 = Prev(_0)
  val _M2 = Prev(_M1)
  val _M3 = Prev(_M2)
  val _M4 = Prev(_M3)
  val _M5 = Prev(_M4)
  val _M6 = Prev(_M5)
  val _M7 = Prev(_M6)
  val _M8 = Prev(_M7)
  val _M9 = Prev(_M8)
  val _M10 = Prev(_M9)

  def IntToNumber(i: Int): Number = {
    if (i < 0) Prev(IntToNumber(i + 1))
    else if (i == 0) Zero
    else Succ(IntToNumber(i - 1))
  }

  sealed trait Positive extends Number

  sealed trait Negative extends Number

  case class Prev[N <: Number](n: N) extends Negative

  case class Succ[N <: Number](n: N) extends Positive

  object Zero extends Positive with Negative
}

