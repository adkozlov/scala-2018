package ru.hse.spb.euler.nat

class I[T <: Nat] extends Digit[T] {

  override type Plus[N <: Nat] = N#PlusI[This]
  override protected type PlusO[N <: Nat] = I[T#Plus[N#DivBy2]]
  override protected type PlusI[N <: Nat] = O[T#PlusWithCarry[N#DivBy2]]
  override protected type PlusWithCarry[N <: Nat] = N#PlusWithCarryI[This]
  override protected type PlusWithCarryO[N <: Nat] = O[T#PlusWithCarry[N#DivBy2]]
  override protected type PlusWithCarryI[N <: Nat] = I[T#PlusWithCarry[N#DivBy2]]

  override protected type MinusImpl[N <: Nat] = N#MinusI[This]
  override protected type MinusWithCarry[N <: Nat] = N#MinusWithCarryI[This]
  override protected type MinusO[N <: Nat] = I[N#DivBy2#MinusWithCarry[T]]
  override protected type MinusI[N <: Nat] = O[N#DivBy2#MinusImpl[T]]
  override protected type MinusWithCarryO[N <: Nat] = O[N#DivBy2#MinusWithCarry[T]]
  override protected type MinusWithCarryI[N <: Nat] = I[N#DivBy2#MinusWithCarry[T]]

  override type Mult[N <: Nat] = N#Plus[O[T#Mult[N]]]
  override type Decrease = T#IsZero[S, O[T]]

  override type Fib = T#IsZero[_1, Decrease#Fib#Plus[Decrease#Decrease#Fib]]

  override protected type This = I[T]
  override protected type Reverse[Acc <: Nat] = T#Reverse[I[Acc]]
  override protected type RemoveZeros = This
}
