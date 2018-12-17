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

    def splitBy[N <: Nat, L1 <: HList, R1 <: HList](index: N)
                                                   (implicit splittable: Splittable[L, N, L1, R1]): (L1, R1) =
      splittable(list, index)
  }

  def main(args: Array[String]): Unit = {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)

    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    println(s"$hello $world")

    val (left, right) = list splitBy S(S(S(Z)))
    println(s"${left.head} ${right.head}")

    // Does not compile
// val (left1, right1) = list splitBy S(S(S(S(S(S(Z))))))
  }
}
