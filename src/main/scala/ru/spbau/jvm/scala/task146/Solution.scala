package ru.spbau.jvm.scala.task146


import scala.language.higherKinds

sealed trait Bool {
  type Match[IfTrue <: Up, IfFalse <: Up, Up] <: Up
  type Not <: Bool
  type And[Other <: Bool] <: Bool
}

class True extends Bool {
  type Match[IfTrue <: Up, IfFalse <: Up, Up] = IfTrue
  type Not = False
  type And[Other <: Bool] = Other
}

class False extends Bool {
  type Match[IfTrue <: Up, IfFalse <: Up, Up] = IfFalse
  type Not = True
  type And[Other <: Bool] = False
}


sealed trait Nat {
  type Plus[B <: Nat] <: Nat
  type IsZero[VO <: Up, VS <: Up, Up] <: Up
  type MinusOne <: Nat
  type Flip <: Nat
  type DivBy2 <: Pair
  type Mult[C <: Nat] <: Nat
  type IsNeg[VO <: Up, VS <: Up, Up] <: Up
  type IsDivisibleBy[D <: Nat] <: Bool
  type Minus[E <: Nat] <: Nat
  type IsPrimeWithDivisor[Dividend <: Nat] <: Bool
  type Sum[Square <: Nat, CurSum <: Nat] <: Nat
  type IsEven <: Bool
  type Square <: Nat
}

sealed trait Pair {
  type First <: Nat
  type Second <: Nat
}

object Checker {
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

  type Check[Q <: Nat, N <: Nat] = N#IsPrimeWithDivisor[Q#Plus[_1]]#And[
    N#IsPrimeWithDivisor[Q#Plus[_3]]#And[
      N#IsPrimeWithDivisor[Q#Plus[_7]]#And[
        N#IsPrimeWithDivisor[Q#Plus[_9]]#And[
          N#IsPrimeWithDivisor[Q#Plus[_13]]#And[
            N#IsPrimeWithDivisor[Q#Plus[_15]]#Not#And[
             N#IsPrimeWithDivisor[Q#Plus[_19]]#Not#And[
              N#IsPrimeWithDivisor[Q#Plus[_21]]#Not#And[
                N#IsPrimeWithDivisor[Q#Plus[_25]]#Not#And[
                  N#IsPrimeWithDivisor[Q#Plus[_27]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ]

  type Calculate[Start <: Nat] = Start#IsEven#Match[Start#Sum[Start#Square, O],
    Start#MinusOne#Sum[Start#MinusOne#Square, O], Nat]
}

class ParametrizedPair[A <: Nat, B <: Nat] extends Pair {
  type First = A
  type Second = B
}

class O extends Nat {
  type Plus[B <: Nat] = B
  type IsZero[VO <: Up, VS <: Up, Up] = VO
  type MinusOne = O
  type DivBy2 = ParametrizedPair[O, O]
  type Flip = S[O]
  type Mult[_ <: Nat] = O
  type IsNeg[VO <: Up, VS <: Up, Up] = VS
  type IsDivisibleBy[D <: Nat] = True
  type Minus[E <: Nat] = E#IsZero[O, Neg, Nat]
  type IsPrimeWithDivisor[_ <: Nat] = False
  type Sum[Square <: Nat, CurSum <: Nat] = CurSum
  type IsEven = True
  type Square = O
}

class Neg extends Nat {
  type Plus[B <: Nat] = Neg
  type IsZero[VO <: Up, VS <: Up, Up] = VS
  type MinusOne = Neg
  type DivBy2 = ParametrizedPair[Neg, Neg]
  type Flip = Neg
  type Mult[_ <: Nat] = Neg
  type IsNeg[VO <: Up, VS <: Up, Up] = VO
  type IsDivisibleBy[D <: Nat] = False
  type Minus[_ <: Nat] = Neg
  type IsPrimeWithDivisor[_ <: Nat] = False
  type IsEven = False
  //type Square = Neg
}

class S[T <: Nat] extends Nat {
  type Plus[B <: Nat] = S[T#Plus[B]]
  type IsZero[VO <: Up, VS <: Up, Up] = VS
  type MinusOne = T
  type Minus[E <: Nat] = E#IsZero[S[T], T#Minus[E#MinusOne], Nat]
  type Flip = O
  type DivBy2 = ParametrizedPair[T#DivBy2#First#Plus[T#DivBy2#Second], T#DivBy2#Second#Flip]
  type Mult[C <: Nat] = T#Mult[C]#Plus[C]
  type IsDivisibleBy[D <: Nat] = T#Minus[D#MinusOne]#IsDivisibleBy[D]
  type IsNeg[VO <: Up, VS <: Up, Up] = VS
  type IsPrimeWithDivisor[Dividend <: Nat] = MinusOne#IsZero[True,
    Dividend#IsDivisibleBy[S[T]]#Match[False, T#IsPrimeWithDivisor[Dividend], Bool], Bool]
  type IsEven = T#IsEven#Not
  type Sum[Square <: Nat, CurSum <: Nat] = IsEven#Match[
    Checker.Check[Square, Plus[Checker._6]]#Match[
      T#Sum[
        Square#Plus[Checker._4]#Minus[Mult[Checker._4]], //(x - 2)^2 = x^2 - 4x + 4
        Plus[CurSum]
        ],
      T#Sum[
        Square#Plus[Checker._4]#Minus[Mult[Checker._4]],
        CurSum],
      Nat], T#Sum[Square, CurSum], Nat]
  type Square = Mult[S[T]]
}


trait NatFold[Up] {
  type VO <: Up
  type VS[_ <: Nat] <: Up
}

/*n2+1,
 n2+3,
 n^2+5 делится на 3
 n2+7,
 n2+9,
 n^2+11 делится на 3
 n2+13,
 n^2+15 -- не простое
 n^2+17 -- делится на 3
 n^2+19 -- не простое
 n^2+21, -- не простое
 n^2+23, делится на 3
 n^2+25 -- не простое
 n2+27,
  */

object Main {

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
    println(toInt[Checker.Calculate[Checker._15]])
  }
}
