package ru.hse.spb

import org.junit.Assert.assertEquals
import org.junit.Test

class EvaluatorTest {
  @Test
  def testIntLiteralAsInt(): Unit = {
    assertEquals(5, IntLiteral(5).asInt())
  }

  @Test
  def testBoolLiteralAsInt(): Unit = {
    assertEquals(0, BoolLiteral(false).asInt())
    assertEquals(1, BoolLiteral(true).asInt())
  }

  @Test
  def testBoolLiteral(): Unit = {
    val expression = BoolLiteral(false)
    assertEquals("false", Evaluator.evaluate(expression).toString)
  }

  @Test
  def testZeroIntLiteral(): Unit = {
    val expression = IntLiteral(0)
    assertEquals("0", Evaluator.evaluate(expression).toString)
  }

  @Test
  def testIntLiteral(): Unit = {
    val expression = IntLiteral(1337)
    assertEquals("1337", Evaluator.evaluate(expression).toString)
  }

  @Test
  def testBoolBinaryExpression(): Unit = {
    val expression = BoolBinaryExpression(IntLiteral(1), NEQ, IntLiteral(5))
    assertEquals("true", Evaluator.evaluate(expression).toString)
  }

  @Test
  def testIntBinaryExpression(): Unit = {
    val expression = IntBinaryExpression(IntLiteral(1), MINUS, IntLiteral(5))
    assertEquals("-4", Evaluator.evaluate(expression).toString)
  }

  @Test
  def testNestedExpressions(): Unit = {
    val expression = BoolBinaryExpression(IntLiteral(1), LEQ, IntBinaryExpression(IntLiteral(5), MULT, IntLiteral(2)))
    assertEquals("true", Evaluator.evaluate(expression).toString)
  }

  @Test
  def testDifferentTypes(): Unit = {
    val expression = IntBinaryExpression(IntLiteral(1), MINUS, BoolLiteral(true))
    assertEquals("0", Evaluator.evaluate(expression).toString)
  }

  @Test
  def testOperatorPriority(): Unit = {
    val expression = IntBinaryExpression(
      IntBinaryExpression(IntLiteral(7), MOD, IntLiteral(4)),
      MINUS,
      IntBinaryExpression(IntLiteral(5), MULT, IntLiteral(2))
    )
    assertEquals("-7", Evaluator.evaluate(expression).toString)
  }

  @Test
  def testBracketsPriority(): Unit = {
    val expression = IntBinaryExpression(
      IntBinaryExpression(
        IntLiteral(7),
        MOD,
        IntBinaryExpression(IntLiteral(6), MINUS, IntLiteral(5)),
      ),
      PLUS,
      IntLiteral(2)
    )
    assertEquals("2", Evaluator.evaluate(expression).toString)
  }
}
