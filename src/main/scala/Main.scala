import grammar._
import org.antlr.v4.runtime.CharStreams.fromString
import org.antlr.v4.runtime.{CommonTokenStream, Recognizer}
import visitors.{BooleanAlgebraEvaluator, RealFieldEvaluator}

import scala.io.StdIn.readLine


object Main {
  def evalBooleanMath(expression: String): Boolean = {
    val lexer = new BooleanAlgebraLexer(fromString(expression))
    makeItToRaiseExceptionOnSyntaxErrors(lexer)
    val parser = new BooleanAlgebraParser(new CommonTokenStream(lexer))
    makeItToRaiseExceptionOnSyntaxErrors(parser)
    parser.booleanExpr().accept(BooleanAlgebraEvaluator)
  }

  def evalRealMath(expression: String): Int = {
    val lexer = new RealFieldLexer(fromString(expression))
    makeItToRaiseExceptionOnSyntaxErrors(lexer)
    val parser = new RealFieldParser(new CommonTokenStream(lexer))
    makeItToRaiseExceptionOnSyntaxErrors(parser)
    parser.realExpr().accept(RealFieldEvaluator)
  }

  private def makeItToRaiseExceptionOnSyntaxErrors(recognizer: Recognizer[_, _]): Unit = {
    val errorListener = new ErrorListener()
    recognizer.removeErrorListeners()
    recognizer.addErrorListener(errorListener)
  }

  def repl(): Boolean = {
    val line = readLine("> ")
    if (line == null) return false

    try {
      println(evalBooleanMath(line))
      return true
    } catch {
      // ignore errors, cause we have the next parser
      case ex: RuntimeException => ()
    }

    try {
      println(evalRealMath(line))
    } catch {
      case ex: ArithmeticException => println("Division by zero")
      // parse errors are displayed here
      case ex: RuntimeException => println(ex.getMessage)
    }

    true
  }

  def main(args: Array[String]) {
    while (repl()) {}
    println("ok!")
  }
}
