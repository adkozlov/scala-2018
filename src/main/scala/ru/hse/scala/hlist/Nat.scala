package ru.hse.scala.hlist

sealed trait Nat

object Nat {
  case object Zero extends Nat

  case class Suc[N <: Nat](n : N) extends Nat

  val zero: Zero.type = Zero
  val one = Suc(zero)
  val two = Suc(one)
  val three = Suc(two)
  val four = Suc(three)
  val five = Suc(four)
  val six = Suc(five)
  val seven = Suc(six)
  val eight = Suc(seven)
  val nine = Suc(eight)
  val ten = Suc(nine)
}
