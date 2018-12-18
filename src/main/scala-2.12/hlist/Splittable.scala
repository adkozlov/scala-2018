package hlist

trait Splittable[L <: HList, I <: Nat, Left <: HList, Right <: HList] {
  def apply(l: L): (Left, Right)
}

object Splittable {

  import Nat.{_0, Suc}
  import HList.{HCons, HNil}

  implicit def splitAt0[R <: HList]: Splittable[R, _0, HNil.type, R] =
    list => (HNil, list)

  implicit def splitAtI[H, L <: HList, I <: Nat, Left <: HList, Right <: HList]
  (implicit splitter: Splittable[L, I, Left, Right])
  : Splittable[HCons[H, L], Suc[I], HCons[H, Left], Right] =
    list => {
      val (f, b) = splitter(list.tail)
      (HCons(list.head, f), b)
    }
}
