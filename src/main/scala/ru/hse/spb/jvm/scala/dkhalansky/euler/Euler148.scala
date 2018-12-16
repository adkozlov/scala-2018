package ru.hse.spb.jvm.scala.dkhalansky.euler

/* First, observe that a number `n!` is strictly divided by `7^k` where

   k = floor(n/7) + floor(n/7^2) + floor(n/7^3) + ...

   So, in order for C(n, k) not to divide 7, it must be true that

   sum_i floor(n/7^i) = sum_i (floor(k/7^i) + floor((n-k)/7^i))

   Since this function is monotonous in each component of the sum, this
   requirement is equivalent to

   forall i, floor(n/7^i) = floor(k/7^i) + floor((n-k)/7^i)

   Observe that if `r = floor(n/7^i)`, then we have `r+1` ways to split
   whole 7^i's among `n` and `n-k` in such a way that this condition is
   fulfilled.

   Now, this gives us an efficient way of finding the number of elements not
   divisible by 7 in the n'th row: we only have to find the representation of
   `n` base 7 and multiply its digits+1.

   All that's left now is to find the closed form of the sum among rows, which
   is done mechanically.
 */

object Euler148 {

  def z(n: Long, p: Long, a: Long) = n * (n + 1) * p / 2 + (n + 1) * a

  def f(n: Long, p: Long, a: Long): Long =
    if (n < 7) {
      z(n, p, a)
    } else {
      val q = n / 7
      val r = n % 7
      f(q, p * 28, z(r, p, a))
    }

  def ans(n: Long): Long = f(n, 1, 0)
}

object Euler148T {

  import TypeFramework.Bin._

  trait Z[N <: Bin, P <: Bin, A <: Bin] { type Out <: Bin }
  object Z {
    type Aux[N <: Bin, P <: Bin, A <: Bin, R <: Bin] = Z[N, P, A] {
      type Out = R
    }
    implicit def c[N <: Bin,
                   P <: Bin,
                   A <: Bin,
                   N1 <: Bin,
                   NmN1 <: Bin,
                   FP <: Bin,
                   FV <: Bin,
                   M2 <: Bin,
                   X <: Bin](implicit n1: BinSuc.Aux[N, N1],
                             nmn1: BinMult.Aux[N, N1, NmN1],
                             fp: BinMult.Aux[NmN1, P, FP],
                             d2: BinDiv.Aux[FP, __2, FV, E],
                             m2: BinMult.Aux[N1, A, M2],
                             c: BinAdd[M2, FV]): Aux[N, P, A, c.Out] = ???
  }

  implicitly[Z.Aux[__2, __2, __4, __18]]

  trait F[N <: Bin, P <: Bin, A <: Bin] { type Out <: Bin }
  object F {
    type Aux[N <: Bin, P <: Bin, A <: Bin, R <: Bin] = F[N, P, A] {
      type Out = R
    }
    implicit def cL[N <: Bin, P <: Bin, A <: Bin](
        implicit c: BinLt[N, __7],
        q: Z[N, P, A]): Aux[N, P, A, q.Out] = ???
    implicit def cG[N <: Bin,
                    P <: Bin,
                    A <: Bin,
                    Q <: Bin,
                    R <: Bin,
                    V <: Bin,
                    P28 <: Bin](implicit c: BinLe[__7, N],
                                dm: BinDiv.Aux[N, __7, Q, R],
                                p28: BinMult.Aux[P, __28, P28],
                                q: Z.Aux[R, P, A, V],
                                p: F[Q, P28, V]): Aux[N, P, A, p.Out] = ???
  }

  implicitly[F.Aux[__7, __28, __10, __804]]

  trait Ans[N <: Bin] { type Out <: Bin }
  object Ans {
    implicit def c[N <: Bin](
        implicit c: F[N, __1, __0]): Ans[N] { type Out = c.Out } = ???
  }

  implicitly[Ans[__4] { type Out = __10 }]
  implicitly[Ans[__5] { type Out = __15 }]
  implicitly[Ans[__10] { type Out = __40 }] // takes a long time

  /* this computation is so long that the compiler thinks that we're in an
     endless loop. If we perform the calculations separately, they give the
     correct result. */
  // implicitly[Ans[__53] { type Out = __804 }] // diverging implicit expansion

}
