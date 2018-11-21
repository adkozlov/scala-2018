package ru.spb.hse

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import ru.spb.hse.calculator.{ExpLexer, ExpParser}

object Calculator {
  def run(expression: String): String = {
    val lexer = new ExpLexer(CharStreams.fromString(expression))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    val visitor = ExpVisitor
    val value = visitor.visit(parser.expression())
    if (value.wasBoolean) {
      (value.value == 1).toString
    } else {
      value.value.toString
    }
  }
}
