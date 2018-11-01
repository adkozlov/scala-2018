import org.antlr.v4.runtime._
import ru.hse.expression.{ExpressionLexer, ExpressionParser}

object Evaluator {
  def getExpressionTree(expression: String): ExpressionNode = {
    val lexer = new ExpressionLexer(CharStreams.fromString(expression))
    val parser = new ExpressionParser(new CommonTokenStream(lexer))
    lexer.removeErrorListeners()
    parser.removeErrorListeners()
    lexer.addErrorListener(AntlrErrorListener)
    parser.addErrorListener(AntlrErrorListener)

    val expressionVisitor = new ExpressionVisitor
    expressionVisitor.visitExpression(parser.expression())
  }

  def getStringResult(expression: String): String = {
    getExpressionTree(expression).getResult
  }

  def getIntResult(expression: String): Int = {
    getExpressionTree(expression).eval
  }
}

private object AntlrErrorListener extends BaseErrorListener {
  override def syntaxError(
                            recognizer: Recognizer[_, _],
                            offendingSymbol: Any,
                            line: Int,
                            charPositionInLine: Int,
                            msg: String,
                            e: RecognitionException): Unit = {
    throw new ParsingException(msg)
  }

}
