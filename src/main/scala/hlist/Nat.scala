package hlist

import hlist.HList.HNil

sealed trait Nat

object Nat {

  sealed trait Pos extends Nat

  sealed trait Neg extends Nat

  case class Succ[T <: Pos](prev: T) extends Pos

  case class Pred[T <: Neg](next: T) extends Neg

  case object Zero extends Neg with Pos

}