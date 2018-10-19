package org.ifmo.calculator.eval

import org.ifmo.calculator.stack.elements._

class StackEvaluator() {
  def run(stack: List[StackElement]): Either[Boolean, Long] = {
    val top :: rest = stack

    top match {
      case op: ComparisonOperation => Left(evalComparisonOperation(op, rest)._1)
      case op: BoolOperation => Left(evalBooleanOperation(op, rest)._1)
      case op: ArithmeticOperation => Right(evalArithmeticOperation(op, rest)._1)
      case value: BoolValue => Left(value.value)
      case value: LongValue => Right(value.value)
    }
  }

  private def evaluateTopAsInt(stack: List[StackElement]): (Long, List[StackElement]) = {
    val top :: rest = stack
    top match {
      case op: ArithmeticOperation => evalArithmeticOperation(op, rest)
      case value: LongValue => (value.value, rest)
      case _ => throw new IllegalStateException("stack corrupted")
    }
  }

  private def evaluateTopAsBoolean(stack: List[StackElement]): (Boolean, List[StackElement]) = {
    val top :: rest = stack
    top match {
      case op: ComparisonOperation => evalComparisonOperation(op, rest)
      case op: BoolOperation => evalBooleanOperation(op, rest)
      case value: BoolValue => (value.value, rest)
      case _ => throw new IllegalStateException("stack corrupted")
    }
  }

  private def evalBooleanOperation(op: BoolOperation, stack: List[StackElement]): (Boolean, List[StackElement]) = {
    val (left, rest) = evaluateTopAsBoolean(stack)
    val (right, newStack) = evaluateTopAsBoolean(rest)

    (op.toFun.apply(left, right), newStack)
  }

  private def evalArithmeticOperation(op: ArithmeticOperation, stack: List[StackElement]): (Long, List[StackElement]) = {
    val (left, rest) = evaluateTopAsInt(stack)
    val (right, newStack) = evaluateTopAsInt(rest)

    (op.toFun.apply(left, right), newStack)
  }

  private def evalComparisonOperation(op: ComparisonOperation, stack: List[StackElement]): (Boolean, List[StackElement]) = {
    val (left, rest) = evaluateTopAsInt(stack)
    val (right, newStack) = evaluateTopAsInt(rest)

    (op.toFun.apply(left, right), newStack)
  }

}
