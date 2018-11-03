package ru.hse.jvm.calculator

import scala.collection.JavaConverters._

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class CalculatorVisitorImpl extends CalculatorParserBaseVisitor[Int] {

  private def calculate(left: Int, right: Int, operation: String): Int = operation match {
    case "+" => left + right
    case "-" => left - right
    case "*" => left * right
    case "/" => left / right
    case ">" => if (left > right) 1 else 0
    case "<" => if (left < right) 1 else 0
    case ">=" => if (left >= right) 1 else 0
    case "<=" => if (left <= right) 1 else 0
    case "==" => if (left == right) 1 else 0
    case "!=" => if (left != right) 1 else 0
    case "||" => if (left != 0 || right != 0) 1 else 0
    case "&&" => if (left != 0 && right != 0) 1 else 0
  }

  private def calculate(children: Iterable[ParserRuleContext], operations: Iterable[TerminalNode]): Int = {
    val values = children.map(child => visit(child))
    val operationsText = operations.map(operation => operation.getText)
    var result = values.head
    for ((value, operation) <- values.tail.zip(operationsText)) {
      result = calculate(result, value, operation)
    }
    result
  }

  override def visitExpr(ctx: CalculatorParser.ExprContext): Int =
    calculate(ctx.andExpr().asScala, ctx.OR().asScala)

  override def visitAndExpr(ctx: CalculatorParser.AndExprContext): Int =
    calculate(ctx.eqExpr().asScala, ctx.AND().asScala)

  override def visitEqExpr(ctx: CalculatorParser.EqExprContext): Int =
    calculate(ctx.compExpr().asScala, ctx.EQ().asScala)

  override def visitCompExpr(ctx: CalculatorParser.CompExprContext): Int =
    calculate(ctx.plusExpr().asScala, ctx.COMP().asScala)

  override def visitPlusExpr(ctx: CalculatorParser.PlusExprContext): Int =
    calculate(ctx.multExpr().asScala, ctx.SUM().asScala)

  override def visitMultExpr(ctx: CalculatorParser.MultExprContext): Int =
    calculate(ctx.atom().asScala, ctx.MULT().asScala)

  override def visitAtom(ctx: CalculatorParser.AtomContext): Int =
    if (ctx.expr() != null) visit(ctx.expr()) else ctx.INT().getText.toInt

}
