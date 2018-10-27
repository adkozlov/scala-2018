package ru.hse.mit

import java.io.{ByteArrayOutputStream, PrintStream}

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}
import org.scalatest.{FlatSpec, Matchers}

class CalcTest extends FlatSpec with Matchers {

  def getParsingErrors(expression: String): String = {
    val oldStderr = System.err
    val output = new ByteArrayOutputStream
    System.setErr(new PrintStream(output))

    val lexer = new CalcLexer(CharStreams.fromString(expression))
    new CalcParser(new BufferedTokenStream(lexer)).data()

    System.setErr(oldStderr)
    output.toString
  }


  def evaluate(expression: String): CalcToken = {
    val lexer = new CalcLexer(CharStreams.fromString(expression))
    val parser = new CalcParser(new BufferedTokenStream(lexer))
    new Calculator().visitData(parser.data())
  }

  "Parser" should "work correctly if expression is valid" in {
    getParsingErrors("1") should be("")
    getParsingErrors("(1)") should be("")
    getParsingErrors("(((123)))") should be("")
    getParsingErrors("(1) + (2)") should be("")
    getParsingErrors("1 + 3 - 4 * (12 / 22) == (3 < 7)") should be("")
    getParsingErrors("true") should be("")
    getParsingErrors("true < false") should be("")
    getParsingErrors("true || (1 < 2 + 3)") should be("")
  }

  it should "print an error if expression is not valid" in {
    getParsingErrors("(1") should not be ""
    getParsingErrors("(1 + 3))") should not be ""
    getParsingErrors("((1) - 3))") should not be ""
    getParsingErrors("1 + a") should not be ""
  }

  "Calculator" should "evaluate correctly primitive examples" in {
    evaluate("3 + 4") should be(IntCalcToken(7))
    evaluate("3 - 4") should be(IntCalcToken(-1))
    evaluate("3 * 4") should be(IntCalcToken(12))
    evaluate("23 / 4") should be(IntCalcToken(5))
    evaluate("23 % 4") should be(IntCalcToken(3))
    evaluate("3 < 4") should be(BooleanCalcToken(true))
    evaluate("3 > 4") should be(BooleanCalcToken(false))
    evaluate("3 <= 4") should be(BooleanCalcToken(true))
    evaluate("3 >= 4") should be(BooleanCalcToken(false))
    evaluate("3 != 4") should be(BooleanCalcToken(true))
    evaluate("3 == 4") should be(BooleanCalcToken(false))
    evaluate("3 == 3") should be(BooleanCalcToken(true))
    evaluate("true || false") should be(BooleanCalcToken(true))
    evaluate("true && false") should be(BooleanCalcToken(false))
  }

  it should "evaluate examples with parenthesis" in {
    evaluate("1 + (3 * 4)") should be(IntCalcToken(13))
    evaluate("(1 - 2) * (3 + 4)") should be(IntCalcToken(-7))
    evaluate("(1 < 2) || (3 * 4 == 12)") should be(BooleanCalcToken(true))
    evaluate("((1 + 2) - 3 * 4) > 5") should be(BooleanCalcToken(false))
  }

  it should "throw UnsupportedOperationException if necessary" in {
    a[UnsupportedOperationException] should be thrownBy {
      evaluate("1 + (2 == 3)")
    }
    a[UnsupportedOperationException] should be thrownBy {
      evaluate("(1 == 3) * (2 < 5)")
    }
    a[UnsupportedOperationException] should be thrownBy {
      evaluate("1 && 3")
    }
    a[UnsupportedOperationException] should be thrownBy {
      evaluate("(33 / 3 % 2 == 1) || 3")
    }
    a[UnsupportedOperationException] should be thrownBy {
      evaluate("true < 3")
    }
    a[UnsupportedOperationException] should be thrownBy {
      evaluate("(1 + 3 < 4) * false")
    }
  }
}
