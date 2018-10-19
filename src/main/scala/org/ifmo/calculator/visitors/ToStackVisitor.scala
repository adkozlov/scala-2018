package org.ifmo.calculator.visitors

import org.ifmo.calculator.stack.elements._
import org.ifmo.grammar.{NotFunAtAllParser, NotFunAtAllParserBaseVisitor}

import scala.collection.mutable

class ToStackVisitor extends NotFunAtAllParserBaseVisitor[Unit] {
  val operationStack: mutable.Stack[StackElement] = mutable.Stack[StackElement]()

  override def visitLogicalCompareExpr(ctx: NotFunAtAllParser.LogicalCompareExprContext): Unit = {
    ctx.left.accept(this)
    ctx.right.accept(this)

    operationStack.push(Operation.parseComparison(ctx.op.getText))
  }

  override def visitLogicalBinaryExpr(ctx: NotFunAtAllParser.LogicalBinaryExprContext): Unit = {
    ctx.left.accept(this)
    ctx.right.accept(this)

    operationStack.push(Operation.parseBoolean(ctx.op.getText))
  }

  override def visitLogicalParensExpr(ctx: NotFunAtAllParser.LogicalParensExprContext): Unit = {
    ctx.logical_expr().accept(this)
  }


  override def visitLogicalAtomExpr(ctx: NotFunAtAllParser.LogicalAtomExprContext): Unit = {
    operationStack.push(BoolValue(ctx.bool_literal().getText.toBoolean))
  }

  override def visitAtom(ctx: NotFunAtAllParser.AtomContext): Unit = {
    operationStack.push(LongValue(ctx.INT_NUM().getSymbol.getText.toLong))
  }

  override def visitArithmeticParensExpr(ctx: NotFunAtAllParser.ArithmeticParensExprContext): Unit = {
    ctx.arithm_expr().accept(this)
  }

  override def visitArithmeticDABinaryExpr(ctx: NotFunAtAllParser.ArithmeticDABinaryExprContext): Unit = {
    ctx.left.accept(this)
    ctx.right.accept(this)

    operationStack.push(Operation.parseArithmetic(ctx.op.getText))
  }

  override def visitArithmeticPMBinaryExpr(ctx: NotFunAtAllParser.ArithmeticPMBinaryExprContext): Unit = {
    ctx.left.accept(this)
    ctx.right.accept(this)

    operationStack.push(Operation.parseArithmetic(ctx.op.getText))
  }

  override def visitArithmeticAtomExpr(ctx: NotFunAtAllParser.ArithmeticAtomExprContext): Unit = {
    operationStack.push(LongValue(ctx.atom().getText.toLong))
  }

  override def visitBinary_expr(ctx: NotFunAtAllParser.Binary_exprContext): Unit = {
    if (ctx.arithm_expr() != null) {
      ctx.arithm_expr().accept(this)
    }

    if (ctx.logical_expr() != null) {
      ctx.logical_expr().accept(this)
    }
  }
}


