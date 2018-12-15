package ru.hse.spb.hlist

import ru.hse.spb.hlist.Number.Positive

trait Splittable[A <: HList, L <: HList, R <: HList, N <: Positive] {
  def apply(ls: A, n: N): (L, R)
}

object Splittable {

  import HList._
  import Number.{Succ, Zero}

  implicit def ZeroSplittable[A <: HList]: Splittable[A, HNil.type, A, Zero.type] =
    (ls: A, _: Zero.type) => (HNil, ls)

  implicit def splittable[Tail <: HList, L <: HList, R <: HList, H, N <: Positive](implicit splittable: Splittable[Tail, L, R, N]): Splittable[HCons[H, Tail], HCons[H, L], R, Succ[N]] =
    (ls: HCons[H, Tail], nat: Succ[N]) => {
      val (l, r) = splittable(ls.tail, nat.n)
      (ls.head :: l, r)
    }
}