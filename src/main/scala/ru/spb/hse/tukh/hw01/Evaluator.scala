package ru.spb.hse.tukh.hw01

import ru.spb.hse.tukh.hw01.Exception.EvaluatorArithmeticException

class Evaluator extends ExpBaseVisitor[Int] {
  implicit def booleanToInt(value: Boolean): Int = if (value) 1 else 0
  implicit def intToBoolean(value: Int): Boolean = if (value != 0) true else false

  override def visitExpression(ctx: ExpParser.ExpressionContext): Int = {
    if (ctx.boolLiteral != null) {
      ctx.boolLiteral.getText match {
        case "true" => true
        case _ => false
      }
    } else if (ctx.literal != null) {
      Integer.parseInt(ctx.literal.getText)
    } else if (ctx.innerExpression != null) {
      ctx.innerExpression.accept(this)
    } else {
      val leftExpression: Int = ctx.left.accept(this)
      val rightExpression: Int = ctx.right.accept(this)
      val operationLabel: String = ctx.operation.getText

      val intOperation = IntOperations.getOperation(operationLabel)
      if (intOperation != null) {
        try {
          intOperation(leftExpression, rightExpression) match {
            case bool: Boolean => bool
            case default => default.asInstanceOf[Int]
          }
        } catch {
          case arithmeticException: ArithmeticException => throw
            EvaluatorArithmeticException(
              arithmeticException.getMessage,
              arithmeticException.getCause)
        }
      } else {
        val booleanOperation = BooleanOperations.getOperation(operationLabel)
        booleanOperation(leftExpression, rightExpression)
      }
    }
  }
}
