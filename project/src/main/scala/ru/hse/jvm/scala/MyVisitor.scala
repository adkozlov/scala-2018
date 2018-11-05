package ru.hse.jvm.scala

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

import scala.collection.JavaConverters._

class MyVisitor extends CalcParserBaseVisitor[Double] {
  override def visitEval(ctx: CalcParser.EvalContext): Double = visit(ctx.additionExp)

  val calc : (Double, (ParserRuleContext, TerminalNode)) => Double = (sum, pair) => pair match {
    case (arg2, op) => op.getSymbol.getText match {
      case "+" => sum + visit(arg2)
      case "-" => sum - visit(arg2)
      case "*" => sum * visit(arg2)
      case "/" => sum / visit(arg2)
    }
  }

  def calc(exps: Iterable[ParserRuleContext], ops: Iterable[TerminalNode]): Double = {
    exps.tail.zip(ops).foldLeft(visit(exps.head))(calc)
  }

  override def visitAdditionExp(ctx: CalcParser.AdditionExpContext): Double = {
    calc(ctx.multiplyExp().asScala, ctx.Add().asScala)
  }

  override def visitMultiplyExp(ctx: CalcParser.MultiplyExpContext): Double = {
    calc(ctx.atomExp().asScala, ctx.Mul().asScala)
  }

  override def visitAtomExp(ctx: CalcParser.AtomExpContext): Double = ctx.additionExp() match {
    case null => ctx.getText.toDouble
    case _ => visit(ctx.additionExp())
  }
}
