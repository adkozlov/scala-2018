package ru.hse.spb.euler

import nat._
import nat.funs._

object SpecialIsoscelesTrianglesTypeLevel {

  class Isosceles extends Fun[Nat] {
    type Apply[N <: Nat] = N#Mult[_6]#Plus[_3]#Fib#DivBy2
  }

  type Evaluate[N <: Nat] = N#Fold[Isosceles, Sum, _0, Nat]
}
