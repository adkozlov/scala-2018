package ru.hse.spb.kazakov

object OperatorsUtils {

  private implicit class IntBool(val n: Int) {
    def toBoolean: Boolean = n != 0
  }

  private implicit def toInt(b: Boolean): Int = if (b) 1 else 0

  def evaluate(left: Int, right: Int, operator: String): Int = operator match {
    case "*"  => left * right
    case "/"  => left / right
    case "%"  => left % right
    case "+"  => left + right
    case "-"  => left - right
    case "<"  => (left < right).toInt
    case "<=" => (left <= right).toInt
    case ">"  => (left > right).toInt
    case ">=" => (left >= right).toInt
    case "==" => (left == right).toInt
    case "!=" => (left != right).toInt
    case "&&" => (left.toBoolean && right.toBoolean).toInt
    case "||" => (left.toBoolean || right.toBoolean).toInt
  }
}
