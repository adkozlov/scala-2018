package ru.spb.hse
import ru.spb.hse.calculator.ExpParser
import ru.spb.hse.calculator.ExpBaseVisitor

class ReturnValue(val value: Int, val wasBoolean: Boolean = false)

object ExpVisitor extends ExpBaseVisitor[ReturnValue] {
  private val True = 1
  private val False = 0
  override def visitExpression(ctx: ExpParser.ExpressionContext): ReturnValue = {
    ctx.inBraces match {
      case null =>
      case context => return context.accept(this)
    }
    ctx.LITERAL match {
      case null =>
      case value => return new ReturnValue(value.getText.toInt)
    }

    ctx.BOOL_LITERAL match {
      case null =>
      case value => return value.toString match {
        case "true" => new ReturnValue(True, true)
        case "false" => new ReturnValue(False, true)
      }
    }
    val left = ctx.left.accept(this).value
    val right = ctx.right.accept(this).value
    ctx.operator.getText match {
      case operation @ ("*" | "/" | "%" | "+" | "-") =>
        new ReturnValue(makeArithmetic(operation, left, right))
      case operation => new ReturnValue(
        if (makeLogic(operation, left, right)) True else False, true)
    }
  }

  private def makeArithmetic(operation : String, left: Int, right: Int): Int = operation match {
    case "*" => left * right
    case "/" => left / right
    case "%" => left % right
    case "+" => left + right
    case "-" => left - right
  }

  private def makeLogic(operation: String, left: Int, right: Int): Boolean = operation match {
    case "<" => left < right
    case ">=" => left >= right
    case "<=" => left <= right
    case "==" => left == right
    case "!=" => left != right
    case "&&" => left != 0 && right != 0
    case "||" => left != 0 || right != 0
  }
}