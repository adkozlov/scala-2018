import ru.hse.expression.{ExpressionBaseVisitor, ExpressionParser}

class ExpressionVisitor extends ExpressionBaseVisitor[ExpressionNode] {
  override def visitExpression(ctx: ExpressionParser.ExpressionContext): ExpressionNode = {
    if (ctx.num != null) {
      return new ArithmeticExpression(ctx.num.getText.toInt)
    }
    if (ctx.bool != null) {
      val value = ctx.bool.getText match {
        case "true" => true
        case "false" => false
        case _ => throw new AssertionError("Should never happen: boolean value is neither true nor false")
      }
      return new BooleanExpression(value)
    }
    if (ctx.innerExpression != null) {
      return ctx.innerExpression.accept(this)
    }
    if (ctx.left != null && ctx.op != null && ctx.right != null) {
      val operator = Operator.createOperator(ctx.op.getText)
      operator match {
        case _: ArithmeticOperator =>
          return new
              ArithmeticExpression(
                ctx.left.accept(this),
                operator.asInstanceOf[ArithmeticOperator],
                ctx.right.accept(this))
        case _: BooleanOperator =>
          return new
              BooleanExpression(
                ctx.left.accept(this),
                operator.asInstanceOf[BooleanOperator],
                ctx.right.accept(this))

        case _ => throw new IllegalStateException(s"Unknown type for operator: ${operator.operator}")
      }
    }
    throw new IllegalStateException("Unknown expression type.")
  }
}

