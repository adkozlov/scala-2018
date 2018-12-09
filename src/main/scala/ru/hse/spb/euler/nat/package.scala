package ru.hse.spb.euler

import scala.language.higherKinds

package object nat {

  class NatRep[T <: Nat](val i: Long)

  implicit def repS: NatRep[S] = new NatRep[S](0)

  implicit def repO[T <: Nat](implicit rep: NatRep[T]): NatRep[O[T]] = new NatRep[O[T]](rep.i * 2)

  implicit def repI[T <: Nat](implicit rep: NatRep[T]): NatRep[I[T]] = new NatRep[I[T]](rep.i * 2 + 1)

  def toLong[T <: Nat](implicit rep: NatRep[T]): Long = rep.i
}
