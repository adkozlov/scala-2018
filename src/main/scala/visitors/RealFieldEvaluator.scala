package visitors

import grammar.RealFieldBaseVisitor
import grammar.RealFieldParser._

object RealFieldEvaluator extends RealFieldBaseVisitor[Int] {
  override def visitBinaryAddition(ctx: BinaryAdditionContext): Int = {
    val left = ctx.left.accept(this)
    if (ctx.right == null) return left
    val right = ctx.right.accept(this)

    ctx.operation.getType match {
      case PLUS => left + right
      case MINUS => left - right
      case _ => throw new IllegalStateException(s"Unknown operation in real field: ${ctx.operation}")
    }
  }

  override def visitBinaryMultiplication(ctx: BinaryMultiplicationContext): Int = {
    val left: Int = ctx.left.accept(this)
    if (ctx.right == null) return left
    val right = ctx.right.accept(this)

    ctx.operation.getType match {
      case DIVISION => left / right
      case MODULUS => left % right
      case PRODUCT => left * right
      case _ => throw new IllegalStateException(s"Unknown operation in real field: ${ctx.operation}")
    }
  }

  override def visitUnaryNegate(ctx: UnaryNegateContext): Int =
    -ctx.value.accept(this)

  override def visitLiteral(ctx: LiteralContext): Int =
    ctx.literal.getText.toInt
}
