package ru.hse.mit

object Main {
  val EXIT = "exit"

  def main(args: Array[String]): Unit = {
    println("Type expression to evaluate and press enter.")
    println("Type 'exit' to quit.")
    var input = scala.io.StdIn.readLine()
    while (input.toLowerCase() != EXIT) {
      println(Calculator.run(input))
      input = scala.io.StdIn.readLine()
    }
  }
}
