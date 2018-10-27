package ru.hse

object Main {
  def main(args: Array[String]): Unit = {
    val calculator = new Calculator
    for (line <- io.Source.stdin.getLines)
      try {
        println(calculator.evaluate(line))
      } catch {
        case e: BinaryOperationException => println(e.getMessage)
        case e: ArithmeticException => println(e.getMessage)
      }
  }
}
