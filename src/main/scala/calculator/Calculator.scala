package calculator

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object Calculator {

  private[calculator] def evaluate(expression: String): Any = {
    val tokens = new CalculatorLexer(CharStreams.fromString(expression))
    val input = new CalculatorParser(new CommonTokenStream(tokens))
    input.expression().accept(new CalculatorEvaluator())
  }

  def run(): Unit = {
    while (true) {
      val input = scala.io.StdIn.readLine("> ")
      if (input == null) return
      println(evaluate(input))
    }
  }
}