package ru.hse.spb.hlist

import ru.hse.spb.hlist.Number.Positive

sealed trait HList

object HList {

  def zip[F <: HList, S <: HList, Result <: HList](first: F, second: S)
                                                  (implicit zippable: Zippable[F, S, Result]): Result =
    zippable(first, second)

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  implicit class HListExt[A <: HList](private val list: A) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, A, Result]): Result =
      appendable(left, list)

    def SplitAt[L <: HList, R <: HList, N <: Positive](n: N)(implicit splittable: Splittable[A, L, R, N]): (L, R) =
      splittable(list, n)
  }

  case object HNil extends HList

}