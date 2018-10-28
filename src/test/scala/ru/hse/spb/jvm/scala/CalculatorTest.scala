package ru.hse.spb.jvm.scala

import org.scalatest.{FlatSpec, Matchers}

class CalculatorTest extends FlatSpec with Matchers {
  private val precision = 1e-8f

  def testExpression(expectedResult: Double, expression: String): Unit = {
    Calculator.evaluate(expression) should be(expectedResult +- precision)
  }

  "Evaluate method" should "be able to evaluate a or b expressions" in {
    testExpression(1, "1 || 0")
    testExpression(1, "0 || 1")
    testExpression(0, "0 || 0")
    testExpression(1, "1 || 1")
  }

  "Evaluate method" should "be able to evaluate a and b expressions" in {
    testExpression(0, "1 && 0")
    testExpression(0, "0 && 1")
    testExpression(0, "0 && 0")
    testExpression(1, "1 && 1")
  }

  "Evaluate method" should "be able to evaluate a == b expressions" in {
    testExpression(0, "1.2 == 0")
    testExpression(0, "0 == 1")
    testExpression(1, "0.0 == 0")
    testExpression(1, "1.2 == 1.2")
  }

  "Evaluate method" should "be able to evaluate a != b expressions" in {
    testExpression(1, "1.2 != 0")
    testExpression(1, "0 != 1")
    testExpression(0, "0.0 != 0")
    testExpression(0, "1.2 != 1.2")
  }

  "Evaluate method" should "be able to evaluate a <= b expressions" in {
    testExpression(0, "1.2 <= 0")
    testExpression(1, "0 <= 1")
    testExpression(1, "0.0 <= 0")
    testExpression(1, "1.2 <= 1.2")
  }

  "Evaluate method" should "be able to evaluate a >= b expressions" in {
    testExpression(1, "1.2 >= 0")
    testExpression(0, "0 >= 1")
    testExpression(1, "0.0 >= 0")
    testExpression(1, "1.2 >= 1.2")
  }

  "Evaluate method" should "be able to evaluate a > b expressions" in {
    testExpression(1, "1.2 > 0")
    testExpression(0, "0 > 1")
    testExpression(0, "0.0 > 0")
    testExpression(0, "1.2 > 1.2")
  }

  "Evaluate method" should "be able to evaluate a < b expressions" in {
    testExpression(0, "1.2 < 0")
    testExpression(1, "0 < 1")
    testExpression(0, "0.0 < 0")
    testExpression(0, "1.2 < 1.2")
  }

  "Evaluate method" should "be able to evaluate a + b expressions" in {
    testExpression(2.1, "1.1 + 1")
    testExpression(2, "1 + 1")
    testExpression(2.1, "1 + 1.1")
    testExpression(2.2, "1.1 + 1.1")
  }

  "Evaluate method" should "be able to evaluate a - b expressions" in {
    testExpression(0.1, "1.1 - 1")
    testExpression(-2, "-1 - 1")
    testExpression(-0.1, "1 - 1.1")
    testExpression(0, "1.1 - 1.1")
  }

  "Evaluate method" should "be able to evaluate a * b expressions" in {
    testExpression(0.11, "1.1 * 0.1")
    testExpression(-1, "-1 * 1")
    testExpression(1.1, "1 * 1.1")
    testExpression(0, "0 * 1.1")
  }

  "Evaluate method" should "be able to evaluate a / b expressions" in {
    testExpression(11, "1.1 / 0.1")
    testExpression(-1, "-1 / 1")
    testExpression(0.5, "1 / 2")
    testExpression(0, "0 / 1.1")
  }

  "Evaluate method" should "be able to evaluate a % b expressions" in {
    testExpression(0, "2 % 2")
    testExpression(1, "5 % 4")
    testExpression(-1, "-3 % 2")
    testExpression(0, "2 % 1")
  }

  "Evaluate method" should "be able to evaluate complex combined expressions" in {
    testExpression(1, "2.2 / 2 + 2 * (3 - 2) == 3.1 && -2 == -2 + 0 + 0")
    testExpression(1, "2.2 / 2 + 2 * (3 - 2) == 1.1 || 4 % 2 == 0")
    testExpression(1, "(2.2 / 2 + 2 * (3 - 2) <= 1.0) < (4 % 2 == 0)")
    testExpression(0, "2.2 / (2 + 2) * (3 - 2) < -20.2 || (-4) % 2 > 0")
  }
}
