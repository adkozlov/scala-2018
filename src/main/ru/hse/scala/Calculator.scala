package ru.hse.scala

import org.antlr.v4.runtime.ParserRuleContext
import ru.hse.scala.gen.{CalculatorBaseVisitor, CalculatorParser}

class Calculator extends CalculatorBaseVisitor[CalculatorNumber] {
  override def visitBooleanExp(ctx: CalculatorParser.BooleanExpContext): CalculatorNumber = BoolNumber(ctx.Boolean().getText.toBoolean)

  override def visitDoubleExp(ctx: CalculatorParser.DoubleExpContext): CalculatorNumber = DoubleNumber(ctx.Double().getText.toDouble)

  override def visitIntegerExp(ctx: CalculatorParser.IntegerExpContext): CalculatorNumber = IntNumber(ctx.Integer().getText.toInt)

  override def visitStatement(ctx: CalculatorParser.StatementContext): CalculatorNumber = visit(ctx.getChild(0))

  override def visitSurroundedExpression(ctx: CalculatorParser.SurroundedExpressionContext): CalculatorNumber = visit(ctx.expression())

  override def visitExpression(ctx: CalculatorParser.ExpressionContext): CalculatorNumber = visit(ctx.getChild(0))
  

}

