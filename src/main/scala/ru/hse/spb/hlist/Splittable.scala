package ru.hse.spb.hlist

trait Splittable[A <: HList, L <: HList, R <: HList, N <: Nat] {
  def apply(ls: A, n: N): (L, R)
}

object Splittable {

  import HList._

  implicit def ZeroSplittable[A <: HList]: Splittable[A, HNil.type, A, Nat.Zero.type] =
    (ls: A, _: Nat.Zero.type) => (HNil, ls)

  implicit def splittable[Tail <: HList, L <: HList, R <: HList, H, N <: Nat](implicit splittable: Splittable[Tail, L, R, N]): Splittable[HCons[H, Tail], HCons[H, L], R, Nat.Succ[N]] =
    (ls: HCons[H, Tail], nat: Nat.Succ[N]) => {
      val (l, r) = splittable(ls.tail, nat.n)
      (ls.head :: l, r)
    }
}