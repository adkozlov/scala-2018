package ru.hse

sealed trait Value {

  def +(other: Value): Value = throw new BinaryOperationException("+")

  def -(other: Value): Value = throw new BinaryOperationException("-")

  def /(other: Value): Value = throw new BinaryOperationException("/")

  def *(other: Value): Value = throw new BinaryOperationException("*")

  def %(other: Value): Value = throw new BinaryOperationException("%")

  def >(other: Value): Value = throw new BinaryOperationException(">")

  def <(other: Value): Value = throw new BinaryOperationException("<")

  def >=(other: Value): Value = throw new BinaryOperationException(">=")

  def <=(other: Value): Value = throw new BinaryOperationException("<=")

  def !=(other: Value): Value = throw new BinaryOperationException("!=")

  def ==(other: Value): Value = throw new BinaryOperationException("==")

  def &&(other: Value): Value = throw new BinaryOperationException("&&")

  def ||(other: Value): Value = throw new BinaryOperationException("||")
}

case class IntValue(value: Int) extends Value {
  override def +(other: Value): Value = other match {
    case IntValue(otherValue) => IntValue(value + otherValue)
    case _ => throw new BinaryOperationException("+")
  }

  override def -(other: Value): Value = other match {
    case IntValue(otherValue) => IntValue(value - otherValue)
    case _ => throw new BinaryOperationException("-")
  }

  override def /(other: Value): Value = other match {
    case IntValue(otherValue) => IntValue(value / otherValue)
    case _ => throw new BinaryOperationException("/")
  }

  override def *(other: Value): Value = other match {
    case IntValue(otherValue) => IntValue(value * otherValue)
    case _ => throw new BinaryOperationException("*")
  }

  override def %(other: Value): Value = other match {
    case IntValue(otherValue) => IntValue(value % otherValue)
    case _ => throw new BinaryOperationException("%")
  }

  override def >(other: Value): Value = other match {
    case IntValue(otherValue) => BoolValue(value > otherValue)
    case _ => throw new BinaryOperationException(">")
  }

  override def <(other: Value): Value = other match {
    case IntValue(otherValue) => BoolValue(value < otherValue)
    case _ => throw new BinaryOperationException("<")
  }

  override def >=(other: Value): Value = other match {
    case IntValue(otherValue) => BoolValue(value >= otherValue)
    case _ => throw new BinaryOperationException(">=")
  }

  override def <=(other: Value): Value = other match {
    case IntValue(otherValue) => BoolValue(value <= otherValue)
    case _ => throw new BinaryOperationException("<=")
  }

  override def !=(other: Value): Value = other match {
    case IntValue(otherValue) => BoolValue(value != otherValue)
    case _ => BoolValue(true)
  }

  override def ==(other: Value): Value = other match {
    case IntValue(otherValue) => BoolValue(value == otherValue)
    case _ => BoolValue(false)
  }

  override def toString: String = value.toString
}

case class BoolValue(value: Boolean) extends Value {
  override def >(other: Value): Value = other match {
    case BoolValue(otherValue) => BoolValue(value > otherValue)
    case _ => throw new BinaryOperationException(">")
  }

  override def <(other: Value): Value = other match {
    case BoolValue(otherValue) => BoolValue(value < otherValue)
    case _ => throw new BinaryOperationException("<")
  }

  override def >=(other: Value): Value = other match {
    case BoolValue(otherValue) => BoolValue(value >= otherValue)
    case _ => throw new BinaryOperationException(">=")
  }

  override def <=(other: Value): Value = other match {
    case BoolValue(otherValue) => BoolValue(value <= otherValue)
    case _ => throw new BinaryOperationException("<=")
  }

  override def !=(other: Value): Value = other match {
    case BoolValue(otherValue) => BoolValue(value != otherValue)
    case _ => throw new BinaryOperationException("!=")
  }

  override def ==(other: Value): Value = other match {
    case BoolValue(otherValue) => BoolValue(value == otherValue)
    case _ => throw new BinaryOperationException("==")
  }

  override def &&(other: Value): Value = other match {
    case BoolValue(otherValue) => BoolValue(value && otherValue)
    case _ => throw new BinaryOperationException("&&")
  }

  override def ||(other: Value): Value = other match {
    case BoolValue(otherValue) => BoolValue(value || otherValue)
    case _ => throw new BinaryOperationException("||")
  }

  override def toString: String = value.toString
}

class BinaryOperationException(operation: String)
  extends Exception("An operation " + operation + " is not supported for given types")