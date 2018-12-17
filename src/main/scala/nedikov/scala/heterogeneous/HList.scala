package nedikov.scala.heterogeneous

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[X <: HList](private val list: X) extends AnyVal {
    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, X, Result])
    : Result = appendable(left, list)

    def zip[R <: HList, Result <: HList](right : R)
                                        (implicit zippable: Zippable[X, R, Result]): Result =
      zippable(list, right)

    def splitAt[N <: NonNegative, LeftResult <: HList, RightResult <: HList](index: N)
                                                                    (implicit splittable: Splittable[X, N, LeftResult, RightResult]):
    (LeftResult, RightResult) = splittable(list, index)
  }
}