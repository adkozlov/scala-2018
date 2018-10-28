package ru.hse.spb

object Calculator {
  def calculate(expression: String): Literal = Evaluator.evaluate(ExprParser.parse(expression))
}
