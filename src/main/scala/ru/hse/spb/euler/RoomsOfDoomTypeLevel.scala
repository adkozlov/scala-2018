package ru.hse.spb.euler

import nat._
import nat.cases._
import nat.funs._

object RoomsOfDoomTypeLevel {

  class NeedCardsImpl[Cards <: Nat] extends Fun2[Nat] {
    type Apply[Current <: Nat, _ <: Nat] =
      Cards#IsLess[Current#Plus[_1], Case {
        type CaseTrue = Current#Plus[Current#Minus[Cards]#Div[Cards#Minus[_2]]#Plus[_1]#Mult[_2]]
        type CaseFalse = Current
      }]#Plus[_1]
  }

  class NeedCards[TotalRooms <: Nat] extends Fun[Nat] {
    type Apply[Cards <: Nat] = TotalRooms#Fold[Id[Nat], NeedCardsImpl[Cards#Plus[_2]], _1, Nat]
  }

  type Evaluate[MaxCards <: Nat, Rooms <: Nat] = MaxCards#Minus[_2]#Fold[NeedCards[Rooms], Sum, _0, Nat]
}
