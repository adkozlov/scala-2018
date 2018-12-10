package ru.hse.spb.euler.nat

class Id[Up] extends Fun[Up] {
  type Apply[N <: Up] = N
}
