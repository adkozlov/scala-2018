package ru.spbau.jvm.scala.calculator

import scala.io.StdIn
import ru.spbau.jvm.scala.calculator.EvaluatorProvider._

object Main {
  def main(args: Array[String]): Unit = {
    try {
      println(eval(StdIn.readLine()))
    } catch {
      case e: Exception => println("[Error] " + e.getMessage)
    }
  }

  def eval(s: String): String = {
    val expressionASTRoot = applyParser(applyLexer(s))
    new ExpressionEvaluatingVisitor().visitExpression(expressionASTRoot) match {
      case Left(a) => a.toString
      case Right(a) => a.toString
    }
  }
}
