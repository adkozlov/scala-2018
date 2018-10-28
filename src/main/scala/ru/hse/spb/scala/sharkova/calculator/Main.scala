package ru.hse.spb.scala.sharkova.calculator

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val input = StdIn.readLine()
    if (input.isEmpty) {
      println(0)
      return
    }

    val lexer = new ArithmeticLexer(CharStreams.fromString(input))
    val parser = new ArithmeticParser(new BufferedTokenStream(lexer))
    val calculator = new Calculator
    println(calculator.evaluate(parser.input()))
  }
}
