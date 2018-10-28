package ru.spbau.jvm.scala.homework1

class Calculator extends ExpBaseVisitor[Int] {
  override def visitCalc(ctx: ExpParser.CalcContext): Int = ctx.exp.accept(this)

  override def visitExpr(ctx: ExpParser.ExprContext): Int = {
    if (ctx.num != null)
      ctx.num.getText.toInt
    else if (ctx.neg_num != null)
      -ctx.neg_num.Number.getSymbol.getText.toInt
    else if (ctx.exp != null)
        ctx.exp.accept(this)
      else
        getFunction(ctx.op.getText)(ctx.left.accept(this), ctx.right.accept(this))
  }

  private def getInt(bool: Boolean):Int = if (bool) 1 else 0
  private def getBool(int: Int):Boolean = if (int == 0) false else true

  private def getFunction(op: String):(Int, Int) => Int = op match {
    case "+"  => _ + _
    case "-"  => _ - _
    case "*"  => _ * _
    case "/"  => _ / _
    case "%"  => _ % _
    case "<"  => (x, y)  => getInt(x < y)
    case ">"  => (x, y)  => getInt(x > y)
    case "<=" => (x, y) => getInt(x <= y)
    case ">=" => (x, y) => getInt(x >= y)
    case "==" => (x, y) => getInt(x == y)
    case "!=" => (x, y) => getInt(x != y)
    case "&&" => (x, y) => getInt(getBool(x) && getBool(y))
    case "||" => (x, y) =>  getInt(getBool(x) || getBool(y))
  }
}
