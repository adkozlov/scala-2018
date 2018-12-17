package ru.spb.hse.hw03

trait Splittable[S <: HList, N <: Number, L <: HList, R <: HList] {
  def apply(list: S, number: N): (L, R)
}

object Splittable {

  import HList._
  import Number._

  implicit def zeroSplittable[S <: HList]: Splittable[S, Zero.type, HNil.type, S] =
    (list: S, _: Zero.type) => (HNil, list)

  implicit def splittable[S <: HList, N <: NonNegative, H, L <: HList, R <: HList](implicit splittable: Splittable[S, N, L, R]): Splittable[HCons[H, S], Plus[N], HCons[H, L], R] =
    (list: HCons[H, S], number: Plus[N]) => {
      val result = splittable(list.tail, number.prev)
      (list.head :: result._1, result._2)
    }
}
