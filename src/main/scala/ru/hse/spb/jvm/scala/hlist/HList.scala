package ru.hse.spb.jvm.scala.hlist

sealed trait HList

object HList {

  def main(args: Array[String]): Unit = {
    val list1 = 42 :: HNil
    val list2 = (2.22 :: HNil) ::: "hello" :: 22 :: HNil
    val zipped = list2.zip(list1)

    val a = 2
  }

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[L <: HList, Result <: HList](left: L)
                                        (implicit zippable: Zippable[L, R, Result]): Result =
      zippable(left, list)
  }

  case object HNil extends HList

}
