package ru.hse

import org.antlr.v4.runtime.tree.TerminalNode

class ExpressionVisitor extends ExpBaseVisitor[Literal] {
  override def visitExpression(ctx: ExpParser.ExpressionContext): Literal = visit(ctx.orExpression())

  override def visitAtomExpression(ctx: ExpParser.AtomExpressionContext): Literal = visit(ctx.children.get(0))

  override def visitExpressionWithBraces(ctx: ExpParser.ExpressionWithBracesContext): Literal = visit(ctx.expression())

  override def visitIntLiteral(ctx: ExpParser.IntLiteralContext): Literal = IntLiteral(ctx.getText.toInt)

  override def visitBoolLiteral(ctx: ExpParser.BoolLiteralContext): Literal = BoolLiteral(ctx.getText.toBoolean)

  override def visitOrExpression(ctx: ExpParser.OrExpressionContext): Literal = if (ctx.orExpression() == null) {
    visit(ctx.andExpression())
  } else {
    runOperation(ctx.OrOp(), visit(ctx.orExpression()), visit(ctx.andExpression()))
  }

  override def visitAndExpression(ctx: ExpParser.AndExpressionContext): Literal = if (ctx.andExpression() == null) {
    visit(ctx.relationalExpression())
  } else {
    runOperation(ctx.AndOp(), visit(ctx.andExpression()), visit(ctx.relationalExpression()))
  }

  override def visitRelationalExpression(ctx: ExpParser.RelationalExpressionContext): Literal = if (ctx.relationalExpression() == null) {
    visit(ctx.additiveExpression())
  } else {
    runOperation(ctx.RelationalOp(), visit(ctx.relationalExpression()), visit(ctx.additiveExpression()))
  }

  override def visitAdditiveExpression(ctx: ExpParser.AdditiveExpressionContext): Literal = if (ctx.additiveExpression() == null) {
    visit(ctx.multiplicativeExpression())
  } else {
    runOperation(ctx.AdditiveOp(), visit(ctx.additiveExpression()), visit(ctx.multiplicativeExpression()))
  }

  override def visitMultiplicativeExpression(ctx: ExpParser.MultiplicativeExpressionContext): Literal = if (ctx.multiplicativeExpression() == null) {
    visit(ctx.atomExpression())
  } else {
    runOperation(ctx.MultiplicativeOp(), visit(ctx.multiplicativeExpression()), visit(ctx.atomExpression()))
  }

  private def runOperation(token: TerminalNode, x: Literal, y: Literal): Literal = token.getText match {
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
