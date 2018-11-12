import antlr.CalculatorParser._
import antlr.{CalculatorBaseVisitor, _}
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.RuleNode

object Calculator extends CalculatorBaseVisitor[AnyVal] {
  override def visitCalculator(ctx: CalculatorContext): AnyVal = ctx.children.get(0) match {
    case child: Arithm_exprContext => child.accept(AritmeticCalculator)
    case child: Logic_exprContext => child.accept(LogicCalculator)
  }
}

private object AritmeticCalculator extends CalculatorBaseVisitor[Int] with ExprEvaluter {
  private def evalArithmeticExpr(leftValue: Int, operator: String, rightValue: Int): Int = operator match {
    case "+" => leftValue + rightValue
    case "-" => leftValue - rightValue
    case "*" => leftValue * rightValue
    case "/" => leftValue / rightValue
    case "%" => leftValue % rightValue
    case "^" => Math.pow(leftValue, rightValue).toInt
  }

  private def visitBinaryExpr(ctx: Arithm_exprContext): Int = eval(ctx, this, evalArithmeticExpr)

  override def visitChildren(node: RuleNode): Int = node match {
    case ctx: ArithmeticExponentExprContext => visitBinaryExpr(ctx)
    case ctx: ArithmeticPrior2BinaryExprContext => visitBinaryExpr(ctx)
    case ctx: ArithmeticPrior1BinaryExprContext => visitBinaryExpr(ctx)
    case _ => super.visitChildren(node)
  }

  override def visitArithmeticNegativeExpr(ctx: ArithmeticNegativeExprContext): Int =
    -ctx.arithm_expr().accept(this)

  override def visitArithmeticParensExpr(ctx: ArithmeticParensExprContext): Int =
    ctx.arithm_expr().accept(this)

  override def visitArithmeticAtomExpr(ctx: ArithmeticAtomExprContext): Int =
    ctx.INT().getText.toInt
}

private object LogicCalculator extends CalculatorBaseVisitor[Boolean] with ExprEvaluter {
  private def evalCompareExpr(leftValue: Int, operator: String, rightValue: Int): Boolean = operator match {
    case "<" => leftValue < rightValue
    case ">" => leftValue > rightValue
    case "<=" => leftValue <= rightValue
    case ">=" => leftValue >= rightValue
    case "==" => leftValue == rightValue
    case "!=" => leftValue != rightValue
  }

  private def evalLogicalExpr(leftValue: Boolean, operator: String, rightValue: Boolean): Boolean = operator match {
    case "&&" => leftValue && rightValue
    case "||" => leftValue || rightValue
    case "^^" => leftValue ^ rightValue
  }

  override def visitLogicNegativeExpr(ctx: LogicNegativeExprContext): Boolean =
    !ctx.logic_expr().accept(this)

  override def visitLogicalCompareExpr(ctx: LogicalCompareExprContext): Boolean =
    eval(ctx, AritmeticCalculator, evalCompareExpr)


  override def visitLogicalBinaryExpr(ctx: LogicalBinaryExprContext): Boolean =
    eval(ctx, this, evalLogicalExpr)

  override def visitLogicalParensExpr(ctx: LogicalParensExprContext): Boolean =
    ctx.logic_expr().accept(this)

  override def visitLogicalAtomExpr(ctx: LogicalAtomExprContext): Boolean =
    ctx.BOOL().getText.toBoolean

}

object Index extends Enumeration {
  val leftValue, operator, rightValue = Value
}

trait ExprEvaluter {
  def eval[A, B](ctx: ParserRuleContext, visitor: CalculatorBaseVisitor[A], evalFunction: (A, String, A) => B): B = {
    val lvalue = ctx.children.get(Index.leftValue.id).accept(visitor)
    val op = ctx.children.get(Index.operator.id).getText
    val rvalue = ctx.children.get(Index.rightValue.id).accept(visitor)
    evalFunction(lvalue, op, rvalue)
  }
}