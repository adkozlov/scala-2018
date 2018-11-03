package ru.hse.jvm.calculator

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}
import scala.io.StdIn

object Calculator {
  def main(args: Array[String]): Unit = {
    while (true) {
      val text = StdIn.readLine()
      println(runCalculator(text))
    }
  }

  def runCalculator(text: String): Int = {
    val lexer = new CalculatorLexer(CharStreams.fromString(text))
    val parser = new CalculatorParser(new BufferedTokenStream(lexer))
    val input = StdIn.readLine()
    val listener = new CalculatorVisitorImpl

    listener.visit(parser.expr())
  }
}
