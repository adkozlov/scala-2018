package ru.hse.jvm.hlist

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {
  import HList._

  implicit def leftNilZippable[R <: HList]: Zippable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  implicit def rightNilZippable[H, L <: HList]: Zippable[HCons[H, L], HNil.type, HNil.type] =
    (_: HCons[H, L], _: HNil.type) => HNil

  // zip(L, R) = Result
  // zip(A::L, B::R) = (A, B)::Result
  implicit def zippable[A, L <: HList, B, R <: HList, Result <: HList]
  (implicit zippable: Zippable[L, R, Result]):
  Zippable[HCons[A, L], HCons[B, R], HCons[(A, B), Result]] = (left: HCons[A, L], right: HCons[B, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))
}