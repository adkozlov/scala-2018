package ru.hse.scala

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams, ParserRuleContext}
import ru.hse.scala.gen.{CalculatorBaseVisitor, CalculatorLexer, CalculatorParser}


class Calculator extends CalculatorBaseVisitor[CalculatorNumber] {
  override def visitBooleanExp(ctx: CalculatorParser.BooleanExpContext): CalculatorNumber = BoolNumber(ctx.Boolean().getText.toBoolean)

  override def visitDoubleExp(ctx: CalculatorParser.DoubleExpContext): CalculatorNumber = DoubleNumber(ctx.Double().getText.toDouble)

  override def visitIntegerExp(ctx: CalculatorParser.IntegerExpContext): CalculatorNumber = IntNumber(ctx.Integer().getText.toInt)

  override def visitStatement(ctx: CalculatorParser.StatementContext): CalculatorNumber = visit(ctx.getChild(0))

  override def visitSurroundedExpression(ctx: CalculatorParser.SurroundedExpressionContext): CalculatorNumber = visit(ctx.expression())

  override def visitExpression(ctx: CalculatorParser.ExpressionContext): CalculatorNumber = visit(ctx.getChild(0))

  override def visitAtomExp(ctx: CalculatorParser.AtomExpContext): CalculatorNumber = visit(ctx.getChild(0))

  private def visitOperation(ctx : ParserRuleContext) : CalculatorNumber = {
    var result = visit(ctx.getChild(0))
    for (i <- 1 until ctx.children.size() by 2) {
      result = result.evaluate(ctx.getChild(i).getText, visit(ctx.getChild(i + 1)))
    }
    result
  }

  override def visitAdditionExp(ctx: CalculatorParser.AdditionExpContext): CalculatorNumber = visitOperation(ctx)

  override def visitComparExp(ctx: CalculatorParser.ComparExpContext): CalculatorNumber = visitOperation(ctx)

  override def visitAndExp(ctx: CalculatorParser.AndExpContext): CalculatorNumber = visitOperation(ctx)

  override def visitMultiplyExp(ctx: CalculatorParser.MultiplyExpContext): CalculatorNumber = visitOperation(ctx)

  override def visitOrExp(ctx: CalculatorParser.OrExpContext): CalculatorNumber = visitOperation(ctx)

  def calculate(line : String): AnyVal = {
    val calculatorLexer = new CalculatorLexer(CharStreams.fromString(line))
    val calculatorParser = new CalculatorParser(new BufferedTokenStream(calculatorLexer))
    visitExpression(calculatorParser.expression()).getValue
  }
}

