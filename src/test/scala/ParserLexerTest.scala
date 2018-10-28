import grammar.{CalcLexer, CalcParser}
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}
import org.scalatest.{FlatSpec, Matchers}
import scala.collection.JavaConverters._

class ParserLexerTest extends FlatSpec with Matchers {
  private def getTokens(input: String): String = {
    val charStream = new ANTLRInputStream(input)
    val lexer = new CalcLexer(charStream)
    val tokens = lexer.getAllTokens().asScala.toList
    tokens.map(_.getText()).toString()
  }


  private def getContextName(input: String): String = {
    val charStream = new ANTLRInputStream(input)
    val lexer = new CalcLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    new CalcParser(tokens).expr().getClass.getName
  }

  "Lexer" should "return wright tokens" in {
    assert(getTokens("1+2") === "List(1, +, 2)")
    assert(getTokens("1.9") === "List(1.9)")
    assert(getTokens("false") === "List(false)")
    assert(getTokens("5 + (9 * 7) || true") === "List(5, +, (, 9, *, 7, ), ||, true)")
  }

  "Parser" should "return proper tree" in {
    assert(getContextName("5.9") === "grammar.CalcParser$NumberContext")
    assert(getContextName("true") === "grammar.CalcParser$LogicContext")
    assert(getContextName("1+2") === "grammar.CalcParser$BinOpContext")
    assert(getContextName("true||false") === "grammar.CalcParser$BinOpLogicContext")
    assert(getContextName("1+2||true") === "grammar.CalcParser$BinOpLogicContext")
    assert(getContextName("(4+7)") === "grammar.CalcParser$InParenthesesContext")
    assert(getContextName("-5") === "grammar.CalcParser$UnaryOpContext")
    assert(getContextName("!true") === "grammar.CalcParser$UnaryOpContext")
  }
}
