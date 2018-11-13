package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.Token
import ru.spbau.jvm.scala.calculator.ExpressionsLexer._

sealed trait FunctionProvider

case object UnaryArithmeticFunctionProvider extends FunctionProvider {
  def apply(operationToken: Token): Double => Double =
    operationToken.getType match {
      case PLUS => + _
      case MINUS => - _
    }
}

case object UnaryLogicalFunctionProvider extends FunctionProvider {
  def apply(operationToken: Token): Boolean => Boolean =
    operationToken.getType match {
      case NOT => ! _
    }
}

case object BinaryArithmeticFunctionProvider extends FunctionProvider {
  def apply(operationToken: Token): (Double, Double) => Double =
    operationToken.getType match {
      case PLUS => _ + _
      case MINUS => _ - _
      case MULT => _ * _
      case DIV => _ / _
    }
}

case object BinaryLogicalFunctionProvider extends FunctionProvider {
  def apply(operationToken: Token): (Boolean, Boolean) => Boolean =
    operationToken.getType match {
      case AND => _ && _
      case OR => _ || _
      case XOR => _ ^ _
    }
}

case object ArithmeticComparisonFunctionProvider extends FunctionProvider {
  def apply(operationToken: Token): (Double, Double) => Boolean =
    operationToken.getType match {
      case LT => _ < _
      case LEQ => _ <= _
      case GT => _ > _
      case GEQ => _ >= _
    }
}

case object EqualityComparisonFunctionProvider extends FunctionProvider {
  def apply(operationToken: Token): (ExpressionType, ExpressionType) => Boolean =
    operationToken.getType match {
      case EQ => _ == _
      case NEQ => _ != _
    }
}