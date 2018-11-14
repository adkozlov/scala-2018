package ru.spbau.jvm.scala.calculator

import java.util.InputMismatchException
import org.antlr.v4.runtime.RecognitionException

import scala.io.StdIn
import ru.spbau.jvm.scala.calculator.EvaluatorProvider._

object Main {
  def main(args: Array[String]): Unit = {
    try {
      println(eval(StdIn.readLine()))
    } catch {
      case e: InputMismatchException => println("Error: input mismatch: " + e.getMessage)
      case e: RecognitionException => println("Error: " + e.getMessage)
    }
  }

  def eval(inputExpression: String): String = {
    val expressionASTRoot = provideASTForTokenList(makeTokenListByExpression(inputExpression))
    new ExpressionEvaluatingVisitor().visitExpression(expressionASTRoot) match {
      case BooleanType(a) => a.toString
      case DoubleType(a) => a.toString
    }
  }
}
