package ru.spbau.jvm.scala.calculator

class ExpressionEvaluatingVisitor extends ExpressionsBaseVisitor[ExpressionType] {

  private val arithmeticExpressionsVisitor = new ArithmeticExpressionsVisitor()
  private val logicalExpressionsVisitor = new LogicalExpressionsVisitor()

  override def visitExpression(ctx: ExpressionsParser.ExpressionContext): ExpressionType =
    ctx.arithmeticExpression() match {
      case null => BooleanType(ctx.logicalExpression().accept(logicalExpressionsVisitor))
      case expression => DoubleType(expression.accept(arithmeticExpressionsVisitor))
    }
}
