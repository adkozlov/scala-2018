package ru.spbau.jvm.scala.heter

sealed trait Nat

object Nat {

  case class Succ[T <: Nat](prev: T) extends Nat

  case object Zero extends Nat

}