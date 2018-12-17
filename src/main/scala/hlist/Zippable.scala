package hlist

trait Zippable[X <: HList, Y <: HList, R <: HList] {
  def apply(xs: X, ys: Y): R
}

object Zippable {

  import HList._

  implicit def NilSmtZippable[Y <: HList]: Zippable[HNil.type, Y, HNil.type] =
    (_: HNil.type, _: Y) => HNil

  implicit def ConsNilZippable[X <: HList, H]: Zippable[HCons[H, X], HNil.type, HNil.type] =
    (_: HCons[H, X], _: HNil.type ) => HNil

  implicit def zippable[X <: HList, Y <: HList, H1, H2, R <: HList]
    (implicit zippable: Zippable[X, Y, R]): Zippable[HCons[H1, X], HCons[H2, Y], HCons[(H1, H2), R]] =
    (xs: HCons[H1, X], ys: HCons[H2, Y]) => HCons((xs.head, ys.head), zippable(xs.tail, ys.tail))
}