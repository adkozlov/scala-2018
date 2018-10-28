package ru.hse.spb.scala.sharkova.calculator

import org.antlr.v4.runtime._
import org.junit.Test
import org.junit.Assert._

class LexerTest {
  private def getTokenName(lexer: ArithmeticLexer, token: Token): String = {
    lexer.getVocabulary.getSymbolicName(token.getType)
  }

  @Test
  def testDouble(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("30.219"))
    val tokens = lexer.getAllTokens
    assertEquals(1, tokens.size())
    assertEquals("DOUBLE", lexer.getVocabulary.getSymbolicName(tokens.get(0).getType))
    assertEquals("30.219", tokens.get(0).getText)
  }

  @Test
  def testValidArithmeticBinaryOperations(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("30 + 59 - 100 * 111 / 11 % 6"))
    val tokens = lexer.getAllTokens
    assertEquals(11, tokens.size())
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(0)))
    assertEquals("ADD", getTokenName(lexer, tokens.get(1)))
    assertEquals("+", tokens.get(1).getText)
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(2)))
    assertEquals("ADD", getTokenName(lexer, tokens.get(3)))
    assertEquals("-", tokens.get(3).getText)
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(4)))
    assertEquals("MUL", getTokenName(lexer, tokens.get(5)))
    assertEquals("*", tokens.get(5).getText)
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(6)))
    assertEquals("MUL", getTokenName(lexer, tokens.get(7)))
    assertEquals("/", tokens.get(7).getText)
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(8)))
    assertEquals("MUL", getTokenName(lexer, tokens.get(9)))
    assertEquals("%", tokens.get(9).getText)
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(10)))
  }

  @Test
  def testValidLogicalBinaryOperations(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("!1 && 0 || 1"))
    val tokens = lexer.getAllTokens
    assertEquals(6, tokens.size())
    assertEquals("NOT", getTokenName(lexer, tokens.get(0)))
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(1)))
    assertEquals("AND", getTokenName(lexer, tokens.get(2)))
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(3)))
    assertEquals("OR", getTokenName(lexer, tokens.get(4)))
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(5)))
  }

  @Test (expected = classOf[CalculatorException])
  def testInvalidBinaryOperation(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("30 $ 45"))
    lexer.addErrorListener(new ThrowExceptionListener)
    lexer.getAllTokens
  }

  @Test
  def testTextInput(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("30 + b"))
    lexer.addErrorListener(new ThrowExceptionListener)
    try {
      lexer.getAllTokens
    } catch {
      case e: CalculatorException => assertTrue(e.getMessage.contains("on line 1 at position 5"))
    }
  }

  @Test
  def testParentheses(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("(30)"))
    val tokens = lexer.getAllTokens
    assertEquals(3, tokens.size())
    assertEquals("LEFT_PARENTHESIS", getTokenName(lexer, tokens.get(0)))
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(1)))
    assertEquals("RIGHT_PARENTHESIS", getTokenName(lexer, tokens.get(2)))
  }

  @Test
  def testFunctions(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("sin 30 + cos 30"))
    val tokens = lexer.getAllTokens
    assertEquals(5, tokens.size())
    assertEquals("SIN", getTokenName(lexer, tokens.get(0)))
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(1)))
    assertEquals("ADD", getTokenName(lexer, tokens.get(2)))
    assertEquals("COS", getTokenName(lexer, tokens.get(3)))
    assertEquals("DOUBLE", getTokenName(lexer, tokens.get(4)))
  }

  @Test (expected = classOf[CalculatorException])
  def testInvalidFunction(): Unit = {
    val lexer = new ArithmeticLexer(CharStreams.fromString("sin 30 + tan(30)"))
    lexer.addErrorListener(new ThrowExceptionListener)
    lexer.getAllTokens
  }
}
