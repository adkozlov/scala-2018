package ru.hse.spb.jvm.scala

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

import scala.io.StdIn

object CalculatorConsoleApplication {
  def main(args: Array[String]): Unit = {
    try {
      printGreetings()
      printUsage()
      runApplication()
    } catch {
      case e: Throwable =>
        handleUnexpectedException(e)
    }
  }

  def runApplication(): Unit = {
    var isRunning = true
    while (isRunning) {
      print(">")
      val input = StdIn.readLine()
      input match {
        case "exit" => isRunning = false
        case _ =>
          try {
            println(evaluate(input))
          } catch {
            case e: Exception =>
              handleExceptionDuringEvaluation(e)
          }
      }
    }
  }

  def evaluate(expression: String): Double = {
    val expLexer = new CalculatorLexer(CharStreams.fromString(expression))
    val expParser = new CalculatorParser(new BufferedTokenStream(expLexer))
    expParser.expr().value
  }

  def handleExceptionDuringEvaluation(e: Exception): Unit = {
    Console.err.println("Error during evaluation of passed expression")
    Console.err.println("Exception: " + e)
    Console.err.println("Message: " + e.getMessage)
  }

  def printGreetings(): Unit = {
    println("Welcome to BALC: Best Arithmetical and Logical Calculator!")
  }

  def printUsage(): Unit = {
    println("Type \"exit\" to finish or type expression to evaluate.")
  }

  def handleUnexpectedException(e: Throwable): Unit = {
    Console.err.println("Unexpected error occurred")
    Console.err.println("Exception: " + e)
    Console.err.println("Message: " + e.getMessage)
  }
}
