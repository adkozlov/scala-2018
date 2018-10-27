package ru.hse

import ru.hse.ExpParser.BoolLiteralContext

sealed trait Literal {
  private def unsupportedOperation(operation: String) =
    throw new BinaryOperationException("An operation " + operation + " is not supported for given types")

  def +(literal: Literal): Literal = unsupportedOperation("+")

  def -(literal: Literal): Literal = unsupportedOperation("-")

  def /(literal: Literal): Literal = unsupportedOperation("/")

  def *(literal: Literal): Literal = unsupportedOperation("*")

  def %(literal: Literal): Literal = unsupportedOperation("%")

  def >(literal: Literal): Literal = unsupportedOperation(">")

  def <(literal: Literal): Literal = unsupportedOperation("<")

  def >=(literal: Literal): Literal = unsupportedOperation(">=")

  def <=(literal: Literal): Literal = unsupportedOperation("<=")

  def !=(literal: Literal): Literal = unsupportedOperation("!=")

  def ==(literal: Literal): Literal = unsupportedOperation("==")

  def &&(literal: Literal): Literal = unsupportedOperation("&&")

  def ||(literal: Literal): Literal = unsupportedOperation("||")
}

case class IntLiteral(value: Int) extends Literal {
  override def +(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value + literal.value)
    case _ => super.+(literal)
  }

  override def -(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value - literal.value)
    case _ => super.-(literal)
  }

  override def /(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value / literal.value)
    case _ => super./(literal)
  }

  override def *(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value * literal.value)
    case _ => super.*(literal)
  }

  override def %(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value % literal.value)
    case _ => super.%(literal)
  }

  override def >(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value > literal.value)
    case _ => super.>(literal)
  }

  override def <(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value < literal.value)
    case _ => super.<(literal)
  }

  override def >=(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value >= literal.value)
    case _ => super.>=(literal)
  }

  override def <=(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value <= literal.value)
    case _ => super.<=(literal)
  }

  override def !=(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value != literal.value)
    case _ => BoolLiteral(true)
  }

  override def ==(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value == literal.value)
    case _ => BoolLiteral(false)
  }

  override def toString: String = value.toString
}

case class BoolLiteral(value: Boolean) extends Literal {
  override def >(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value > literal.value)
    case _ => super.>(literal)
  }

  override def <(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value < literal.value)
    case _ => super.<(literal)
  }

  override def >=(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value >= literal.value)
    case _ => super.>=(literal)
  }

  override def <=(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value <= literal.value)
    case _ => super.<=(literal)
  }

  override def !=(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value != literal.value)
    case _ => super.!=(literal)
  }

  override def ==(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value == literal.value)
    case _ => super.==(literal)
  }

  override def &&(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value && literal.value)
    case _ => super.&&(literal)
  }

  override def ||(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value || literal.value)
    case _ => super.||(literal)
  }

  override def toString: String = value.toString
}

class BinaryOperationException(message: String) extends Exception(message)