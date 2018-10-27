package ru.spbau.jvm.scala.calculator

class LogicalExpressionsVisitor extends ExpressionsBaseVisitor[Boolean] {

  private val arithmeticExpressionsVisitor = new ArithmeticExpressionsVisitor()

  override def visitAnd(ctx: ExpressionsParser.AndContext): Boolean =
    OperationProvider.get(ctx.op, Operation.BINARY).apply(ctx.left.accept(this), ctx.right.accept(this))

  override def visitXor(ctx: ExpressionsParser.XorContext): Boolean =
    OperationProvider.get(ctx.op, Operation.BINARY).apply(ctx.left.accept(this), ctx.right.accept(this))

  override def visitOr(ctx: ExpressionsParser.OrContext): Boolean =
    OperationProvider.get(ctx.op, Operation.BINARY).apply(ctx.left.accept(this), ctx.right.accept(this))

  override def visitEqLogical(ctx: ExpressionsParser.EqLogicalContext): Boolean =
    OperationProvider.get(ctx.op, Operation.LOGICAL).apply(ctx.left.accept(this), ctx.right.accept(this))

  override def visitNestedLogical(ctx: ExpressionsParser.NestedLogicalContext): Boolean =
    ctx.nested.accept(this)

  override def visitNot(ctx: ExpressionsParser.NotContext): Boolean =
    OperationProvider.get(ctx.op, Operation.UNARY).apply(ctx.operand.accept(this))

  override def visitComp(ctx: ExpressionsParser.CompContext): Boolean =
    OperationProvider.get(ctx.op, Operation.ARITHMETIC).applyComparison(ctx.left.accept(arithmeticExpressionsVisitor), ctx.right.accept(arithmeticExpressionsVisitor))

  override def visitEqArithmetic(ctx: ExpressionsParser.EqArithmeticContext): Boolean =
    OperationProvider.get(ctx.op, Operation.ARITHMETIC).applyComparison(ctx.left.accept(arithmeticExpressionsVisitor), ctx.right.accept(arithmeticExpressionsVisitor))

  override def visitBool(ctx: ExpressionsParser.BoolContext): Boolean =
    ctx.BOOL().getSymbol.getText.toBoolean
}
