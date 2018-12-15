package ru.hse.spb.hlist

sealed trait Nat

object Nat {

  val _0: Zero.type = Nat.Zero
  val _1 = Nat.Succ(_0)
  val _2 = Nat.Succ(_1)
  val _3 = Nat.Succ(_2)
  val _4 = Nat.Succ(_3)
  val _5 = Nat.Succ(_4)
  val _6 = Nat.Succ(_5)
  val _7 = Nat.Succ(_6)
  val _8 = Nat.Succ(_7)
  val _9 = Nat.Succ(_8)
  val _10 = Nat.Succ(_9)

  def IntToNat(i: Int): Nat = {
    if (i < 0) throw new IllegalArgumentException("Can't convert negative value to ru.hse.spb.hlist.Nat")
    else if (i == 0) Zero
    else Succ(IntToNat(i - 1))
  }

  case class Succ[N <: Nat](n: N) extends Nat

  object Zero extends Nat

}

