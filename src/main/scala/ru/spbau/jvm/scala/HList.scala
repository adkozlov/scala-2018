package ru.spbau.jvm.scala

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[L <: HList, Result <: HList](left: L)
                                        (implicit zipable: Zipable[R, L, Result]): Result =
      zipable(list, left)

    def splitAt[N <: MyNumber, ResultL <: HList, ResultR <: HList](index: N)
                                        (implicit splitable: Splitable[R, N, ResultL, ResultR]): (ResultL, ResultR) =
      splitable(list, index)

  }

}