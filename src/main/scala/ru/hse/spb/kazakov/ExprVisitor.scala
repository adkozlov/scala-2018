package ru.hse.spb.kazakov

object ExprVisitor extends ExprGrammarBaseVisitor[AnyVal] {
  override def visitArithmetic(ctx: ExprGrammarParser.ArithmeticContext): Int = {
    ctx.arithmeticExpression().accept(ArithmeticVisitor)
  }

  override def visitBoolean(ctx: ExprGrammarParser.BooleanContext): Boolean = {
    ctx.booleanExpression().accept(BooleanVisitor)
  }
}
