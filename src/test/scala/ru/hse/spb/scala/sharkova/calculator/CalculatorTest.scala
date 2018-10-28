package ru.hse.spb.scala.sharkova.calculator

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}
import org.junit.Test
import org.junit.Assert._

class CalculatorTest {
  private val Delta = 0.00001

  private def evaluate(input: String): Double = {
    val lexer = new ArithmeticLexer(CharStreams.fromString(input))
    val parser = new ArithmeticParser(new BufferedTokenStream(lexer))
    val calculator = new Calculator
    calculator.evaluate(parser.input())
  }

  @Test
  def testLiterals(): Unit = {
    assertEquals(0, evaluate("0"), 0)
    assertEquals(30, evaluate("30"), 0)
    assertEquals(56475624, evaluate("56475624"), 0)
    assertEquals(0.0, evaluate("0"), 0)
    assertEquals(0.0, evaluate("0.0"), 0)
    assertEquals(30.25, evaluate("30.25"), 0)
    assertEquals(56475624.56475624, evaluate("56475624.56475624"), 0)
  }

  @Test
  def testAdditionExpression(): Unit = {
    assertEquals(89, evaluate("30 + 59"), 0)
    assertEquals(89, evaluate("59 + 30"), 0)
    assertEquals(-29, evaluate("30 - 59"), 0)
    assertEquals(29, evaluate("59 - 30"), 0)
    assertEquals(30, evaluate("30 - 0"), 0)
    assertEquals(30, evaluate("30 + 0"), 0)
    assertEquals(30, evaluate("0 + 30"), 0)
    assertEquals(-30, evaluate("0 - 30"), 0)
    assertEquals(89.89, evaluate("30.59 + 59.30"), 0)
    assertEquals(90, evaluate("30.59 + 59.41"), 0)
  }

  @Test
  def testMultiplicationExpression(): Unit = {
    assertEquals(8, evaluate("1 * 8"), 0)
    assertEquals(8, evaluate("8 * 1"), 0)
    assertEquals(0, evaluate("8 * 0"), 0)
    assertEquals(0, evaluate("0 * 8"), 0)
    assertEquals(0, evaluate("0 * 1"), 0)
    assertEquals(0, evaluate("1.0 * 0"), 0)
    assertEquals(1.25, evaluate("1.25 * 1"), Delta)
    assertEquals(4.93525, evaluate("1.25 * 3.9482"), Delta)
    assertEquals(55378629.280753764, evaluate("12214.232985 * 4533.9424382"), Delta)

    assertEquals(8, evaluate("8 / 1"), 0)
    assertEquals(0.125, evaluate("1 / 8"), 0)
    assertEquals(4.45, evaluate("10.413 / 2.34"), Delta)
    assertEquals(0, evaluate("0 / 8"), 0)

    assertEquals(2, evaluate("5 % 3"), 0)
    assertEquals(2, evaluate("2 % 3"), 0)
    assertEquals(2.421, evaluate("5.421 % 3"), Delta)
    assertEquals(1.88, evaluate("5 % 3.12"), Delta)
    assertEquals(2.301, evaluate("5.421 % 3.12"), Delta)
  }

  @Test (expected = classOf[CalculatorException])
  def testDivisionByZero(): Unit = {
    evaluate("3.421 / 0")
  }

  @Test (expected = classOf[CalculatorException])
  def testModuloZero(): Unit = {
    evaluate("3 % 0")
  }

  @Test
  def testParenthesisedExpression(): Unit = {
    assertEquals(0, evaluate("(0)"), 0)
    assertEquals(102.86, evaluate("(30.0 + 21.43) * 2"), Delta)
    assertEquals(72.86, evaluate("30.0 + 21.43 * 2"), Delta)
    assertEquals(28.73, evaluate("(30.0 + 21.43) - 22.7"), Delta)
    assertEquals(28.73, evaluate("30.0 + (21.43 - 22.7)"), Delta)
    assertEquals(28.73, evaluate("(30.0 + 21.43 - 22.7)"), Delta)
    assertEquals(28.73, evaluate("30.0 + 21.43 - 22.7"), Delta)
  }

