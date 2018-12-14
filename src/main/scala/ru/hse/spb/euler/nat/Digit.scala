package ru.hse.spb.euler.nat

import cases._
import funs._

trait Digit[T <: Nat] extends Nat {

  override protected final type MinusS = SS

  override final type Div[N <: Nat] = DivImpl[N, S, This#Plus[_1]]
  override final type DivImpl[N <: Nat, L <: Nat, R <: Nat] = L#IsLess[R#Decrease, Case {
    type CaseTrue = This#IsLess[L#Plus[R]#DivBy2#Mult[N], DivBinSearchCase[This, N, L, R]]
    type CaseFalse = L
  }]

  override final type DivBy2 = T

  override final type Fold[F <: Fun[Nat], Acc <: Fun2[Up], Init <: Up, Up] =
    Acc#Apply[Decrease#Fold[F, Acc, Init, Up], F#Apply[This]]

  override final type ApplyCase[C <: Case] = C#CaseTrue
  override protected final type IsZero[CaseZero <: Nat, CaseNotZero <: Nat] = CaseNotZero
}
