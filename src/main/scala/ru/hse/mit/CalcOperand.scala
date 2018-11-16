package ru.hse.mit

sealed trait CalcOperand {
  def +(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def -(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def *(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def /(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def %(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def ==(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def !=(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def <=(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def >=(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def <(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def >(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def ||(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()

  def &&(that: CalcOperand): CalcOperand = throw new UnsupportedOperationException()
}

case class IntCalcOperand(private val value: Int) extends CalcOperand {
  override def +(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => IntCalcOperand(value + other)
    case _ => throw new UnsupportedOperationException()
  }

  override def -(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => IntCalcOperand(value - other)
    case _ => throw new UnsupportedOperationException()
  }

  override def *(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => IntCalcOperand(value * other)
    case _ => throw new UnsupportedOperationException()
  }

  override def /(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => IntCalcOperand(value / other)
    case _ => throw new UnsupportedOperationException()
  }

  override def %(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => IntCalcOperand(value % other)
    case _ => throw new UnsupportedOperationException()
  }

  override def ==(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => BooleanCalcOperand(value == other)
    case _ => throw new UnsupportedOperationException()
  }

  override def !=(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => BooleanCalcOperand(value != other)
    case _ => throw new UnsupportedOperationException()
  }

  override def <=(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => BooleanCalcOperand(value <= other)
    case _ => throw new UnsupportedOperationException()
  }

  override def >=(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => BooleanCalcOperand(value >= other)
    case _ => throw new UnsupportedOperationException()
  }

  override def <(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => BooleanCalcOperand(value < other)
    case _ => throw new UnsupportedOperationException()
  }

  override def >(that: CalcOperand): CalcOperand = that match {
    case IntCalcOperand(other) => BooleanCalcOperand(value > other)
    case _ => throw new UnsupportedOperationException()
  }

  override def toString: String = value.toString
}


case class BooleanCalcOperand(private val value: Boolean) extends CalcOperand {
  override def ==(that: CalcOperand): CalcOperand = that match {
    case BooleanCalcOperand(other) => BooleanCalcOperand(value == other)
    case _ => throw new UnsupportedOperationException()
  }

  override def !=(that: CalcOperand): CalcOperand = that match {
    case BooleanCalcOperand(other) => BooleanCalcOperand(value != other)
    case _ => throw new UnsupportedOperationException()
  }

  override def <=(that: CalcOperand): CalcOperand = that match {
    case BooleanCalcOperand(other) => BooleanCalcOperand(value <= other)
    case _ => throw new UnsupportedOperationException()
  }

  override def >=(that: CalcOperand): CalcOperand = that match {
    case BooleanCalcOperand(other) => BooleanCalcOperand(value >= other)
    case _ => throw new UnsupportedOperationException()
  }

  override def <(that: CalcOperand): CalcOperand = that match {
    case BooleanCalcOperand(other) => BooleanCalcOperand(value < other)
    case _ => throw new UnsupportedOperationException()
  }

  override def >(that: CalcOperand): CalcOperand = that match {
    case BooleanCalcOperand(other) => BooleanCalcOperand(value > other)
    case _ => throw new UnsupportedOperationException()
  }

  override def ||(that: CalcOperand): CalcOperand = that match {
    case BooleanCalcOperand(other) => BooleanCalcOperand(value || other)
    case _ => throw new UnsupportedOperationException()
  }

  override def &&(that: CalcOperand): CalcOperand = that match {
    case BooleanCalcOperand(other) => BooleanCalcOperand(value && other)
    case _ => throw new UnsupportedOperationException()
  }

  override def toString: String = value.toString
}