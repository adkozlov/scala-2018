package ru.spb.hse

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import ru.spb.hse.calculator.{ExpLexer, ExpParser}

object Calculator {
  def run(expression: String): Int = {
    val lexer = new ExpLexer(CharStreams.fromString(expression))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    val visitor = new ExpVisitor()
    visitor.visit(parser.expression())
  }
}
