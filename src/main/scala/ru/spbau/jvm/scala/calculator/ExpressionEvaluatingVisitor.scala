package ru.spbau.jvm.scala.calculator

class ExpressionEvaluatingVisitor extends ExpressionsBaseVisitor[Either[Double, Boolean]] {

  val arithmeticExpressionsVisitor = new ArithmeticExpressionsVisitor()
  val logicalExpressionsVisitor = new LogicalExpressionsVisitor()

  override def visitExpression(ctx: ExpressionsParser.ExpressionContext): Either[Double, Boolean] =
    if (ctx.arithmeticExpression() != null) {
      Left(ctx.arithmeticExpression().accept(arithmeticExpressionsVisitor))
    } else {
      Right(ctx.logicalExpression().accept(logicalExpressionsVisitor))
    }
}
