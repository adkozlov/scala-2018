package ru.spbau.jvm.scala.hlist

trait Zip[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zip {

  import HList._

  implicit def leftNilZipper[R <: HList]: Zip[HNil.type , R, HNil.type] = (_: HNil.type, _ : R) => HNil
  implicit def rightNilZipper[L <: HList, H]: Zip[HCons[H, L], HNil.type, HNil.type] = (_: HCons[H, L], _ : HNil.type) => HNil

  implicit def zipper[HL, HR, L <: HList, R <: HList, Result <: HList](implicit zipper : Zip[L, R, Result]) : Zip[HCons[HL, L],
    HCons[HR, R], HCons[(HL, HR), Result]] = (left: HCons[HL, L], right: HCons[HR, R]) => HCons((left.head, right.head),
    zipper(left.tail, right.tail))

}