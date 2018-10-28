package ru.spb.hse.tukh.hw01

object IntOperations extends Operations[(Int, Int) => _] {
  val Plus = Operation("+", (first: Int, second: Int) => first + second)
  val Minus = Operation("-", (first: Int, second: Int) => first - second)
  val Multiply = Operation("*", (first: Int, second: Int) => first * second)
  val Divide = Operation("/", (first: Int, second: Int) => first / second)
  val Modulo = Operation("%", (first: Int, second: Int) => first % second)

  val Greater = Operation(">", (first: Int, second: Int) => first > second)
  val Geq = Operation(">=", (first: Int, second: Int) => first >= second)
  val Lower = Operation("<", (first: Int, second: Int) => first < second)
  val Leq = Operation("<=", (first: Int, second: Int) => first <= second)
  val Neq = Operation("!=", (first: Int, second: Int) => first != second)

  override val defaultValue: (Int, Int) => _ = null
}
