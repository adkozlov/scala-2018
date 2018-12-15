package ru.hse.list

import ru.hse.nat.Nat

trait Cut[L <: HList, N <: Nat, Left <: HList, Right <: HList] {
  def apply(list: L, n: N): (Left, Right)
}

object Cut {

  import HList._
  import ru.hse.nat.Nat._

  implicit def cutZero[L <: HList]: Cut[L, Zero.type, HNil.type, L] =
    (list: L, _: Zero.type) => (HNil, list)

  implicit def cut[H, Tail <: HList, N <: Pos, Left <: HList, Right <: HList](implicit cut: Cut[Tail, N, Left, Right])
  : Cut[HCons[H, Tail], Succ[N], HCons[H, Left], Right] =
    (list: HCons[H, Tail], n: Succ[N]) => {
      val (l, r) = cut(list.tail, n.prev)
      (list.head :: l, r)
    }
}