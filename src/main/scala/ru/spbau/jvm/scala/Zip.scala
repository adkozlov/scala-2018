package ru.spbau.jvm.scala

trait Zip[LList <: HList, RList <: HList, Result <: HList] {
  def apply(left: LList, right: RList): Result
}

object Zip {
  import HList._

  // {Nil, list} => Nil
  implicit def hNilZipLEnd[R <: HList]: Zip[HNil.type, R, HNil.type] = (_: HNil.type, _: R) => HNil

  // {list, Nil} => Nil
  implicit def hNilZipREnd[H, L <: HList]: Zip[HCons[H, L], HNil.type, HNil.type] = (_: HCons[H, L], _: HNil.type) => HNil

  // {list1, list2} => (list1.head, list2.head) :: zip(list1.tail, list2.tail)
  implicit def zip[HL, HR, L <: HList, R <: HList, Result <: HList](implicit zip: Zip[L, R, Result]):
    Zip[HCons[HL, L], HCons[HR, R], HCons[(HL, HR), Result]] =
    (left: HCons[HL, L], right: HCons[HR, R]) => (left.head, right.head) :: zip(left.tail, right.tail)
}
