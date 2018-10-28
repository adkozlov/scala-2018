package ru.hse.spb

import ru.hse.spb.CalcParser._

object AntlrMapper {
  def map(ctx: ExpressionContext): Expression = ctx match {
      case ctx: IntegerLiteralContext => IntLiteral(ctx.IntLiteral().getText.toInt)
      case ctx: BooleanLiteralContext => BoolLiteral(ctx.BoolLiteral().getText.toBoolean)
      case ctx: SurroundedExpressionContext => map(ctx.expression())
      case ctx: BoolBinaryOperationContext => BoolBinaryExpression(
          map(ctx.left),
          OpMatcher.matchBoolOp(ctx.op.getText),
          map(ctx.right)
      )

      case ctx: IntBinaryOperationContext => IntBinaryExpression(
          map(ctx.left),
          OpMatcher.matchIntOp(ctx.op.getText),
          map(ctx.right)
      )
  }
}
