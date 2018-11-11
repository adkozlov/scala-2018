package ru.hse.spb.jvm.scala

import org.antlr.v4.runtime.{ParserRuleContext, Token}

class Visitor extends CalculatorBaseVisitor[Double] {
  private val binaryOperationFunctions: Map[String, (Double, Double) => Double] = Map(
    "+" -> { (a, b) => a + b },
    "-" -> { (a, b) => a - b },
    "*" -> { (a, b) => a * b },
    "/" -> { (a, b) => a / b },
    "%" -> { (a, b) => a % b },
    ">" -> { (a, b) => toDouble(a > b) },
    "<" -> { (a, b) => toDouble(a < b) },
    ">=" -> { (a, b) => toDouble(a >= b) },
    "<=" -> { (a, b) => toDouble(a <= b) },
    "==" -> { (a, b) => toDouble(a == b) },
    "!=" -> { (a, b) => toDouble(a != b) },
    "||" -> { (a, b) => toDouble(a != 0 || b != 0) },
    "&&" -> { (a, b) => toDouble(a != 0 && b != 0) }
  )

  def toDouble(b: Boolean): Double = if (b) 1 else 0

  override def visitExpr(ctx: CalculatorParser.ExprContext): Double = visitLogicalOr(ctx.logicalOr())

  override def visitLogicalOr(ctx: CalculatorParser.LogicalOrContext): Double
  = visitBinaryExpression(ctx.operator, ctx.leftOperand, ctx.rightOperand)

  override def visitLogicalAnd(ctx: CalculatorParser.LogicalAndContext): Double
  = visitBinaryExpression(ctx.operator, ctx.leftOperand, ctx.rightOperand)

  private def visitBinaryExpression(operator: Token, leftOperand: ParserRuleContext,
                                    rightOperand: ParserRuleContext): Double = {
    if (operator == null) visit(leftOperand)
    else binaryOperationFunctions(operator.getText).apply(visit(leftOperand), visit(rightOperand))
  }

  override def visitEquality(ctx: CalculatorParser.EqualityContext): Double
  = visitBinaryExpression(ctx.operator, ctx.leftOperand, ctx.rightOperand)


  override def visitRelational(ctx: CalculatorParser.RelationalContext): Double
  = visitBinaryExpression(ctx.operator, ctx.leftOperand, ctx.rightOperand)

  override def visitAdditive(ctx: CalculatorParser.AdditiveContext): Double
  = visitBinaryExpression(ctx.operator, ctx.leftOperand, ctx.rightOperand)


  override def visitMultiplicative(ctx: CalculatorParser.MultiplicativeContext): Double
  = visitBinaryExpression(ctx.operator, ctx.leftOperand, ctx.rightOperand)

  override def visitVisitDouble(ctx: CalculatorParser.VisitDoubleContext): Double = ctx.getText.toDouble

  override def visitVisitExpressionInBraces(ctx: CalculatorParser.VisitExpressionInBracesContext): Double = visit(ctx.expr())
}
