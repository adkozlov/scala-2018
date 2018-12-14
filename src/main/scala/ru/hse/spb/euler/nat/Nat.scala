package ru.hse.spb.euler.nat

import funs._
import cases._

trait Nat {

  /* Plus methods */
  type Plus[N <: Nat] <: Nat
  protected type PlusWithCarry[N <: Nat] <: Nat
  protected type PlusO[N <: Nat] <: Nat
  protected type PlusI[N <: Nat] <: Nat
  protected type PlusWithCarryO[N <: Nat] <: Nat
  protected type PlusWithCarryI[N <: Nat] <: Nat

  /* Minus methods */
  final type Minus[N <: Nat] = MinusImpl[N]#Reverse[S]#RemoveZeros#Reverse[S]
  protected type MinusImpl[N <: Nat] <: Nat
  protected type MinusO[N <: Nat] <: Nat
  protected type MinusI[N <: Nat] <: Nat
  protected type MinusS <: Nat
  protected type MinusWithCarry[N <: Nat] <: Nat
  protected type MinusWithCarryO[N <: Nat] <: Nat
  protected type MinusWithCarryI[N <: Nat] <: Nat

  /* Divide methods */
  type Div[N <: Nat] <: Nat
  type DivImpl[N <: Nat, L <: Nat, R <: Nat] <: Nat

  /* Other arithmetic methods */
  type Mult[N <: Nat] <: Nat
  type DivBy2 <: Nat
  type Decrease <: Nat

  /* Recursive methods and cycles */
  type Fib <: Nat
  type Fold[F <: Fun[Nat], Acc <: Fun2[Up], Init <: Up, Up] <: Up
  final type Repeat[F <: Fun[Up], Init <: Up, Up] = Fold[Id[Nat], AccForRepeat[F, Up], Init, Up]

  /* Auxiliary methods */
  final type IsLess[N <: Nat, C <: Case] = N#Minus[This]#ApplyCase[C]
  protected type ApplyCase[C <: Case] <: Nat
  protected type IsZero[CaseZero <: Nat, CaseNotZero <: Nat] <: Nat
  protected type This <: Nat
  protected type Reverse[Acc <: Nat] <: Nat
  protected type RemoveZeros <: Nat
}
