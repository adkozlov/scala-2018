package ru.hse.spb

trait Splitable[T <: HList, N <: Number, ResultLeft <: HList, ResultRight <: HList] {
  def apply(list: T, index: N): (ResultLeft, ResultRight)
}

object Splitable {

  import HList._, Number._

  implicit def ZeroSplitable[T <: HList]: Splitable[T, Zero.type, HNil.type, T] =
    (list: T, _: Zero.type) => (HNil, list)

  implicit def splitable[Head, Tail <: HList, N <: Number, ResultLeft <: HList, ResultRight <: HList]
  (implicit splitable: Splitable[Tail, N, ResultLeft, ResultRight]):
  Splitable[HCons[Head, Tail], Succ[N], HCons[Head, ResultLeft], ResultRight] =
    (list: HCons[Head, Tail], number: Succ[N]) => {
      val (left, right) = splitable(list.tail, number.previousNumber)
      (HCons(list.head, left), right)
    }
}