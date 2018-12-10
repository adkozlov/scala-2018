package ru.hse.spb.euler.nat

trait Fun[Up] {
  type Apply[N <: Up] <: Up
}
