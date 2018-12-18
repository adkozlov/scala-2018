package ru.hse.dkaznacheev.heterogenous

trait Appendable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Appendable {

  import ru.hse.dkaznacheev.heterogenous.HList._

  implicit def nilAppendable[R <: HList]: Appendable[HNil.type, R, R] =
    (_: HNil.type, right: R) => right

  implicit def appendable[L <: HList, R <: HList, H, Result <: HList](implicit appendable: Appendable[L, R, Result]): Appendable[HCons[H, L], R, HCons[H, Result]] =
    (left: HCons[H, L], right: R) => HCons(left.head, appendable(left.tail, right))
}