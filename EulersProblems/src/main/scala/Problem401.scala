import CommonTypes.{Bool, False, True}

object Problem401 {
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
    type Square[A <: Nat] = Nat#Mult[A, A]
    type sigma2[M <: Nat] <: Nat
    type SigmaSum <: Nat
  }

  sealed trait _0 extends Nat {
    type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = Init
    type MinusOne = _0
    type IsZero = True
    type GCD[A <: Nat] = A
    type sigma2[M <: Nat] = _0
    type SigmaSum = _0
  }

  sealed trait Succ[N <: Nat] extends Nat {
    type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = F#Apply[Succ[N], N#FoldR[Init, Type, F]]
    type MinusOne = N
    type IsZero = False
    type GCD[A <: Nat] = Nat#Minus[Succ[N], A]#IsZero#If[Nat#Minus[A, Succ[N]]#GCD[Succ[N]], Nat#Minus[Succ[N], A]#GCD[A], Nat]
    type sigma2[M <: Nat] = Add[DevidedBy[M, Succ[N]]#Not#If[_0, Square[Succ[N]], Nat], N#sigma2[M]]
    type SigmaSum = Add[Succ[N]#sigma2[Succ[N]], N#SigmaSum]
  }

  trait Fold[-Elem, Value] {
    type Apply[N <: Elem, Acc <: Value] <: Value
  }

  object Problem401Scala {
    def sigma2(a: Int): Int = {
      var sum = 0
      for (i <- 1 to a)
        if (a % i == 0)
          sum += i*i
      sum
    }

    def sigmaSum(b: Int): Int = {
      var sum = 0
      for (i <- 1 to b)
        sum += sigma2(i)
      sum
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