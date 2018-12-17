package hlist

sealed trait HList

case object HNil extends HList

final case class HCons[H, T <: HList](head: H, tail: T) extends HList

object HList {

  implicit class HListOpt[L <: HList](list:  L) {
      def ::[H](head: H) = HCons(head, list)
  }

  def main(args: Array[String]): Unit = {
    print((1 :: "string" :: HNil) :: HNil)
  }

}