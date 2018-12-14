package ru.hse.scala.hlist

trait Splittable[L <: HList, N <: Nat, LResult <: HList, RResult <: HList] {
  def apply(left: L, index: N): (LResult, RResult)
}

object Splittable {
  import HList._
  import Nat._

  implicit def zeroSplittable[L <: HList]: Splittable[L, Zero.type, HNil.type, L] =
    (list: L, _: Zero.type) => (HNil, list)

  implicit def splittable[L <: HList, H, N <: Nat, LResult <: HList, RResult <: HList]
    (implicit splittable: Splittable[L, N, LResult, RResult])
    : Splittable[HCons[H, L], Suc[N], HCons[H, LResult], RResult] =
    (list: HCons[H, L], index: Suc[N]) => {
      val (left, right) = splittable(list.tail, index.n)
      (list.head :: left, right)
    }
}
