package ru.hse.mit

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

object Main {
  val EXIT = "exit"

  def main(args: Array[String]): Unit = {
    println("Type expression to evaluate and press enter.")
    println("Type 'exit' to quit.")
    var input = scala.io.StdIn.readLine()
    val calculator = new Calculator()
    while (input.toLowerCase() != EXIT) {
      val lexer = new CalcLexer(CharStreams.fromString(input))
      val parser = new CalcParser(new BufferedTokenStream(lexer))
      println(calculator.visitData(parser.data()))
      input = scala.io.StdIn.readLine()
    }
  }
}
