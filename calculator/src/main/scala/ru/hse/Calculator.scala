package ru.hse

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

object Calculator {
  def evaluate(expression: String): Literal = {
    val lexer = new ExpLexer(CharStreams.fromString(expression))
    val parser = new ExpParser(new BufferedTokenStream(lexer))
    ExpressionVisitor.visit(parser.expression())
  }
}
