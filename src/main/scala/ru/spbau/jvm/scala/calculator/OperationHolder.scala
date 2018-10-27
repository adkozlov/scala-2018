package ru.spbau.jvm.scala.calculator

class OperationHolder(f: OperationProvider.Function) {
  def apply(x: Double): Double = f match {
    case OperationProvider.UnaryArithmeticFunction(g) => g(x)
  }

  def apply(x: Double, y: Double): Double = f match {
    case OperationProvider.BinaryArithmeticFunction(g) => g(x, y)
  }

  def apply(x: Boolean): Boolean = f match {
    case OperationProvider.UnaryLogicalFunction(g) => g(x)
  }

  def apply(x: Boolean, y: Boolean): Boolean = f match {
    case OperationProvider.BinaryLogicalFunction(g) => g(x, y)
  }

  def applyComparison(x: Double, y: Double): Boolean = f match {
    case OperationProvider.ArithmeticComparisonFunction(g) => g(x, y)
  }
}
