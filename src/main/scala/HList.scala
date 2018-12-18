import Nat.Zero

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val self: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, self)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, self)

    def zip[L <: HList, Result <: HList](right: L)
                                        (implicit zippable: Zippable[R, L, Result]): Result =
      zippable(self, right)

    def split[N <: Nat, LPair <: HList, RPair <: HList](idx: N)
                                                       (implicit splittable: Splittable[N, R, LPair, RPair]): (LPair, RPair) =
      splittable(idx, self)

  }

  def main(args: Array[String]): Unit = {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)

    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    println(s"$hello $world")

    println(("hello" :: 42 :: false :: HNil) zip ("world" :: HNil)) // HCons((hello,world),HNil)

    val list2 = HNil split Zero
    println(list2)
  }
}
