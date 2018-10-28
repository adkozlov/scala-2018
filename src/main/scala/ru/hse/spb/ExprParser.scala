package ru.hse.spb

import org.antlr.v4.runtime._

object ExprParser {
  def parse(expr: String): Expression = {
      val lexer = new CalcLexer(CharStreams.fromString(expr + "\n"))
      val parser = new CalcParser(new BufferedTokenStream(lexer))

      AntlrMapper.map(parser.expression())
  }
}
