package ru.hse.dkaznacheev.heterogenous

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import ru.hse.dkaznacheev.heterogenous.HList._

  implicit def leftNilZippable[R <: HList]: Zippable[HNil.type, R, HNil.type] =
    (_: HNil.type, _: R) => HNil

  implicit def rightNilZippable[L <: HList, H]: Zippable[HCons[H, L], HNil.type, HNil.type] =
    (_: HCons[H, L], _: HNil.type) => HNil

  implicit def zippable[HL, HR, L <: HList, R <: HList, Result <: HList](implicit zippable: Zippable[L, R, Result]): Zippable[HCons[HL, L],
    HCons[HR, R], HCons[(HL, HR), Result]] = (left: HCons[HL, L], right: HCons[HR, R]) => HCons((left.head, right.head),
    zippable(left.tail, right.tail))
}
