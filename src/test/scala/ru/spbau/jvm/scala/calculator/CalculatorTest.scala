package ru.spbau.jvm.scala.calculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class CalculatorTest {
  private def test(input: String, expected: Int): Unit = {
    val value = Calculator.evaluate(input)
    assertTrue(value.isDefined)
    val result = value.get
    assertTrue(result.isLeft)
    val actual = result.left.get
    assertEquals(expected, actual)
  }

  private def test(input: String, expected: Boolean): Unit = {
    val value = Calculator.evaluate(input)
    assertTrue(value.isDefined)
    val result = value.get
    assertTrue(result.isRight)
    val actual = result.right.get
    assertEquals(expected, actual)
  }

  private def testTrue(input: String): Unit = test(input, expected = true)

  private def testFalse(input: String): Unit = test(input, expected = false)
  
  @Test
  def test1(): Unit = test("1 + 1", 2)

  @Test
  def test2(): Unit = test("1 + 2 * 3 + 4 % 3", 8)

  @Test
  def test3(): Unit = test("((1) + (1 - 3))*(100/33)", -3)

  @Test
  def test4(): Unit = testTrue("true")

  @Test
  def test5(): Unit = testFalse("false")

  @Test
  def test6(): Unit = testTrue("true && false || false && false || true && true")

  @Test
  def test7(): Unit = testFalse("((1) + (1 - 2))*(100/33) > 10")

  @Test
  def test8(): Unit = testTrue("10 >= 10")

  @Test
  def test9(): Unit = testTrue("10 <= 10")

  @Test
  def test10(): Unit = testTrue("10 == 10")

  @Test
  def test11(): Unit = testFalse("10 != 10")

  @Test
  def test12(): Unit = testTrue("10 != 9")

  @Test
  def test13(): Unit = testTrue("10 > 9")

  @Test
  def test14(): Unit = testTrue("9 < 10")
}
