package ru.hse.scala.hlist

trait Zipable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zipable {
  import HList._

  implicit def leftNilZipable[R <: HList]: Zipable[HNil.type, R, R] = (_: HNil.type, right: R) => right
  implicit def rightNilZipable[L <: HList]: Zipable[L, HNil.type, L] = (left: L, _: HNil.type) => left

  implicit def zipable[L <: HList, R <: HList, HL, HR, Result <: HList]
    (implicit zipable: Zipable[L, R, Result]): Zipable[HCons[HL, L], HCons[HR, R], HCons[(HL, HR), Result]] =
    (left: HCons[HL, L], right: HCons[HR, R]) => HCons((left.head, right.head), zipable(left.tail, right.tail))
}
