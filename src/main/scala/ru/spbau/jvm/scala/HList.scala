package ru.spbau.jvm.scala

sealed trait HList

object HList {
  case class HCons[H, T <: HList](head: H, tail: T) extends HList {
    def ::[A](v: A) = HCons(v, this)
  }

  case object HNil extends HList {
    type toI[N <: Nat] = Nothing

    def ::[T](v: T) = HCons(v, this)
  }

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[H <: HList, Result <: HList](right: H)(implicit zip: Zip[R, H, Result]): Result = zip(list, right)

    def splitAt[I <: Nat, L <: HList, H <: HList](index: I)
                                                 (implicit split: Split[I, R, L, H]): (L, H) = split(index, list)
  }

  def main(args: Array[String]): Unit = {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)
    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    println(s"$hello $world")
  }
}