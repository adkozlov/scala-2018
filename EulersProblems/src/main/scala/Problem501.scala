import CommonTypes.{Bool, False, True}

object Problem501 {
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
    type GCD[A <: Nat] <: Nat
    type DevidedBy[A <: Nat, B <: Nat] = Eq[A#GCD[B], B]
    type Sigma[A <: Nat] <: Nat
    type Has8Divisor[A <: Nat] = Nat#Eq[Problem501._8, A#Sigma[A]]#If[Succ[_0], _0, Nat]
    type F <: Nat
  }

  sealed trait _0 extends Nat {
    type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = Init
    type MinusOne = _0
    type IsZero = True
    type GCD[A <: Nat] = A
    type Sigma[A <: Nat] = _0
    type F = _0
  }

  sealed trait Succ[N <: Nat] extends Nat {
    type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = F#Apply[Succ[N], N#FoldR[Init, Type, F]]
    type MinusOne = N
    type IsZero = False
    type GCD[A <: Nat] = Nat#Minus[Succ[N], A]#IsZero#If[Nat#Minus[A, Succ[N]]#GCD[Succ[N]], Nat#Minus[Succ[N], A]#GCD[A], Nat]
    type Sigma[A <: Nat] = Nat#DevidedBy[A, Succ[N]]#If[Nat#Add[Succ[_0], N#Sigma[A]], N#Sigma[A], Nat]
    type F = Nat#Add[Has8Divisor[Succ[N]], N#F]
  }

  trait Fold[-Elem, Value] {
    type Apply[N <: Elem, Acc <: Value] <: Value
  }

  object Problem501Scala {
    def sigma(a: Int, b: Int): Int = if (b > 0) if (a % b == 0)  1 + sigma(a, b-1) else sigma(a, b-1) else 0
    def f(n: Int): Int = if (n > 0) if (sigma(n, n) == 8) f(n-1) + 1 else f(n-1) else 0
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
  type _11 = Succ[_10]
  type _12 = Succ[_11]
  type _13 = Succ[_12]
  type _14 = Succ[_13]
  type _15 = Succ[_14]
  type _16 = Succ[_15]
  type _17 = Succ[_16]
  type _18 = Succ[_17]
  type _19 = Succ[_18]
  type _20 = Succ[_19]
  type _21 = Succ[_20]
  type _22 = Succ[_21]
  type _23 = Succ[_22]
  type _24 = Succ[_23]

  class NatRep[T <: Nat](val i: Int)
  def toInt[T <: Nat](implicit rep: NatRep[T]): Int = rep.i
  implicit val repO: NatRep[_0] = new NatRep[_0](0)
  implicit def repS[T <: Nat](implicit rep: NatRep[T]): NatRep[Succ[T]] = new NatRep[Succ[T]](rep.i + 1)
}