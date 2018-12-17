package ru.hse.spb.jvm.scala.dkhalansky.euler

/*
The task is to find such x, y, z that
  x + y = c
  x - y = d
  x + z = e
  x - z = f
  y + z = g
  y - z = h
where c, d, e, f, g, h are perfect squares.

By adding and subtracting the first equation to and from everything else, we
get

  x = (c + d) / 2
  y = (c - d) / 2
  h = c - e
  g = c - f

Then, by adding and subtracting the third equation to and from some of the
others, we also get

  g = e - d
  h = f - d
  z = (e - f) / 2

From this, we can derive that `x + y + z` is `c + (e - f) / 2`, which tells us
that the difference between `e` and `f` must be an even number. We also derive
that

  c - e = f - d = h
  c - f = e - d = g

From here, we arrive to the following form:

  c = e + h
  c = f + g
  d = f - h

Remembering that c, e, f, and d are all perfect squares, we conclude that the
solution can be derived by finding two right triangles with the same hypotenuse
and different catets. It is also imperative that the difference between the
squares of the larger catet of one triangle and the smaller catet of another
triangle is a perfect square, and that the larger catets of the triangles have
the same evenness.

It turns out that these requirements are sufficient. By plugging these
properties into the initial problem, we can verify that any solution of the
described form will do.

So, we need to:
 * Iterate all the Pythagorean triples;
 * Group the triples by the largest component;
 * For each group, try to match every triple with every other triple and see
    if the difference between their second components is even, and that the
    difference between the second component of one of the triples and the third
    component of the other is a perfect square. If so, we've found our answer.
 */

object Euler142 {

  def isSquare(n: Long): Boolean = {
    def helper(l: Long, h: Long): Boolean = {
      val mid = l + (h - l) / 2
      l <= h && (n == mid * mid || (if (n < mid * mid) helper(l, mid - 1)
                                    else helper(mid + 1, h)))
    }
    helper(1, n)
  }

  /* If `x`, `y`, and `z` for the required answer lie in [1; n], output the
     answer. */
  def ans(n: Int): Int = {
    for (a <- 1 to n) {
      val a1 = a * a
      for (pc <- 0 to (a/2)) {
        val c = 2*pc + (a%2)
        if (c != 0) {
          val c1 = c * c
          if (isSquare(a1-c1)) {
            for (pb <- 0 to (c/2)) {
              val b = 2*pb + (a%2)
              if (b != 0) {
                val b1 = b * b
                if (isSquare(c1-b1) && isSquare(a1+b1-c1) && a1+b1 < 2 * c1) {
                  return c1 + (a1-b1)/2
                }
              }
            }
          }
        }
      }
    }
    0
  }
}

object Euler142I {

  import TypeLevelI._
  import Bin._
  import Maybe._
  import Ops._

  type Condition[A1 <: Bin, B1 <: Bin, C1 <: Bin] = A1#add[B1]#suc#le[O[C1]#norm]#and[isSquare[C1#sub[B1]]#and[isSquare[A1#add[B1]#sub[C1]]]]
  type Returns[A1 <: Bin, B1 <: Bin, C1 <: Bin] = Condition[A1, B1, C1]#select[Maybe[Bin], Just[Bin, C1#add[A1#sub[B1]#halve]], Nothing[Bin]]
  type BBody[A1 <: Bin, C1 <: Bin, B <: Bin] = B#isZero#select[Maybe[Bin], Nothing[Bin], Returns[A1, B#mul[B], C1]]
  type BBodyBDef[A1 <: Bin, C <: Bin, C1 <: Bin, PB <: Bin] = BBody[A1, C1, O[PB]#norm#add[C#mod2]]
  type BLoop[A1 <: Bin, C <: Bin, C1 <: Bin] = find[Bin, ({type Z[PB <: Bin] = BBodyBDef[A1, C, C1, PB] })#Z, C#halve]
  type CBodyReturns[A1 <: Bin, C <: Bin, C1 <: Bin] = isSquare[A1#sub[C1]]#select[Maybe[Bin], BLoop[A1, C, C1], Nothing[Bin]]
  type CBody[A1 <: Bin, C <: Bin] = C#isZero#select[Maybe[Bin], Nothing[Bin], CBodyReturns[A1, C, C#mul[C]]]
  type CBodyCDef[A <: Bin, A1 <: Bin, PC <: Bin] = CBody[A1, O[PC]#norm#add[A#mod2]]
  type CLoop[A <: Bin, A1 <: Bin] = find[Bin, ({type Z[PC <: Bin] = CBodyCDef[A, A1, PC] })#Z, A#halve]
  type ABody[A <: Bin] = CLoop[A, A#mul[A]]
  type Ans[N <: Bin] = find[Bin, ABody, N]

}
