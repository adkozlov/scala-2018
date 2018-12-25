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

object Problem401Type {
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
    assert(Problem401Scala.sigmaSum(1) == toInt[_1#SigmaSum])
    assert(Problem401Scala.sigmaSum(2) == toInt[_2#SigmaSum])
    assert(Problem401Scala.sigmaSum(3) == toInt[_3#SigmaSum])
    assert(Problem401Scala.sigmaSum(4) == toInt[_4#SigmaSum])
    assert(Problem401Scala.sigmaSum(5) == toInt[_5#SigmaSum])
  }

  def main(args: Array[String]): Unit = {
    TestProblem()
  }
}