trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import HList.{HCons => cons, HNil => nil}

  // zip []       _        = []
  // zip _        []       = []
  // zip (x : xs) (y : ys) = (x, y) : zip xs ys

  implicit def nilZipable[R <: HList]: Zippable[nil.type, R, nil.type] =
    (xs: nil.type, ys: R) => nil

  implicit def nilZipableRight[R <: HList]: Zippable[R, nil.type, nil.type] =
    (xs: R, ys: nil.type) => nil

  implicit def zippable[L <: HList, R <: HList, LH, RH, Result <: HList]
  (implicit zippable: Zippable[L, R, Result])
  : Zippable[cons[LH, L], cons[RH, R], cons[(LH, RH), Result]] =
    (xs: cons[LH, L], ys: cons[RH, R]) =>
      (xs.head, ys.head) :: zippable(xs.tail, ys.tail)
}
