package calculator

import calculator.CalculatorParser.ExpressionContext
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object Calculator {

  private[calculator] def parse(expression: String) : ExpressionContext = {
    val tokens = new CalculatorLexer(CharStreams.fromString(expression))
    val input = new CalculatorParser(new CommonTokenStream(tokens))
    input.expression()
  }

  private[calculator] def evaluate(expression: ExpressionContext): AnyVal =
    expression.accept(CalculatorEvaluator)

  private[calculator] def parseAndEval(input: String): AnyVal =
    evaluate(parse(input))

  def run(): Unit = {
    while (true) {
      io.StdIn.readLine("> ") match {
        case null => return
        case input => println(parseAndEval(input))
      }
    }
  }
}