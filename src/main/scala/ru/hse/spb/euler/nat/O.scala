package ru.hse.spb.euler.nat

class O[T <: Nat] extends Digit[T] {

  override type Plus[N <: Nat] = N#PlusO[This]
  override protected type PlusWithCarry[N <: Nat] = N#PlusWithCarryO[This]
  override protected type PlusO[N <: Nat] = O[T#Plus[N#DivBy2]]
  override protected type PlusI[N <: Nat] = I[T#Plus[N#DivBy2]]
  override protected type PlusWithCarryO[N <: Nat] = I[T#Plus[N#DivBy2]]
  override protected type PlusWithCarryI[N <: Nat] = O[T#PlusWithCarry[N#DivBy2]]

  override protected type MinusImpl[N <: Nat] = N#MinusO[This]
  override protected type MinusWithCarry[N <: Nat] = N#MinusWithCarryO[This]
  override protected type MinusO[N <: Nat] = O[N#DivBy2#MinusImpl[T]]
  override protected type MinusI[N <: Nat] = I[N#DivBy2#MinusImpl[T]]
  override protected type MinusWithCarryO[N <: Nat] = I[N#DivBy2#MinusWithCarry[T]]
  override protected type MinusWithCarryI[N <: Nat] = O[N#DivBy2#MinusImpl[T]]

  override type Mult[N <: Nat] = O[T#Mult[N]]
  override type Decrease = I[T#Decrease]

  override type Fib = Decrease#Fib#Plus[Decrease#Decrease#Fib]

  override protected type This = O[T]
  override protected type Reverse[Acc <: Nat] = T#Reverse[O[Acc]]
  override protected type RemoveZeros = T#RemoveZeros
}
