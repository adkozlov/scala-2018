package ru.spbau.jvm.scala.hlist

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import HList._

  // zip(HNil, R) = HNil
  implicit def leftNilZippable[H, R <: HList]: Zippable[HNil.type, HCons[H, R], HNil.type] =
    (_: HNil.type, right: HCons[H, R]) => HNil

  // zip(R, HNil) = HNil
  implicit def rightNilZippable[L <: HList]: Zippable[L, HNil.type, HNil.type] =
    (left: L, _: HNil.type) => HNil

  // zip(L, R) = Result
  // zip(H1 :: L, H2 :: R) = (H1, H2) :: Result
  implicit def zippable[L <: HList, R <: HList, H1, H2, Result <: HList](implicit zippable: Zippable[L, R, Result]): Zippable[HCons[H1, L], HCons[H2, R], HCons[(H1, H2), Result]] =
    (left: HCons[H1, L], right: HCons[H2, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))
}