package ru.hse.scala.hlist

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import HList._

  implicit def nilZippableLeft[R <: HList]: Zippable[HNil.type, R, HNil.type] =
    (_: HNil.type, right: R) => HNil

  implicit def nilZippableRight[L <: HList]: Zippable[L, HNil.type, HNil.type] =
    (left: L, _: HNil.type) => HNil

  implicit def zippable[L <: HList, R <: HList, LeftHead, RightHead, Result <: HList](implicit zippable: Zippable[L, R, Result]):
  Zippable[HCons[LeftHead, L], HCons[RightHead, R], HCons[(LeftHead, RightHead), Result]] =
    (left: HCons[LeftHead, L], right: HCons[RightHead, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))
}
