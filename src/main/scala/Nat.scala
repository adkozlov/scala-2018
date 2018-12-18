sealed trait Nat

object Nat {

  case object Zero extends Nat

  case class Suc[N <: Nat](num: N) extends Nat

}
