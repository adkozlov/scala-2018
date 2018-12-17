package ru.hse.scala.hlist

sealed trait Nat

object Nat {
  case class Succ[Tail <: Nat](tail: Tail) extends Nat

  case object Zero extends Nat
}
