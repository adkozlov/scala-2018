package ru.hse.spb.euler.nat.funs

class Id[Up] extends Fun[Up] {
  type Apply[N <: Up] = N
}
