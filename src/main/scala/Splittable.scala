trait Splittable[N <: Nat, R <: HList, PairL <: HList, PairR <: HList] {
  def apply(idx: N, list: R): (PairL, PairR)
}

object Splittable {

  import HList.{HCons => cons, HNil => nil}
  import Nat._

  // split zero    xs       = ([], xs)
  // split (suc n) (x : xs) = let (ls, rs) = split n xs  in (x : ls, rs)

  implicit def zeroSplittable[R <: HList]: Splittable[Zero.type, R, nil.type, R] =
    (_, list) => (nil, list)

  implicit def splittable[N <: Nat, RH, R <: HList, PairL <: HList, PairR <: HList]
  (implicit splittable: Splittable[N, R, PairL, PairR])
  : Splittable[Suc[N], cons[RH, R], cons[RH, PairL], PairR] =
    (idx, xs) => splittable(idx.num, xs.tail) match {
      case (ls, rs) => (xs.head :: ls, rs)
    }
}
