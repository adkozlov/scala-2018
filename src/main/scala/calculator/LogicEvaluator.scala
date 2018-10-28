package calculator

import calculator.CalculatorParser._

class LogicEvaluator extends CalculatorBaseVisitor[Boolean] {

  override def visitConjunction(ctx: ConjunctionContext): Boolean =
    ctx.left.accept(this) && ctx.right.accept(this)

  override def visitDisjunction(ctx: DisjunctionContext): Boolean =
    ctx.left.accept(this) || ctx.right.accept(this)

  override def visitNegatedLogicAtom(ctx: NegatedLogicAtomContext): Boolean =
    !ctx.logicAtom().accept(this)

  override def visitLiteralLogicAtom(ctx: LiteralLogicAtomContext): Boolean =
    ctx.literal.getType match {
      case TRUE => true
      case FALSE => false
    }

  override def visitLogicAtomWithBrackets(ctx: LogicAtomWithBracketsContext): Boolean =
    ctx.logicExpression().accept(this)

}
