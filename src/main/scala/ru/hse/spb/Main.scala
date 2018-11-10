package ru.hse.spb

import ast.AntlrAstVisitor
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

object Main {
  def main(args: Array[String]) = {
    for (ln <- io.Source.stdin.getLines) {
      val input = new ANTLRInputStream(ln)
      val lexer = new CalcLexer(input)
      val tokens = new CommonTokenStream(lexer)
      val parser = new CalcParser(tokens)
      val visitor = new AntlrAstVisitor()
      val expression = visitor.visit(parser.expression())
      println(Evaluator.eval(expression))
    }
  }
}
