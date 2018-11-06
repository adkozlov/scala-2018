package ru.hse.spb

import ru.hse.spb.CalcParser._

class CalcBaseVisitorImpl extends CalcParserBaseVisitor[Long] {
  override def visitBoolExpr(ctx: BoolExprContext): Long = {
    val (leftOperand, rightOperand) = extractOperands(ctx)

    ctx.op.getType match {
      case AND => boolConverter(leftOperand != 0 && rightOperand != 0)
      case OR => boolConverter(leftOperand != 0 || rightOperand != 0)
    }
  }

  override def visitComparisonExpr(ctx: ComparisonExprContext): Long = {
    val (leftOperand, rightOperand) = extractOperands(ctx)

    ctx.op.getType match {
      case GT => boolConverter(leftOperand > rightOperand)
      case LT => boolConverter(leftOperand < rightOperand)
      case LE => boolConverter(leftOperand <= rightOperand)
      case GE => boolConverter(leftOperand >= rightOperand)
      case EQUAL => boolConverter(leftOperand == rightOperand)
      case NOTEQUAL => boolConverter(leftOperand != rightOperand)
    }

  }

  override def visitAdditiveExpr(ctx: AdditiveExprContext): Long = {
    val (leftOperand, rightOperand) = extractOperands(ctx)

    ctx.op.getType match {
      case ADD => leftOperand + rightOperand
      case SUB => leftOperand - rightOperand
    }
  }

  override def visitMultExpr(ctx: MultExprContext): Long = {
    val (leftOperand, rightOperand) = extractOperands(ctx)

    ctx.op.getType match {
      case MULT => leftOperand * rightOperand
      case DIV => leftOperand / rightOperand
      case MOD => leftOperand % rightOperand
    }
  }

  override def visitParanthesisExpr(ctx: ParanthesisExprContext): Long = {
    ctx.expression().accept(this)
  }

  override def visitUnitLiteral(ctx: UnitLiteralContext): Long = {
    val strLiteral = ctx.LITERAL().getText
    strLiteral.toLong
  }

  private def boolConverter(expr: Boolean): Long = if (expr) 1 else 0

  private def extractOperands(ctx: ExpressionContext) = {
    val leftOperand = ctx.getRuleContext(classOf[CalcParser.ExpressionContext], 0).accept(this)
    val rightOperand = ctx.getRuleContext(classOf[CalcParser.ExpressionContext], 1).accept(this)
    (leftOperand, rightOperand)
  }

}
