package ru.hse.spb.sharkova.heterogeneous

import ru.hse.spb.sharkova.NonNegativeNumber
import ru.hse.spb.sharkova.NonNegativeNumber.{Zero, Next}

trait Splittable[I <: NonNegativeNumber, G <: HList, L <: HList, R <: HList] {
  def apply(index: I, list: G): (L, R)
}

object Splittable {
  import HList._

  implicit def zeroSplittable[G <: HList]: Splittable[Zero.type, G, HNil.type, G] =
    (_: Zero.type, list: G) => (HNil, list)

  implicit def splittable[H, I <: NonNegativeNumber, G <: HList, L <: HList, R <: HList]
                         (implicit splittable: Splittable[I, G, L, R]):
                         Splittable[Next[I], HCons[H, G], HCons[H, L], R] =
    (index: Next[I], list: HCons[H, G]) => {
      val (left, right) = splittable(index.prev, list.tail)
      (list.head :: left, right)
    }
}

