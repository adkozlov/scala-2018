package ru.spb.hse.jvm.scala.hw03

import ru.spb.hse.jvm.scala.hw03.HList.{HCons, HNil}
import ru.spb.hse.jvm.scala.hw03.ChurchNumeral.{Suc, Zero}

trait Splittable[L <: HList, I <: ChurchNumeral, R1 <: HList, R2 <: HList] {
  def apply(list: L, index: I): (R1, R2)
}

object Splittable {

  implicit def zeroSplittable[L <: HList]: Splittable[L, Zero.type, HNil.type, L] =
    (list: L, _: Zero.type) => (HNil, list)

  implicit def splittable[HL, L <: HList, I <: ChurchNumeral, R1 <: HList, R2 <: HList](implicit splittable: Splittable[L, I, R1, R2]): Splittable[HCons[HL, L], Suc[I], HCons[HL, R1], R2] =
    (list: HCons[HL, L], index: Suc[I]) => {
      val (r1, r2) = splittable(list.tail, index.n)
      (HCons(list.head, r1), r2)
    }

}
