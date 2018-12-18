package ru.hse.spb

trait Zipable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zipable {

  import HList._

  implicit def NilZipable: Zipable[HNil.type, HNil.type , HNil.type] =
    (_: HNil.type, _: HNil.type ) => HNil

  implicit def leftNilZipable[R <: HList]: Zipable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  implicit def rightNilZipable[L <: HList]: Zipable[L, HNil.type, HNil.type ] =
    (_: L, _: HNil.type ) => HNil

  implicit def zipable[L <: HList, R <: HList, LH, RH, Result <: HList]
  (implicit zipable: Zipable[L, R, Result]):
  Zipable[HCons[LH, L], HCons[RH, R], HCons[(LH, RH), Result]] =
    (left: HCons[LH, L], right: HCons[RH, R]) => HCons((left.head, right.head), zipable(left.tail, right.tail))
}
