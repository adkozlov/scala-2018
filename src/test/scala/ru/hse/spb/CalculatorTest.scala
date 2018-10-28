package ru.hse.spb

import org.junit.Test
import org.junit.Assert

class CalculatorTest {

  @Test
  def numberTest(): Unit = {
    Assert.assertEquals("42.0", Calculator.calculate("42"))
  }

  @Test
  def trueTest(): Unit = {
    Assert.assertEquals("true", Calculator.calculate("true"))
  }

  @Test
  def falseTest(): Unit = {
    Assert.assertEquals("false", Calculator.calculate("false"))
  }

  @Test
  def unaryMinusTest(): Unit = {
    Assert.assertEquals("-42.0", Calculator.calculate("-42"))
  }

  @Test
  def notTest(): Unit = {
    Assert.assertEquals("false", Calculator.calculate("!true"))
  }

  @Test
  def bracketsTest(): Unit = {
    Assert.assertEquals("42.0", Calculator.calculate("(42)"))
    Assert.assertEquals("43.0", Calculator.calculate("(42 + 1)"))
    Assert.assertEquals("true", Calculator.calculate("(42 = 42)"))
  }

  @Test
  def plusTest(): Unit = {
    Assert.assertEquals("43.0", Calculator.calculate("42 + 1"))
  }

  @Test
  def minusTest(): Unit = {
    Assert.assertEquals("41.0", Calculator.calculate("42.0 - 1"))
  }

  @Test
  def multTest(): Unit = {
    Assert.assertEquals("84.0", Calculator.calculate("42.0 * 2"))
  }

  @Test
  def divTest(): Unit = {
    Assert.assertEquals("21.0", Calculator.calculate("42.0 / 2"))
  }

  @Test
  def powTest(): Unit = {
    Assert.assertEquals("8.0", Calculator.calculate("2 ^ 3"))
  }

  @Test
  def powAssociativeTest(): Unit = {
    Assert.assertEquals("64.0", Calculator.calculate("2 ^ 3 ^ 2"))
  }

  @Test
  def prioritiesTest(): Unit = {
    Assert.assertEquals("18.0", Calculator.calculate("2 + 2 * 2 ^ 3"))
  }

  @Test
  def andTest(): Unit = {
    Assert.assertEquals("false", Calculator.calculate("true && false"))
  }

  @Test
  def orTest(): Unit = {
    Assert.assertEquals("true", Calculator.calculate("true || false"))
  }

  @Test
  def eqTest(): Unit = {
    Assert.assertEquals("true", Calculator.calculate("42 = 42"))
  }

  @Test
  def ltTest(): Unit = {
    Assert.assertEquals("true", Calculator.calculate("42 < 43"))
  }

  @Test
  def gtTest(): Unit = {
    Assert.assertEquals("true", Calculator.calculate("42 > 41"))
  }

  @Test
  def leqTest(): Unit = {
    Assert.assertEquals("true", Calculator.calculate("42 <= 42"))
  }

  @Test
  def geqTest(): Unit = {
    Assert.assertEquals("true", Calculator.calculate("42 >= 41"))
  }
}
