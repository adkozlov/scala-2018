package ru.spbau.jvm.scala.calculator

class OperationHolder(f: OperationProvider.Function) {
  def apply(x: Double): Double = f match {
    case OperationProvider.UnaryArithmeticFunction(g) => g(x)
    case _ => throw new ParsingExceptions.IncorrectOperationSignatureException
  }

  def apply(x: Double, y: Double): Double = f match {
    case OperationProvider.BinaryArithmeticFunction(g) => g(x, y)
    case _ => throw new ParsingExceptions.IncorrectOperationSignatureException
  }

  def apply(x: Boolean): Boolean = f match {
    case OperationProvider.UnaryLogicalFunction(g) => g(x)
    case _ => throw new ParsingExceptions.IncorrectOperationSignatureException
  }

  def apply(x: Boolean, y: Boolean): Boolean = f match {
    case OperationProvider.BinaryLogicalFunction(g) => g(x, y)
    case _ => throw new ParsingExceptions.IncorrectOperationSignatureException
  }

  def applyComparison(x: Double, y: Double): Boolean = f match {
    case OperationProvider.ArithmeticComparisonFunction(g) => g(x, y)
    case _ => throw new ParsingExceptions.IncorrectOperationSignatureException
  }
}
