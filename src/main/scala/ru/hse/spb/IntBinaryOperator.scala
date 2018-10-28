package ru.hse.spb

sealed trait IntBinaryOperator {
  def evaluate(a: Int, b: Int): Int
}

case object PLUS extends IntBinaryOperator {
  override def evaluate(a: Int, b: Int): Int = a + b
}

case object MINUS extends IntBinaryOperator {
  override def evaluate(a: Int, b: Int): Int = a - b
}

case object MULT extends IntBinaryOperator {
  override def evaluate(a: Int, b: Int): Int = a * b
}

case object DIV extends IntBinaryOperator {
  override def evaluate(a: Int, b: Int): Int = a / b
}

case object MOD extends IntBinaryOperator {
  override def evaluate(a: Int, b: Int): Int = a % b
}