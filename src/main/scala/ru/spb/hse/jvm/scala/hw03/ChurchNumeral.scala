package ru.spb.hse.jvm.scala.hw03

sealed trait ChurchNumeral

object ChurchNumeral {

  case object Zero extends ChurchNumeral

  case class Suc[N <: ChurchNumeral](n: N) extends ChurchNumeral

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
