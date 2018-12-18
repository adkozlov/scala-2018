package ru.spbau.jvm.scala.heter

trait Splitable[T <: HList, N <: Nat, LResult <: HList, RResult <: HList] {
  def apply(list: T, index: N): (LResult, RResult)
}

object Splitable {

  import HList._
  import Nat._

  implicit def zeroSplitable[T <: HList]: Splitable[T, Zero.type, HNil.type, T] =
    (list: T, _: Zero.type) => (HNil, list)

  implicit def splitable[T <: HList, H, N <: Nat, LResult <: HList, RResult <: HList](implicit splittable: Splitable[T, N, LResult, RResult]): Splitable[HCons[H, T], Succ[N], HCons[H, LResult], RResult] =
    (list: HCons[H, T], index: Succ[N]) => {
      val (l, r) = splittable(list.tail, index.prev)
      (HCons(list.head, l), r)
    }
}