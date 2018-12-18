package ru.spbau.jvm.scala

trait Appendable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Appendable {

  import HList._

  // HNil ::: R = R
  implicit def nilAppendable[R <: HList]: Appendable[HNil.type, R, R] =
    (_: HNil.type, right: R) => right

  // L ::: R = Result
  // (H :: L) ::: R = (H :: Result)
  implicit def appendable[L <: HList, R <: HList, H, Result <: HList](implicit appendable: Appendable[L, R, Result]): Appendable[HCons[H, L], R, HCons[H, Result]] =
    (left: HCons[H, L], right: R) => HCons(left.head, appendable(left.tail, right))
}