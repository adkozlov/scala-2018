package calculator

import calculator.CalculatorParser.{ArithmeticContext, LogicContext}

class CalculatorEvaluator extends CalculatorBaseVisitor[Any] {

  override def visitLogic(ctx: LogicContext): Boolean =
    ctx.logicExpression().accept(new LogicEvaluator())

  override def visitArithmetic(ctx: ArithmeticContext): Double =
    ctx.arithmeticExpression().accept(new ArithmeticEvaluator())

}
