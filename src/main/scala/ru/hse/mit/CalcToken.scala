package ru.hse.mit

sealed trait CalcToken {
  def +(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def -(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def *(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def /(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def %(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def ==(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def !=(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def <=(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def >=(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def <(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def >(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def ||(that: CalcToken): CalcToken = throw new UnsupportedOperationException()

  def &&(that: CalcToken): CalcToken = throw new UnsupportedOperationException()
}

case class IntCalcToken(private val value: Int) extends CalcToken {
  override def +(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => IntCalcToken(value + other)
    case _ => throw new UnsupportedOperationException()
  }

  override def -(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => IntCalcToken(value - other)
    case _ => throw new UnsupportedOperationException()
  }

  override def *(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => IntCalcToken(value * other)
    case _ => throw new UnsupportedOperationException()
  }

  override def /(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => IntCalcToken(value / other)
    case _ => throw new UnsupportedOperationException()
  }

  override def %(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => IntCalcToken(value % other)
    case _ => throw new UnsupportedOperationException()
  }

  override def ==(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => BooleanCalcToken(value == other)
    case _ => throw new UnsupportedOperationException()
  }

  override def !=(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => BooleanCalcToken(value != other)
    case _ => throw new UnsupportedOperationException()
  }

  override def <=(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => BooleanCalcToken(value <= other)
    case _ => throw new UnsupportedOperationException()
  }

  override def >=(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => BooleanCalcToken(value >= other)
    case _ => throw new UnsupportedOperationException()
  }

  override def <(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => BooleanCalcToken(value < other)
    case _ => throw new UnsupportedOperationException()
  }

  override def >(that: CalcToken): CalcToken = that match {
    case IntCalcToken(other) => BooleanCalcToken(value > other)
    case _ => throw new UnsupportedOperationException()
  }

  override def toString: String = value.toString
}


case class BooleanCalcToken(private val value: Boolean) extends CalcToken {
  override def ==(that: CalcToken): CalcToken = that match {
    case BooleanCalcToken(other) => BooleanCalcToken(value == other)
    case _ => throw new UnsupportedOperationException()
  }

  override def !=(that: CalcToken): CalcToken = that match {
    case BooleanCalcToken(other) => BooleanCalcToken(value != other)
    case _ => throw new UnsupportedOperationException()
  }

  override def <=(that: CalcToken): CalcToken = that match {
    case BooleanCalcToken(other) => BooleanCalcToken(value <= other)
    case _ => throw new UnsupportedOperationException()
  }

  override def >=(that: CalcToken): CalcToken = that match {
    case BooleanCalcToken(other) => BooleanCalcToken(value >= other)
    case _ => throw new UnsupportedOperationException()
  }

  override def <(that: CalcToken): CalcToken = that match {
    case BooleanCalcToken(other) => BooleanCalcToken(value < other)
    case _ => throw new UnsupportedOperationException()
  }

  override def >(that: CalcToken): CalcToken = that match {
    case BooleanCalcToken(other) => BooleanCalcToken(value > other)
    case _ => throw new UnsupportedOperationException()
  }

  override def ||(that: CalcToken): CalcToken = that match {
    case BooleanCalcToken(other) => BooleanCalcToken(value || other)
    case _ => throw new UnsupportedOperationException()
  }

  override def &&(that: CalcToken): CalcToken = that match {
    case BooleanCalcToken(other) => BooleanCalcToken(value && other)
    case _ => throw new UnsupportedOperationException()
  }

  override def toString: String = value.toString
}