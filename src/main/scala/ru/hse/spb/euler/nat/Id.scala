package ru.hse.spb.euler.nat

class Id extends Fun {
  type Apply[N <: Nat] = N
}
