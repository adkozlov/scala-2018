package ru.hse.spb.euler.nat

sealed trait Nat {
  final type StartsWithI[CaseI <: Nat, CaseNotI <: Nat] = MatchType[CaseI, CaseNotI, CaseNotI]
  final type IsZero[CaseZero <: Nat, CaseNotZero <: Nat] = MatchType[CaseNotZero, CaseNotZero, CaseZero]
  type Plus[N <: Nat] <: Nat
  type Mult[N <: Nat] <: Nat
  type DivBy2 <: Nat
  type MultBy2 <: Nat
  type Decrease <: Nat
  type Fib <: Nat
  type RepeatAndSum[F <: Fun] <: Nat
  protected type PlusWithCarry[N <: Nat] <: Nat
  protected type MatchType[CaseI <: Nat, CaseO <: Nat, CaseS <: Nat] <: Nat
  protected type This <: Nat
}

class S extends Nat {
  type Plus[N <: Nat] = N
  type PlusWithCarry[N <: Nat] = N#Plus[I[S]]
  type Mult[N <: Nat] = S
  type DivBy2 = S
  type MultBy2 = S
  type MatchType[CaseI <: Nat, CaseO <: Nat, CaseS <: Nat] = CaseS
  type Decrease = S
  type Fib = S
  type RepeatAndSum[F <: Fun] = S
  type This = S
}

sealed trait Digit[T <: Nat] extends Nat {
  type DivBy2 = T
  type MultBy2 = O[This]
  type RepeatAndSum[F <: Fun] = Decrease#RepeatAndSum[F]#Plus[F#Apply[This]]
}

class O[T <: Nat] extends Digit[T] {
  type Plus[N <: Nat] = N#StartsWithI[I[T#Plus[N#DivBy2]], O[T#Plus[N#DivBy2]]]
  type PlusWithCarry[N <: Nat] = N#StartsWithI[O[T#PlusWithCarry[N#DivBy2]], I[T#Plus[N#DivBy2]]]
  type Mult[N <: Nat] = O[T#Mult[N]]
  type MatchType[CaseI <: Nat, CaseO <: Nat, CaseS <: Nat] = CaseO
  type Decrease = I[T#Decrease]
  type Fib = Decrease#Fib#Plus[Decrease#Decrease#Fib]
  type This = O[T]
}

class I[T <: Nat] extends Digit[T] {
  type Plus[N <: Nat] = N#StartsWithI[O[T#PlusWithCarry[N#DivBy2]], I[T#Plus[N#DivBy2]]]
  type PlusWithCarry[N <: Nat] = N#StartsWithI[I[T#PlusWithCarry[N#DivBy2]], O[T#PlusWithCarry[N#DivBy2]]]
  type Mult[N <: Nat] = N#Plus[O[T#Mult[N]]]
  type MatchType[CaseI <: Nat, CaseO <: Nat, CaseS <: Nat] = CaseI
  type Decrease = T#IsZero[S, O[T]]
  type Fib = T#IsZero[I[S], Decrease#Fib#Plus[Decrease#Decrease#Fib]]
  type This = I[T]
}
