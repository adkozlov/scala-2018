package ru.hse.spb.scala.sharkova.calculator

import ru.hse.spb.scala.sharkova.calculator.ArithmeticParser.InputContext

import scala.math._

class Calculator() extends ArithmeticBaseVisitor[Double] {
  implicit private def booleanToDouble(b: Boolean): Double = if (b) 1 else 0
  implicit private def doubleToBoolean(d: Double): Boolean = if (d != 0) true else false

  def apply(): Calculator = new Calculator()

  def evaluate(ctx: InputContext): Double = {
    ctx.expression().accept(this)
  }

  override def visitFunctionExpr(ctx: ArithmeticParser.FunctionExprContext): Double = {
    val value = ctx.expression().accept(this)
    val function = ctx.function.getText

    function match {
      case "sin" => sin(value)
      case "cos" => cos(value)
    }
  }

  override def visitAdditionExpr(ctx: ArithmeticParser.AdditionExprContext): Double = {
    val left = ctx.left.accept(this)
    val right = ctx.right.accept(this)
    val op = ctx.op.getText

    op match {
      case "+" => left + right
      case "-" => left - right
    }
  }

  override def visitMultiplicationExpr(ctx: ArithmeticParser.MultiplicationExprContext): Double = {
    val left = ctx.left.accept(this)
    val right = ctx.right.accept(this)
    val op = ctx.op.getText

    op match {
      case "*" => left * right
      case "/" => if (right == 0)
        throw new CalculatorException("Division right argument evaluated to 0")
        else left / right
      case "%" => if (right == 0)
        throw new CalculatorException("Modulo right argument evaluated to 0")
        else left % right
    }
  }

  override def visitLogicalExpr(ctx: ArithmeticParser.LogicalExprContext): Double = {
    val left = ctx.left.accept(this)
    val right = ctx.right.accept(this)
    val op = ctx.op.getText

    op match {
      case "||" => left || right
      case "&&" => left && right
    }
  }

  override def visitNegateExpression(ctx: ArithmeticParser.NegateExpressionContext): Double = {
    val value = ctx.expression().accept(this)

    !value
  }

  override def visitUnaryExpr(ctx: ArithmeticParser.UnaryExprContext): Double = {
    val value = ctx.expression().accept(this)
    val op = ctx.op.getText

    op match {
      case "+" => value
      case "-" => -value
    }
  }

  override def visitParenthesisedExpr(ctx: ArithmeticParser.ParenthesisedExprContext): Double = {
    ctx.expression().accept(this)
  }

  override def visitLiteralExpr(ctx: ArithmeticParser.LiteralExprContext): Double = {
    ctx.DOUBLE().getText.toDouble
  }
}
