package ru.spb.hse.hw03

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[O <: HList, Result <: HList](other: O)
                                        (implicit zippable: Zippable[R, O, Result]): Result =
      zippable(list, other)

    def splitAt[N <: Number, LT <: HList, RT <: HList](index: N)
                                                      (implicit splittable: Splittable[R, N, LT, RT]): (LT, RT) =
      splittable(list, index)
  }

  def main(args: Array[String]): Unit = {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)

    val hello: String = list.head
    val world: String = list.tail.tail.tail.head

    // Just for test if it compiles
    import Number._
    val zippedList = (1 :: 2 :: 3 :: HNil) zip ("one" :: "two" :: "three" :: HNil)
    var splittedList = (1 :: 2 :: 3 :: HNil) splitAt zero
    // no implicit fot splittedList = 1:: HNil splitAt minusOne

    println(s"$hello $world, ${zippedList.head._1} is ${zippedList.head._2}")
  }
}
