package ru.hse.spb.ast

import ru.hse.spb._
import org.antlr.v4.runtime.tree._

class AntlrAstVisitor extends CalcBaseVisitor[Expr] {
  override def visitParenthesisedExpr(
      ctx: CalcParser.ParenthesisedExprContext): Expr = {
    visit(ctx.expression)
  }

  override def visitBinOpExpr(ctx: CalcParser.BinOpExprContext): Expr = {
    BinOp(ctx.s.getText, visit(ctx.x), visit(ctx.y))
  }

  override def visitConstExpr(ctx: CalcParser.ConstExprContext): Expr = {
    Const(ctx.n.getText.toInt)
  }
}
