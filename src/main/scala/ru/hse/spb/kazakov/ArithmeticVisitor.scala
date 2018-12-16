package ru.hse.spb.kazakov

import org.antlr.v4.runtime.Token
import ru.hse.spb.kazakov.ExprGrammarParser._

object ArithmeticVisitor extends ExprGrammarBaseVisitor[Int] {

  override def visitArithmeticExpression(ctx: ArithmeticExpressionContext): Int = {
    ctx.NUMBER() match {
      case null   =>
      case number => return number.getText.toInt
    }

    ctx.inner match {
      case null  =>
      case inner => return inner.accept(this)
    }

    val left = ctx.left.accept(this)
    val right = ctx.right.accept(this)
    evaluateOperation(left, right, ctx.operator)
  }

  private def evaluateOperation(left: Int, right: Int, operator: Token): Int =
    operator.getType match {
      case MUL   => left * right
      case DIV   => left / right
      case MOD   => left % right
      case PLUS  => left + right
      case MINUS => left - right
    }
}
