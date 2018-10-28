package ru.hse.spb

object Evaluator {
  def evaluate(expression: Expression): Literal = expression match {
      case expression: Literal => expression
      case expression: BoolBinaryExpression => applyBoolOperator(
          evaluate(expression.left),
          expression.op,
          evaluate(expression.right)
      )
      case expression: IntBinaryExpression => applyIntOperator(
        evaluate(expression.left),
        expression.op,
        evaluate(expression.right)
      )
  }

  private def applyBoolOperator(left: Literal, operator: BoolBinaryOperator, right: Literal): Literal = {
      BoolLiteral(operator.evaluate(left.asInt(), right.asInt()))
  }

  private def applyIntOperator(left: Literal, operator: IntBinaryOperator, right: Literal): Literal = {
      IntLiteral(operator.evaluate(left.asInt(), right.asInt()))
  }
}
