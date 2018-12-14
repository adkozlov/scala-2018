package ru.hse.spb.euler.nat.funs

import ru.hse.spb.euler.nat.Nat

trait Fun2[Up] {
  type Apply[N <: Up, M <: Nat] <: Up
}
