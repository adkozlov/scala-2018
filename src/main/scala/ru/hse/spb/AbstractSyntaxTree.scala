package ru.hse.spb

trait ASTNode

sealed trait Expression extends ASTNode

sealed trait Literal extends Expression {
  def asInt(): Int
}

case class IntLiteral(value: Int) extends Literal {
  override def toString() = value.toString

  override def asInt(): Int = value
}

case class BoolLiteral(value: Boolean) extends Literal {
  override def toString() = value.toString

  override def asInt(): Int = if (value) 1 else 0
}

case class BoolBinaryExpression(left: Expression, op: BoolBinaryOperator, right: Expression) extends Expression

case class IntBinaryExpression(left: Expression, op: IntBinaryOperator, right: Expression) extends Expression

