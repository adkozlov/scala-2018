package nedikov.scala.heterogeneous

import nedikov.scala.heterogeneous.NonNegative.Zero

trait Splittable[List <: HList, N <: NonNegative, L <: HList, R <: HList] {
  def apply(list: List, n: N): (L, R)
}

object Splittable {

  import HList._

  implicit def zeroSplittable[List <: HList, L <: HList, R <: HList]
  : Splittable[List, Zero.type, HNil.type, List] =
    (list: List, _: Zero.type) => (HNil, list)

  implicit def splittable[N <: NonNegative, H, List <: HList, L <: HList, R <: HList]
  (implicit splittable: Splittable[List, N, L, R])
  : Splittable[HCons[H, List], NonNegative.Succ[N], HCons[H, L], R] =
    (list: HCons[H, List], n: NonNegative.Succ[N]) => {
      val (l, r) = splittable(list.tail, n.tail)
      (HCons(list.head, l), r)
    }

}
