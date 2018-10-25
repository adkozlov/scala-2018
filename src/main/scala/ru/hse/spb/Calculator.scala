package ru.hse.spb

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object Calculator {
  def run(s: String): Long = {
    val input = CharStreams.fromString(s)
    val lexer = new CalcLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new CalcParser(tokens)
    val calcVisitor = new CalcBaseVisitorImpl
    val result = calcVisitor.visit(parser.expression())
    result
  }

}
