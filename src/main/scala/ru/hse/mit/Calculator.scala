package ru.hse.mit

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class Calculator extends CalcBaseVisitor[CalcToken] {
  override def visitData(ctx: CalcParser.DataContext): CalcToken = visit(ctx.expression())

  override def visitAdditionExp(ctx: CalcParser.AdditionExpContext): CalcToken = evaluate(ctx)

  def evaluate(ctx: ParserRuleContext): CalcToken = {
    var result = visit(ctx.getChild(0))
    val length = ctx.children.size()
    if (length > 1) {
      for (i <- 1 until length if i % 2 == 1) {
        val second = visit(ctx.getChild(i + 1))
        ctx.getChild(i).getText match {
          case "+" => result = result + second
          case "-" => result = result - second
          case "*" => result = result * second
          case "/" => result = result / second
          case "%" => result = result % second
          case "==" => result = result == second
          case "!=" => result = result != second
          case "<" => result = result < second
          case ">" => result = result > second
          case "<=" => result = result <= second
          case ">=" => result = result >= second
          case "||" => result = result || second
          case "&&" => result = result && second
        }
      }
    }
    result
  }

  override def visitLogicalExp(ctx: CalcParser.LogicalExpContext): CalcToken = evaluate(ctx)

  override def visitComparisonExp(ctx: CalcParser.ComparisonExpContext): CalcToken = evaluate(ctx)

  override def visitAtomExp(ctx: CalcParser.AtomExpContext): CalcToken =
    if (ctx.children.size() == 3) visit(ctx.getChild(1)) else visit(ctx.getChild(0))

  override def visitMultiplyExp(ctx: CalcParser.MultiplyExpContext): CalcToken = evaluate(ctx)

  override def visitTerminal(node: TerminalNode): CalcToken = {
    IntCalcToken(node.getSymbol.getText.toInt)
  }

  override def visitBool(ctx: CalcParser.BoolContext): CalcToken = {
    BooleanCalcToken(ctx.getChild(0).getText.toBoolean)
  }
}
