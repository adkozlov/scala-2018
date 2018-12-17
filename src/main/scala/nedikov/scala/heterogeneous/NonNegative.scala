package nedikov.scala.heterogeneous

import scala.language.implicitConversions

sealed trait NonNegative

object NonNegative {

  case class Succ[Tail <: NonNegative](tail: Tail) extends NonNegative

  case object Zero extends NonNegative

  def succ(n: NonNegative): NonNegative = Succ(n)

  def prev(n: NonNegative): NonNegative = n match {
    case Succ(tail) => tail
    case _          => throw new IllegalArgumentException("The argument must be positive")
  }

  def apply(n: Int): NonNegative = n match {
    case 0 => Zero
    case _ =>
      if (n > 0)
        Succ(NonNegative(n - 1))
      else
        throw new IllegalArgumentException("The argument must be non negative")
  }

  implicit def toInt(n: NonNegative): Int = n match {
    case Zero => 0
    case Succ(m) => 1 + toInt(m)
  }

  implicit def fromInt(n: Int): NonNegative = apply(n)

  implicit class NonNegativeExtension(val number: NonNegative) extends AnyVal {
    def +(n: NonNegative): NonNegative = n match {
      case Zero    => number
      case Succ(m) => number + m
    }

    def -(n: NonNegative): NonNegative = n match {
      case Zero    => number
      case Succ(m) => m - prev(n)
    }

    def *(n: NonNegative): NonNegative = n match {
      case Zero => Zero
      case Succ(Zero) => number
      case Succ(m) => number + number * prev(m)
    }
  }
}
