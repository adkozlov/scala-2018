package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.Token
import ru.spbau.jvm.scala.calculator.ExpressionsParser.{ArithmeticExpressionContext, LogicalExpressionContext}

class ArithmeticExpressionsVisitor extends ExpressionsBaseVisitor[Double] {

  override def visitUnary(ctx: ExpressionsParser.UnaryContext): Double =
    UnaryArithmeticFunctionProvider(ctx.op)(ctx.operand.accept(this))

  override def visitAdd(ctx: ExpressionsParser.AddContext): Double =
    evaluateArithmeticLogicalExpression(ctx.op, ctx.left, ctx.right)

  override def visitMult(ctx: ExpressionsParser.MultContext): Double =
    evaluateArithmeticLogicalExpression(ctx.op, ctx.left, ctx.right)

  override def visitNestedArithmetic(ctx: ExpressionsParser.NestedArithmeticContext): Double =
    ctx.nested.accept(this)

  override def visitNumber(ctx: ExpressionsParser.NumberContext): Double =
    ctx.NUMBER().getSymbol.getText.toDouble

  private def evaluateArithmeticLogicalExpression(op: Token, left: ArithmeticExpressionContext, right: ArithmeticExpressionContext) =
    BinaryArithmeticFunctionProvider(op).apply(left.accept(this), right.accept(this))
}
