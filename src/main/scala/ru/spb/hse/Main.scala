package ru.hse.spb

import ru.spb.hse.Calculator

object Main {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Provide an expression to calculate as an argument")
      return
    }
    println(args(0) + " = " + Calculator.run(args(0)))
  }
}