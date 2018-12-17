package ru.hse.spb.sharkova

sealed trait NonNegativeNumber

object NonNegativeNumber {
  object Zero extends NonNegativeNumber

  case class Next[T <: NonNegativeNumber](prev: T) extends NonNegativeNumber
}
