package ru.spb.hse

object Main {
  def main(args: Array[String]): Unit = {
    val output = args match {
      case Array(argument) => argument + " = " + Calculator.run(argument)
      case _ => "Provide an expression to calculate as an argument"
    }

    println(output)
  }
}