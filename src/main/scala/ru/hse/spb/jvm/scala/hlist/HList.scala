package ru.hse.spb.jvm.scala.hlist

import ru.hse.spb.jvm.scala.numbers.NonNegativeNumber

sealed trait HList

object HList {
  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[L <: HList, Result <: HList](left: L)
                                        (implicit zippable: Zippable[L, R, Result]): Result =
      zippable(left, list)

    def splitAt[ResultLeft <: HList, ResultRight <: HList, N <: NonNegativeNumber](n: N)
                                                                                  (implicit splittableAt:
                                                                                  SplittableAt[R, N, ResultLeft, ResultRight]):
    (ResultLeft, ResultRight) = splittableAt(list, n)
  }

  case object HNil extends HList
}
