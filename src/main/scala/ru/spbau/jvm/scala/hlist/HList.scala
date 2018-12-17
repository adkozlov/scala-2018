package ru.spbau.jvm.scala.hlist

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[L <: HList](private val list: L) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[R <: HList, Result <: HList](left: R)
                                        (implicit appendable: Appendable[R, L, Result]): Result =
      appendable(left, list)

    def zip[R <: HList, Result <: HList](right: R)
                                        (implicit zippable: Zippable[L, R, Result]): Result =
      zippable(list, right)
  }

  def main(args: Array[String]): Unit = {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)

    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    println(s"$hello $world")
  }
}
