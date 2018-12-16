package ru.hse.spb.kazakov

import ru.hse.spb.kazakov.Nat.{O, S}

trait Splittable[N <: Nat, A <: HList, L <: HList, R <: HList] {
  def apply(index: N, list: A): (L, R)
}

object Splittable {

  import HList._

  implicit def zeroSplittable[A <: HList]: Splittable[O.type, A, HNil.type, A] =
    (_: O.type, list: A) => (HNil, list)

  implicit def splittable[N <: Nat, A <: HList, H, L <: HList, R <: HList]
  (implicit splittable: Splittable[N, A, L, R]): Splittable[S[N], HCons[H, A], HCons[H, L], R] =
    (index: S[N], list: HCons[H, A]) => {
      val (left, right) = splittable(index.pred, list.tail)
      (HCons(list.head, left), right)
    }
}