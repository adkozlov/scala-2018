package ru.spb.hse.tukh.hw01

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import ru.spb.hse.tukh.hw01.Exception.EvaluatorArithmeticException

object Main {
  val evaluator: Evaluator = new Evaluator()

  def getResult(expression: String): Int = {
    val lexer = new ExpLexer(CharStreams.fromString(expression))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    evaluator.visitExpression(parser.expression())
  }

  def main(args: Array[String]): Unit = {
    print("Enter exit to exit.\nOtherwise enter an expression\n> ")
    var line: String = scala.io.StdIn.readLine()
    while (line != "exit") {
      println(s"Entered: \'$line\'")
      try {
        println(s"Result: ${getResult(line)}")
      } catch {
        case evaluatorArithmeticException: EvaluatorArithmeticException =>
          val message: String = evaluatorArithmeticException.getMessage
          val cause: Throwable = evaluatorArithmeticException.getCause
          println(s"Arithmetic exception: ${if (message != null) message else "unknown"}" +
            s", caused by ${if (cause != null) cause else "unknown"}")
        // case _ => println("Unknown exception")
      }
      print("> ")
      line = scala.io.StdIn.readLine()
    }
  }
}
