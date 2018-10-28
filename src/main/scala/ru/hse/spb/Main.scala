package ru.hse.spb

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

object Main {

  def main(args: Array[String]): Unit = {
    val input = scala.io.StdIn.readLine()
    val calculator = new Calculator()
    val lexer = new ExpLexer(CharStreams.fromString(input))
    val parser = new ExpParser(new BufferedTokenStream(lexer))
    println(calculator.visitExpression(parser.expression()))
  }
}