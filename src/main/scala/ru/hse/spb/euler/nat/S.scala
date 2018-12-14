package ru.hse.spb.euler.nat

import cases._
import funs._

class S extends Nat {

  override type Plus[N <: Nat] = N
  override protected type PlusWithCarry[N <: Nat] = N#PlusI[_1]
  override protected type PlusO[N <: Nat] = N
  override protected type PlusI[N <: Nat] = N
  override protected type PlusWithCarryO[N <: Nat] = N#PlusI[_1]
  override protected type PlusWithCarryI[N <: Nat] = N#PlusI[_1]

  override type MinusImpl[N <: Nat] = N#MinusS
  override protected type MinusWithCarry[N <: Nat] = SS
  override protected type MinusO[N <: Nat] = N
  override protected type MinusI[N <: Nat] = N
  override protected type MinusS = S
  override protected type MinusWithCarryO[N <: Nat] = N#Decrease
  override protected type MinusWithCarryI[N <: Nat] = N#Decrease

  override type Mult[N <: Nat] = S
  override type Div[N <: Nat] = S
  override type DivBy2 = S
  override type Decrease = S

  override type Fib = S
  override type Fold[F <: Fun[Nat], Acc <: Fun2[Up], Init <: Up, Up] = Init

  override protected type ApplyCase[C <: Case] = C#CaseFalse
  override protected type IsZero[CaseZero <: Nat, CaseNotZero <: Nat] = CaseZero
  override protected type This = S
  override protected type Reverse[Acc <: Nat] = Acc
  override protected type RemoveZeros = S
}
