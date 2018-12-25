object Problem625Scala {
  sealed trait Bool {
  type If[T <: Up, F <: Up, Up] <: Up
  type And[A <: Bool] <: Bool
  type Or[A <: Bool] <: Bool
}
sealed trait True extends Bool {
  type If[T <: Up, F <: Up, Up] = T
  type And[A <: Bool] = A
  type Or[A <: Bool] = True
}
sealed trait False extends Bool {
  type If[T <: Up, F <: Up, Up] = F
  type And[A <: Bool] = False
  type Or[A <: Bool] = A
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

  type MinusOne <: Nat
  type Eq[A <: Nat, B <: Nat] = Nat#Minus[A, B]#IsZero#And[Nat#Minus[B, A]#IsZero]
  type IsZero <: Bool
  type GCD[A <: Nat] <: Nat
  type ForGCD[I <: Nat] <: Nat
  type ProblemSolve <: Nat
}

sealed trait _0 extends Nat {
  type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = Init
  type MinusOne = _0
  type IsZero = True
  type GCD[A <: Nat] = A
  type ForGCD[I <: Nat] = _0
  type ProblemSolve = _0
}

sealed trait Succ[N <: Nat] extends Nat {
  type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = F#Apply[Succ[N], N#FoldR[Init, Type, F]]
  type MinusOne = N
  type IsZero = False
  type GCD[A <: Nat] = Nat#Minus[Succ[N], A]#IsZero#If[Nat#Minus[A, Succ[N]]#GCD[Succ[N]], Nat#Minus[Succ[N], A]#GCD[A], Nat]
  type ForGCD[I <: Nat] = Nat#Add[Succ[N]#GCD[I], N#ForGCD[I]]
  type ProblemSolve = Nat#Add[Succ[N]#ForGCD[Succ[N]], N#ProblemSolve]
}

trait Fold[-Elem, Value] {
  type Apply[N <: Elem, Acc <: Value] <: Value
}
 def gcd(a: Int, b: Int): Int = {
    if (a == b) a
    else if (a > b) gcd(a-b, b) else gcd(a, b-a)
  }

  def ans(N: Int) : Int = {
    var ans: Int = 0
    for (j <- 1 to N)
      for (i <- 1 to j)
        ans += gcd(j, i)
    ans
  }

  type _1 = Succ[_0]
  type _2 = Succ[_1]
  type _3 = Succ[_2]
  type _4 = Succ[_3]
  type _5 = Succ[_4]
  type _6 = Succ[_5]
  type _7 = Succ[_6]
  type _8 = Succ[_7]
  type _9 = Succ[_8]
  type _10 = Succ[_9]


  class NatRep[T <: Nat](val i: Int)
  def toInt[T <: Nat](implicit rep: NatRep[T]) = rep.i

  implicit val repO = new NatRep[_0](0)
  implicit def repS[T <: Nat](implicit rep: NatRep[T]) = new NatRep[Succ[T]](rep.i + 1)

  def TestProblem(): Unit = {
    assert(Problem625Scala.ans(1) == toInt[_1#ProblemSolve])
    assert(Problem625Scala.ans(2) == toInt[_2#ProblemSolve])
    assert(Problem625Scala.ans(3) == toInt[_3#ProblemSolve])
    assert(Problem625Scala.ans(4) == toInt[_4#ProblemSolve])
    assert(Problem625Scala.ans(5) == toInt[_5#ProblemSolve])
    assert(Problem625Scala.ans(6) == toInt[_6#ProblemSolve])
    assert(Problem625Scala.ans(7) == toInt[_7#ProblemSolve])
    assert(Problem625Scala.ans(8) == toInt[_8#ProblemSolve])
    assert(Problem625Scala.ans(9) == toInt[_9#ProblemSolve])
    assert(Problem625Scala.ans(10) == toInt[_10#ProblemSolve])
  }

  def main(args: Array[String]): Unit = {
    TestProblem()
  }
}