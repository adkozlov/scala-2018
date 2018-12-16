package ru.hse.jvm.hlist

import ru.hse.jvm.HNumber
import ru.hse.jvm.HNumber.{Pos, Succ, Zero}

trait Splittable[A <: HList, I <: HNumber, L <: HList, R <: HList] {
  def apply(list: A, index: I): (L, R)
}

object Splittable {
  import HList._

  implicit def splittableAtZero[A <: HList]: Splittable[A, Zero.type, HNil.type, A] = (list: A, _: Zero.type) => (HNil, list)

  implicit def splittableAt[H, A <: HList, I <: Pos, L <: HList, R <: HList](implicit splittable: Splittable[A, I, L, R]): Splittable[HCons[H, A], Succ[I], HCons[H, L], R] = (list: HCons[H, A], index: Succ[I]) => {
    val (l, r) = splittable(list.tail, index.less)
    (list.head :: l, r)
  }
}