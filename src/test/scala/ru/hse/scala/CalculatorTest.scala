package ru.hse.scala

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
  val calculator = new Calculator()

  private def test(expected: AnyVal, line: String): Unit = assertEquals(expected, calculator.calculate(line))

  private def testDouble(expected: Double, line: String): Unit = assertEquals(expected, calculator.calculate(line).asInstanceOf[Double], 1e-9)

  @Test
  def parseBool(): Unit = {
    test(true, "true")
  }

  @Test
  def parseInt() : Unit = {
    test(1, "1")
  }

  @Test
  def parseDouble() : Unit = {
    testDouble(0.5, "0.5")
  }

  @Test
  def simple(): Unit = test(1, "0 + 1")

  @Test
  def severalOperationsWithEqualPriority(): Unit = test(2, "0 - 1 + 5 - 2")

  @Test
  def severalMultAndDiv(): Unit = test(2, "7 * 2 / 5")

  @Test
  def unaryMinus(): Unit = test(-8, "-1 * 8")

  @Test
  def addAndMult(): Unit = test(-3, "7 - 5 * 2")

  @Test
  def expWithParentheses(): Unit = test(6, "(8 - 5) * 2")

  @Test
  def severalParentheses(): Unit = test(6, "((1 + 5))")

  @Test
  def mod(): Unit = test(1, "5 % 4")

  @Test
  def doubleLeftOperand() : Unit = testDouble(1.5, "0.5 + 1")

  @Test
  def doubleRightOperand() : Unit = testDouble(2.0, "1 / 0.5")

  @Test
  def comparExp() : Unit = test(true, "5 < 7")

  @Test
  def orExp() : Unit = test(true, "false || 8 > 4 + 3")

  @Test
  def andExp() : Unit = test(false, "7 > 6 && 5 == 1")

  @Test
  def logicalExp() : Unit = test(true, "false && true || true")

  @Test
  def greater() : Unit = test(false, "6 >= 7.5")

  @Test
  def less() : Unit = test(true, "7 <= 67")


  @Test(expected = classOf[UnsupportedOperationException])
  def addToBool(): Unit = {
    calculator.calculate("true + 5")
  }

  @Test(expected = classOf[UnsupportedOperationException])
  def addBoolToInt(): Unit = {
    calculator.calculate("0 + (7 < 1)")
  }

  @Test(expected = classOf[UnsupportedOperationException])
  def compareBool(): Unit = {
    calculator.calculate("(6 == 7) <= false")
  }

  @Test(expected = classOf[UnsupportedOperationException])
  def modToDouble() : Unit = {
    calculator.calculate("8 % 5.0")
  }

  @Test
  def eqBool() : Unit = {
    test(false, "(6 == 7) == (8 > 3.5)")
  }
}
