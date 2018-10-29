import java.io.OutputStream

trait AstNode {
  val elementName: String
  def print(out: OutputStream): Unit = {
    out.write(elementName.toCharArray.map(_.toByte))
    out.write('{'.toByte)
    printContents(out)
    out.write('}'.toByte)
  }

  def printContents(out: OutputStream): Unit
}

trait ExpressionNode extends AstNode {
  def eval: Int
  def getResult: String
}


class BooleanExpression extends ExpressionNode {
  override val elementName: String = "booleanExpression"
  private var evaluator: () => Int = _
  private var contentsPrinter: OutputStream => Unit = _

  def this(boolean: Boolean) {
    this()
    evaluator = () => { if (boolean) 1 else 0 }
    contentsPrinter = (out:OutputStream) => {
      val content: String = BooleanExpression.booleanString(evaluator())
      out.write(content.toCharArray.map(_.toByte))
    }
  }

  def this(left: ExpressionNode, op: BooleanOperator, right: ExpressionNode) {
    this()
    evaluator = () => { op.evaluator(left.eval, right.eval)}
    contentsPrinter = (out:OutputStream) => {
      left.print(out)
      out.write(op.operator.toCharArray.map(_.toByte))
      right.print(out)
    }
  }

  override def eval: Int = evaluator()
  override def getResult: String = BooleanExpression.booleanString(eval)
  override def printContents(out: OutputStream): Unit = contentsPrinter(out)
}

object BooleanExpression {
  private def booleanString(value: Int): String = if (value == 0) "false" else "true"
}

class ArithmeticExpression extends ExpressionNode {
  override val elementName: String = "arithmeticExpression"
  private var evaluator: () => Int = _
  private var contentsPrinter: OutputStream => Unit = _

  def this(num: Int) {
    this()
    evaluator = () => { num }
    contentsPrinter = (out:OutputStream) => { out.write(num) }
  }

  def this(left: ExpressionNode, op: ArithmeticOperator, right: ExpressionNode) {
    this()
    evaluator = () => { op.evaluator(left.eval, right.eval)}
    contentsPrinter = (out:OutputStream) => {
      left.print(out)
      out.write(op.operator.toCharArray.map(_.toByte))
      right.print(out)
    }
  }

  override def eval: Int = evaluator()
  override def getResult: String = eval.toString
  override def printContents(out: OutputStream): Unit = contentsPrinter(out)
}

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
