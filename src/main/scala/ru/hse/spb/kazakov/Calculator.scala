package ru.hse.spb.kazakov

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

class Calculator(private val input: String) {
  def evaluate(): AnyVal = {
    val lexer = new ExprGrammarLexer(CharStreams.fromString(input))
    val tokens = new CommonTokenStream(lexer)
    val parser = new ExprGrammarParser(tokens)
    val visitor = ExprVisitor
    visitor.visit(parser.expression())
  }
}
