package org.ifmo.calculator.stack.elements

trait Operation[T, V] extends StackElement {
  /**
    * @return lambda representing operation in scala
    */
  def toFun: (T, T) => V
}

sealed trait ArithmeticOperation extends Operation[Long, Long] {
  override def toFun: (Long, Long) => Long = this match {
    case Operation.Plu => _ + _
    case Operation.Min => _ - _
    case Operation.Mult => _ * _
    case Operation.Div => _ / _
    case Operation.Mod => _ % _
  }
}

sealed trait ComparisonOperation extends Operation[Long, Boolean] {
  override def toFun: (Long, Long) => Boolean = this match {
    case Operation.Equal => _ == _
    case Operation.NotEqual => _ != _
    case Operation.Greater => _ > _
    case Operation.Grequal => _ >= _
    case Operation.Less => _ < _
    case Operation.Lequal => _ <= _
  }

}

sealed trait BoolOperation extends Operation[Boolean, Boolean] {
  override def toFun: (Boolean, Boolean) => Boolean = this match {
    case Operation.And => _ && _
    case Operation.Or => _ || _
  }
}

object Operation {

  /** Arithmetic **/
  object Plu extends ArithmeticOperation

  object Min extends ArithmeticOperation

  object Mult extends ArithmeticOperation

  object Div extends ArithmeticOperation

  object Mod extends ArithmeticOperation

  /** Compare  **/
  object Equal extends ComparisonOperation

  object NotEqual extends ComparisonOperation

  object Greater extends ComparisonOperation

  object Grequal extends ComparisonOperation

  object Less extends ComparisonOperation

  object Lequal extends ComparisonOperation

  /** Boolean  **/
  object And extends BoolOperation

  object Or extends BoolOperation


  def parseArithmetic(operation: String): ArithmeticOperation = operation match {
    case "+" => Operation.Plu
    case "-" => Operation.Min
    case "/" => Operation.Div
    case "%" => Operation.Mod
    case "*" => Operation.Mult
    case _ => throw new IllegalArgumentException(s"$operation is not arithmetic operator")
  }

  def parseComparison(operation: String): ComparisonOperation = operation match {
    case "==" => Operation.Equal
    case "!=" => Operation.NotEqual
    case ">" => Operation.Greater
    case ">=" => Operation.Grequal
    case "<" => Operation.Less
    case "<=" => Operation.Lequal
    case _ => throw new IllegalArgumentException(s"$operation is not comparison operator")
  }

  def parseBoolean(operation: String): BoolOperation = operation match {
    case "&&" => Operation.And
    case "||" => Operation.Or
    case _ => throw new IllegalArgumentException(s"$operation is not boolean operator")
  }

}
