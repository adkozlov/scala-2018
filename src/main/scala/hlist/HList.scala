package hlist

import hlist.Nat.{Pred, Succ, Zero}

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[L <: HList](private val list: L) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[X <: HList, R <: HList](xs: X)
           (implicit appendable: Appendable[X, L, R]): R =
      appendable(xs, list)

    def zip[Y <: HList, R <: HList](ys : Y)
           (implicit zippable: Zippable[L, Y, R]): R =
      zippable(list, ys)

    def split[N <: Nat, R1 <: HList, R2 <: HList](n: N)
             (implicit splittable : Splittable[L, N, R1, R2]): (R1, R2) =
      splittable(list, n)
  }

}