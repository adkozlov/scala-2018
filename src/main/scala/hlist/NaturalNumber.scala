package hlist

sealed trait NaturalNumber

sealed trait PositiveNumber  extends NaturalNumber
case object  Zero            extends NaturalNumber


object NaturalNumber {
  case class Succ[N <: NaturalNumber](prev: N) extends PositiveNumber
}