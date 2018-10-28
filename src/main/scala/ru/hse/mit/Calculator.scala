package ru.hse.mit

import org.antlr.v4.runtime.ParserRuleContext

class Calculator extends CalcBaseVisitor[Int] {

  override def visitFile(ctx : CalcParser.FileContext) : Int = visit(ctx.expression())

  override def visitExpression(ctx: CalcParser.ExpressionContext): Int = visit(ctx.logical())

  override def visitLogical(ctx: CalcParser.LogicalContext): Int = evaluateExpression(ctx)

  override def visitEquality(ctx: CalcParser.EqualityContext): Int = evaluateExpression(ctx)

  override def visitMultiplication(ctx: CalcParser.MultiplicationContext): Int = evaluateExpression(ctx)

  override def visitAddition(ctx: CalcParser.AdditionContext): Int = evaluateExpression(ctx)

  override def visitAtomic(ctx: CalcParser.AtomicContext): Int = {
    if (ctx.children.size() == 1) visit(ctx.getChild(0)) else visit(ctx.getChild(1))
  }

  override def visitNumber(ctx: CalcParser.NumberContext): Int = ctx.value

  override def visitBool(ctx: CalcParser.BoolContext): Int = ctx.value

  private def evaluateExpression(ctx: ParserRuleContext): Int = {
    var result = visit(ctx.getChild(0))
    val length = ctx.children.size()
      for (i <- 1 until length - 1 if i % 2 == 1) {
        val op = ctx.getChild(i).getText
        result = applyOperation(result, op, visit(ctx.getChild(i + 1)))
    }
    result
  }

  private def applyOperation(first : Int, op : String, second : Int) : Int = {
    op match {
      case "+"  => first + second
      case "-"  => first - second
      case "*"  => first * second
      case "/"  => first / second
      case "%"  => first % second
      case "==" => if (first == second) 1 else 0
      case "!=" => if (first != second) 1 else 0
      case "<"  => if (first < second) 1 else 0
      case ">"  => if (first > second) 1 else 0
      case "<=" => if (first <= second) 1 else 0
      case ">=" => if (first >= second) 1 else 0
      case "||" => if (first != 0 || second != 0) 1 else 0
      case "&&" => if (first != 0 && second != 0) 1 else 0
    }
  }
}
