import antlr.CalculatorParser.CalculatorContext
import antlr.{CalculatorBaseVisitor, CalculatorLexer, CalculatorParser}
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    while (true) {
      val expr = StdIn.readLine()
      if (expr == "exit") {
        return
      }
      println(visit(parse(expr)))
    }
  }

  def parse(expr: String): CalculatorContext = {
    val stream = CharStreams.fromString(expr)
    val lexer = new CalculatorLexer(stream)
    val parser = new CalculatorParser(new CommonTokenStream(lexer))
    parser.calculator()
  }

  def visit(treeRoot: CalculatorContext, visitor: CalculatorBaseVisitor[_] = Calculator): Any = {
    try
      treeRoot.accept(visitor)
    catch {
      case e: ParseCancellationException =>
        e.getMessage
    }
  }
}