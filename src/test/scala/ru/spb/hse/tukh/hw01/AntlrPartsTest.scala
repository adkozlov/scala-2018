package ru.spb.hse.tukh.hw01

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.scalatest.{FlatSpec, Matchers}

class AntlrPartsTest extends FlatSpec with Matchers {
  private def getTree(expression: String): String = {
    val lexer = new ExpLexer(CharStreams.fromString(expression))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    parser.expression().toStringTree(parser)
  }

  "parser" should "build correct tree" in {
    getTree("1 + 1") should equal("(expression (expression 1) + (expression 1))")
    getTree("(1 + 1) * (1 - 1)") should equal(
      "(expression (expression ( (expression (expression 1) + (expression 1)) ))" +
               " * (expression ( (expression (expression 1) - (expression 1)) )))")
    getTree("1 * 1 * 1 * 1 * 1") should equal(
      "(expression (expression (expression (expression (" +
        "expression 1) * (expression 1)) * (expression 1)) * (expression 1)) * (expression 1))")
  }
}
