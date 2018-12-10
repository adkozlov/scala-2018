package ru.hse.spb.euler

import nat._

object FibonacciGoldenNuggetsTypeLevel {

  private type _1 = I[S]
  private type _2 = O[I[S]]

  type Evaluate[N <: Nat] = N#Mult[_2]#Fib#Mult[N#Mult[_2]#Plus[_1]#Fib]
}
