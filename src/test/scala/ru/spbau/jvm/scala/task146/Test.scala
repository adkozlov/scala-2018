package ru.spbau.jvm.scala.task146

import org.junit
import org.junit.Assert._
import org.junit.Test
import Solution._

class Test {
  def solve(n: Int): Int = {
    val max = n * n + 30
    val isPrime = Array.fill(max)(true)
    for (i <- 2 to n * n + 27) {
      if (isPrime(i)) {
        for (j <- 2 * i until max by i) {
          isPrime(j) = false
        }
      }
    }
    var res = 0
    for (i <- 1 to n) {
      val sqr = i * i
      if (isPrime(sqr + 1) && isPrime(sqr + 3) && isPrime(sqr + 9)
        && isPrime(sqr + 13) && !isPrime(sqr + 15) && !isPrime(sqr + 19)
        && !isPrime(sqr + 21) && !isPrime(sqr + 25) && isPrime(sqr + 27)) {
        res += i
      }
    }
    res
  }

  @junit.Test
  def task146(): Unit = {
    //solve(10)
    assertEquals(solve(1), toInt[Calculate[_1]])
    assertEquals(solve(2), toInt[Calculate[_2]])
    assertEquals(solve(3), toInt[Calculate[_3]])
    assertEquals(solve(4), toInt[Calculate[_4]])
    assertEquals(solve(5), toInt[Calculate[_5]])
    assertEquals(solve(6), toInt[Calculate[_6]])
    assertEquals(solve(7), toInt[Calculate[_7]])
    assertEquals(solve(8), toInt[Calculate[_8]])
    assertEquals(solve(9), toInt[Calculate[_9]])
    assertEquals(solve(10), toInt[Calculate[_10]])
    //assertEquals(solve(20), toInt[Calculate[_20]])
  }
}