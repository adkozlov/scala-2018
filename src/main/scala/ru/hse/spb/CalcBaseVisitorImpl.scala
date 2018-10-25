package ru.hse.spb

import scala.collection.mutable

class CalcBaseVisitorImpl extends CalcParserBaseVisitor[Long] {
  override def visitBoolExpr(ctx: CalcParser.BoolExprContext): Long = {
    val op1: Long = ctx.expression(0).accept(this)
    val op2: Long = ctx.expression(1).accept(this)

    ctx.op.getType match {
      case 16 => if (op1 != 0 && op2 != 0) 1 else 0
      case 17 => if (op1 != 0 || op2 != 0) 1 else 0
    }
  }

  override def visitComparisonExpr(ctx: CalcParser.ComparisonExprContext): Long = {
    val op1: Long = ctx.expression(0).accept(this)
    val op2: Long = ctx.expression(1).accept(this)

    ctx.op.getType match {
      case 10 => if (op1 > op2) 1 else 0
      case 11 => if (op1 < op2) 1 else 0
      case 12 => if (op1 <= op2) 1 else 0
      case 13 => if (op1 >= op2) 1 else 0
      case 14 => if (op1 == op2) 1 else 0
      case 15 => if (op1 != op2) 1 else 0
    }

  }

  override def visitAdditiveExpr(ctx: CalcParser.AdditiveExprContext): Long = {
    val op1: Long = ctx.expression(0).accept(this)
    val op2: Long = ctx.expression(1).accept(this)

    ctx.op.getType match {
      case 5 => op1 + op2
      case 6 => op1 - op2
    }
  }

  override def visitMultExpr(ctx: CalcParser.MultExprContext): Long = {
    val op1: Long = ctx.expression(0).accept(this)
    val op2: Long = ctx.expression(1).accept(this)

    ctx.op.getType match {
      case 7 => op1 * op2
      case 8 => op1 / op2
      case 9 => op1 % op2
    }
  }

  override def visitParanthesisExpr(ctx: CalcParser.ParanthesisExprContext): Long = {
    ctx.expression().accept(this)
  }

  override def visitUnitLiteral(ctx: CalcParser.UnitLiteralContext): Long = {
    val strLiteral = ctx.LITERAL().getText
    strLiteral.toLong
  }

}
