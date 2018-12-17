package hlist

import hlist.Nat.{Pos, Succ, Zero}

trait Splittable[X <: HList, N <: Nat, R1 <: HList, R2 <: HList] {
  def apply(xs: X, n: N): (R1, R2)
}

object Splittable {

  import HList._

  implicit def zeroSplittable[X <: HList]: Splittable[X, Zero.type, HNil.type, X] =
    (xs : X, _: Zero.type ) => (HNil, xs)

  implicit def splittable[X <: HList, N <: Pos, H, R1 <: HList, R2 <: HList]
                         (implicit splittable: Splittable[X, N, R1, R2])
                        : Splittable[HCons[H, X], Succ[N], HCons[H, R1], R2] =
    (xs: HCons[H, X], n: Succ[N]) => {
      val (l, r) = splittable(xs.tail, n.prev)
      (xs.head :: l, r)
    }
}

