package hlist

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result = appendable(left, list)

    def zip[Other <: HList, Result <: HList](other: Other)
                                        (implicit zip: Zippable[R, Other, Result]): Result = zip(list, other)

    def splitAt[I <: NaturalNumber, F <: HList, S <: HList](index: I)
                                       (implicit split: Splittable[I, R, F, S]): (F, S) = split(list, index)
  }

  def main(args: Array[String]): Unit = {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)

    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    println(s"$hello $world")
  }
}