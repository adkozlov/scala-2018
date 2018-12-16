package ru.spbau.jvm.scala.hlist

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[T <: HList](private val list: T) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)(implicit appendable: Appendable[L, T, Result]): Result =
      appendable(left, list)

    def zip[R <: HList, Result <: HList](right: R)(implicit zippable: Zippable[T, R, Result]): Result =
      zippable(list, right)

    def splitAt[N <: HNat, LResult <: HList, RResult <: HList](index: N)(implicit splittable: Splittable[T, N, LResult, RResult]): (LResult, RResult) =
      splittable(list, index)
  }

  def main(args: Array[String]): Unit = {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)
    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    println(s"$hello $world")
    HNil zip HNil
  }
}