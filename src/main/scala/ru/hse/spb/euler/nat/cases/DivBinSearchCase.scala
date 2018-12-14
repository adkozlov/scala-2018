package ru.hse.spb.euler.nat.cases

import ru.hse.spb.euler.nat.Nat

class DivBinSearchCase[X <: Nat, N <: Nat, L <: Nat, R <: Nat] extends Case {
  type CaseTrue = X#DivImpl[N, L, L#Plus[R]#DivBy2]
  type CaseFalse = X#DivImpl[N, L#Plus[R]#DivBy2, R]
}
