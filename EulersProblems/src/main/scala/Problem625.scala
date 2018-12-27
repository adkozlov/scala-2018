import CommonTypes.{Bool, False, True}

object Problem625 {

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
  object Problem625Scala {
    def gcd(a: Int, b: Int): Int = {
      if (a == b) a
      else if (a > b) gcd(a - b, b) else gcd(a, b - a)
    }

    def ans(N: Int): Int = {
      var ans: Int = 0
      for (j <- 1 to N)
        for (i <- 1 to j)
          ans += gcd(j, i)
      ans
    }
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
  def toInt[T <: Nat](implicit rep: NatRep[T]): Int = rep.i
  implicit val repO: NatRep[_0] = new NatRep[_0](0)
  implicit def repS[T <: Nat](implicit rep: NatRep[T]): NatRep[Succ[T]] = new NatRep[Succ[T]](rep.i + 1)
}