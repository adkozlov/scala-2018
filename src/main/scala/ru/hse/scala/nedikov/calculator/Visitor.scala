package ru.hse.scala.nedikov.calculator

class Visitor extends CalculatorBaseVisitor[Expression] {
  override def visitEval(ctx: CalculatorParser.EvalContext): Expression = {
    ctx.getChild(0).accept(this)
  }

  override def visitDoubleExpression(ctx: CalculatorParser.DoubleExpressionContext): Expression = {
    if (ctx.getChildCount == 1) {
      ctx.getChild(0).accept(this)
    } else {
      val left = ctx.left.accept(this).asInstanceOf[DoubleExpression]
      val right = ctx.right.accept(this).asInstanceOf[DoubleExpression]
      new DoubleBinop(ctx.op.getText, left, right)
    }
  }

  override def visitBooleanExpression(ctx: CalculatorParser.BooleanExpressionContext): Expression = {
    if (ctx.getChildCount == 1) {
      ctx.getChild(0).accept(this)
    } else {
      val left = ctx.left.accept(this).asInstanceOf[BooleanExpression]
      val right = ctx.right.accept(this).asInstanceOf[BooleanExpression]
      new BooleanBinop(ctx.op.getText, left, right)
    }
  }

  override def visitBooleanCompare(ctx: CalculatorParser.BooleanCompareContext): Expression = {
    val left = ctx.left.accept(this).asInstanceOf[DoubleExpression]
    val right = ctx.right.accept(this).asInstanceOf[DoubleExpression]
    new BooleanCompare(ctx.op.getText, left, right)
  }

  override def visitAtomDouble(ctx: CalculatorParser.AtomDoubleContext): Expression = {
    ctx.getChild(0).accept(this)
  }

  override def visitAtomBoolean(ctx: CalculatorParser.AtomBooleanContext): Expression = {
    ctx.getChild(0).accept(this)
  }

  override def visitNumber(ctx: CalculatorParser.NumberContext): Expression = {
    new DoubleConst(ctx.n.getText.toDouble)
  }

  override def visitBracedDoubleExpression(ctx: CalculatorParser.BracedDoubleExpressionContext): Expression = {
    ctx.exp.accept(this)
  }

  override def visitBool(ctx: CalculatorParser.BoolContext): Expression = {
    new BooleanConst(ctx.b.getText.toBoolean)
  }

  override def visitBracedBooleanExpression(ctx: CalculatorParser.BracedBooleanExpressionContext): Expression = {
    ctx.exp.accept(this)
  }
}
