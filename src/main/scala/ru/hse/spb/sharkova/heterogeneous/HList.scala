
package ru.hse.spb.sharkova.heterogeneous

import ru.hse.spb.sharkova.NonNegativeNumber

sealed trait HList

object HList {
  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList
  case object HNil extends HList

  implicit class HListExt[G <: HList](private val list: G) extends AnyVal {
    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)(implicit appendable: Appendable[L, G, Result]): Result =
      appendable(left, list)

    def zip[R <: HList, Result <: HList](right: R)(implicit zippable: Zippable[G, R, Result]): Result =
      zippable(list, right)

    def splitAt[I <: NonNegativeNumber, L <: HList, R <: HList](index: I)
                                                               (implicit splittable: Splittable[I, G, L, R]): (L, R) =
      splittable(index, list)
  }
}


