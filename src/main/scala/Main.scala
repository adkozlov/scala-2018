package main.scala

import arithm.{aLexer, aParser}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

import scala.io.StdIn

object Main {
  def main(args: Array[String]) {
    while (read()) {}
  }

  private def read(): Boolean = {
    val line = StdIn.readLine("> ")
    println("KEK: " + line)
    if (line == null) return false

    try {
      println(eval(line))
    } catch {
      case ex: ArithmeticException => println("Division by zero")
      case ex: RuntimeException => println("Some exception occured")
    }

    true
  }

  def eval(str: String): Int =
    new aParser(new CommonTokenStream(new aLexer(CharStreams.fromString(str)))).expr().res
}
