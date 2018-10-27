package ru.spbau.jvm.scala.calculator

class LogicalExpressionsVisitor extends ExpressionsBaseVisitor[Boolean] {

  override def visitAnd(ctx: ExpressionsParser.AndContext): Boolean =
    OperationProvider.get(ctx.op, Operation.BINARY).apply(ctx.left.accept(this), ctx.right.accept(this))

  override def visitXor(ctx: ExpressionsParser.XorContext): Boolean =
    OperationProvider.get(ctx.op, Operation.BINARY).apply(ctx.left.accept(this), ctx.right.accept(this))

  override def visitOr(ctx: ExpressionsParser.OrContext): Boolean =
    OperationProvider.get(ctx.op, Operation.BINARY).apply(ctx.left.accept(this), ctx.right.accept(this))

  override def visitEquiv(ctx: ExpressionsParser.EquivContext): Boolean =
    OperationProvider.get(ctx.op, Operation.BINARY).apply(ctx.left.accept(this), ctx.right.accept(this))

  override def visitNestedLogical(ctx: ExpressionsParser.NestedLogicalContext): Boolean =
    ctx.nested.accept(this)

  override def visitNot(ctx: ExpressionsParser.NotContext): Boolean =
    OperationProvider.get(ctx.op, Operation.UNARY).apply(ctx.operand.accept(this))

  override def visitBool(ctx: ExpressionsParser.BoolContext): Boolean =
    ctx.BOOL().getSymbol.getText.toBoolean
}
