package ru.hse.spb.euler

import nat._

object SwappingCountersTypeLevel {

  private type _1 = I[S]
  private type _2 = O[I[S]]
  private type _3 = I[I[S]]
  private type _4 = O[O[I[S]]]
  private type _5 = I[O[I[S]]]

  private type A = _3
  private type B = _4
  private type C = _5
  private type D = _2
  private type E = _3
  private type F = _3

  sealed trait MyTriple {
    type GetX <: Nat
    type GetY <: Nat
    type GetZ <: Nat
  }

  class MyTripleImpl[X <: Nat, Y <: Nat, Z <: Nat] extends MyTriple {
    type GetX = X
    type GetY = Y
    type GetZ = Z
  }

  class NextSolution extends Fun2[MyTriple] {
    type Apply[T <: MyTriple, N <: Nat] =
      MyTripleImpl[
        T#GetX#Mult[A]#Plus[T#GetY#Mult[B]]#Plus[C],
        T#GetX#Mult[D]#Plus[T#GetY#Mult[E]]#Plus[F],
        T#GetZ#Plus[T#GetX#Mult[D]#Plus[T#GetY#Mult[E]]#Plus[F]]
      ]
  }

  type Evaluate[N <: Nat] =
    N#DivBy2#Decrease#Fold[Id[Nat], NextSolution, MyTripleImpl[_2, _1, _1], MyTriple]#GetZ
    #Plus[N#DivBy2#Decrease#Fold[Id[Nat], NextSolution, MyTripleImpl[_5, _3, _3], MyTriple]#GetZ]
}
