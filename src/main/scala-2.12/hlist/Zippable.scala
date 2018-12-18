package hlist

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(l: L, r: R): Result
}

object Zippable {

  import HList.{HCons, HNil}

  // for cases `nil zip nil` and `anything zip nil`
  implicit def nilRightZippable[L <: HList]: Zippable[L, HNil.type, HNil.type] =
    (_, nil) => nil

  // for case `nil zip cons(x, _)` only
  implicit def nilLeftZippable[H, T <: HList]: Zippable[HNil.type, HCons[H, T], HNil.type] =
    (nil, _) => nil

  implicit def zippable[L <: HList, LH, R <: HList, RH, Result <: HList]
  (implicit zippable: Zippable[L, R, Result])
  : Zippable[HCons[LH, L], HCons[RH, R], HCons[(LH, RH), Result]] =
    (left, right) => HCons((left.head, right.head), zippable(left.tail, right.tail))
}
