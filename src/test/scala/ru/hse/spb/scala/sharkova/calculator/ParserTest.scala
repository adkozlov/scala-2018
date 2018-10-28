package ru.hse.spb.scala.sharkova.calculator

import org.antlr.v4.runtime._
import org.junit.Test
import org.junit.Assert._
import ru.hse.spb.scala.sharkova.calculator.ArithmeticParser._

class ParserTest {
  private def isLiteralExpr(ctx: ExpressionContext): Boolean = {
    ctx.isInstanceOf[LiteralExprContext]
  }

  private def isMultiplicationExpr(ctx: ExpressionContext): Boolean = {
    ctx.isInstanceOf[MultiplicationExprContext]
  }

  private def isAdditionExpr(ctx: ExpressionContext): Boolean = {
    ctx.isInstanceOf[AdditionExprContext]
  }

  private def isLogicalExpr(ctx: ExpressionContext): Boolean = {
    ctx.isInstanceOf[LogicalExprContext]
  }

  private def isUnaryExpr(ctx: ExpressionContext): Boolean = {
    ctx.isInstanceOf[UnaryExprContext]
  }

  private def isNegateExpr(ctx: ExpressionContext): Boolean = {
    ctx.isInstanceOf[NegateExpressionContext]
  }

  private def isFunctionCall(ctx: ExpressionContext): Boolean = {
    ctx.isInstanceOf[FunctionExprContext]
  }

  private def isParenthesisedExpr(ctx: ExpressionContext): Boolean = {
    ctx.isInstanceOf[ParenthesisedExprContext]
  }

  private def getExpression(input: String): ExpressionContext = {
    val lexer = new ArithmeticLexer(CharStreams.fromString(input))
    val parser = new ArithmeticParser(new BufferedTokenStream(lexer))
    parser.addErrorListener(new ThrowExceptionListener)
    parser.input().expression()
  }

  @Test
  def testParseLiteral(): Unit = {
    val expr = getExpression("30.0")
    assertTrue(isLiteralExpr(expr))
  }

  @Test
  def testParseParenthesisedExpr(): Unit = {
    val expr = getExpression("(30.0)")
    assertTrue(isParenthesisedExpr(expr))
    val parenthesisedExpr = expr.asInstanceOf[ParenthesisedExprContext]
    assertTrue(isLiteralExpr(parenthesisedExpr.expression()))
  }

  @Test
  def testParseUnaryExpr(): Unit = {
    val expr = getExpression("(-30.0)")
    assertTrue(isUnaryExpr(expr))
  }

  @Test
  def testParseNegateExpr(): Unit = {
    val expr = getExpression("!1")
    assertTrue(isNegateExpr(expr))
  }

  @Test
  def testParseAdditionExpr(): Unit = {
    val expr = getExpression("30 + 59 - 11")
    assertTrue(isAdditionExpr(expr))
    val additionExpr = expr.asInstanceOf[AdditionExprContext]
    assertTrue(isAdditionExpr(additionExpr.left))
    assertTrue(isLiteralExpr(additionExpr.right))
  }

  @Test
  def testParseMultiplicationExpr(): Unit = {
    assertTrue(isMultiplicationExpr(getExpression("30 * 59")))
    assertTrue(isMultiplicationExpr(getExpression("59 / 11")))
    assertTrue(isMultiplicationExpr(getExpression("11 % 6")))
  }

  @Test
  def testParseLogicalExpr(): Unit = {
    assertTrue(isLogicalExpr(getExpression("(!1) && 0")))
    assertTrue(isLogicalExpr(getExpression("1 || 0")))
  }

  @Test
  def testParseFunctionCall(): Unit = {
    assertTrue(isFunctionCall(getExpression("sin(30)")))
    assertTrue(isFunctionCall(getExpression("cos(30)")))
  }

  @Test (expected = classOf[CalculatorException])
  def testParseIncorrectFunctionCall(): Unit = {
    getExpression("sin 30")
  }

  @Test
  def testParseExtraParenthesis(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("(30 + 59)) * 111"))
    val parser = new ArithmeticParser(new BufferedTokenStream(lexer))
    parser.input()
  }

  @Test (expected = classOf[CalculatorException])
  def testParseLackingParenthesis(): Unit = {
    getExpression("(30 + 59 * 112")
  }

  @Test (expected = classOf[CalculatorException])
  def testParseUnaryExpressionWithoutParentheses(): Unit = {
    getExpression("30 + -59")
  }
}
