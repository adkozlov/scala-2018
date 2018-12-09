package ru.hse.spb.euler

import nat._

object FibonacciGoldenNuggetsTypeLevel {

  private type _1 = I[S]

  type Evaluate[N <: Nat] = N#MultBy2#Fib#Mult[N#MultBy2#Plus[_1]#Fib]
}
