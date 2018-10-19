package org.ifmo.calculator.visitors

import org.ifmo.calculator.stack.elements._
import org.ifmo.grammar.{NotFunAtAllParser, NotFunAtAllParserBaseVisitor}

class ToStackVisitor extends NotFunAtAllParserBaseVisitor[List[StackElement]] {
  override def visitLogicalCompareExpr(ctx: NotFunAtAllParser.LogicalCompareExprContext): List[StackElement] = {
    Operation.parseComparison(ctx.op.getText).asInstanceOf[StackElement] ::
      (ctx.left.accept(this) ++ ctx.right.accept(this))
  }

  override def visitLogicalBinaryExpr(ctx: NotFunAtAllParser.LogicalBinaryExprContext): List[StackElement] = {
    Operation.parseBoolean(ctx.op.getText) ::
      ctx.left.accept(this) ++ ctx.right.accept(this)
  }

  override def visitLogicalParensExpr(ctx: NotFunAtAllParser.LogicalParensExprContext): List[StackElement] = {
    ctx.logical_expr().accept(this)
  }

  override def visitLogicalAtomExpr(ctx: NotFunAtAllParser.LogicalAtomExprContext): List[StackElement] = {
    List(BoolValue(ctx.bool_literal().getText.toBoolean))
  }

  override def visitAtom(ctx: NotFunAtAllParser.AtomContext): List[StackElement] = {
    List(LongValue(ctx.INT_NUM().getSymbol.getText.toLong))
  }

  override def visitArithmeticParensExpr(ctx: NotFunAtAllParser.ArithmeticParensExprContext): List[StackElement] = {
    ctx.arithm_expr().accept(this)
  }

  override def visitArithmeticDABinaryExpr(ctx: NotFunAtAllParser.ArithmeticDABinaryExprContext): List[StackElement] = {
    Operation.parseArithmetic(ctx.op.getText) ::
      ctx.left.accept(this) ++ ctx.right.accept(this)
  }

  override def visitArithmeticPMBinaryExpr(ctx: NotFunAtAllParser.ArithmeticPMBinaryExprContext): List[StackElement] = {
    Operation.parseArithmetic(ctx.op.getText) ::
      ctx.left.accept(this) ++ ctx.right.accept(this)
  }

  override def visitArithmeticAtomExpr(ctx: NotFunAtAllParser.ArithmeticAtomExprContext): List[StackElement] = {
    List(LongValue(ctx.atom().getText.toLong))
  }

  override def visitBinary_expr(ctx: NotFunAtAllParser.Binary_exprContext): List[StackElement] = {
    if (ctx.arithm_expr() != null) {
      ctx.arithm_expr().accept(this)
    } else {
      ctx.logical_expr().accept(this)
    }
  }
}


