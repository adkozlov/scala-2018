package ru.hse.scala.nedikov.calculator

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

import scala.io.StdIn.readLine

object Calculator {
  def main(args: Array[String]): Unit = {
    while (true) {
      val in = readLine()
      if (in == ":q") return
      println(Evaluator.eval(in))
    }
  }
}

object Evaluator {
  def eval(in: String): String = {
    val calculatorLexer = new CalculatorLexer(CharStreams.fromString(in))
    new CalculatorParser(new BufferedTokenStream(calculatorLexer)).eval().value
  }
}
