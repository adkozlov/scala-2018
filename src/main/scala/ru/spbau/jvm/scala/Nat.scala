package ru.spbau.jvm.scala

sealed trait Nat

object Nat {

  object _0 extends Nat

  case class Succ[N <: Nat](prev: N) extends Nat
}