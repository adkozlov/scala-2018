package org.ifmo.calculator

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.ifmo.calculator.eval.StackEvaluator
import org.ifmo.calculator.visitors.ToStackVisitor
import org.ifmo.grammar.{NotFunAtAllLexer, NotFunAtAllParser}


object Runner {
  def run(input: String): Either[Boolean, Long] = {
    val lexer = new NotFunAtAllLexer(CharStreams.fromString(input))
    val parser = new NotFunAtAllParser(new CommonTokenStream(lexer))

    val stack = parser.binary_expr().accept(new ToStackVisitor())
    new StackEvaluator().run(stack)
  }

  def main(args: Array[String]): Unit = {
    while (true) {
      try {
        val input = scala.io.StdIn.readLine()
        val output = run(input)
        println(output.fold(x => x.toString, x => x.toString))
      } catch {
        case e: Exception => println(e.getMessage)
      }
    }
  }

}
