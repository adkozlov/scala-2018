import antlr.{CalculatorBaseVisitor, CalculatorLexer, CalculatorParser}
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    while (true) {
      val expr = StdIn.readLine()
      if (expr.equals("exit")) {
        return
      }
      println(evalExpr(expr))
    }
  }

  private def visit[T](expr: String, visitor: CalculatorBaseVisitor[_]): Any = {
    val stream = CharStreams.fromString(expr)
    var lexer = new CalculatorLexer(stream)
    val parser = new CalculatorParser(new CommonTokenStream(lexer))
    try
      parser.calculator().accept(visitor)
    catch {
      case e: ParseCancellationException =>
        e.getMessage
    }
  }

  def evalExpr(expr: String): Any = {
    visit(expr, Calculator)
  }

  def toBeautyString(expr: String): Any = {
    visit(expr, Mirror)
  }
}