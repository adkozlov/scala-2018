package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.{ParserRuleContext, Token}
import ru.spbau.jvm.scala.calculator.CalcParser._

import scala.collection.JavaConverters._

class Evaluator extends CalcBaseVisitor[Result[_]] {
  private val logicEvaluator = new LogicEvaluator
  private val integerEvaluator = new IntegerEvaluator

  def evaluate(ctx: ExpressionContext): Result[_] = ctx.accept(this)

  override def visitExpression(ctx: ExpressionContext): Result[_] = {
    ctx.intExpr() match {
      case null => BoolResult(ctx.logicExpr().accept(logicEvaluator))
      case intExpr => IntResult(intExpr.accept(integerEvaluator))
    }
  }

  private class LogicEvaluator extends CalcBaseVisitor[Boolean] {
    override def visitLogicExpr(ctx: LogicExprContext): Boolean = {
      val context = ctx.logicOrExpr() match {
        case null => ctx.logicExpr()
        case orExpr => orExpr
      }
      context.accept(this)
    }

    override def visitLogicOrExpr(ctx: LogicOrExprContext): Boolean = {
      processBinaryExpr(ctx.`var`, ctx.vars.asScala, _ || _)
    }

    override def visitLogicAndExpr(ctx: LogicAndExprContext): Boolean = {
      processBinaryExpr(ctx.`var`, ctx.vars.asScala, _ && _)
    }

    private def processBinaryExpr(init: ParserRuleContext, vars: Seq[ParserRuleContext], op: (Boolean, Boolean) => Boolean): Boolean = {
      val initValue = init.accept(this)
      val varValues= vars.map(_.accept(this))
      varValues.fold(initValue)(op)
    }

    override def visitAtomLogicExpr(ctx: AtomLogicExprContext): Boolean = {
      ctx.constValue match {
        case null =>
          val context = ctx.value match {
            case null => ctx.logicOrExpr()
            case value => value
          }
          context.accept(this)
        case literal => literal.getText.equals("true")
      }
    }

    override def visitComparingExpr(ctx: ComparingExprContext): Boolean = {
      val left = ctx.var1.accept(integerEvaluator)
      val right = ctx.var2.accept(integerEvaluator)
      parseOperation(ctx.op)(left, right)
    }

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

  private class IntegerEvaluator extends CalcBaseVisitor[Int] {
    override def visitIntExpr(ctx: IntExprContext): Int = {
      if (ctx.additionExp() != null) {
        ctx.additionExp().accept(this)
      } else {
        ctx.intExpr().accept(this)
      }
    }

    override def visitAdditionExp(ctx: AdditionExpContext): Int = {
      processBinaryExpression(ctx.`var`, ctx.vars.asScala, ctx.ops.asScala)
    }

    override def visitMultiplyExp(ctx: MultiplyExpContext): Int = {
      processBinaryExpression(ctx.`var`, ctx.vars.asScala, ctx.ops.asScala)
    }

    private def processBinaryExpression(init: ParserRuleContext, vars: Seq[ParserRuleContext], ops: Seq[Token]) = {
      val initValue = init.accept(this)
      val varValues = vars.map(_.accept(this))
      val functions = ops.map(parseOperation)
      varValues.zip(functions).foldLeft(initValue) {
        case (left, (right, function)) => function(left, right)
      }
    }

    override def visitAtomExp(ctx: AtomExpContext): Int = {
      ctx.n match {
        case null => ctx.intExpr().accept(this)
        case literal => literal.getText.toInt
      }
    }

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
