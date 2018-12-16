package ru.hse.spb.jvm.scala.hlist

import ru.hse.spb.jvm.scala.numbers.NonNegativeNumber
import ru.hse.spb.jvm.scala.numbers.NonNegativeNumber.Zero

trait SplittableAt[L <: HList, N <: NonNegativeNumber, ResultFirst <: HList, ResultSecond <: HList] {
  def apply(list: L, n: N): (ResultFirst, ResultSecond)
}

object SplittableAt {

  import HList._

  implicit def splittableAtHere
  [L <: HList]:
  SplittableAt[L, Zero.type, HNil.type, L] =
    (list: L, _: Zero.type) => (HNil, list)

  implicit def splittableAt[H, L <: HList, N <: NonNegativeNumber, ResultFirst <: HList, ResultSecond <: HList]
  (implicit splittableAt: SplittableAt[L, N, ResultFirst, ResultSecond]):
  SplittableAt[HCons[H, L], NonNegativeNumber.Suc[N], HCons[H, ResultFirst], ResultSecond] =
    (list: HCons[H, L], n: NonNegativeNumber.Suc[N]) => {
      val (first, second) = splittableAt(list.tail, n.prev)
      (list.head :: first, second)
    }
}
