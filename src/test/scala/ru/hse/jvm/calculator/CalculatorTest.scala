package ru.hse.jvm.calculator

import org.scalatest.{FlatSpec, Matchers}

class CalculatorTest extends FlatSpec with Matchers {
  private val precision = 1e-8f

  def checkThat(expression: String, expectedResult: Int): Unit = {
    Calculator.runCalculator(expression) should be(expectedResult)
  }

  "Calculator" should "handle and operation" in checkThat("2 && 2", 1)

  "Calculator" should "handle or operation" in checkThat("2 || 0", 1)

  "Calculator" should "handle plus operation" in checkThat("2 + 2", 4)

  "Calculator" should "handle mult operation" in checkThat("2 * 3", 6)

  "Calculator" should "handle minus operation" in checkThat("3 - 2", 1)

  "Calculator" should "handle divide operation" in checkThat("4 / 2", 2)

  "Calculator" should "handle parens" in checkThat("2 * (3 + 7)", 20)

  "Calculator" should "handle compare operations" in
    checkThat("4 > 2 && 1 < 3 && 2 <= 2 && 3 >= 2", 1)

  "Calculator" should "handle equal/not equal operations" in checkThat("2 == 2 && 2 != 1", 1)

  "Calculator" should "handle operations with different priorities" in
    checkThat("1 + 2 * 3 == 7 && 1 || 0", 1)
}