package ru.spbau.jvm.scala.hlist

import scala.language.implicitConversions


trait Splittable[List <: HList, Left <: HList, Right <: HList, Index <: Nat] {
  def apply(list: List): (Left, Right)
}

object Splittable {
  import HList._

  implicit def zeroSplittable[L <: HList] :
  Splittable[L, HNil.type, L, O]  =
  (list : L) => (HNil, list)

  implicit def splittable[L <: HList, H,  Left <: HList, Right <: HList, T <: Nat](implicit splittable:
  Splittable[L, Left, Right, T]) : Splittable[HCons[H, L], HCons[H, Left], Right, S[T]] =
    (list : HCons[H, L]) => {
      val previous = splittable(list.tail)
      (HCons(list.head, previous._1), previous._2)
    }
}