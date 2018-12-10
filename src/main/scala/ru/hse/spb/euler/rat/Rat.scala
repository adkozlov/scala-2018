package ru.hse.spb.euler.rat

import ru.hse.spb.euler.nat._

class Rat[Num <: Nat, Denom <: Nat] {
  type GetNum = Num
  type GetDenom = Denom
}
