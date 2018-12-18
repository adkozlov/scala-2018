package ru.hse.dkaznacheev.heterogenous

trait Splittable[L <: HList, N <: Natural, LResult <: HList, RResult <: HList] {
  def apply(list: L, index: N): (LResult, RResult)
}

object Splittable {

  import ru.hse.dkaznacheev.heterogenous.HList._
  import ru.hse.dkaznacheev.heterogenous.Natural._

  implicit def zeroSplittable[L <: HList]: Splittable[L, Zero.type, HNil.type, L] =
    (list: L, _: Zero.type) => (HNil, list)

  implicit def splittable[L <: HList, H, N <: Natural, LResult <: HList, RResult <: HList](implicit splittable: Splittable[L, N, LResult, RResult]): Splittable[HCons[H, L], Succ[N], HCons[H, LResult], RResult] =
    (list: HCons[H, L], index: Succ[N]) => {
      val (lResult, rResult) = splittable(list.tail, index.pred)
      (HCons(list.head, lResult), rResult)
    }
}