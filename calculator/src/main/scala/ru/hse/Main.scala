package ru.hse

object Main {
  def main(args: Array[String]): Unit = {
    for (line <- io.Source.stdin.getLines)
      try {
        println(Calculator.evaluate(line))
      } catch {
        case e@(_: BinaryOperationException |
                _: ArithmeticException) => println(e.getMessage)
      }
  }
}
