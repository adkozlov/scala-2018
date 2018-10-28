import grammar._

import scala.util.Try


class CalcVisitorApp extends CalcParserBaseVisitor[Double] {

  override def visitMainExpr(ctx: CalcParser.MainExprContext): Double = {
    ctx.expr().accept(this)
  }

  override def visitNumber(ctx: CalcParser.NumberContext): Double = {
    parseDouble(ctx.NUMBER().toString).getOrElse(0.0)
  }

  override def visitLogicalVar(ctx: CalcParser.LogicalVarContext): Double = {
    val value = Option(ctx.TRUE())

    value match {
      case Some(n) => 1.0
      case None => 0.0
    }

  }

  override def visitBinOp(ctx: CalcParser.BinOpContext): Double = {
    val left = ctx.expr(0).accept(this)
    val right = ctx.expr(1).accept(this)
    val operator = ctx.op.getText
    val result = calculate(left, right, operator)
    result match {
      case Some(n) => result.get
      case None => throw new IllegalArgumentException(s"Illegal operation $left $operator $right")
    }

  }

  override def visitLogic(ctx: CalcParser.LogicContext): Double = {
    ctx.logicalVar().accept(this)
  }

  override def visitBinOpLogic(ctx: CalcParser.BinOpLogicContext): Double = {
    val left = ctx.expr(0).accept(this)
    val right = ctx.expr(1).accept(this)
    val operator = ctx.op.getText
    calculateLog(left, right, operator)
  }

  override def visitInParentheses(ctx: CalcParser.InParenthesesContext): Double = {
    ctx.expr().accept(this)
  }

  override def visitUnaryOp(ctx: CalcParser.UnaryOpContext): Double = {
    val expr = ctx.expr()
    val operand = ctx.op.getText
    if (operand.equals("!")) {
      return bool2double(!double2bool(expr.accept(this)))
    }
    else if (operand.equals("-")) {
      return -1.0 * expr.accept(this)
    }
    else {
      println(s"No such unary operator! Will be ignored!")
      return expr.accept(this)
    }

  }

  private def parseDouble(s: String): Option[Double] = Try(s.toDouble).toOption

  private def bool2double(b: Boolean) = if (b) 1.0 else 0.0

  private def double2bool(d: Double) = if (d == 0.0) false else true

  private def calculate(l: Double, r: Double, operation: String): Option[Double] = {
    operation match {
      case "+" => Some(l + r)
      case "-" => Some(l - r)
      case "*" => Some(l * r)
      case "/" => Try(l / r).toOption
      case "%" => Some(l % r)
      case "^" => Some(Math.pow(l, r))
      case _ =>
        println(s"Unsupported operation $operation")
        None
    }
  }

  private def calculateLog(l: Double, r: Double, operation: String): Double = {
    operation match {
      case "||" => bool2double(double2bool(l) || double2bool(r))
      case "&&" => bool2double(double2bool(l) && double2bool(r))
      case "==" => bool2double(l == r)
      case "!=" => bool2double(l != r)
      case ">" => bool2double(l > r)
      case "<" => bool2double(l < r)
      case ">=" => bool2double(l >= r)
      case "<=" => bool2double(l <= r)
      case _ =>
        println(s"Unsupported operation $operation")
        0.0
    }
  }

}
