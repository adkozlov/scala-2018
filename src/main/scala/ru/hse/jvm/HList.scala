package ru.hse.jvm


sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[T <: HList](private val list: T) extends AnyVal {
    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, T, Result]): Result =
      appendable(left, list)

    def zip[R <: HList, Result <: HList](right: R)
                                        (implicit zippable: Zippable[T, R, Result]): Result =
      zippable(list, right)

    def splitAt[N <: HNumber, L <: HList, R <: HList](n: N)
                                                     (implicit splittable: Splittable[T, N, L, R]): (L, R) =
      splittable(list, n)
  }

}



