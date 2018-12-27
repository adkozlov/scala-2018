import CommonTypes.{Bool, False, True}

object Problem549 {

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
    type Fact <: Nat
    type s[N <: Nat] <: Nat
    type SFor <: Nat
  }

  sealed trait _0 extends Nat {
    type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = Init
    type MinusOne = _0
    type IsZero = True
    type GCD[A <: Nat] = A
    type Fact = Succ[_0]
    type s[N <: Nat] = _0
    type SFor = _0
  }

  sealed trait Succ[N <: Nat] extends Nat {
    type FoldR[Init <: Type, Type, F <: Fold[Nat, Type]] = F#Apply[Succ[N], N#FoldR[Init, Type, F]]
    type MinusOne = N
    type IsZero = False
    type GCD[A <: Nat] = Nat#Minus[Succ[N], A]#IsZero#If[Nat#Minus[A, Succ[N]]#GCD[Succ[N]], Nat#Minus[Succ[N], A]#GCD[A], Nat]
    type Fact = Nat#Mult[Succ[N], N#Fact]
    type s[M <: Nat] = Nat#Eq[Succ[N], Succ[_0]]#If[_0, N#s[M]#IsZero#Not#If[N#s[M],
      Nat#DevidedBy[Succ[N]#Fact, M]#If[Succ[N], _0, Nat], Nat], Nat]
    type SFor = Nat#Add[Succ[N]#s[Succ[N]], N#SFor]
  }

  trait Fold[-Elem, Value] {
    type Apply[N <: Elem, Acc <: Value] <: Value
  }

  object Problem549Scala {
    def gcd(a: Int, b: Int): Int = {
      if (a == b) a
      else if (a > b) gcd(a-b, b) else gcd(a, b-a)
    }

    def divided(a: Int, b: Int): Boolean = {
      gcd(a, b) == b
    }

    def fact(a: Int): Int = {
      if (a == 1) 1 else a*fact(a-1)
    }

    def s(m: Int, n: Int): Int = {
      if (n == 1) {
        0
      }
      else {
        if (s(m, n - 1) != 0) s(m, n - 1)
        else if (divided(fact(n), m)) n
        else 0
      }
    }

    def S(n: Int): Int = if (n > 0) s(n,n) + S(n-1) else 0
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