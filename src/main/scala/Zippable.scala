trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import HList._

  // zip(HNil, R) = HNil
  implicit def nilZippableLeft[R <: HList]: Zippable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  //zip(L, HNil) = HNil
  implicit def nilZippableRight[L <: HList]: Zippable[L, HNil.type, HNil.type] =
    (_: L, _: HNil.type) => HNil

  implicit def nilZippableLeftRight: Zippable[HNil.type, HNil.type, HNil.type] =
    (_: HNil.type, _: HNil.type) => HNil


  //zip(HCons, HCons) = Result
  //zip(LH::L, RH::R) = (LH, RH) :: zip(L, R)
  implicit def zippable[L <: HList, R <: HList, Hl, Hr, Result <: HList](implicit zippable: Zippable[L, R, Result]):
  Zippable[HCons[Hl, L], HCons[Hr, R], HCons[(Hl, Hr), Result]] =
    (left: HCons[Hl, L], right: HCons[Hr, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))

}