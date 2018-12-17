package ru.hse.scala.hlist

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[L <: HList, Result <: HList](right : L)(implicit zippable: Zippable[R, L, Result]): Result =
      zippable(list, right)

    def splitAt[N <: Nat, LeftResult <: HList, RightResult <: HList](index: N)(implicit splittable: Splittable[N, R, LeftResult, RightResult]):
    (LeftResult, RightResult) = splittable(list, index)
  }
}
