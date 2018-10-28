package ru.hse.dkaznacheev.calculator

import org.junit.Test
import org.junit.Assert.assertEquals

class CalculatorTest {
  def equals(expected: Int, actual: String): Unit = assertEquals(expected, Calculator.calculate(actual))

  @Test
  def testAdd(): Unit = equals(4, "2 + 2")

  @Test
  def testSub(): Unit = equals(0, "2 - 2")
  
  @Test
  def testMul(): Unit = equals(4, "2 * 2")
  
  @Test
  def testDiv(): Unit = equals(1, "3 / 2")
  
  @Test
  def testMod(): Unit = equals(0, "2 % 2")
  
  @Test
  def testAnd(): Unit = equals(0, "1 && 0")
  
  @Test
  def testOr(): Unit = equals(1, "1 || 0")
  
  @Test
  def testEq(): Unit = equals(1, "2 == 2")
  
  @Test
  def testNe(): Unit = equals(0, "2 != 2")
  
  @Test
  def testLt(): Unit = equals(1, "2 < 3")
  
  @Test
  def testLe(): Unit = equals(1, "2 <= 3")
  
  @Test
  def testGt(): Unit = equals(0, "2 > 3")
  
  @Test
  def testGe(): Unit = equals(0, "2 >= 3")
  
  @Test
  def testBrackets(): Unit = equals(0, "3*(3 - 3)")
  
  @Test
  def complex1():Unit = equals(1, "-1 + 2")
  
  @Test
  def complex2():Unit = equals(-1, "-1*3 + 2")
  
  @Test
  def complex3():Unit = equals(1, "1 + 2 * 3 > 3 + 2 * 1")
}
