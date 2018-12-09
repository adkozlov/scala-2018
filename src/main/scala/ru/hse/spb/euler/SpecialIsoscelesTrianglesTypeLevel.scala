package ru.hse.spb.euler

import ru.hse.spb.euler.nat._

object SpecialIsoscelesTrianglesTypeLevel {

  private type _3 = I[I[S]]
  private type _6 = O[I[I[S]]]

  class Isosceles extends Fun {
    type Apply[N <: Nat] = N#Mult[_6]#Plus[_3]#Fib#DivBy2
  }

  type Evaluate[N <: Nat] = N#RepeatAndSum[Isosceles]
}
