package ru.hse.scala.hlist

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[U <: HList](private val list: U) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList]
      (left: L)(implicit appendable: Appendable[L, U, Result]): Result = appendable(left, list)

    def zip[R <: HList, Result <: HList]
      (right: R)(implicit zipable: Zipable[U, R, Result]): Result = zipable(list, right)

    def splitAt[N <: Nat, LResult <: HList, RResult <: HList]
    (index: N)(implicit splittable: Splittable[U, N, LResult, RResult])
    : (LResult, RResult) = splittable(list, index)
  }
}