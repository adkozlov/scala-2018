package ru.spbau.jvm.scala.heter

trait Zipable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zipable {

  import HList._

  implicit def NilZipable: Zipable[HNil.type, HNil.type, HNil.type] =
    (_: HNil.type, _: HNil.type) => HNil

  implicit def leftNilZipable[R <: HList]: Zipable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  implicit def rightNilZipable[L <: HList]: Zipable[L, HNil.type, HNil.type] =
    (_: L, _: HNil.type) => HNil

  implicit def zipable[L <: HList, R <: HList, LHlist, RHlist, Result <: HList]
  (implicit zipable: Zipable[L, R, Result]):
  Zipable[HCons[LHlist, L], HCons[RHlist, R], HCons[(LHlist, RHlist), Result]] =
    (left: HCons[LHlist, L], right: HCons[RHlist, R]) => HCons((left.head, right.head), zipable(left.tail, right.tail))
}