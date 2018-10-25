package ru.hse.spb

import org.scalatest.{FlatSpec, Matchers}

class MainTest extends FlatSpec with Matchers {

  "Calculator" should "return -8" in {
    val value = Calculator.run("-5 - 3")
    assert(value.equals(-8L))
  }


  "Calculator" should "return 1" in {
    val value = Calculator.run("10 > 2 && 1")
    assert(value.equals(1L))
  }

  "Calculator" should "return 0" in {
    val value = Calculator.run("10 > 2 && 0")
    assert(value.equals(0L))
  }

  "Calculator" should "return 1 again" in {
    val value = Calculator.run("0 || 1 && (4 > 20 || 10 < 20) ")
    assert(value.equals(1L))
  }

  "Calculator" should "return 66512" in {
    val value = Calculator.run("1000 * 200 - (200232 * 2) / 3")
    assert(value.equals(66512L))
  }

}
