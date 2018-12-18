package hlist

sealed trait HList

object HList {

  import nat._

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)(implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[L <: HList, Result <: HList](right: L)(implicit zippable: Zippable[R, L, Result]): Result =
      zippable(list, right)

    def splitAt[I <: Nat, L <: HList, T <: HList](i: I)(implicit splittable: Splittable[R, I, L, T]): (L, T) =
      splittable(list)
  }

  def main(args: Array[String]): Unit = {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)

    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    println(s"$hello $world")

    val list1 = 1 :: false :: -12 :: Some(17) :: "kek" :: HNil
    val list2 = -1 :: true :: HNil
    val listRes = HNil zip list2
    println(list1 zip list2)

    println(list splitAt new Succ[Zero])
  }

}
