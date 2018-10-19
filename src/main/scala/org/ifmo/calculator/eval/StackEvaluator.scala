package org.ifmo.calculator.eval

import org.ifmo.calculator.stack.elements._

import scala.collection.mutable

class StackEvaluator(val stack: mutable.Stack[StackElement]) {
  def run(): Either[Boolean, Long] = {
    val element = stack.pop()

    element match {
      case op: ComparisonOperation => Left(evalComparisonOperation(op))
      case op: BoolOperation => Left(evalBooleanOperation(op))
      case op: ArithmeticOperation => Right(evalArithmeticOperation(op))
      case value: BoolValue => Left(value.value)
      case value: LongValue => Right(value.value)
    }
  }

  def evaluateTopAsInt(): Long = {
    val element = stack.pop()
    element match {
      case op: ArithmeticOperation => evalArithmeticOperation(op)
      case value: LongValue => value.value
      case _ => throw new IllegalStateException("stack corrupted")
    }
  }

  def evaluateTopAsBoolean(): Boolean = {
    val element = stack.pop()
    element match {
      case op: ComparisonOperation => evalComparisonOperation(op)
      case op: BoolOperation => evalBooleanOperation(op)
      case value: BoolValue => value.value
      case _ => throw new IllegalStateException("stack corrupted")
    }
  }

  def evalBooleanOperation(op: BoolOperation): Boolean = {
    val right = evaluateTopAsBoolean()
    val left = evaluateTopAsBoolean()

    op.toFun.apply(left, right)
  }

  def evalArithmeticOperation(op: ArithmeticOperation): Long = {
    val right = evaluateTopAsInt()
    val left = evaluateTopAsInt()

    op.toFun.apply(left, right)
  }

  def evalComparisonOperation(op: ComparisonOperation): Boolean = {
    val right = evaluateTopAsInt()
    val left = evaluateTopAsInt()

    op.toFun.apply(left, right)
  }

}
