package ru.hse.spb.jvm.scala.numbers

sealed trait NonNegativeNumber

object NonNegativeNumber {

  case class Suc[P <: NonNegativeNumber](prev: P) extends NonNegativeNumber

  case object Zero extends NonNegativeNumber

}