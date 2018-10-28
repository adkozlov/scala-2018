package ru.hse.spb

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}
import org.junit

class Test {
  private val calculator = new Calculator()

  @junit.Test
  def testPlus(): Unit = {
    testCalculator("1+2", 3)
    testCalculator("12+23", 35)
  }

  @junit.Test
  def testMinus(): Unit = {
    testCalculator("1-2", -1)
    testCalculator("0-4", -4)
  }

  @junit.Test
  def testUnaryMinus(): Unit = {
    testCalculator("-123", -123)
    testCalculator("-(-17)", 17)
  }

  @junit.Test
  def testDoubleMinus(): Unit = {
    testCalculator("-12-13", -25)
    testCalculator("-(5-13)", 8)
  }

  @junit.Test
  def testBrackets(): Unit = {
    testCalculator("-(1+4)", -5)
    testCalculator("(1-4)-(3-2)", -4)
  }

  @junit.Test
  def testComplicatedAdding(): Unit = {
    testCalculator("-(12-13)+25-(3-1)-1-1", 22)
  }

  @junit.Test
  def testMultiply(): Unit = {
    testCalculator("2*2*3", 12)
    testCalculator("1+2*3", 7)
  }

  @junit.Test
  def testDiv(): Unit = {
    testCalculator("10/(1+1)", 5)
    testCalculator("10/(35/7)", 2)
  }

  @junit.Test
  def testMod(): Unit = {
    testCalculator("123 % 10", 3)
    testCalculator("17 % 3", 2)
  }

  @junit.Test
  def testLongNumberExpression(): Unit = {
    testCalculator("(25-4)*(-2-3*(1+1))", -168)
    testCalculator("-5*(4-9)+17%17*35", 25)
  }

  @junit.Test
  def testBooleanExpression(): Unit = {
    testCalculator("true", 1)
    testCalculator("true || (true && false)", 1)
  }

  @junit.Test
  def testBooleanExpressionWithNot(): Unit = {
    testCalculator("!false", 1)
    testCalculator("!(true && false) || false", 1)
  }

  @junit.Test
  def testBooleanNumberExpression(): Unit = {
    testCalculator("(25/4-13%7) && true", 0)
  }

  private def testCalculator(expression: String, expectedResult: Int): Unit = {
    val lexer = new ExpLexer(CharStreams.fromString(expression))
    val parser = new ExpParser(new BufferedTokenStream(lexer))
    assert(expectedResult == calculator.visitExpression(parser.expression()))
  }
}
