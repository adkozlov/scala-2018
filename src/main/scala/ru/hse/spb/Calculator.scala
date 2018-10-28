package ru.hse.spb

class Calculator() extends ExpBaseVisitor[Int] {
  override def visitExpression(ctx: ExpParser.ExpressionContext): Int = {
    if (ctx.Literal() != null) {
      ctx.Literal().getText match {
        case "true" => return 1
        case "false" => return 0
        case integer => return integer.toInt
      }
    }

    if (ctx.expression().size == 1) {
      if (ctx.operation == null) {
        return visitExpression(ctx.expression(0))
      }
      ctx.operation.getText match {
        case "-" => return - visit(ctx.expression(0))
        case "!" => return toNumber(visit(ctx.expression(0)) == 0)
      }
      throw new UnsupportedOperationException()
    }
    if (ctx.expression().size == 2) {
      val left = visit(ctx.expression(0))
      val right = visit(ctx.expression(1))
       ctx.operation.getText match {
        case "+" => return left + right
        case "-" => return left - right
        case "*" => return left * right
        case "/" => return left / right
        case "%" => return left % right
        case ">" => return toNumber(left > right)
        case  "<" => return toNumber(left < right)
        case ">=" => return toNumber(left >= right)
        case  "<=" => return toNumber(left <= right)
        case  "==" => return toNumber(left == right)
        case  "!=" => return toNumber(left != right)
        case "&&" => return toNumber(left != 0 && right != 0)
        case "||" => return toNumber(left != 0 || right != 0)
      }
    }
    throw new UnsupportedOperationException()
  }

  private def toNumber(value: Boolean): Int = {
    if (value) {
      return 1
    }
    0
  }
}
