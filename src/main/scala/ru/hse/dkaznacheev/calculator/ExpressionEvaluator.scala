package ru.hse.dkaznacheev.calculator


class ExpressionEvaluator extends CalculatorBaseVisitor[Int]{
  override def visitCalculator(ctx: CalculatorParser.CalculatorContext): Int =
    visitExpression(ctx.expression())

  override def visitExpression(ctx: CalculatorParser.ExpressionContext): Int = {
    if (ctx.ex != null)
      visitExpression(ctx.ex) * (if (ctx.unOp != null) -1 else 1)
    else if (ctx.num != null)
      ctx.num.getText.toInt
    else
      operator(ctx.op.getText, visitExpression(ctx.left), visitExpression(ctx.right))
  }

  def operator(op: String, a:Int, b:Int): Int = op match {
    case "*"  => a * b
    case "/"  => a / b
    case "%"  => a % b
    case "+"  => a + b
    case "-"  => a - b
    case "<"  => if (a < b) 1 else 0
    case "<=" => if (a <= b) 1 else 0
    case ">"  => if (a > b) 1 else 0
    case ">=" => if (a >= b) 1 else 0
    case "==" => if (a == b) 1 else 0
    case "!=" => if (a != b) 1 else 0
    case "&&" => if (a != 0 && b != 0) 1 else 0
    case "||" => if (a != 0 || b != 0) 1 else 0
  }
}
