package ru.hse.spb.euler.nat.cases

import ru.hse.spb.euler.nat.Nat

trait Case {
  type CaseTrue <: Nat
  type CaseFalse <: Nat
}
