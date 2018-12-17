package ru.hse.jvm


trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import HList._

  implicit def nilZippable: Zippable[HNil.type, HNil.type, HNil.type] =
    (left: HNil.type, right: HNil.type) => HNil

  implicit def leftNilZippable[R <: HList]: Zippable[HNil.type, R, HNil.type] =
    (left: HNil.type, right: R) => HNil

  implicit def rightNilZippable[R <: HList]: Zippable[R, HNil.type, HNil.type] =
    (left: R, right: HNil.type) => HNil

  implicit def zippable[L <: HList, R <: HList, H, T, Result <: HList]
  (implicit zippable: Zippable[L, R, Result]):
  Zippable[HCons[H, L], HCons[T, R], HCons[(H, T), Result]] =
    (left: HCons[H, L], right: HCons[T, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))
}