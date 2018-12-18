package ru.spbau.jvm.scala

import ru.spbau.jvm.scala.Nat.{Succ, _0}

trait Split[N <: Nat, List <: HList, L <: HList, R <: HList] {
  def apply(index: N, right: List): (L, R)
}

object Split {
  import HList._

  // {0, list} => (Nil, list)
  implicit def oSplit[G <: HList]: Split[_0.type , G, HNil.type, G] = (_: _0.type , list: G) => (HNil, list)

  // {i, list} = { (l, r) = split(i-1, list.tail); (list.head::l, r)}
  implicit def split[H, I <: Nat, G <: HList, L <: HList, R <: HList](implicit split: Split[I, G, L, R]):
    Split[Succ[I], HCons[H, G], HCons[H, L], R] = (index: Succ[I], list: HCons[H, G]) => {
      val (left, right) = split(index.prev, list.tail)
      (list.head :: left, right)
    }
}
