package ru.hse.spb

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

import scala.io.StdIn

object Main {

  def calculate(expr: String): Double = {
    val expLexer = new calcLexer(CharStreams.fromString(expr))
    val expParser = new calcParser(new BufferedTokenStream(expLexer))
    expParser.input().value
  }

  def main(args: Array[String]): Unit = {
    println("To calculate write expression. To exit type \"exit\"")
    while (true) {
      val input = StdIn.readLine()
      if (input == "exit") return
      println(calculate(input))
    }
  }
}
