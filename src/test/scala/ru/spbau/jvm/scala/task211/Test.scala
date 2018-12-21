package ru.spbau.jvm.scala.task211

import org.junit
import org.junit.Assert._
import Solution._

import scala.math.{round, sqrt}

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

  def solve(n : Int) : Int = {
    var res = 0
    for (i <- 1 to n) {
      val sum = sumOfDivisors(i)
      val sumSqrt = round(sqrt(sum))
      if (sumSqrt * sumSqrt == sum) {
        res += i
      }
    }
    res
  }

  @junit.Test
  def task211() : Unit = {
    assertEquals(solve(1), toInt[Calculate[_1]])
    assertEquals(solve(2), toInt[Calculate[_2]])
    assertEquals(solve(3), toInt[Calculate[_3]])
    assertEquals(solve(9), toInt[Calculate[_9]])
  }


}
