package ru.hse.spb.euler.nat

class AccForRepeat[F <: Fun[Up], Up] extends Fun2[Up] {
  type Apply[N <: Up, M <: Nat] = F#Apply[N]
}
