package ru.hse.spb

object OpMatcher {
  def matchIntOp(op: String): IntBinaryOperator = op match {
      case "+" => PLUS
      case "-" => MINUS
      case "*" => MULT
      case "/" => DIV
      case "%" => MOD
  }

  def matchBoolOp(op: String): BoolBinaryOperator = op match {
      case "&&" => AND
      case "||" => OR
      case "<" => LT
      case ">" => GT
      case "<=" => LEQ
      case ">=" => GEQ
      case "==" => EQ
      case "!=" => NEQ
  }
}
