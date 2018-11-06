package ru.hse.spb

import org.scalatest.{FlatSpec, Matchers}

class MainTest extends FlatSpec with Matchers {

  "Calculator" should "return -8" in {
    val parser = Calculator.parser("-5 - 3")
    val value = Calculator.evaluator(parser)
    assert(value == -8)
  }

  "Calculator" should "return 0 from -0" in {
    val parser = Calculator.parser("(-0)")
    val value = Calculator.evaluator(parser)
    assert(value == 0)
  }


  "Calculator" should "return 1" in {
    val parser = Calculator.parser("10 > 2 && 1")
    val value = Calculator.evaluator(parser)
    assert(value == 1)
  }

  "Calculator" should "return 0" in {
    val parser = Calculator.parser("10 > 2 && 0")
    val value = Calculator.evaluator(parser)
    assert(value == 0)
  }

  "Calculator" should "return 1 again" in {
    val parser = Calculator.parser("0 || 1 && (4 > 20 || 10 < 20) ")
    val value = Calculator.evaluator(parser)
    assert(value == 1)
  }

  "Calculator" should "return 66512" in {
    val parser = Calculator.parser("1000 * 200 - (200232 * 2) / 3")
    val value = Calculator.evaluator(parser)
    assert(value == 66512)
  }

}
