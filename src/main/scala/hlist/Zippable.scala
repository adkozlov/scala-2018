package hlist

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import HList._

  // HNil zip R = HNil
  implicit def leftNilZip[R <: HList]: Zippable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  // L zip HNil = HNil
  implicit def rightNilZip[L <: HList, H]: Zippable[HCons[H, L], HNil.type, HNil.type] =
    (_: HCons[H, L], _: HNil.type) => HNil

  // L zip R = Result
  // (H1 :: L) zip (H2 :: R) = (H1, H2) :: Result
  implicit def zip[L <: HList, R <: HList, H1, H2, Result <: HList]
  (implicit zip: Zippable[L, R, Result]): Zippable[HCons[H1, L], HCons[H2, R], HCons[(H1, H2), Result]] =
    (left: HCons[H1, L], right: HCons[H2, R]) => HCons((left.head, right.head), zip(left.tail, right.tail))
}