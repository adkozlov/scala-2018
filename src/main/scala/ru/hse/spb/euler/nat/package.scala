package ru.hse.spb.euler

import scala.language.higherKinds

package object nat {

  type _0 = S
  type _1 = I[S]
  type _2 = O[I[S]]
  type _3 = I[I[S]]
  type _4 = O[O[I[S]]]
  type _5 = I[O[I[S]]]
  type _6 = O[I[I[S]]]
  type _7 = I[I[I[S]]]
  type _10 = O[I[O[I[S]]]]
  type _12 = O[O[I[I[S]]]]
  type _15 = I[I[I[I[S]]]]
  type _20 = O[O[I[O[I[S]]]]]
  type _30 = O[I[I[I[I[S]]]]]
  type _40 = O[O[O[I[O[I[S]]]]]]

  class NatRep[T <: Nat](val i: Long)

  implicit def repS: NatRep[S] = new NatRep[S](0)

  implicit def repO[T <: Nat](implicit rep: NatRep[T]): NatRep[O[T]] = new NatRep[O[T]](rep.i * 2)

  implicit def repI[T <: Nat](implicit rep: NatRep[T]): NatRep[I[T]] = new NatRep[I[T]](rep.i * 2 + 1)

  def toLong[T <: Nat](implicit rep: NatRep[T]): Long = rep.i
}
