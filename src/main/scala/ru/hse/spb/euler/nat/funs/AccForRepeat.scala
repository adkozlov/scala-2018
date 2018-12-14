package ru.hse.spb.euler.nat.funs

import ru.hse.spb.euler.nat.Nat

class AccForRepeat[F <: Fun[Up], Up] extends Fun2[Up] {
  type Apply[N <: Up, M <: Nat] = F#Apply[N]
}
