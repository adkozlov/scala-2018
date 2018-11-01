class BooleanExpression extends ExpressionNode {
  private var evaluator: () => Int = _

  def this(boolean: Boolean) {
    this()
    evaluator = () => { if (boolean) 1 else 0 }
  }

  def this(left: ExpressionNode, op: BooleanOperator, right: ExpressionNode) {
    this()
    evaluator = () => { op.evaluator(left.eval, right.eval)}
  }

  override def eval: Int = evaluator()
  override def getResult: String = BooleanExpression.booleanString(eval)
}

object BooleanExpression {
  private def booleanString(value: Int): String = if (value == 0) "false" else "true"
}