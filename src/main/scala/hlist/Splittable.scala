package hlist

import hlist.NaturalNumber.Succ

trait Splittable[I <: NaturalNumber, T <: HList, L <: HList, R <: HList] {
  def apply(list: T, index: I): (L, R)
}

object Splittable {

  import HList._

  implicit def splitAtZero[R <: HList]: Splittable[Zero.type, R, HNil.type, R] =
    (list: R, _: Zero.type) => (HNil, list)

  implicit def split[I <: NaturalNumber, T <: HList, H, L <: HList, R <: HList]
  (implicit split: Splittable[I, T, L, R]): Splittable[Succ[I], HCons[H, T], HCons[H, L], R] =
    (list: HCons[H, T], index: Succ[I]) => {
      val (left, right) = split(list.tail, index.prev)
      (list.head :: left, right)
    }
}