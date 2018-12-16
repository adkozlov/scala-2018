package ru.spbau.jvm.scala.hlist

sealed trait HNat

object HNat {

  sealed trait Pos extends HNat

  sealed trait Neg extends HNat

  case class Succ[T <: Pos](prev: T) extends Pos

  case class Pred[T <: Neg](next: T) extends Neg

  case object Zero extends Neg with Pos

}