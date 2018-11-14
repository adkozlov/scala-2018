package calculator

import calculator.CalculatorParser.{ArithmeticContext, LogicContext}

object CalculatorEvaluator extends CalculatorBaseVisitor[AnyVal] {

  override def visitLogic(ctx: LogicContext): Boolean =
    ctx.logicExpression().accept(LogicEvaluator)

  override def visitArithmetic(ctx: ArithmeticContext): Double =
    ctx.arithmeticExpression().accept(ArithmeticEvaluator)

}
