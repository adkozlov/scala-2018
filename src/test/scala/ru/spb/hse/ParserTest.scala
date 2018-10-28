package ru.spb.hse

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import ru.spb.hse.calculator.{ExpLexer, ExpParser}
import org.junit.Assert.assertEquals
import org.junit.Test

class ParserTest {
  @Test
  def testBoolLiteral(): Unit = {
    val lexer = new ExpLexer(CharStreams.fromString("true"))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    val expression = parser.expression()
    assertEquals("(expression true)", expression.toStringTree(parser))
  }

  @Test
  def testLiteral(): Unit = {
    val lexer = new ExpLexer(CharStreams.fromString("123"))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    val expression = parser.expression()
    assertEquals("(expression 123)", expression.toStringTree(parser))
  }

  @Test
  def testSum(): Unit = {
    val lexer = new ExpLexer(CharStreams.fromString("1 + 2"))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    val expression = parser.expression()
    assertEquals("(expression (expression 1) + (expression 2))", expression.toStringTree(parser))
  }

  @Test
  def testDifficultExpression(): Unit = {
    val lexer = new ExpLexer(CharStreams.fromString("(1 + 3) == 4 && 5 < 6"))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    val expression = parser.expression()
    assertEquals("(expression (expression (expression " +
      "( (expression (expression 1) + (expression 3)) ))" +
      " == (expression 4)) && (expression (expression 5) < (expression 6)))",
      expression.toStringTree(parser))
  }
}
