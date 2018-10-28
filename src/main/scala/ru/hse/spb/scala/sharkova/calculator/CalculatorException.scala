package ru.hse.spb.scala.sharkova.calculator

class CalculatorException(message: String) extends Exception {
  def apply(message: String): CalculatorException = new CalculatorException(message)

  override def getMessage: String = message
}
