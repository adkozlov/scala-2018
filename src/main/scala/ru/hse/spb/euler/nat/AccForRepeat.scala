package ru.hse.spb.euler.nat

class AccForRepeat[F <: Fun] extends Fun2 {
  type Apply[N <: Nat, M <: Nat] = F#Apply[N]
}
