import antlr.{CalculatorBaseVisitor, _}
import org.antlr.v4.runtime.ParserRuleContext

object Calculator extends CalculatorBaseVisitor[Any] {
  override def visitCalculator(ctx: CalculatorParser.CalculatorContext): Any = {
    if (ctx.arithm_expr() != null) {
      return ctx.arithm_expr().accept(AritmeticCalculator)
    }
    if (ctx.logic_expr() != null) {
      return ctx.logic_expr().accept(LogicCalculator)
    }
  }
}

private object AritmeticCalculator extends CalculatorBaseVisitor[Int] with ExprEvalutor {
  private def evalArithmeticExpr(x: Int, y: Int, op: String): Int = op match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x / y
    case "%" => x % y
    case "^" => Math.pow(x, y).toInt
  }

  override def visitArithmeticExponentExpr(ctx: CalculatorParser.ArithmeticExponentExprContext): Int = {
    eval(ctx, this, evalArithmeticExpr)
  }

  override def visitArithmeticPrior1BinaryExpr(ctx: CalculatorParser.ArithmeticPrior1BinaryExprContext): Int = {
    eval(ctx, this, evalArithmeticExpr)
  }

  override def visitArithmeticPrior2BinaryExpr(ctx: CalculatorParser.ArithmeticPrior2BinaryExprContext): Int = {
    eval(ctx, this, evalArithmeticExpr)
  }

  override def visitArithmeticParensExpr(ctx: CalculatorParser.ArithmeticParensExprContext): Int = {
    val value = ctx.arithm_expr().accept(this)
    if (ctx.MINUS() == null) value else -value
  }

  override def visitArithmeticAtomExpr(ctx: CalculatorParser.ArithmeticAtomExprContext): Int = {
    val value = ctx.INT().getText.toInt
    if (ctx.MINUS() == null) value else -value
  }
}

private object LogicCalculator extends CalculatorBaseVisitor[Boolean] with ExprEvalutor {
  private def evalCompareExpr(x: Int, y: Int, op: String): Boolean = op match {
    case "<" => x < y
    case ">" => x > y
    case "<=" => x <= y
    case ">=" => x >= y
    case "==" => x == y
    case "!=" => x != y
  }

  private def evalLogicalExpr(x: Boolean, y: Boolean, op: String): Boolean = op match {
    case "&&" => x && y
    case "||" => x || y
    case "^^" => x ^ y
  }


  override def visitLogicalCompareExpr(ctx: CalculatorParser.LogicalCompareExprContext): Boolean = {
    eval(ctx, AritmeticCalculator, evalCompareExpr)
  }

  override def visitLogicalBinaryExpr(ctx: CalculatorParser.LogicalBinaryExprContext): Boolean = {
    eval(ctx, this, evalLogicalExpr)
  }

  override def visitLogicalParensExpr(ctx: CalculatorParser.LogicalParensExprContext): Boolean = {
    val value = ctx.logic_expr().accept(this)
    if (ctx.NOT() == null) value else !value
  }

  override def visitLogicalAtomExpr(ctx: CalculatorParser.LogicalAtomExprContext): Boolean = {
    val value = ctx.BOOL().getText.toBoolean
    if (ctx.NOT() == null) value else !value
  }
}

private trait ExprEvalutor {
  def eval[A, B](ctx: ParserRuleContext, visitor: CalculatorBaseVisitor[A], evalFunction: (A, A, String) => B): B = {
    val lvalue = ctx.children.get(0).accept(visitor)
    val op = ctx.children.get(1).getText
    val rvalue = ctx.children.get(2).accept(visitor)
    evalFunction(lvalue, rvalue, op)
  }
}