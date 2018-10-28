package ru.spbau.jvm.scala.lecture01

object Main {

  def main(args: Array[String]): Unit = {
    val bar: Bar = Bar(42)
    bar.foo

    bar.text = "Hello"
    println(bar.text)
  }
}
