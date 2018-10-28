package ru.hse.spb

object Main {
  def main(args: Array[String]): Unit = {
      for (line <- io.Source.stdin.getLines) {
          try {
              println(Calculator.calculate(line))
          } catch {
              case e: Throwable => println(e.getMessage)
          }
      }
  }
}
