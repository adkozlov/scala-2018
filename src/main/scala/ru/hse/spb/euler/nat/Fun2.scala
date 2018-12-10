package ru.hse.spb.euler.nat

trait Fun2[Up] {
  type Apply[N <: Up, M <: Nat] <: Up
}
