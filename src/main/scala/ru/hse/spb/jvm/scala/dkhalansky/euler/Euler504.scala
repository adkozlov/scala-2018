package ru.hse.spb.jvm.scala.dkhalansky.euler
import shapeless.Lazy

/*
This solution is straightforward. First, observe that we can split the solution
space by splitting the figure by the axes. Second, we can count the number of
elements in each triangle that are contained strictly using the formula
  2 * (a * b - gcd(a, b)) + 1
Next, we just iterate through all the boundaries to find the answer.
Now, it could be sped up by memoization of results for triangles, but it's fast
enough as it is in compiled code, and in the type level memoization doesn't
work as well due to lack of random-access structures.
 */

object Euler504 {

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def f(a: Int, b: Int): Int = 2 * (a * b - gcd(a, b)) + 1

  def isSquare(n: Int): Boolean = {
    def helper(l: Int, h: Int): Boolean = {
      val mid = l + (h - l) / 2
      l <= h && (n == mid * mid || (if (n < mid * mid) helper(l, mid - 1)
                                    else helper(mid + 1, h)))
    }
    helper(1, n)
  }

  def ans(n: Int): Int = {
    var ctr = 0
    for (i <- 1 to n) {
      for (j <- 1 to n) {
        for (k <- 1 to n) {
          for (m <- 1 to n) {
            if (isSquare(f(i, j) + f(j, k) + f(k, m) + f(m, i))) {
              ctr += 1
            }
          }
        }
      }
    }
    ctr
  }

}

object Euler504T {

  import TypeFramework.Bin._
  import TypeFramework.Bool._
  import TypeFramework.Funs._
  import TypeFramework.TList._

  trait F[A <: Bin, B <: Bin] { type Out <: Bin }
  object F {
    type Aux[A <: Bin, B <: Bin, R <: Bin] = F[A, B] { type Out = R }
    implicit def c[A <: Bin, B <: Bin, Mul <: Bin, Gcd <: Bin](
        implicit mul: BinMult.Aux[A, B, Mul],
        gcd: BinGcd.Aux[A, B, Gcd],
        dif: BinSub[Mul, Gcd]): F[A, B] { type Out = I[dif.Out] } = ???
  }

  implicitly[F[__3, __3] { type Out = __13 }]
  implicitly[F[__3, __2] { type Out = __11 }]

  trait Condition[I <: Bin, J <: Bin, K <: Bin, M <: Bin] { type Out <: Bin }
  object Condition {
    type Aux[I <: Bin, J <: Bin, K <: Bin, M <: Bin, R <: Bool] = Condition[I, J, K, M] { type Out = Bool }
    implicit def c[I <: Bin, J <: Bin, K <: Bin, M <: Bin, FIJ <: Bin, FJK <: Bin, FKM <: Bin, FMI <: Bin, FIK <: Bin, FIM <: Bin, FII <: Bin, R <: Bool](
        implicit fij: F.Aux[I, J, FIJ],
        fjk: F.Aux[J, K, FJK],
        fkm: F.Aux[K, M, FKM],
        fmi: F.Aux[M, I, FMI],
        fik: BinAdd.Aux[FIJ, FJK, FIK],
        fim: BinAdd.Aux[FIK, FKM, FIM],
        fii: BinAdd.Aux[FIM, FMI, FII],
        out: BinIsSquare[FII]): Aux[I, J, K, M, out.Out] = ???
  }

  trait Fn3[I <: Bin, J <: Bin, K <: Bin] extends Func
  object Fn3 {
    implicit def ct[I <: Bin, J <: Bin, K <: Bin, M <: Bin](
      implicit v: Condition.Aux[I, J, K, M, True]): Apply.Aux[Fn3[I, J, K], M, __1] = ???
    implicit def cf[I <: Bin, J <: Bin, K <: Bin, M <: Bin](
      implicit v: Condition.Aux[I, J, K, M, False]): Apply.Aux[Fn3[I, J, K], M, __0] = ???
  }

  implicitly[Apply.Aux[Fn3[__1, __1, __1], __1, __1]]

  trait Fn2[N <: Bin, I <: Bin, J <: Bin] extends Func
  object Fn2 {
    implicit def c[N <: Bin, I <: Bin, J <: Bin, K <: Bin, L1 <: TList, L2 <: TList, R <: Bin](
       implicit x: BinRange.Aux[N, L1],
       v: ListMap.Aux[Fn3[I, J, K], L1, L2],
       y: ListSum.Aux[L2, R]
    ): Apply.Aux[Fn2[N, I, J], K, R] = ???

    implicitly[BinRange.Aux[__1, Cons[__1, Nil]]]
    implicitly[ListMap.Aux[Fn3[__1, __1, __1], Cons[__1, Nil], Cons[__1, Nil]]]
    implicitly[ListSum.Aux[Cons[__1, Nil], __1]]
    /* this implicit value fails to be found, which is weird since all the
       parameters needed for the corresponding definition are there, as shown
       directly above. */
    // implicitly[Apply.Aux[Fn2[__1, __1, __1], __1, __1]]
  }

  trait Fn1[N <: Bin, I <: Bin] extends Func
  object Fn1 {
    implicit def c[N <: Bin, I <: Bin, J <: Bin, L1 <: TList, L2 <: TList, R <: Bin](
       implicit x: BinRange.Aux[N, L1],
       v: ListMap.Aux[Fn2[N, I, J], L1, L2],
       y: ListSum.Aux[L2, R]
    ): Apply.Aux[Fn1[N, I], J, R] = ???
  }

  trait Fn0[N <: Bin] extends Func
  object Fn0 {
    implicit def c[N <: Bin, I <: Bin, L1 <: TList, L2 <: TList, R <: Bin](
       implicit x: BinRange.Aux[N, L1],
       v: ListMap.Aux[Fn1[N, I], L1, L2],
       y: ListSum.Aux[L2, R]
    ): Apply.Aux[Fn0[N], I, R] = ???
  }

  trait Ans[N <: Bin] { type Out <: Bin }
  object Ans {
    type Aux[N <: Bin, R <: Bin] = Ans[N] { type Out = R }
    implicit def c[N <: Bin, L1 <: TList, L2 <: TList, R <: Bin](
        implicit x: BinRange.Aux[N, L1],
        v: ListMap.Aux[Fn0[N], L1, L2],
        y: ListSum.Aux[L2, R]
    ): Aux[N, R] = ???
  }

  implicitly[Ans.Aux[__0, __0]]

  /* no amount of `Lazy` managed to get rid of fake divergence detections. */
  // implicitly[Ans.Aux[__1, __1]]
  // implicitly[Ans.Aux[__2, __5]]
  // implicitly[Ans.Aux[__3, __13]]

}
