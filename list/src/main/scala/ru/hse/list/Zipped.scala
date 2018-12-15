package ru.hse.list

trait Zipped[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zipped {

  import HList._

  implicit def leftNil[R <: HList]: Zipped[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  implicit def rightNil[L <: HList]: Zipped[L, HNil.type, HNil.type] =
    (_: L, _: HNil.type) => HNil

  implicit def zipped[A, L <: HList, B, R <: HList, Result <: HList](implicit zipped: Zipped[L, R, Result]): Zipped[HCons[A, L], HCons[B, R], HCons[(A, B), Result]] =
    (left: HCons[A, L], right: HCons[B, R]) => HCons((left.head, right.head), zipped(left.tail, right.tail))
}