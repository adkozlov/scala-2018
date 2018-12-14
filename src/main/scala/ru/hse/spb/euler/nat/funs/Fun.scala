package ru.hse.spb.euler.nat.funs

trait Fun[Up] {
  type Apply[N <: Up] <: Up
}
