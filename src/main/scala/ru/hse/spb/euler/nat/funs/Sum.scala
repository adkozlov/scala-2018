package ru.hse.spb.euler.nat.funs

import ru.hse.spb.euler.nat.Nat

class Sum extends Fun2[Nat] {
  type Apply[N <: Nat, M <: Nat] = N#Plus[M]
}
