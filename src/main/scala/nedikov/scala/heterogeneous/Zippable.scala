package nedikov.scala.heterogeneous

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(l: L, r: R): Result
}

object Zippable {

  import HList._

  implicit def leftNilZippable[R <: HList]: Zippable[HNil.type, R, HNil.type] = (_: HNil.type, _: R) => HNil

  implicit def rightNilZippable[L <: HList]: Zippable[L, HNil.type, HNil.type] = (_: L, _: HNil.type) => HNil

  implicit def zippable[L <: HList, R <: HList, HL, HR, Result <: HList](implicit zippable: Zippable[L, R, Result])
  : Zippable[HCons[HL, L], HCons[HR, R], HCons[(HL, HR), Result]] =
    (left: HCons[HL, L], right: HCons[HR, R]) => HCons((left.head, right.head), zippable(left.tail, right.tail))
}
