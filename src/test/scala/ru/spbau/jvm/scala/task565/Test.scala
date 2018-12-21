package ru.spbau.jvm.scala.task565

import org.junit
import org.junit.Assert._
import Solution._

class Test {
  def sumOfDivisors(n : Int): Int = {
    var res = 0
    for (i <- 1 to n) {
      if (n % i == 0) {
        res += i
      }
    }
    res
  }

  def solve(n : Int, d : Int) : Int = {
    var res = 0
    for (i <- 1 to n) {
      val sum = sumOfDivisors(i)
      if (sum % d == 0) {
        res += i
      }
    }
    res
  }

  @junit.Test
  def task565() : Unit = {
    assertEquals(solve(20, 7), toInt[Calculate[_20, _7]])
  }

}
