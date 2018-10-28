package ru.spb.hse
import ru.spb.hse.calculator.ExpParser
import ru.spb.hse.calculator.ExpBaseVisitor

class ExpVisitor extends ExpBaseVisitor[Int] {
  override def visitExpression(ctx: ExpParser.ExpressionContext): Int = {
    if (ctx.inBraces != null) {
      return ctx.inBraces.accept(this)
    }
    if (ctx.LITERAL != null) {
      return ctx.LITERAL().getText.toInt
    }
    if (ctx.BOOL_LITERAL != null) {
      ctx.BOOL_LITERAL.toString match {
        case "true" => return 1
        case "false" => return 0
      }
    }
    val left = ctx.left.accept(this)
    val right = ctx.right.accept(this)
    ctx.operator.getText match {
      case "*" => left * right
      case "/" => left / right
      case "%" => left % right
      case "+" => left + right
      case "-" => left - right
      case ">" => if (left > right) 1 else 0
      case "<" => if (left < right) 1 else 0
      case ">=" => if (left >= right) 1 else 0
      case "<=" => if (left <= right) 1 else 0
      case "==" => if (left == right) 1 else 0
      case "!=" => if (left != right) 1 else 0
      case "&&" => if (left != 0 && right != 0) 1 else 0
      case "||" => if (left != 0 || right != 0) 1 else 0
    }
  }
}
