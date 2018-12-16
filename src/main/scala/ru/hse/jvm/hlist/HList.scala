package ru.hse.jvm.hlist

sealed trait HList

object HList {

  import ru.hse.jvm.HNumber

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[A <: HList](private val list: A) {

    def ::[H](head: H) = HCons(head, list)

    def :::[B <: HList, Result <: HList](left: B)(implicit appendable: Appendable[B, A, Result]): Result =
      appendable(left, list)

    def zip[R <: HList, Result <: HList](right: R)(implicit zippable: Zippable[A, R, Result]): Result = zippable(list, right)

    def splitAt[I <: HNumber, L <: HList, R <: HList](index: I)(implicit splittable: Splittable[A, I, L, R]): (L, R) = splittable(list, index)
  }

  def main(args: Array[String]): Unit = {
    import HNumber._
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)

    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    val list2 = 1 :: 3 :: 4 :: HNil
    // val t = splitAt(1 :: list, Zero)
    //println(t._1, t._2)
    val result = list zip list2
    val temp = list splitAt _2
    println(temp._1.head + " " + temp._2.head)
    println(result.head + " " + result.tail)
    println(s"$hello $world")
  }
}