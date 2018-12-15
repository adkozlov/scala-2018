package ru.spbau.jvm.scala.task169

import scala.language.higherKinds
/*
Define f(0)=1 and f(n) to be the number of different ways n can be expressed as a sum of integer powers of 2 using each power no more than twice.

For example, f(10)=5 since there are five different ways to express 10:

1 + 1 + 8
1 + 1 + 4 + 4
1 + 1 + 2 + 2 + 4
2 + 4 + 4
2 + 8

What is f(10^25)?
 */

/*
 Решение: у нас есть три случая:
 1) В представлении ровно одна единица -- только для нечётных
 2) В представлении нет единиц -- только для чётных
 3) В представлении две единицы -- только для чётных
 */
sealed trait Nat {
  type Plus[B <: Nat] <: Nat
  type IsZero[VO <: Up, VS <: Up, Up] <: Up
  type MinusOne <: Nat
  type Flip <: Nat
  type DivBy2 <: Pair
  type Mult[C <: Nat] <: Nat
  // Base ^ this
  type Deg[Base <: Nat] <: Nat
  type F <: Nat
  type F0 <: Nat // no 1, all numbers are 2 or greater
  type F1 <: Nat // one 1
  type F11 <: Nat // two 1
}

sealed trait Pair {
  type First <: Nat
  type Second <: Nat
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
  type Deg[_ <: Nat] = S[O]
  type F = S[O]
  type F0 = S[O]
  type F1 = O
  type F11 = O
}

class S[T <: Nat] extends Nat {
  type Plus[B <: Nat] = S[T#Plus[B]]
  type IsZero[VO <: Up, VS <: Up, Up] = VS
  type MinusOne = T
  type Minus[O] = S[T]
  type Flip = O
  type DivBy2 = ParametrizedPair[T#DivBy2#First#Plus[T#DivBy2#Second], T#DivBy2#Second#Flip]
  type Mult[C <: Nat] = T#Mult[C]#Plus[C]
  type Deg[Base <: Nat] = T#Deg[Base]#Mult[Base]
  type F = F0#Plus[F1#Plus[F11]]
  type F0 = DivBy2#Second#IsZero[DivBy2#First#F, O, Nat]
  type F1 = T#F0
  type F11 = T#F1
}

object Solution {
  type _1 = S[O]
  type _2 = S[_1]
  type _3 = S[_2]
  type _4 = S[_3]
  type _5 = S[_4]
  type _10 = _5#Mult[_2]
  type _25 = _5#Mult[_5]
  type _100 = _10#Mult[_10]

  class NatRep[T <: Nat](val i: Int)
  implicit val repO = new NatRep[O](0)
  implicit def repS[T <: Nat](implicit rep: NatRep[T]) = new NatRep[S[T]](rep.i + 1)

  def toInt[T <: Nat](implicit rep: NatRep[T]) = rep.i

  def solve(i : Int): Int = {
    if (i == 0) {
      return 1
    }
    if (i % 2 == 1) {
      return solve(i / 2)
    }
    solve(i / 2) + solve(i / 2 - 1)
  }

  def main(args: Array[String]): Unit = {
    assert(toInt[_1#F] == solve(1))
    assert(toInt[_2#F] == solve(2))
    assert(toInt[_3#F] == solve(3))
    assert(toInt[_4#F] == solve(4))
    assert(toInt[_10#F] == solve(10))
    assert(toInt[_10#F] == 5)
    assert(toInt[_25#F] == solve(25))
    assert(toInt[_100#F] == solve(100))
  }
}
