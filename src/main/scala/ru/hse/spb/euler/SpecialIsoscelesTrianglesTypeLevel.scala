package ru.hse.spb.euler

import ru.hse.spb.euler.nat._

object SpecialIsoscelesTrianglesTypeLevel {

  private type _3 = I[I[S]]
  private type _6 = O[I[I[S]]]
  private type _0 = S

  class Isosceles extends Fun[Nat] {
    type Apply[N <: Nat] = N#Mult[_6]#Plus[_3]#Fib#DivBy2
  }

  class Sum extends Fun2[Nat] {
    type Apply[N <: Nat, M <: Nat] = N#Plus[M]
  }

  type Evaluate[N <: Nat] = N#Fold[Isosceles, Sum, _0, Nat]
}
