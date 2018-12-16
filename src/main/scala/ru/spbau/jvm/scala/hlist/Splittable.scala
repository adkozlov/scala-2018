package ru.spbau.jvm.scala.hlist

trait Splittable[T <: HList, N <: HNat, LResult <: HList, RResult <: HList] {
  def apply(list: T, index: N): (LResult, RResult)
}

object Splittable {

  import HList._
  import HNat._

  // split(T, Zero) = (HNil, T)
  implicit def zeroSplittable[T <: HList]: Splittable[T, Zero.type, HNil.type, T] =
    (list: T, index: Zero.type) => (HNil, list)

  // split(L, N) = (split(L, N - 1).1, split(L, N - 1).2)
  implicit def splittable[T <: HList, H, N <: Pos, LR <: HList, RR <: HList](implicit splittable: Splittable[T, N, LR, RR]): Splittable[HCons[H, T], Succ[N], HCons[H, LR], RR] =
    (list: HCons[H, T], index: Succ[N]) => {
      val (left, right) = splittable(list.tail, index.prev)
      (list.head :: left, right)
    }
}