package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.Token

import scala.collection.JavaConverters

class Evaluator extends CalcBaseVisitor[Either[Int, Boolean]] {
  private val logicEvaluator = new LogicEvaluator
  private val integerEvaluator = new IntegerEvaluator

  override def visitExpression(ctx: CalcParser.ExpressionContext): Either[Int, Boolean] = {
    if (ctx.intExpr() != null) {
      Left(ctx.intExpr().accept(integerEvaluator))
    } else {
      Right(ctx.logicExpr().accept(logicEvaluator))
    }
  }

  class LogicEvaluator extends CalcBaseVisitor[Boolean] {
    private val TRUE = "true"

    override def visitLogicExpr(ctx: CalcParser.LogicExprContext): Boolean = {
      if (ctx.logicOrExpr() != null) {
        ctx.logicOrExpr().accept(this)
      } else {
        ctx.logicExpr().accept(this)
      }
    }

    override def visitLogicOrExpr(ctx: CalcParser.LogicOrExprContext): Boolean = {
      val init = ctx.`var`.accept(this)
      val vars = JavaConverters.asScalaBuffer(ctx.vars).map({variable => variable.accept(this)})
      vars.fold(init)(_ || _)
    }

    override def visitLogicAndExpr(ctx: CalcParser.LogicAndExprContext): Boolean = {
      val init = ctx.`var`.accept(this)
      val vars = JavaConverters.asScalaBuffer(ctx.vars).map({variable => variable.accept(this)})
      vars.fold(init)(_ && _)
    }

    override def visitAtomLogicExpr(ctx: CalcParser.AtomLogicExprContext): Boolean = {
      if (ctx.value != null) {
        ctx.value.accept(this)
      } else if (ctx.constValue != null) {
        parseLiteral(ctx.constValue)
      } else {
        ctx.logicOrExpr().accept(this)
      }
    }

    override def visitEqualityExpr(ctx: CalcParser.EqualityExprContext): Boolean = {
      val left = ctx.var1.accept(integerEvaluator)
      val right = ctx.var2.accept(integerEvaluator)
      parseOperation(ctx.op)(left, right)
    }

    private def parseLiteral(literal: Token): Boolean = literal.getText.equals(TRUE)

    private def parseOperation(operation: Token): (Int, Int) => Boolean = operation.getText match {
      case "==" => _ == _
      case "!=" => _ != _
      case "<=" => _ <= _
      case ">=" => _ >= _
      case "<" => _ < _
      case ">" => _ > _
      case _ => throw new IllegalArgumentException("Illegal operation")
    }
  }

  class IntegerEvaluator extends CalcBaseVisitor[Int] {
    override def visitIntExpr(ctx: CalcParser.IntExprContext): Int = {
      if (ctx.additionExp() != null) {
        ctx.additionExp().accept(this)
      } else {
        ctx.intExpr().accept(this)
      }
    }

    override def visitAdditionExp(ctx: CalcParser.AdditionExpContext): Int = {
      val init = ctx.`var`.accept(this)
      val ops = JavaConverters.asScalaBuffer(ctx.ops).map(op => parseOperation(op))
      val vars = JavaConverters.asScalaBuffer(ctx.vars)
        .map(variable => variable.accept(this))
      vars.zip(ops).foldLeft(init){ (a, tup) => tup._2(a, tup._1)}
    }

    override def visitMultiplyExp(ctx: CalcParser.MultiplyExpContext): Int = {
      val init = ctx.`var`.accept(this)
      val ops = JavaConverters.asScalaBuffer(ctx.ops).map(op => parseOperation(op))
      val vars = JavaConverters.asScalaBuffer(ctx.vars)
        .map(variable => variable.accept(this))
      vars.zip(ops).foldLeft(init){ (a, tup) => tup._2(a, tup._1)}
    }

    override def visitAtomExp(ctx: CalcParser.AtomExpContext): Int = {
      if (ctx.n != null) {
        parseLiteral(ctx.n)
      } else {
        ctx.intExpr().accept(this)
      }
    }

    private def parseLiteral(literal: Token): Int = literal.getText.toInt

    private def parseOperation(operation: Token): (Int, Int) => Int = operation.getText match {
        case "+" => _ + _
        case "-" => _ - _
        case "*" => _ * _
        case "/" => _ / _
        case "%" => _ % _
        case _ => throw new IllegalArgumentException("Illegal operation")
    }
  }
}
