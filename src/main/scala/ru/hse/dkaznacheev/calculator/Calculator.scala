package ru.hse.dkaznacheev.calculator
import org.antlr.v4.runtime._

object Calculator {
  def evaluator = new ExpressionEvaluator()

  def main(args: Array[String]): Unit = {
    println("Enter expression:")
    val input: String = scala.io.StdIn.readLine()
    try {
      println(calculate(input))
    } catch {
      case _: Exception => println("Invalid expression")
    }
  }

  def calculate(expr: String):Int = {
    val parser = new CalculatorParser(
      new CommonTokenStream(
        new CalculatorLexer(
          CharStreams.fromString(expr)
        )
      )
    )
    parser.calculator().accept(evaluator)
  }
}
