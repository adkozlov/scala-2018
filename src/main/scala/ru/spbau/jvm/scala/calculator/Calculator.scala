package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object Calculator {
  private val EXIT = "exit"

  def main(args: Array[String]): Unit = {
    val evaluator = new Evaluator()

    println("type \"exit\" to exit")
    while (true) {
      try {
        val input = scala.io.StdIn.readLine()
        evaluate(input, evaluator) match {
          case Some(Result(value)) => println(value)
          case _ => return
        }
      } catch {
        case e: Exception => println(e.getMessage)
      }
    }
  }

  def evaluate(input: String, evaluator: Evaluator): Option[Result[_]] = {
    input match {
      case EXIT => None
      case _ =>
        val lexer = new CalcLexer(CharStreams.fromString(input))
        val tokens = new CommonTokenStream(lexer)

        val parser = new CalcParser(tokens)
        Some(evaluator.evaluate(parser.expression()))
    }
  }
}
