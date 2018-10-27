package ru.hse

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

class Calculator {
  private val expressionVisitor = new ExpressionVisitor

  def evaluate(expression: String): Literal = {
    val lexer = new ExpLexer(CharStreams.fromString(expression))
    val parser = new ExpParser(new BufferedTokenStream(lexer))
    expressionVisitor.visit(parser.expression())
  }
}
