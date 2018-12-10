package ru.hse.spb.euler

import ru.hse.spb.euler.nat._
import ru.hse.spb.euler.rat.Rat

object UnderTheRainbowTypeLevel {

  type _1 = I[S]

  class Plus[M <: Nat] extends Fun {
    type Apply[N <: Nat] = N#Plus[M]
  }

  class Prod extends Fun2 {
    type Apply[N <: Nat, M <: Nat] = N#Mult[M]
  }

  class DivBy2 extends Fun {
    type Apply[N <: Nat] = N#DivBy2
  }

  type UpperFact[Base <: Nat, N <: Nat] = N#Fold[Plus[Base#Decrease], Prod, _1]

  type Num[Colors <: Nat, SameBalls <: Nat, Attempts <: Nat] =
    UpperFact[Colors#Decrease#Mult[SameBalls]#Minus[Attempts]#Plus[_1], SameBalls]

  type Denom[Colors <: Nat, SameBalls <: Nat, Attempts <: Nat] =
    UpperFact[Colors#Decrease#Mult[SameBalls]#Plus[_1], SameBalls]

  type Evaluate[Colors <: Nat, SameBalls <: Nat, Attempts <: Nat] =
    Rat[
      SameBalls#DivBy2#Repeat[
        DivBy2,
        Denom[Colors, SameBalls, Attempts]#Minus[Num[Colors, SameBalls, Attempts]]
        ]#Mult[Colors],
      SameBalls#DivBy2#Repeat[
        DivBy2,
        Denom[Colors, SameBalls, Attempts]
        ]
      ]
}
