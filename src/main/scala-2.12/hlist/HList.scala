package hlist

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)(
        implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[L <: HList, Result <: HList](other: L)(
        implicit zippable: Zippable[R, L, Result]): Result =
      zippable(list, other)

    // no explicit parameters to be able to write `splitAt[_0]`
    def splitAt[I <: Nat](implicit splittable: Splittable[R, I, _, _]) =
      splittable(list)
  }

}
