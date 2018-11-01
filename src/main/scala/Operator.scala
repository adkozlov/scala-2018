sealed abstract class Operator(val operator: String, val evaluator: (Int, Int) => Int)
sealed abstract class BooleanOperator(override val operator: String, override val evaluator: (Int, Int) => Int)
  extends Operator(operator, evaluator)
sealed abstract class ArithmeticOperator(override val operator: String, override val evaluator: (Int, Int) => Int)
  extends Operator(operator, evaluator)
case object MUL extends ArithmeticOperator("*", (a: Int, b: Int) => {a * b})
case object DIV extends ArithmeticOperator("/", (a: Int, b: Int) => {a / b})
case object MOD extends ArithmeticOperator("%", (a: Int, b: Int) => {a % b})
case object PLUS extends ArithmeticOperator("+", (a: Int, b: Int) => {a + b})
case object MINUS extends ArithmeticOperator("-", (a: Int, b: Int) => {a - b})
case object LESS_THAN extends BooleanOperator("<", (a: Int, b: Int) => { if (a < b) 1 else 0 })
case object GREATER_THAN extends BooleanOperator(">", (a: Int, b: Int) => { if (a > b) 1 else 0 })
case object LE extends BooleanOperator("<=", (a: Int, b: Int) => { if (a <= b) 1 else 0 })
case object GE extends BooleanOperator(">=", (a: Int, b: Int) => { if (a >= b) 1 else 0 })
case object EQ extends BooleanOperator("==", (a: Int, b: Int) => { if (a == b) 1 else 0 })
case object NEQ extends BooleanOperator("!=", (a: Int, b: Int) => { if (a != b) 1 else 0 })
case object AND extends BooleanOperator("&&", (a: Int, b: Int) => { if (a != 0 && b != 0) 1 else 0 })
case object OR extends BooleanOperator("||", (a: Int, b: Int) => { if (a != 0 || b != 0) 1 else 0 })

object Operator {
  def createOperator(string: String): Operator = {
    string match {
      case "*" => MUL
      case "/" => DIV
      case "%" => MOD
      case "+" => PLUS
      case "-" => MINUS
      case "<" => LESS_THAN
      case ">" => GREATER_THAN
      case "<=" => LE
      case ">=" => GE
      case "==" => EQ
      case "!=" => NEQ
      case "&&" => AND
      case "||" => OR
      case _ => throw new IllegalArgumentException(s"Unknown operator string: $string")
    }
  }
}
