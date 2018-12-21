package ru.spbau.jvm.scala.task216


import scala.language.higherKinds

/*
Consider numbers t(n) of the form t(n) = 2n2-1 with n > 1.
The first such numbers are 7, 17, 31, 49, 71, 97, 127 and 161.
It turns out that only 49 = 7*7 and 161 = 7*23 are not prime.
For n ≤ 10000 there are 2202 numbers t(n) that are prime.

How many numbers t(n) are prime for n ≤ 50,000,000 ?
*/
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
  type Plus[B <: Nat] <: Nat
  type IsZero[VO <: Up, VS <: Up, Up] <: Up
  type MinusOne <: Nat
  type Mult[C <: Nat] <: Nat
  type IsDivisibleBy[D <: Nat] <: Bool
  type Minus[E <: Nat] <: Nat
  type IsPrimeWithDivisor[Dividend <: Nat] <: Bool
  type Count[ValToCheck <: Nat, CurCnt <: Nat] <: Nat
  type Square <: Nat
}

class O extends Nat {
  type Plus[B <: Nat] = B
  type IsZero[VO <: Up, VS <: Up, Up] = VO
  type MinusOne = O
  type Mult[_ <: Nat] = O
  type IsDivisibleBy[D <: Nat] = True
  type Minus[E <: Nat] = E#IsZero[O, Neg, Nat]
  type Count[_ <: Nat, CurCnt <: Nat] = CurCnt
  type Square = O
}

class Neg extends Nat {
  type Plus[B <: Nat] = Neg
  type IsZero[VO <: Up, VS <: Up, Up] = VS
  type MinusOne = Neg
  type Mult[_ <: Nat] = Neg
  type IsDivisibleBy[D <: Nat] = False
  type Minus[_ <: Nat] = Neg
}

class S[T <: Nat] extends Nat {
  type Plus[B <: Nat] = S[T#Plus[B]]
  type IsZero[VO <: Up, VS <: Up, Up] = VS
  type MinusOne = T
  type Minus[E <: Nat] = E#IsZero[S[T], T#Minus[E#MinusOne], Nat]
  type Mult[C <: Nat] = T#Mult[C]#Plus[C]
  type IsDivisibleBy[D <: Nat] = T#Minus[D#MinusOne]#IsDivisibleBy[D]
  type IsPrimeWithDivisor[Dividend <: Nat] = MinusOne#IsZero[True,
    Dividend#IsDivisibleBy[S[T]]#Match[False, T#IsPrimeWithDivisor[Dividend], Bool], Bool]
  import Solution._
  type Count[ValToCheck <: Nat, CurCnt <: Nat] = T#Count[ValToCheck#Minus[S[S[T#Mult[_4]]]],    //2 (n - 1 + 1) ^ 2 - 1 = 2(n - 1)^ + 4(n - 1) + 2 - 1
    Mult[_2]#IsPrimeWithDivisor[ValToCheck]#Match[S[CurCnt], CurCnt, Nat]]
  type Square = Mult[S[T]]
}

object Solution {
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

  type Calculate[Start <: Nat] = Start#Count[Start#Square#Mult[_2]#MinusOne, O]
  class NatRep[T <: Nat](val i: Int)

  implicit val repO = new NatRep[O](0)

  implicit def repS[T <: Nat](implicit rep: NatRep[T]) = new NatRep[S[T]](rep.i + 1)

  def toInt[T <: Nat](implicit rep: NatRep[T]) = rep.i

  class BoolRep[T <: Bool](val b: Boolean)
  implicit val repTrue = new BoolRep[True](true)

  implicit val repFalse = new BoolRep[False](false)
  def toBool[T <: Bool](implicit rep: BoolRep[T]) = rep.b


  def main(args: Array[String]): Unit = {
    //println(toBool[Checker._10#Square#Plus[Checker._5#Mult[Checker._3]]#IsDivisibleBy[Checker._5]])
    println(toInt[Calculate[_2]])
  }
}
