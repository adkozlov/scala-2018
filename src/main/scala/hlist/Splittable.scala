package hlist

import nat._

trait Splittable[List <: HList, I <: Nat, L <: HList, R <: HList] {
  def apply(list: List): (L, R)
}

object Splittable {

  import HList._

  implicit def zeroIndexSplittable[P <: HList]: Splittable[P, Zero, HNil.type, P] =
    (list: P) => (HNil, list)

  implicit def splittable[M, N <: HList, I <: Nat, L <: HList, R <: HList]
    (implicit splittable: Splittable[N, I, L, R]): Splittable[HCons[M, N], Succ[I], HCons[M, L], R] =
    (list) => splittable(list.tail) match {
      case (l, r) => (HCons(list.head, l), r)
    }
}