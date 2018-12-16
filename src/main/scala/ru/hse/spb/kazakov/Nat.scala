package ru.hse.spb.kazakov

sealed trait Nat

object Nat {

  object O extends Nat

  case class S[T <: Nat](pred: T) extends Nat

}