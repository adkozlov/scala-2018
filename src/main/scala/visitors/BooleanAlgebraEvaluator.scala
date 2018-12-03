package visitors

import grammar.BooleanAlgebraBaseVisitor
import grammar.BooleanAlgebraParser._
import org.antlr.v4.runtime.ParserRuleContext

object BooleanAlgebraEvaluator extends BooleanAlgebraBaseVisitor[Boolean] {
  override def visitBooleanLiteral(ctx: BooleanLiteralContext): Boolean =
    ctx.literal.getType match {
      case FALSE => false
      case TRUE => true
      case _ => throw new IllegalStateException(s"Unknown literal for boolean algebra: ${ctx.literal}")
    }

  override def visitUnaryNegation(ctx: UnaryNegationContext): Boolean =
    !ctx.value.accept(this)

  override def visitBinaryDisjunction(ctx: BinaryDisjunctionContext): Boolean =
    ctx.left.accept(this) || acceptIfNotNull(ctx.right, default = false)

  override def visitBinaryConjunction(ctx: BinaryConjunctionContext): Boolean =
    ctx.left.accept(this) && acceptIfNotNull(ctx.right, default = true)

  private def acceptIfNotNull(ctx: ParserRuleContext, default: Boolean): Boolean =
    if (ctx == null) default else ctx.accept(this)
}
