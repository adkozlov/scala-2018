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

object Problem549Type {
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

  def toBoolean[B <: Bool](implicit b: BoolRep[B]): Boolean = b.value

  class BoolRep[B <: Bool](val value: Boolean)
  implicit val falseRep: BoolRep[False] = new BoolRep(false)
  implicit val trueRep: BoolRep[True] = new BoolRep(true)

  implicit val repO = new NatRep[_0](0)
  implicit def repS[T <: Nat](implicit rep: NatRep[T]) = new NatRep[Succ[T]](rep.i + 1)

  def TestProblem(): Unit = {
    assert(Problem549Scala.S(1) == toInt[_1#SFor])
    assert(Problem549Scala.S(2) == toInt[_2#SFor])
    assert(Problem549Scala.S(3) == toInt[_3#SFor])
    assert(Problem549Scala.S(4) == toInt[_4#SFor])
    assert(Problem549Scala.S(5) == toInt[_5#SFor])
    assert(Problem549Scala.S(6) == toInt[_6#SFor])

  }

  def main(args: Array[String]): Unit = {
    TestProblem()
  }
}