  @Test
  def testUnaryExpressions(): Unit = {
    assertEquals(-30, evaluate("(-30)"), 0)
    assertEquals(56475624, evaluate("(+56475624)"), 0)
    assertEquals(0.0, evaluate("(-0.0000000000)"), 0)
    assertEquals(-23.41, evaluate("(-23.41)"), Delta)
  }

  @Test
  def testAdditionExpressionWithNegativeExpressions(): Unit = {
    assertEquals(0.0, evaluate("(-30) + 30"), 0)
    assertEquals(-10, evaluate("(-30) + 20"), 0)
    assertEquals(-10, evaluate("20 + (-30)"), 0)
    assertEquals(-50, evaluate("(-20) + (-30)"), 0)

    assertEquals(-50.8, evaluate("(-30.3) - 20.5"), Delta)
  }

  @Test
  def testMultiplicationExpressionWithNegativeExpressions(): Unit = {
    assertEquals(0, evaluate("(-1) * 0"), 0)
    assertEquals(0, evaluate("0 * (-1)"), 0)
    assertEquals(-1, evaluate("1 * (-1)"), 0)
    assertEquals(-1, evaluate("(-1) * 1"), 0)
    assertEquals(1, evaluate("(-1) * (-1)"), 0)
    assertEquals(-1929.935, evaluate("(-23.45) * 82.3"), Delta)

    assertEquals(-23, evaluate("23.0 / (-1)"), 0)
    assertEquals(-23, evaluate("(-23.0) / 1"), 0)
    assertEquals(23, evaluate("(-23.0) / (-1)"), 0)
    assertEquals(23.4324, evaluate("(-23.4324) / (-1)"), Delta)

    assertEquals(-2.301, evaluate("(-5.421) % 3.12"), Delta)
  }

  @Test
  def testTrigonometricFunctions(): Unit = {
    assertEquals(0, evaluate("sin(0)"), Delta)
    assertEquals(1, evaluate(s"sin(${scala.math.Pi} / 2)"), Delta)
    assertEquals(0.5, evaluate(s"sin(${scala.math.Pi} / 6)"), Delta)
    assertEquals(1, evaluate("cos(0)"), Delta)
    assertEquals(0, evaluate(s"cos(${scala.math.Pi} / 2)"), Delta)
    assertEquals(0.5, evaluate(s"cos(${scala.math.Pi} / 3)"), Delta)
  }

  @Test
  def testLogicalBinaryExpressions(): Unit = {
    assertEquals(0, evaluate("1 && 0"), 0)
    assertEquals(0, evaluate("0 && 1"), 0)
    assertEquals(0, evaluate("0 && 0"), 0)
    assertEquals(1, evaluate("1 && 1"), 0)
    assertEquals(1, evaluate("1 && 30"), 0)
    assertEquals(1, evaluate("59.111 && (-30)"), 0)

    assertEquals(1, evaluate("1 || 0"), 0)
    assertEquals(1, evaluate("0 || 1"), 0)
    assertEquals(0, evaluate("0 && 0"), 0)
    assertEquals(1, evaluate("1 && 1"), 0)
    assertEquals(1, evaluate("1 && 30"), 0)
    assertEquals(1, evaluate("59.111 && 30"), 0)
  }

  @Test
  def testNegateExpressions(): Unit = {
    assertEquals(0, evaluate("!30"), 0)
    assertEquals(1, evaluate("!0"), 0)
    assertEquals(1, evaluate("!(-0.000000)"), 0)
    assertEquals(evaluate("!(1 && 0)"), evaluate("(!1) || (!0)"), 0)
    assertEquals(0, evaluate("1 && !1"), 0)
  }
}
