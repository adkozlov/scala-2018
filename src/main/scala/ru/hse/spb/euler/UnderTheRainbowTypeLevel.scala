package ru.hse.spb.euler

import nat._
import nat.funs._
import rat.Rat

object UnderTheRainbowTypeLevel {

  class Plus[M <: Nat] extends Fun[Nat] {
    type Apply[N <: Nat] = N#Plus[M]
  }

  class Prod extends Fun2[Nat] {
    type Apply[N <: Nat, M <: Nat] = N#Mult[M]
  }

  class DivBy2 extends Fun[Nat] {
    type Apply[N <: Nat] = N#DivBy2
  }

  type UpperFact[Base <: Nat, N <: Nat] = N#Fold[Plus[Base#Decrease], Prod, _1, Nat]

  type Num[Colors <: Nat, SameBalls <: Nat, Attempts <: Nat] =
    UpperFact[Colors#Decrease#Mult[SameBalls]#Minus[Attempts]#Plus[_1], SameBalls]

  type Denom[Colors <: Nat, SameBalls <: Nat, Attempts <: Nat] =
    UpperFact[Colors#Decrease#Mult[SameBalls]#Plus[_1], SameBalls]

  type Evaluate[Colors <: Nat, SameBalls <: Nat, Attempts <: Nat] =
    Rat[
      SameBalls#DivBy2#Repeat[
        DivBy2,
        Denom[Colors, SameBalls, Attempts]#Minus[Num[Colors, SameBalls, Attempts]],
        Nat
      ]#Mult[Colors],
      SameBalls#DivBy2#Repeat[
        DivBy2,
        Denom[Colors, SameBalls, Attempts],
        Nat
      ]
    ]
}
