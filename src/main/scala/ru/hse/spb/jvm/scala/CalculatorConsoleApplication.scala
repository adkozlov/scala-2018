package ru.hse.spb.jvm.scala

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

  private def runApplication(): Unit = {
    var isRunning = true
    while (isRunning) {
      print(">")
      val input = StdIn.readLine()
      input match {
        case "exit" => isRunning = false
        case _ =>
          try {
            println(Calculator.evaluate(input))
          } catch {
            case e: Exception =>
              handleExceptionDuringEvaluation(e)
          }
      }
    }
  }

  private def handleExceptionDuringEvaluation(e: Exception): Unit = {
    Console.err.println("Error during evaluation of passed expression")
    Console.err.println("Exception: " + e)
    Console.err.println("Message: " + e.getMessage)
  }

  private def printGreetings(): Unit = {
    println("Welcome to BALC: Best Arithmetical and Logical Calculator!")
  }

  private def printUsage(): Unit = {
    println("Type \"exit\" to finish or type expression to evaluate.")
  }

  private def handleUnexpectedException(e: Throwable): Unit = {
    Console.err.println("Unexpected error occurred")
    Console.err.println("Exception: " + e)
    Console.err.println("Message: " + e.getMessage)
  }
}
