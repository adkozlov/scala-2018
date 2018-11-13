package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.Token
import ru.spbau.jvm.scala.calculator.ExpressionsParser._

class LogicalExpressionsVisitor extends ExpressionsBaseVisitor[Boolean] {

  private val arithmeticExpressionsVisitor = new ArithmeticExpressionsVisitor()

  override def visitNot(ctx: ExpressionsParser.NotContext): Boolean =
    UnaryLogicalFunctionProvider(ctx.op)(ctx.operand.accept(this))

  override def visitAnd(ctx: ExpressionsParser.AndContext): Boolean =
    evaluateBinaryLogicalExpression(ctx.op, ctx.left, ctx.right)

  override def visitXor(ctx: ExpressionsParser.XorContext): Boolean =
    evaluateBinaryLogicalExpression(ctx.op, ctx.left, ctx.right)

  override def visitOr(ctx: ExpressionsParser.OrContext): Boolean =
    evaluateBinaryLogicalExpression(ctx.op, ctx.left, ctx.right)

  override def visitEqLogical(ctx: ExpressionsParser.EqLogicalContext): Boolean =
    EqualityComparisonFunctionProvider(ctx.op)(BooleanType(ctx.left.accept(this)), BooleanType(ctx.right.accept(this)))

  override def visitComp(ctx: ExpressionsParser.CompContext): Boolean =
    ArithmeticComparisonFunctionProvider(ctx.op)(ctx.left.accept(arithmeticExpressionsVisitor), ctx.right.accept(arithmeticExpressionsVisitor))

  override def visitEqArithmetic(ctx: ExpressionsParser.EqArithmeticContext): Boolean =
    EqualityComparisonFunctionProvider(ctx.op)(DoubleType(ctx.left.accept(arithmeticExpressionsVisitor)), DoubleType(ctx.right.accept(arithmeticExpressionsVisitor)))

  override def visitNestedLogical(ctx: ExpressionsParser.NestedLogicalContext): Boolean =
    ctx.nested.accept(this)

  override def visitBool(ctx: ExpressionsParser.BoolContext): Boolean =
    ctx.BOOL().getSymbol.getText.toBoolean

  private def evaluateBinaryLogicalExpression(op: Token, left: LogicalExpressionContext, right: LogicalExpressionContext) =
    BinaryLogicalFunctionProvider(op).apply(left.accept(this), right.accept(this))
}
