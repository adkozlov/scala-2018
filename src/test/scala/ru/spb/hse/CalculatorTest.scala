package ru.spb.hse

import org.junit.Test
import org.junit.Assert.assertEquals

class CalculatorTest {
  @Test
  def testBasicSum(): Unit = {
    val result = Calculator.run("2 + 3")
    assertEquals("5", result)
  }

  @Test
  def testBasicSubtract(): Unit = {
    val result = Calculator.run("2 - 3")
    assertEquals("-1", result)
  }

  @Test
  def testBasicMultiply(): Unit = {
    val result = Calculator.run("2 * 3")
    assertEquals("6", result)
  }

  @Test
  def testBasicDivide(): Unit = {
    val result = Calculator.run("6 / 3")
    assertEquals("2", result)
  }

  @Test
  def testBasicMod(): Unit = {
    val result = Calculator.run("5 % 3")
    assertEquals("2", result)
  }

  @Test
  def testSumAndMultiply(): Unit = {
    val result = Calculator.run("5 + 2 * 3")
    assertEquals("11", result)
  }

  @Test
  def testSumAndMultiplyAndParentheses(): Unit = {
    val result = Calculator.run("(5 + 2) * 3")
    assertEquals("21", result)
  }

  @Test
  def testMultiplyAndSum(): Unit = {
    val result = Calculator.run("2 * 3 + 5")
    assertEquals("11", result)
  }

  @Test
  def testMultiplyAndSumAndParentheses(): Unit = {
    val result = Calculator.run("3 * (5 + 2)")
    assertEquals("21", result)
  }

  @Test
  def testDifficultArithmetic(): Unit = {
    val result = Calculator.run("10 - 2 * (1 + 3) - 1")
    assertEquals("1", result)
  }

  @Test
  def testSimpleAnd(): Unit = {
    val result = Calculator.run("true && 0")
    assertEquals("false", result)
  }

  @Test
  def testLogicAndAndOr(): Unit = {
    val result = Calculator.run("true && (false || true)")
    assertEquals("true", result)
  }

  @Test
  def testLogicAndArithmetic(): Unit = {
    val result = Calculator.run("(1 + 3) == 4 && 5 < 6")
    assertEquals("true", result)
  }

  @Test
  def testLogicArithmeticAndParentheses(): Unit = {
    val result = Calculator.run("(1 + 3) == (4 && 5 < 6)")
    assertEquals("false", result)
  }
}
