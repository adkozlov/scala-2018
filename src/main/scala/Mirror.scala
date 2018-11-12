import antlr.CalculatorParser._
import antlr.CalculatorBaseVisitor
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.RuleNode

object Mirror extends CalculatorBaseVisitor[String] with ExprEvaluter {
  private def toString(leftValue: String, operator: String, rightValue: String): String = s"$leftValue $operator $rightValue"

  override def visitChildren(node: RuleNode): String = node match {
    case ctx: ArithmeticExponentExprContext => eval(ctx, this, toString)
    case ctx: ArithmeticPrior2BinaryExprContext => eval(ctx, this, toString)
    case ctx: ArithmeticPrior1BinaryExprContext => eval(ctx, this, toString)
    case ctx: LogicalBinaryExprContext => eval(ctx, this, toString)
    case ctx: LogicalCompareExprContext => eval(ctx, this, toString)
    case ctx: ArithmeticParensExprContext => s"(${ctx.arithm_expr().accept(this)})"
    case ctx: LogicalParensExprContext => s"(${ctx.logic_expr().accept(this)})"
    case ctx: ArithmeticNegativeExprContext => s"-${ctx.arithm_expr().accept(this)}"
    case ctx: LogicNegativeExprContext => s"!${ctx.logic_expr().accept(this)}"
    case _ => super.visitChildren(node)
  }

  override def visitCalculator(ctx: CalculatorContext): String = {
    ctx.children.get(0).accept(this)
  }

  override def visitArithmeticAtomExpr(ctx: ArithmeticAtomExprContext): String =
    ctx.INT().getText

  override def visitLogicalAtomExpr(ctx: LogicalAtomExprContext): String = {
    ctx.BOOL().getText
  }
}