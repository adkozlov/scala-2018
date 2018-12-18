package ru.hse.dkaznacheev.heterogenous

sealed trait HList

object HList {
  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[O <: HList, Result <: HList](other: O)
                                        (implicit zippable: Zippable[R, O, Result]): Result =
      zippable(list, other)

    def splitAt[N <: Natural, Left <: HList, Right <: HList](index: N)(implicit splittable: Splittable[R, N, Left, Right]): (Left, Right) =
      splittable(list, index)
  }
}
