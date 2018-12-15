package ru.hse.spb.hlist

trait Zippable[F <: HList, S <: HList, Result <: HList] {
  def apply(first: F, second: S): Result
}

object Zippable {

  import HList._

  implicit def leftNilZippable[S <: HList]: Zippable[HNil.type, S, HNil.type] =
    (_: HNil.type, _: S) => HNil

  implicit def rightNilZippable[H, F <: HList]: Zippable[HCons[H, F], HNil.type, HNil.type] =
    (_: HCons[H, F], _: HNil.type) => HNil

  implicit def zippable[F <: HList, S <: HList, H1, H2, Result <: HList](implicit zippable: Zippable[F, S, Result]): Zippable[HCons[H1, F], HCons[H2, S], HCons[(H1, H2), Result]] =
    (first: HCons[H1, F], second: HCons[H2, S]) => HCons((first.head, second.head), zippable(first.tail, second.tail))
}
