package ru.hse.spb.kazakov

object Main {
  def main(args: Array[String]): Unit = {
    val input = scala.io.StdIn.readLine()
    val calculator = new Calculator(input)
    try {
      println(calculator.evaluate())
    } catch {
      case exception: ArithmeticException => println(exception.getMessage)
    }
  }
}
