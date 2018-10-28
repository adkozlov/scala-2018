package ru.hse.scala

trait CalculatorNumber {
  def add(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def sub(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def div(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def mult(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def mod(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def or(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def and(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def eq(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def neq(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def greater(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def less(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def ge(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def le(right: CalculatorNumber): CalculatorNumber = throw new UnsupportedOperationException

  def toInt: Int = throw new UnsupportedOperationException

  def toDouble: Double = throw new UnsupportedOperationException

  def toBoolean: Boolean = throw new UnsupportedOperationException

  def getValue: AnyVal = throw new UnsupportedOperationException

  def evaluate(op : String, right : CalculatorNumber) : CalculatorNumber = op match {
    case "+" => add(right)
    case "-" => sub(right)
    case "*" => mult(right)
    case "/" => div(right)
    case "%" => mod(right)
    case "&&" => and(right)
    case "||" => or(right)
    case "==" => eq(right)
    case "!=" => neq(right)
    case "<" => less(right)
    case ">" => greater(right)
    case "<=" => le(right)
    case ">=" => ge(right)
    case _ => throw new UnsupportedOperationException("Unknown operation")
  }
}

case class DoubleNumber(private val value: Double) extends CalculatorNumber {
  override def add(right: CalculatorNumber): CalculatorNumber = DoubleNumber(value + right.toDouble)

  override def sub(right: CalculatorNumber): CalculatorNumber = DoubleNumber(value - right.toDouble)

  override def div(right: CalculatorNumber): CalculatorNumber = DoubleNumber(value / right.toDouble)

  override def mult(right: CalculatorNumber): CalculatorNumber = DoubleNumber(value * right.toDouble)

  override def eq(right: CalculatorNumber): CalculatorNumber = BoolNumber(value.equals(right.toDouble))

  override def neq(right: CalculatorNumber): CalculatorNumber = BoolNumber(! eq(right).toBoolean)

  override def greater(right: CalculatorNumber): CalculatorNumber = BoolNumber(value > right.toDouble)

  override def less(right: CalculatorNumber): CalculatorNumber = BoolNumber(value < right.toDouble)

  override def ge(right: CalculatorNumber): CalculatorNumber = BoolNumber(value >= right.toDouble)

  override def le(right: CalculatorNumber): CalculatorNumber = BoolNumber(value <= right.toDouble)

  override def toDouble: Double = value

  override def getValue: AnyVal = value
}


case class IntNumber(private val value: Int) extends CalculatorNumber {
  override def add(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => DoubleNumber(value + right.toDouble)
    case _ => IntNumber(value + right.toInt)
  }

  override def sub(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => DoubleNumber(value - right.toDouble)
    case _ => IntNumber(value - right.toInt)
  }

  override def div(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => DoubleNumber(value / right.toDouble)
    case _ => IntNumber(value / right.toInt)
  }

  override def mult(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => DoubleNumber(value * right.toDouble)
    case _ => IntNumber(value * right.toInt)
  }

  override def mod(right: CalculatorNumber): CalculatorNumber = IntNumber(value % right.toInt)

  override def eq(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => right.eq(this)
    case _ => BoolNumber(value == right.toInt)
  }

  override def neq(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => right.neq(this)
    case _ => BoolNumber(value != right.toInt)
  }

  override def greater(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => right.less(this)
    case _ => BoolNumber(value > right.toInt)
  }

  override def less(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => right.greater(this)
    case _ => BoolNumber(value < right.toInt)
  }

  override def ge(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => right.le(this)
    case _ => BoolNumber(value >= right.toInt)
  }

  override def le(right: CalculatorNumber): CalculatorNumber = right match {
    case DoubleNumber(_) => right.ge(this)
    case _ => BoolNumber(value <= right.toInt)
  }

  override def toInt: Int = value

  override def toDouble: Double = value.toDouble

  override def getValue: AnyVal = value
}

case class BoolNumber(private val value: Boolean) extends CalculatorNumber {
  override def eq(right: CalculatorNumber): CalculatorNumber = BoolNumber(value == right.toBoolean)

  override def neq(right: CalculatorNumber): CalculatorNumber = BoolNumber(value != right.toBoolean)

  override def or(right: CalculatorNumber): CalculatorNumber = BoolNumber(value || right.toBoolean)

  override def and(right: CalculatorNumber): CalculatorNumber = BoolNumber(value && right.toBoolean)

  override def toBoolean: Boolean = value

  override def getValue: AnyVal = value
}

