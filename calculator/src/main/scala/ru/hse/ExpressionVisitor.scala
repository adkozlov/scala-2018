package ru.hse

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import ru.hse.ExpParser._

object ExpressionVisitor extends ExpBaseVisitor[Value] {
  override def visitExpression(ctx: ExpressionContext): Value = visit(ctx.orExpression())

  override def visitAtomExpression(ctx: AtomExpressionContext): Value = visit(ctx.children.get(0))

  override def visitExpressionWithBraces(ctx: ExpressionWithBracesContext): Value = visit(ctx.orExpression())

  override def visitOrExpression(ctx: OrExpressionContext): Value = ctx.orExpression() match {
    case null => visit(ctx.andExpression())
    case expression => visitBinaryOperation(ctx.OrOp(), expression, ctx.andExpression())
  }

  override def visitAndExpression(ctx: AndExpressionContext): Value = ctx.andExpression match {
    case null => visit(ctx.relationalExpression())
    case expression => visitBinaryOperation(ctx.AndOp(), expression, ctx.relationalExpression())
  }

  override def visitRelationalExpression(ctx: RelationalExpressionContext): Value = ctx.relationalExpression() match {
    case null => visit(ctx.additiveExpression())
    case expression => visitBinaryOperation(ctx.RelationalOp(), expression, ctx.additiveExpression())
  }

  override def visitAdditiveExpression(ctx: AdditiveExpressionContext): Value = ctx.additiveExpression() match {
    case null => visit(ctx.multiplicativeExpression())
    case expression => visitBinaryOperation(ctx.AdditiveOp(), expression, ctx.multiplicativeExpression())
  }

  override def visitMultiplicativeExpression(ctx: MultiplicativeExpressionContext): Value =
    ctx.multiplicativeExpression() match {
      case null => visit(ctx.atomExpression())
      case expression => visitBinaryOperation(ctx.MultiplicativeOp(), expression, ctx.atomExpression())
    }

  override def visitTerminal(node: TerminalNode): Value = node.getSymbol.getType match {
    case BoolLiteral => BoolValue(node.getText.toBoolean)
    case IntLiteral => IntValue(node.getText.toInt)
    case _ => super.visitTerminal(node)
  }

  private def visitBinaryOperation(token: TerminalNode, left: ParserRuleContext, right: ParserRuleContext): Value = {
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
