package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.Token
import ru.spbau.jvm.scala.calculator.ExpressionsLexer._
import ru.spbau.jvm.scala.calculator.Operation._

object OperationProvider {

  sealed trait Function

  case class UnaryArithmeticFunction(f: Double => Double) extends Function
  case class BinaryArithmeticFunction(f: (Double, Double) => Double) extends Function
  case class UnaryLogicalFunction(f: Boolean => Boolean) extends Function
  case class BinaryLogicalFunction(f: (Boolean, Boolean) => Boolean) extends Function

  def get(token: Token, opType: Operation.Type): OperationHolder =
    new OperationHolder(
      (token.getType, opType) match {
        case (PLUS, UNARY) => UnaryArithmeticFunction(+_)
        case (MINUS, UNARY) => UnaryArithmeticFunction(-_)
        case (PLUS, BINARY) => BinaryArithmeticFunction(_ + _)
        case (MINUS, BINARY) => BinaryArithmeticFunction(_ - _)
        case (MULT, _) => BinaryArithmeticFunction(_ * _)
        case (DIV, _) => BinaryArithmeticFunction(_ / _)
        case (NOT, _) => UnaryLogicalFunction(!_)
        case (AND, _) => BinaryLogicalFunction(_ && _)
        case (XOR, _) => BinaryLogicalFunction(_ ^ _)
        case (OR, _) => BinaryLogicalFunction(_ || _)
        case (EQUIV, _) => BinaryLogicalFunction(_ == _)
        case _ => throw new ParsingExceptions.IncorrectOperationException(token, opType)
      }
    )
}
