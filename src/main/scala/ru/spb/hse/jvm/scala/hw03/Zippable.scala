package ru.spb.hse.jvm.scala.hw03

import ru.spb.hse.jvm.scala.hw03.HList.{HCons, HNil}

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  implicit def leftNilZippable[R <: HList]: Zippable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  implicit def rightNilZippable[HL, L <: HList]: Zippable[HCons[HL, L], HNil.type, HNil.type] =
    (_: HCons[HL, L], _: HNil.type) => HNil

  implicit def zippable[HL, L <: HList, HR, R <: HList, Result <: HList](implicit zippable: Zippable[L, R, Result]): Zippable[HCons[HL, L], HCons[HR, R], HCons[(HL, HR), Result]] =
    (left: HCons[HL, L], right: HCons[HR, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))
}
