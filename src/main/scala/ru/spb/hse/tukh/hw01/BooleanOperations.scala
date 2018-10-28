package ru.spb.hse.tukh.hw01

object BooleanOperations extends Operations[(Boolean, Boolean) => Boolean] {
  val And = Operation("&&", (first: Boolean, second: Boolean) => first && second)
  val Or = Operation("||", (first: Boolean, second: Boolean) => first || second)

  override val defaultValue: (Boolean, Boolean) => Boolean = null
}
