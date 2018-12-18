sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[L <: HList, Result <: HList](left: L)
                                        (implicit zippable: Zippable[L, R, Result]): Result =
      zippable(left, list)

    def splitAt[I <: PositiveNumber, LR <: HList, RR <: HList](i: I)
                                                              (implicit splitable: Splitable[I, R, LR, RR]):
    (LR, RR) = splitable(list, i)

  }

}
