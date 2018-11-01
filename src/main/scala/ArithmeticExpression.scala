class ArithmeticExpression extends ExpressionNode {
  private var evaluator: () => Int = _

  def this(num: Int) {
    this()
    evaluator = () => { num }
  }

  def this(left: ExpressionNode, op: ArithmeticOperator, right: ExpressionNode) {
    this()
    evaluator = () => { op.evaluator(left.eval, right.eval)}
  }

  override def eval: Int = evaluator()
  override def getResult: String = eval.toString
}