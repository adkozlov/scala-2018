package ru.hse.spb.jvm.scala.dkhalansky.euler

/*
Let f(n) = lcm_{i=1}^n i.

If n + k is divisible by k + 1, then n - 1 is also divisible by k + 1. So,
streak(n) = k <=> (f(k) divides n-1, but f(k) doesn't).

P(s, N), hence, is the number of such n, 1 < n < N, that (n-1) is divided by
f(s) but not by f(s+1). So, it is the number of such i = n-1, 0 < i < N-1. Thus,
we can count numbers in range [1; N-2] that are divided by f(s) but not by
f(s-1).

How many multiples of f(s) are there? floor((N-2)/f(s)). How many of of them are
multiples of f(s+1)? floor((N-2)/lcm(s+1, f(s))).

This gives us an efficient method of calculating P(s, N).
 */

object Euler601 {

  def gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)

  def lcm(a: Long, b: Long) = a * b / gcd(a, b)

  def f(n: Long): Long = (1L /: (1L to n))((x, y) => lcm(x, y))

  def p(s: Long, n: Long): Long = (n - 2) / f(s) - (n - 2) / f(s + 1)

  def ans: Long = {
    var ctr = 0L
    var p4 = 1L
    for (i <- 1 to 31) {
      p4 *= 4L
      ctr += p(i, p4)
    }
    ctr
  }
}

object Euler601T {

  import TypeFramework.Bin._

  trait F[A <: Bin] { type Out <: Bin }
  object F {
    type Aux[A <: Bin, B <: Bin] = F[A] { type Out = B }
    implicit def cE: Aux[E, __1] = ???
    implicit def cO[A <: Bin, B <: Bin, C <: Bin](
        implicit p: BinPred.Aux[A, C],
        c: Aux[C, B],
        d: BinLcm[A, B]): Aux[A, d.Out] = ???
  }

  implicitly[F.Aux[__1, __1]]
  implicitly[F.Aux[__2, __2]]
  implicitly[F.Aux[__3, __6]]
  implicitly[F.Aux[__4, __12]]

  trait P[S <: Bin, N <: Bin] { type Out <: Bin }
  object P {
    type Aux[S <: Bin, N <: Bin, R <: Bin] = P[S, N] { type Out = R }
    implicit def c[S <: Bin,
                   N <: Bin,
                   FS <: Bin,
                   NM2 <: Bin,
                   NM2sFS <: Bin,
                   Z <: Bin,
                   SS <: Bin,
                   FSS <: Bin,
                   NM2sFSS <: Bin,
                   Y <: Bin](
        implicit fa: F.Aux[S, FS],
        nm2: BinSub.Aux[N, __2, NM2],
        nm2sfa: BinDiv.Aux[NM2, FS, NM2sFS, Z],
        sf: BinSuc.Aux[S, SS],
        fsf: F.Aux[SS, FSS],
        nm2sfsa: BinDiv.Aux[NM2, FSS, NM2sFSS, Y],
        c: BinSub[NM2sFS, NM2sFSS]
    ): Aux[S, N, c.Out] = ???
  }

  implicitly[P.Aux[__1, __4, __1]]
  implicitly[P.Aux[__2, __16, __5]]
  implicitly[P.Aux[__3, __64, __5]]
  implicitly[P.Aux[__4, __256, __17]]
  implicitly[P.Aux[__5, __1024, __0]] // already takes too long a long time

}
