package ru.hse.spb

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}
import ru.hse.spb.parser.{CalculatorLexer, CalculatorParser}

object Calculator {

  def main(args: Array[String]): Unit = {
    while (true) {
      println(calculate(scala.io.StdIn.readLine()))
    }
  }

  def calculate(exception: String): String = {
    val parser = new CalculatorParser(new BufferedTokenStream(new CalculatorLexer(CharStreams.fromString(exception))))
    (new MyCalculatorVisitor).visit(parser.input).toString
  }
}
