package ru.hse.mit

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

object Main {

  private val EXIT_COMMAND = "exit"
  private val calculator = new Calculator()

  def main(args: Array[String]): Unit = {
    printManual()
    var input = nextCommand
    while (input != EXIT_COMMAND) {
      processCommand(input)
      input = nextCommand
    }

  }

  private def processCommand(text: String): Unit = {
    val lexer = new CalcLexer(CharStreams.fromString(text))
    val parser = new CalcParser(new BufferedTokenStream(lexer))
    try {
      println(calculator.visit(parser.file()))
    } catch {
      case e : Exception => println("ERROR")
    }
  }

  private def printManual(): Unit = {
    println("Type expression to evaluate or type 'exit' to quit")
  }

  private def nextCommand = {
    scala.io.StdIn.readLine()
  }

}
