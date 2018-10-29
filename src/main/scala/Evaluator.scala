import org.antlr.v4.runtime._
import ru.hse.expression.{ExpressionLexer, ExpressionParser}

object Evaluator {
  def evaluate(expression: String): String = {
    val lexer = new ExpressionLexer(CharStreams.fromString(expression))
    val parser = new ExpressionParser(new CommonTokenStream(lexer))
    lexer.removeErrorListeners()
    parser.removeErrorListeners()
    lexer.addErrorListener(AntlrErrorListener)
    parser.addErrorListener(AntlrErrorListener)

    val expressionVisitor = new ExpressionVisitor
    val result = expressionVisitor.visitExpression(parser.expression())
    result.getResult
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

class ParsingException(var message: String) extends Exception(message)