package nat

sealed trait Nat {
  type N <: Nat
}

class Zero extends Nat {
  type N = Zero
}

class Succ[T <: Nat] extends Nat {
  type N = Succ[T]
}

trait ToInt[N <: Nat] {
  def apply(): Int
}

object ToInt {

  case class ToIntInstance[N <: Nat](i: Int) extends ToInt[N] {
    def apply(): Int = i
  }

  implicit def zeroToInt: ToIntInstance[Zero] = ToIntInstance[Zero](0)

  implicit def succToInt[N <: Nat](implicit nToInt: ToInt[N])
  : ToInt[Succ[N]] = ToIntInstance[Succ[N]](nToInt() + 1)

  def apply[N <: Nat](implicit toInt: ToInt[N]): ToInt[N] = toInt

}
