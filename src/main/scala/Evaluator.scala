import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import ru.hse.expression.{ExpressionLexer, ExpressionParser}

object Evaluator {
  def evaluate(expression: String): String = {
    val lexer = new ExpressionLexer(CharStreams.fromString(expression))
    val parser = new ExpressionParser(new CommonTokenStream(lexer))
    val expressionVisitor = new ExpressionVisitor
    val result = expressionVisitor.visitExpression(parser.expression())
    return result.getResult
  }
}
