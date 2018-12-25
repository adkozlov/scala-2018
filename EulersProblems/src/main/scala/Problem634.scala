sealed trait Bool {
  type If[T <: Up, F <: Up, Up] <: Up
  type And[A <: Bool] <: Bool
  type Or[A <: Bool] <: Bool
  type Not <: Bool
}
sealed trait True extends Bool {
  type If[T <: Up, F <: Up, Up] = T
  type And[A <: Bool] = A
  type Or[A <: Bool] = True
  type Not = False
}
sealed trait False extends Bool {
  type If[T <: Up, F <: Up, Up] = F
  type And[A <: Bool] = False
  type Or[A <: Bool] = A
  type Not = True
}

sealed trait Nat {
  type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] <: Type
  type Add[A <: Nat, B <: Nat] = A#FoldR[B, Nat, Inc]
  type Inc = Fold[Nat, Nat] {
    type Apply[N <: Nat, Acc <: Nat] = Succ[Acc]
  }
  type Minus[A <: Nat, B <: Nat] = B#FoldR[A, Nat, Dec]
  type Dec = Fold[Nat, Nat] {
    type Apply[N <: Nat, Acc <: Nat] = Acc#MinusOne
  }

  type Mult[A <: Nat, B <: Nat] = A#FoldR[_0, Nat, Sum[B]]
  type Sum[By <: Nat] = Fold[Nat, Nat] {
    type Apply[N <: Nat, Acc <: Nat] = Add[By, Acc]
  }

  type MinusOne <: Nat
  type Eq[A <: Nat, B <: Nat] = Nat#Minus[A, B]#IsZero#And[Nat#Minus[B, A]#IsZero]
  type IsZero <: Bool
  type Square[A <: Nat] = Nat#Mult[A, A]
  type Quadr[A <: Nat] = Nat#Mult[Nat#Mult[A, A], A]
  type PresentAs[A <: Nat, B <: Nat, C <: Nat] = Nat#Eq[C, Nat#Mult[Square[A], Nat#Quadr[B]]]#If[Succ[_0], _0, Nat]
  type constA[B <: Nat, C <: Nat] <: Nat
  type minusA[B <: Nat, C <: Nat] <: Nat
  type solve[A <: Nat] = A#minusA[A, A]
}

sealed trait _0 extends Nat {
  type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = Init
  type MinusOne = _0
  type IsZero = True
  type constA[B <: Nat, C <: Nat] = _0
  type minusA[B <: Nat, C <: Nat] = _0
}

sealed trait Succ[N <: Nat] extends Nat {
  type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = F#Apply[Succ[N], N#FoldR[Init, Type, F]]
  type MinusOne = N
  type IsZero = False
  type constA[A <: Nat, C <: Nat] = Nat#Eq[Succ[_0], N]#If[_0, Nat#Add[Nat#PresentAs[Succ[A], Succ[N], Succ[C]], N#constA[Succ[A], Succ[C]]], Nat]
  type minusA[B <: Nat, C <: Nat] = Nat#Eq[Succ[_0], N]#If[_0, Nat#Add[Succ[B]#constA[Succ[N], Succ[C]], N#minusA[B, C]], Nat]
}

trait Fold[-Elem, Value] {
  type Apply[N <: Elem, Acc <: Value] <: Value
}

object Problem634Scala {
  def presentAs(a: Int, b: Int, c: Int): Int = if (c == a * a * b * b * b) 1 else 0

  def constA(a: Int, b: Int, c: Int): Int = {
    if (b > 1) {
      presentAs(a, b, c) + constA(a, b - 1 ,c )
    } else {
      0
    }
  }
  def minusA(a: Int, b: Int, c: Int): Int =  {
    if (a > 1) {
      constA(a, b, c) + constA(a - 1, b ,c )
    } else {
      0
    }
  }

  def solve(a: Int) = constA(a, a, a)
}

object Problem643Type {
  type _1 = Succ[_0]
  type _2 = Succ[_1]
  type _3 = Succ[_2]
  type _4 = Succ[_3]

  class NatRep[T <: Nat](val i: Int)
  def toInt[T <: Nat](implicit rep: NatRep[T]) = rep.i

  def toBoolean[B <: Bool](implicit b: BoolRep[B]): Boolean = b.value

  class BoolRep[B <: Bool](val value: Boolean)
  implicit val falseRep: BoolRep[False] = new BoolRep(false)
  implicit val trueRep: BoolRep[True] = new BoolRep(true)

  implicit val repO = new NatRep[_0](0)
  implicit def repS[T <: Nat](implicit rep: NatRep[T]) = new NatRep[Succ[T]](rep.i + 1)

  def TestProblem(): Unit = {
    assert(Problem634Scala.solve(1) == toInt[Nat#solve[_1]])
    assert(Problem634Scala.solve(2) == toInt[Nat#solve[_2]])
    assert(Problem634Scala.solve(3) == toInt[Nat#solve[_3]])
    assert(Problem634Scala.solve(4) == toInt[Nat#solve[_4]])
  }

  def main(args: Array[String]): Unit = {
    TestProblem()
  }
}