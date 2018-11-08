package ru.hse

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

object ExpressionVisitor extends ExpBaseVisitor[Literal] {
  override def visitExpression(ctx: ExpParser.ExpressionContext): Literal = visit(ctx.orExpression())

  override def visitAtomExpression(ctx: ExpParser.AtomExpressionContext): Literal = visit(ctx.children.get(0))

  override def visitExpressionWithBraces(ctx: ExpParser.ExpressionWithBracesContext): Literal = visit(ctx.orExpression())

  override def visitIntLiteral(ctx: ExpParser.IntLiteralContext): Literal = IntLiteral(ctx.getText.toInt)

  override def visitBoolLiteral(ctx: ExpParser.BoolLiteralContext): Literal = BoolLiteral(ctx.getText.toBoolean)

  override def visitOrExpression(ctx: ExpParser.OrExpressionContext): Literal = ctx.orExpression() match {
      case null => visit(ctx.andExpression())
      case expression => visitBinaryOperation(ctx.OrOp(), expression, ctx.andExpression())
    }

  override def visitAndExpression(ctx: ExpParser.AndExpressionContext): Literal = if (ctx.andExpression() == null) {
    visit(ctx.relationalExpression())
  } else {
    visitBinaryOperation(ctx.AndOp(), ctx.andExpression(), ctx.relationalExpression())
  }

  override def visitRelationalExpression(ctx: ExpParser.RelationalExpressionContext): Literal =
    if (ctx.relationalExpression() == null) {
    visit(ctx.additiveExpression())
  } else {
    visitBinaryOperation(ctx.RelationalOp(), ctx.relationalExpression(), ctx.additiveExpression())
  }

  override def visitAdditiveExpression(ctx: ExpParser.AdditiveExpressionContext): Literal =
    if (ctx.additiveExpression() == null) {
    visit(ctx.multiplicativeExpression())
  } else {
    visitBinaryOperation(ctx.AdditiveOp(), ctx.additiveExpression(), ctx.multiplicativeExpression())
  }

  override def visitMultiplicativeExpression(ctx: ExpParser.MultiplicativeExpressionContext): Literal =
    if (ctx.multiplicativeExpression() == null) {
    visit(ctx.atomExpression())
  } else {
    visitBinaryOperation(ctx.MultiplicativeOp(), ctx.multiplicativeExpression(), ctx.atomExpression())
  }

  private def visitBinaryOperation(token: TerminalNode, left: ParserRuleContext, right: ParserRuleContext): Literal = {
    val x = visit(left)
    val y = visit(right)

    token.getText match {
      case "*" => x * y
      case "/" => x / y
      case "%" => x % y
      case "+" => x + y
      case "-" => x - y
      case ">" => x > y
      case "<" => x < y
      case ">=" => x >= y
      case "<=" => x <= y
      case "==" => x == y
      case "!=" => x != y
      case "&&" => x && y
      case "||" => x || y
      case operation => throw new RuntimeException("Unsupported binary operation: " + operation)
    }
  }
}
