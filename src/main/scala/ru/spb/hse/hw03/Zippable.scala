package ru.spb.hse.hw03

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import HList._

  implicit def leftNilZippable[R <: HList]: Zippable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  implicit def rightNilZippable[L <: HList, H]: Zippable[HCons[H, L], HNil.type, HNil.type] =
    (_: HCons[H, L], _: HNil.type) => HNil

  implicit def zippable[L <: HList, R <: HList, H1, H2, Result <: HList](implicit zippable: Zippable[L, R, Result]): Zippable[HCons[H1, L], HCons[H2, R], HCons[(H1, H2), Result]] =
    (left: HCons[H1, L], right: HCons[H2, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))
}
