package ru.spbau.jvm.scala.calculator

class ArithmeticExpressionsVisitor extends ExpressionsBaseVisitor[Double] {

  override def visitUnary(ctx: ExpressionsParser.UnaryContext): Double =
    UnaryArithmeticFunctionProvider(ctx.op)(ctx.operand.accept(this))

  override def visitAdd(ctx: ExpressionsParser.AddContext): Double =
    BinaryArithmeticFunctionProvider(ctx.op)(ctx.left.accept(this), ctx.right.accept(this))

  override def visitMult(ctx: ExpressionsParser.MultContext): Double =
    BinaryArithmeticFunctionProvider(ctx.op)(ctx.left.accept(this), ctx.right.accept(this))

  override def visitNestedArithmetic(ctx: ExpressionsParser.NestedArithmeticContext): Double =
    ctx.nested.accept(this)

  override def visitNumber(ctx: ExpressionsParser.NumberContext): Double =
    ctx.NUMBER().getSymbol.getText.toDouble
}
