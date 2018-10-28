package ru.hse.spb

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    println("If you want to leave calculator press Ctrl+D")
    while (true) {
      val command = StdIn.readLine("> ")
      try {
        println(calculate(command))
      }
      catch {
        case e: Exception => println(e.getMessage)
      }
    }
  }

  def calculate(command: String): Int = {
    val lexer = new ExpLexer(CharStreams.fromString(command))
    val tokens = new CommonTokenStream(lexer)
    val parser = new ExpParser(tokens)

    parser.expression().accept(MyVisitor)
  }

}
