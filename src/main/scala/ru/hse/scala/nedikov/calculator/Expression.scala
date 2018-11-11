package ru.hse.scala.nedikov.calculator

trait Expression


trait BooleanExpression extends Expression {
  def evaluate(): Boolean
}

class BooleanConst(val value: Boolean) extends BooleanExpression {
  override def evaluate(): Boolean = value
}



class BooleanBinop(val operation: String, val left: BooleanExpression, val right: BooleanExpression)
  extends BooleanExpression {
  override def evaluate(): Boolean = operation match {
    case "==" => left.evaluate() == right.evaluate()
    case "!=" => left.evaluate() != right.evaluate()
    case "||" => left.evaluate() || right.evaluate()
    case "&&" => left.evaluate() && right.evaluate()
  }
}


class BooleanCompare(val operation: String, val left: DoubleExpression, val right: DoubleExpression)
  extends BooleanExpression {
  override def evaluate(): Boolean = operation match {
    case "<"  => left.evaluate() < right.evaluate()
    case ">"  => left.evaluate() > right.evaluate()
    case "<=" => left.evaluate() <= right.evaluate()
    case ">=" => left.evaluate() >= right.evaluate()
    case "==" => left.evaluate() == right.evaluate()
    case "!=" => left.evaluate() != right.evaluate()
  }
}

trait DoubleExpression extends Expression {
  def evaluate(): Double
}

class DoubleConst(val value: Double) extends DoubleExpression {
override def evaluate(): Double = value
}

class DoubleBinop(val operation: String, val left: DoubleExpression, val right: DoubleExpression)
  extends DoubleExpression {
  override def evaluate(): Double = operation match {
    case "+" => left.evaluate() + right.evaluate()
    case "-" => left.evaluate() - right.evaluate()
    case "*" => left.evaluate() * right.evaluate()
    case "/" => left.evaluate() / right.evaluate()
  }
}
