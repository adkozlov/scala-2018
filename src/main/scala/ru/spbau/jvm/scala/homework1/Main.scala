package ru.spbau.jvm.scala.homework1

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object Main {
  private val evaluator = new Calculator()

  def calculate(expression: String):Int = {
    val lexer = new ExpLexer(CharStreams.fromString(expression))
    val parser = new ExpParser(new CommonTokenStream(lexer))
    parser.calc().accept(evaluator)
  }

  def main(args: Array[String]): Unit = {
    while (true) {
      val input = scala.io.StdIn.readLine()
      println(calculate(input))
    }
  }
}