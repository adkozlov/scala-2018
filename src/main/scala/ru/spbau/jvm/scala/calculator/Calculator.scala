package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object Calculator {
  private val EXIT = "exit"
  private val evaluator = new Evaluator()

  def main(args: Array[String]): Unit = {
    println("type \"exit\" to exit")
    while (true) {
      try {
        val input = scala.io.StdIn.readLine()
        val output = evaluate(input)
        if (output.isEmpty) {
          return
        }
        println(output.get.fold(x => x.toString, x => x.toString))
      } catch {
        case e: Exception => println(e.getMessage)
      }
    }
  }

  def evaluate(input: String): Option[Either[Int, Boolean]] = {
    if (input == EXIT) {
      return None
    }
    val lexer = new AnotherShittyCalcLexer(CharStreams.fromString(input))
    val tokens = new CommonTokenStream(lexer)

    val parser = new AnotherShittyCalcParser(tokens)
    Some(parser.expression().accept(evaluator))
  }
}
