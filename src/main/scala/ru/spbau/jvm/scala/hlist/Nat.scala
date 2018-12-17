package ru.spbau.jvm.scala.hlist

sealed trait Nat

case object Z extends Nat
case class S[N <: Nat](n: N) extends Nat