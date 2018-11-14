package calculator

import calculator.CalculatorParser._
import org.antlr.v4.runtime.Token

object ArithmeticEvaluator extends CalculatorBaseVisitor[Double] {

  def binaryOperation(left: Double, op: Token, right: Double): Double =
    op.getType match {
      case MULT => left * right
      case DIV => left / right
      case PLUS => left + right
      case MINUS => left - right
    }

  override def visitAddend(ctx: AddendContext): Double =
    ArithmeticEvaluator.binaryOperation(ctx.left.accept(this), ctx.op, ctx.right.accept(this))

  override def visitMultiplier(ctx: MultiplierContext): Double =
    ArithmeticEvaluator.binaryOperation(ctx.left.accept(this), ctx.op, ctx.right.accept(this))

  override def visitSignedAtom(ctx: SignedAtomContext): Double =
    (ctx.sign.getType match {
      case MINUS => -1
      case PLUS => 1
    }) * ctx.signedArithmeticAtom().accept(this)

  override def visitNumberArithmeticAtom(ctx: NumberArithmeticAtomContext): Double =
    ctx.NUMBER().getText.toDouble

  override def visitArithmeticAtomWithBrackets(ctx: ArithmeticAtomWithBracketsContext): Double =
    ctx.arithmeticExpression().accept(this)

}
