package ru.hse.jvm


trait Splittable[T <: HList, N <: HNumber, L <: HList, R <: HList] {
  def apply(list: T, n: N): (L, R)
}

object Splittable {

  import HNumber._
  import HList._

  implicit def zeroSplittable[R <: HList]: Splittable[R, Zero.type, HNil.type, R] =
    (list: R, n: Zero.type) => (HNil, list)

  implicit def splittable[T <: HList, H, N <: HNumber, L <: HList, R <: HList]
  (implicit splittable: Splittable[T, N, L, R]):
  Splittable[HCons[H, T], Succ[N], HCons[H, L], R] =
    (list: HCons[H, T], n: Succ[N]) => {
      val Succ(m) = n
      val (left, right) = splittable(list.tail, m)
      (list.head :: left, right)
    }
}