package ru.hse.spb

import scala.language.implicitConversions

sealed trait BoolBinaryOperator {
  def evaluate(a: Int, b: Int): Boolean
}

case object EQ extends BoolBinaryOperator {
  override def evaluate(a: Int, b: Int): Boolean = a == b
}

case object NEQ extends BoolBinaryOperator {
  override def evaluate(a: Int, b: Int): Boolean = a != b
}

case object OR extends BoolBinaryOperator {
  override def evaluate(a: Int, b: Int): Boolean = (a != 0) || (b != 0)
}

case object AND extends BoolBinaryOperator {
  override def evaluate(a: Int, b: Int): Boolean = (a != 0) && (b != 0)
}

case object GT extends BoolBinaryOperator {
  override def evaluate(a: Int, b: Int): Boolean = a > b
}

case object LT extends BoolBinaryOperator {
  override def evaluate(a: Int, b: Int): Boolean = a < b
}

case object GEQ extends BoolBinaryOperator {
  override def evaluate(a: Int, b: Int): Boolean = a >= b
}

case object LEQ extends BoolBinaryOperator {
  override def evaluate(a: Int, b: Int): Boolean = a <= b
}