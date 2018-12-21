package ru.spbau.jvm.scala.task565

import scala.language.higherKinds

sealed trait Bool {
  type Match[IfTrue <: Up, IfFalse <: Up, Up] <: Up
}

class True extends Bool {
  type Match[IfTrue <: Up, IfFalse <: Up, Up] = IfTrue
}

class False extends Bool {
  type Match[IfTrue <: Up, IfFalse <: Up, Up] = IfFalse
}

sealed trait Nat {
  type MinusOne <: Nat
  type Minus[Other <: Nat] <: Nat
  type Plus[Other <: Nat] <: Nat
  type Mult[Other <: Nat] <: Nat
  type IsZero[True <: Up, False <: Up, Up] <: Up
  type IsDivisibleBy[Other <: Nat] <: Bool
  type SumOfDivisors[Dividend <: Nat, CurSum <: Nat] <: Nat
  type SumOfAllGood[CurSum <: Nat, Divisor <: Nat] <: Nat
}

class O extends Nat {
  override type MinusOne = Neg
  override type Plus[Other <: Nat] = Other
  override type Minus[Other <: Nat] = Other#IsZero[O, Neg, Nat]
  override type IsZero[True <: Up, False <: Up, Up] = True
  override type SumOfDivisors[Dividend <: Nat, CurSum <: Nat] = CurSum
  override type IsDivisibleBy[_] = True
  override type Mult[_] = O
  override type SumOfAllGood[CurSum <: Nat, _ <: Nat] = CurSum
}

/**
  * After zero goes -inf
  */
class Neg extends Nat {
  override type MinusOne = Neg
  override type Minus[Other <: Nat] = Neg
  override type IsZero[True <: Up, False <: Up, Up] = False
  override type IsDivisibleBy[_] = False
}

class S[T <: Nat] extends Nat {
  import Solution._
  override type MinusOne = T
  override type Minus[Other <: Nat] = Other#IsZero[this.type, T#Minus[Other#MinusOne], Nat]
  override type Plus[B <: Nat] = S[T#Plus[B]]
  override type Mult[C <: Nat] = T#Mult[C]#Plus[C]
  override type IsDivisibleBy[D <: Nat] = T#Minus[D#MinusOne]#IsDivisibleBy[D]
  override type SumOfDivisors[Dividend <: Nat, CurSum <: Nat] = T#SumOfDivisors[Dividend, Dividend#IsDivisibleBy[S[T]]#Match[CurSum#Plus[S[T]], CurSum, Nat]]
  override type IsZero[True <: Up, False <: Up, Up] = False
  override type SumOfAllGood[CurSum <: Nat, Divisor <: Nat] = T#SumOfAllGood[SumOfDivisors[S[T], O]#IsDivisibleBy[Divisor]#Match[CurSum#Plus[S[T]], CurSum, Nat], Divisor]
}



object Solution {
  class NatRep[T <: Nat](val i: Int)

  implicit val repNeg = new NatRep[Neg](-1)
  implicit val repO = new NatRep[O](0)

  implicit def repS[T <: Nat](implicit rep: NatRep[T]) = new NatRep[S[T]](rep.i + 1)

  def toInt[T <: Nat](implicit rep: NatRep[T]) = rep.i

  class BoolRep[T <: Bool](val b: Boolean)
  implicit val repTrue = new BoolRep[True](true)

  implicit val repFalse = new BoolRep[False](false)
  def toBool[T <: Bool](implicit rep: BoolRep[T]) = rep.b

  type Calculate[Start <: Nat, Divisor <: Nat] = Start#SumOfAllGood[O, Divisor]

  type _1 = S[O]
  type _2 = S[_1]
  type _3 = S[_2]
  type _4 = S[_3]
  type _5 = S[_4]
  type _6 = S[_5]
  type _7 = S[_6]
  type _8 = S[_7]
  type _9 = S[_8]
  type _10 = S[_9]
  type _11 = S[_10]
  type _12 = S[_11]
  type _13 = S[_12]
  type _14 = S[_13]
  type _15 = S[_14]
  type _16 = S[_15]
  type _17 = S[_16]
  type _18 = S[_17]
  type _19 = S[_18]
  type _20 = S[_19]
  type _21 = S[_20]
  type _22 = S[_21]
  type _23 = S[_22]
  type _24 = S[_23]
  type _25 = S[_24]
  type _26 = S[_25]
  type _27 = S[_26]
  type _28 = S[_27]


  def main(args: Array[String]): Unit = {

    println(toInt[Calculate[_20, _7]])
  }
}

