package ru.hse.scala.hlist

import ru.hse.scala.hlist.Nat.Zero

trait Splittable[N <: Nat, L <: HList, LeftResult <: HList, RightResult <: HList] {
  def apply(left: L, n: N): (LeftResult, RightResult)
}

object Splittable {

  import HList._

  implicit def zeroSplittable[L <: HList]: Splittable[Zero.type, L, HNil.type, L] =
    (list: L, _: Zero.type ) => (HNil, list)

  implicit def splittable[N <: Nat, L <: HList, H, LeftResult <: HList, RightResult <: HList](implicit splittable: Splittable[N, L, LeftResult, RightResult]):
  Splittable[Nat.Succ[N], HCons[H, L], HCons[H, LeftResult], RightResult] =
    (list: HCons[H, L], n: Nat.Succ[N]) => {
      val (left, right) = splittable(list.tail, n.tail)
      (list.head :: left, right)
    }
}
