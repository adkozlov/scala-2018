package ru.hse

sealed trait Literal {

  def +(literal: Literal): Literal = throw new BinaryOperationException("+")

  def -(literal: Literal): Literal = throw new BinaryOperationException("-")

  def /(literal: Literal): Literal = throw new BinaryOperationException("/")

  def *(literal: Literal): Literal = throw new BinaryOperationException("*")

  def %(literal: Literal): Literal = throw new BinaryOperationException("%")

  def >(literal: Literal): Literal = throw new BinaryOperationException(">")

  def <(literal: Literal): Literal = throw new BinaryOperationException("<")

  def >=(literal: Literal): Literal = throw new BinaryOperationException(">=")

  def <=(literal: Literal): Literal = throw new BinaryOperationException("<=")

  def !=(literal: Literal): Literal = throw new BinaryOperationException("!=")

  def ==(literal: Literal): Literal = throw new BinaryOperationException("==")

  def &&(literal: Literal): Literal = throw new BinaryOperationException("&&")

  def ||(literal: Literal): Literal = throw new BinaryOperationException("||")
}

case class IntLiteral(value: Int) extends Literal {
  override def +(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value + literal.value)
    case _ => throw new BinaryOperationException("+")
  }

  override def -(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value - literal.value)
    case _ => throw new BinaryOperationException("-")
  }

  override def /(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value / literal.value)
    case _ => throw new BinaryOperationException("/")
  }

  override def *(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value * literal.value)
    case _ => throw new BinaryOperationException("*")
  }

  override def %(literal: Literal): Literal = literal match {
    case literal: IntLiteral => IntLiteral(value % literal.value)
    case _ => throw new BinaryOperationException("%")
  }

  override def >(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value > literal.value)
    case _ => throw new BinaryOperationException(">")
  }

  override def <(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value < literal.value)
    case _ => throw new BinaryOperationException("<")
  }

  override def >=(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value >= literal.value)
    case _ => throw new BinaryOperationException(">=")
  }

  override def <=(literal: Literal): Literal = literal match {
    case literal: IntLiteral => BoolLiteral(value <= literal.value)
    case _ => throw new BinaryOperationException("<=")
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
    case _ => throw new BinaryOperationException(">")
  }

  override def <(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value < literal.value)
    case _ => throw new BinaryOperationException("<")
  }

  override def >=(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value >= literal.value)
    case _ => throw new BinaryOperationException(">=")
  }

  override def <=(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value <= literal.value)
    case _ => throw new BinaryOperationException("<=")
  }

  override def !=(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value != literal.value)
    case _ => throw new BinaryOperationException("!=")
  }

  override def ==(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value == literal.value)
    case _ => throw new BinaryOperationException("==")
  }

  override def &&(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value && literal.value)
    case _ => throw new BinaryOperationException("&&")
  }

  override def ||(literal: Literal): Literal = literal match {
    case literal: BoolLiteral => BoolLiteral(value || literal.value)
    case _ => throw new BinaryOperationException("||")
  }

  override def toString: String = value.toString
}

class BinaryOperationException(operation: String)
  extends Exception("An operation " + operation + " is not supported for given types")