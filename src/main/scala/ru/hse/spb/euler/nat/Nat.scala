package ru.hse.spb.euler.nat

sealed trait Nat {

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
  protected type MinusWithCarry[N <: Nat] <: Nat
  protected type MinusWithCarryO[N <: Nat] <: Nat
  protected type MinusWithCarryI[N <: Nat] <: Nat

  /* Arithmetic methods */
  type Mult[N <: Nat] <: Nat
  type DivBy2 <: Nat
  type Decrease <: Nat

  /* Recursive methods and cycles */
  type Fib <: Nat
  type Fold[F <: Fun[Nat], Acc <: Fun2[Up], Init <: Up, Up] <: Up
  final type Repeat[F <: Fun[Up], Init <: Up, Up] = Fold[Id[Nat], AccForRepeat[F, Up], Init, Up]

  /* Auxiliary methods */
  protected type IsZero[CaseZero <: Nat, CaseNotZero <: Nat] <: Nat
  protected type This <: Nat
  protected final type Normalize = Reverse[S]#RemoveZeros#Reverse[S]
  protected type Reverse[Acc <: Nat] <: Nat
  protected type RemoveZeros <: Nat
}

class S extends Nat {

  type Plus[N <: Nat] = N
  type PlusWithCarry[N <: Nat] = N#PlusI[I[S]]
  type PlusO[N <: Nat] = N
  type PlusI[N <: Nat] = N
  type PlusWithCarryO[N <: Nat] = N#PlusI[I[S]]
  type PlusWithCarryI[N <: Nat] = N#PlusI[I[S]]

  type MinusImpl[N <: Nat] = S
  type MinusWithCarry[N <: Nat] = S
  type MinusO[N <: Nat] = N
  type MinusI[N <: Nat] = N
  type MinusWithCarryO[N <: Nat] = N#Decrease
  type MinusWithCarryI[N <: Nat] = N#Decrease

  type Mult[N <: Nat] = S
  type DivBy2 = S
  type Decrease = S

  type Fib = S
  type Fold[F <: Fun[Nat], Acc <: Fun2[Up], Init <: Up, Up] = Init

  type IsZero[CaseZero <: Nat, CaseNotZero <: Nat] = CaseZero
  type This = S
  type Reverse[Acc <: Nat] = Acc
  type RemoveZeros = S
}

sealed trait Digit[T <: Nat] extends Nat {

  final type DivBy2 = T

  final type Fold[F <: Fun[Nat], Acc <: Fun2[Up], Init <: Up, Up] =
    Acc#Apply[Decrease#Fold[F, Acc, Init, Up], F#Apply[This]]

  final type IsZero[CaseZero <: Nat, CaseNotZero <: Nat] = CaseNotZero
}

class O[T <: Nat] extends Digit[T] {

  type Plus[N <: Nat] = N#PlusO[This]
  type PlusWithCarry[N <: Nat] = N#PlusWithCarryO[This]
  type PlusO[N <: Nat] = O[T#Plus[N#DivBy2]]
  type PlusI[N <: Nat] = I[T#Plus[N#DivBy2]]
  type PlusWithCarryO[N <: Nat] = I[T#Plus[N#DivBy2]]
  type PlusWithCarryI[N <: Nat] = O[T#PlusWithCarry[N#DivBy2]]

  type MinusImpl[N <: Nat] = N#MinusO[This]
  type MinusWithCarry[N <: Nat] = N#MinusWithCarryO[This]
  type MinusO[N <: Nat] = O[N#DivBy2#MinusImpl[T]]
  type MinusI[N <: Nat] = I[N#DivBy2#MinusImpl[T]]
  type MinusWithCarryO[N <: Nat] = I[N#DivBy2#MinusWithCarry[T]]
  type MinusWithCarryI[N <: Nat] = O[N#DivBy2#MinusImpl[T]]

  type Mult[N <: Nat] = O[T#Mult[N]]
  type Decrease = I[T#Decrease]

  type Fib = Decrease#Fib#Plus[Decrease#Decrease#Fib]

  type This = O[T]
  type Reverse[Acc <: Nat] = T#Reverse[O[Acc]]
  type RemoveZeros = T#RemoveZeros
}

class I[T <: Nat] extends Digit[T] {

  type Plus[N <: Nat] = N#PlusI[This]
  type PlusO[N <: Nat] = I[T#Plus[N#DivBy2]]
  type PlusI[N <: Nat] = O[T#PlusWithCarry[N#DivBy2]]
  type PlusWithCarry[N <: Nat] = N#PlusWithCarryI[This]
  type PlusWithCarryO[N <: Nat] = O[T#PlusWithCarry[N#DivBy2]]
  type PlusWithCarryI[N <: Nat] = I[T#PlusWithCarry[N#DivBy2]]

  type MinusImpl[N <: Nat] = N#MinusI[This]
  type MinusWithCarry[N <: Nat] = N#MinusWithCarryI[This]
  type MinusO[N <: Nat] = I[N#DivBy2#MinusWithCarry[T]]
  type MinusI[N <: Nat] = O[N#DivBy2#MinusImpl[T]]
  type MinusWithCarryO[N <: Nat] = O[N#DivBy2#MinusWithCarry[T]]
  type MinusWithCarryI[N <: Nat] = I[N#DivBy2#MinusWithCarry[T]]

  type Mult[N <: Nat] = N#Plus[O[T#Mult[N]]]
  type Decrease = T#IsZero[S, O[T]]

  type Fib = T#IsZero[I[S], Decrease#Fib#Plus[Decrease#Decrease#Fib]]

  type This = I[T]
  type Reverse[Acc <: Nat] = T#Reverse[I[Acc]]
  type RemoveZeros = This
}
