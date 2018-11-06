package ru.hse.spb

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object Calculator {
  def parser(s: String): CalcParser = {
    val input = CharStreams.fromString(s)
    val lexer = new CalcLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new CalcParser(tokens)
    parser
  }

  def evaluator(parser: CalcParser): Long = {
    val calcVisitor = new CalcBaseVisitorImpl
    calcVisitor.visit(parser.expression())
  }

}
