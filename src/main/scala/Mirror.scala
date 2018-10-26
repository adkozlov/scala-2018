import antlr.{CalculatorBaseVisitor, CalculatorParser}
import org.antlr.v4.runtime.ParserRuleContext

object Mirror extends CalculatorBaseVisitor[String] {
  private def exprToString(ctx: ParserRuleContext) : String = {
    s"${ctx.children.get(0).accept(this)} ${ctx.children.get(1).getText} ${ctx.children.get(2).accept(this)}"
  }

  override def visitCalculator(ctx: CalculatorParser.CalculatorContext): String = {
    ctx.children.get(0).accept(this)
  }

  override def visitArithmeticExponentExpr(ctx: CalculatorParser.ArithmeticExponentExprContext): String = {
    exprToString(ctx)
  }

  override def visitArithmeticPrior1BinaryExpr(ctx: CalculatorParser.ArithmeticPrior1BinaryExprContext): String = {
    exprToString(ctx)
  }

  override def visitArithmeticPrior2BinaryExpr(ctx: CalculatorParser.ArithmeticPrior2BinaryExprContext): String = {
    exprToString(ctx)
  }

  override def visitArithmeticParensExpr(ctx: CalculatorParser.ArithmeticParensExprContext): String = {
    val not = if (ctx.MINUS() != null) {"-"} else {""}
    not + s"(${ctx.arithm_expr().accept(this)})"
  }

  override def visitArithmeticAtomExpr(ctx: CalculatorParser.ArithmeticAtomExprContext): String = {
    val not = if (ctx.MINUS() != null) {"-"} else {""}
    not + ctx.INT().getText
  }

  override def visitLogicalCompareExpr(ctx: CalculatorParser.LogicalCompareExprContext): String = {
    exprToString(ctx)
  }

  override def visitLogicalBinaryExpr(ctx: CalculatorParser.LogicalBinaryExprContext): String = {
    exprToString(ctx)
  }

  override def visitLogicalParensExpr(ctx: CalculatorParser.LogicalParensExprContext): String = {
    val not = if (ctx.NOT() != null) {"!"} else {""}
    not + s"(${ctx.logic_expr().accept(this)})"
  }

  override def visitLogicalAtomExpr(ctx: CalculatorParser.LogicalAtomExprContext): String = {
    val not = if (ctx.NOT() != null) {"!"} else {""}
    not + ctx.BOOL().getText
  }
}