package hlist

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[L <: HList](private val list: L) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[X <: HList, R <: HList](xs: X)
           (implicit appendable: Appendable[X, L, R]): R =
      appendable(xs, list)

    def zip[Y <: HList, R <: HList](ys : Y)
           (implicit zippable: Zippable[L, Y, R]): R =
      zippable(list, ys)
  }

  def main(args: Array[String]): Unit = {
    val list1 = "hello" :: 42 :: HNil
    val list2 = 7 :: 44 :: true :: HNil

    println(list1 zip list2)
  }
}