package ru.hse.scala

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val calculator: Calculator = new Calculator()
    var line: String = StdIn.readLine()
    while (!line.equals("exit")) {
      try {
        System.out.println(calculator.calculate(line))
      }
      catch {
        case e: Exception => System.err.println(e.getMessage)
      }
      line = StdIn.readLine()
    }
  }
}
