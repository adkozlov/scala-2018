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

object Euler164I {}
