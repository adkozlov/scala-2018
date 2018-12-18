package ru.spbau.jvm.scala

trait Zipable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zipable {

  import HList._

  implicit def nilZipableR[R <: HList]: Zipable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  implicit def nilZipableL[L <: HList]: Zipable[L, HNil.type, HNil.type] =
    (_: L, _: HNil.type) => HNil

  implicit def nilZippableLeftRight: Zipable[HNil.type, HNil.type, HNil.type] =
    (_: HNil.type, _: HNil.type) => HNil

  implicit def zippable[L <: HList, R <: HList, HL, HR, Result <: HList](implicit zippable: Zipable[L, R, Result]): Zipable[HCons[HL, L], HCons[HR, R], HCons[(HL, HR), Result]] =
    (left: HCons[HL, L], right: HCons[HR, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))

}
