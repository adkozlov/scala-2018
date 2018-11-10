package ru.spbau.jvm.scala.calculator

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test


class CalculatorTest {
  private val evaluator = new Evaluator()

  private def test(input: String, expected: Int): Unit = {
    Calculator.evaluate(input, evaluator) match {
      case Some(Left(actual)) => assertEquals(expected, actual)
      case _ => fail()
    }
  }

  private def test(input: String, expected: Boolean): Unit = {
    Calculator.evaluate(input, evaluator) match {
      case Some(Right(actual)) => assertEquals(expected, actual)
      case _ => fail()
    }
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
