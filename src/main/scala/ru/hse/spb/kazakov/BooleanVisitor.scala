package ru.hse.spb.kazakov

import org.antlr.v4.runtime.Token
import ru.hse.spb.kazakov.ExprGrammarParser._

object BooleanVisitor extends ExprGrammarBaseVisitor[Boolean] {
  override def visitBooleanExpression(ctx: BooleanExpressionContext): Boolean = {
    ctx.booleanAtom() match {
      case null =>
      case atom => return atom.accept(this)
    }

    val left = ctx.left.accept(this)
    val right = ctx.right.accept(this)
    evaluateOperation(left, right, ctx.operator)
  }

  override def visitBooleanAtom(ctx: BooleanAtomContext): Boolean = {
    ctx.literal match {
      case null =>
      case literal => return literal.getText.toBoolean
    }

    ctx.negated match {
      case null =>
      case negated => return !negated.accept(this)
    }

    ctx.inner.accept(this)
  }

  private def evaluateOperation(left: Boolean, right: Boolean, operator: Token): Boolean =
    operator.getType match {
      case OR  => left || right
      case AND => left && right
    }
}
