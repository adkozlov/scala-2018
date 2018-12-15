package ru.hse.list


sealed trait HList

object HList {

  import ru.hse.nat.Nat

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[L <: HList](private val list: L) {

    def ::[H](head: H) = HCons(head, list)

    def :::[P <: HList, Result <: HList](left: P)(implicit appendable: Appendable[P, L, Result]): Result =
      appendable(left, list)

    def zip[R <: HList, Result <: HList](right: R)(implicit zipped: Zipped[L, R, Result]): Result =
      zipped(list, right)

    def splitAt[N <: Nat, Left <: HList, Right <: HList](n: N)(implicit cut: Cut[L, N, Left, Right]): (Left, Right) =
      cut(list, n)

  }

}