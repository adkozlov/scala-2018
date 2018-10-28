package ru.hse.spb

import org.junit.Assert.assertEquals
import org.junit.Test

class ExprParserTest {
  @Test
  def testParseBoolLiteral(): Unit = {
    assertEquals(BoolLiteral(false), ExprParser.parse("false"))
    assertEquals(BoolLiteral(true), ExprParser.parse("true"))
  }

  @Test
  def testParseIntLiteral(): Unit = {
    assertEquals(IntLiteral(0), ExprParser.parse("0"))
    assertEquals(IntLiteral(1337), ExprParser.parse("1337"))
  }

  @Test
  def testParseBoolBinaryExpression(): Unit = {
    assertEquals(BoolBinaryExpression(IntLiteral(1), NEQ, IntLiteral(5)), ExprParser.parse("1!=5"))
  }

  @Test
  def testParseIntBinaryExpression(): Unit = {
    assertEquals(IntBinaryExpression(IntLiteral(1), MINUS, IntLiteral(5)), ExprParser.parse("1-5"))
  }

  @Test
  def testParseNestedExpressions(): Unit = {
    assertEquals(
      BoolBinaryExpression(IntLiteral(1), LEQ, IntBinaryExpression(IntLiteral(5), MULT, IntLiteral(2))),
      ExprParser.parse("1 <= 5 * 2")
    )
  }

  @Test
  def testParseDifferentTypes(): Unit = {
    assertEquals(
      IntBinaryExpression(IntLiteral(1), MINUS, BoolLiteral(true)),
      ExprParser.parse("1-true")
    )
  }

  @Test
  def testParseOperatorPriority(): Unit = {
    assertEquals(
      IntBinaryExpression(
        IntBinaryExpression(IntLiteral(7), MOD, IntLiteral(4)),
        MINUS,
        IntBinaryExpression(IntLiteral(5), MULT, IntLiteral(2))
      ),
      ExprParser.parse("7 % 4 - 5 * 2")
    )
  }

  @Test
  def testParseBracketsPriority(): Unit = {
    assertEquals(
      IntBinaryExpression(
        IntBinaryExpression(
          IntLiteral(7),
          MOD,
          IntBinaryExpression(IntLiteral(6), MINUS, IntLiteral(5)),
        ),
        PLUS,
        IntLiteral(2)
      ),
      ExprParser.parse("7 % (6 - 5) + 2")
    )
  }
}
