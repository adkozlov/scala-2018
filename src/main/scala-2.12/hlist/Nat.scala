package hlist

sealed trait Nat
object Nat {
  sealed trait Suc[N <: Nat] extends Nat
  sealed trait _0 extends Nat

  type _1 = Suc[_0]
  type _2 = Suc[_1]
  type _3 = Suc[_2]
  type _4 = Suc[_3]
  type _5 = Suc[_4]
}