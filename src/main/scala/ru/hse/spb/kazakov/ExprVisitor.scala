package ru.hse.spb.kazakov

class ExprVisitor extends ExprGrammarBaseVisitor[Int] {
  override def visitParse(ctx: ExprGrammarParser.ParseContext): Int = ctx.expression.accept(this)

  override def visitExpression(ctx: ExprGrammarParser.ExpressionContext): Int = {
    if (ctx.NUMBER != null) {
      return ctx.NUMBER.getText.toInt
    }
    if (ctx.BOOL_LITERAL != null) {
      return if (ctx.BOOL_LITERAL.getText == "true") 1 else 0
    }
    if (ctx.inner != null) {
      return ctx.inner.accept(this)
    }

    val left = ctx.left.accept(this)
    val right = ctx.right.accept(this)
    val operator = ctx.operator.getText
    OperatorsUtils.evaluate(left, right, operator)
  }
}
