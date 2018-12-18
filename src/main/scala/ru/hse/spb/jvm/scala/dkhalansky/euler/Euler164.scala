package ru.hse.spb.jvm.scala.dkhalansky.euler
import scala.collection.immutable.IndexedSeq

/* This is a simple task on dynamics with profile. First, we calculate
   how rows are matched one to another. Then, keeping a list of current
   matches, we update it iteratively.
 */
object Euler164 {

  def mask(): IndexedSeq[IndexedSeq[Boolean]] = {
    for (x <- 0 to 9; m <- 0 to 9)
      yield
        for (r <- 0 to 9; y <- 0 to 9)
          yield r == m && x + m + y <= 9
  }

  def step(old: IndexedSeq[Long],
           mask: IndexedSeq[IndexedSeq[Boolean]]): IndexedSeq[Long] = {
    for (x <- 0 to 99)
      yield (0 to 99).filter(mask(x)(_)).foldLeft(0L)(_ + old(_))
  }

  def withZeros(n: Int, mask: IndexedSeq[IndexedSeq[Boolean]]): Long = {
    (1 to n)
      .foldLeft((0 to 99).map(_ => 1L))((ac, _) => step(ac, mask))
      .foldLeft(0L)(_ + _)
  }

  def ans(n: Int): Long = {
    val m = mask()
    withZeros(n - 2, m) - withZeros(n - 3, m)
  }

}

object Euler164I {

  import TypeLevelI._
  import Bin._
  import Bin.Ops._
  import TList._
  import TList.Ops._
  import Bool._
  import Maybe._

  type _0to9 = range[_9]

  type _99 = _9#mul[_10#suc]

  type _0to99 = range[_99]

  type mask = concat[TList[Bool], _0to9#map[TList[TList[Bool]],
      ({type Z[X <: Bin] = _0to9#map[TList[Bool],
          ({type Z1[M <: Bin] = concat[Bool, _0to9#map[TList[Bool],
              ({type Z2[R <: Bin] = _0to9#map[Bool,
                  ({type Z3[Y <: Bin] =
                      eq[M, R]#and[X#add[M]#add[Y]#le[_9]]})#Z3
              ]})#Z2
          ]]})#Z1]})#Z]]

/*
  // Stack overflow after 10 minutes
  implicitly[mask#head =:= Just[TList[Bool],
      replicate[Bool, _10, T]#append[replicate[Bool, _10#mul[_9], F]]]]
*/

  type step[O <: TList[Bin]] = mask#zip[Bin, O]#
    map[TList[Bin],
    ({type Z[X <: Pair[TList[Bool], Bin]] =
        X#fst#map[Bin, ({type Z1[A <: Bool] = A#select[Bin, X#snd, _0] })#Z1]
    })#Z]#
    foldr[TList[Bin],
        ({type Z[X <: TList[Bin], P <: TList[Bin]] =
            X#zip[Bin, P]#map[Bin,
                ({type Z1[A <: Pair[Bin, Bin]] = A#fst#add[A#snd]})#Z1]})#Z,
        replicate[Bin, _99#suc, _0]]

  type withZeros[N <: Bin] = sum[replicate[Bin, N#pred, _0]#foldr[TList[Bin],
    ({type Z[_ <: Bin, A <: TList[Bin]] = step[A]})#Z,
    replicate[Bin, _99#suc, _1]]]

  implicitly[withZeros[_0] =:= _99#suc]

  type ans[N <: Bin] = withZeros[N#pred]#sub[withZeros[N#pred#pred]]

}
