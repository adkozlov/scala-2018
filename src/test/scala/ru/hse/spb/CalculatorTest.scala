package ru.hse.spb

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
  @Test
  def testIntegration(): Unit = {
    assertEquals("true", Calculator.calculate("3 == (1 + 6 % 4)").toString)
    assertEquals("false", Calculator.calculate("4 == 1 - 6 * 4").toString)
    assertEquals("20", Calculator.calculate("5 * 4").toString)
    assertEquals("0", Calculator.calculate("false+false").toString)
  }
}
