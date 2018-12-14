package ru.hse.spb.euler

import nat._

object FibonacciGoldenNuggetsTypeLevel {
  type Evaluate[N <: Nat] = N#Mult[_2]#Fib#Mult[N#Mult[_2]#Plus[_1]#Fib]
}
