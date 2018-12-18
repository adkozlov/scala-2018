sealed trait PositiveNumber

object PositiveNumber {

  case object Zero extends PositiveNumber

  case class Suc[T <: PositiveNumber](prev: T) extends PositiveNumber

}
