package ru.hse.spb.kazakov

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[A <: HList](private val list: A) extends AnyVal {
    def ::[H](head: H) = HCons(head, list)

    def :::[B <: HList, R <: HList](left: B)(implicit appendable: Appendable[B, A, R]): R = {
      appendable(left, list)
    }

    def zip[B <: HList, R <: HList](right: B)(implicit zippable: Zippable[A, B, R]): R = {
      zippable(list, right)
    }

    def splitAt[N <: Nat, L <: HList, R <: HList](index: N)(implicit splittable: Splittable[N, A, L, R]): (L, R) = {
      splittable(index, list)
    }
  }

}