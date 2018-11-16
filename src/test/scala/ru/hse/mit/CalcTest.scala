package ru.hse.mit

import java.io.{ByteArrayOutputStream, PrintStream}

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}
import org.scalatest.{FlatSpec, Matchers}

class CalcTest extends FlatSpec with Matchers {

  "Parser" should "work correctly if expression is valid" in {
    checkForParsingErrors("1", shouldFindErrors = false)
    checkForParsingErrors("(1)", shouldFindErrors = false)
    checkForParsingErrors("(((123)))", shouldFindErrors = false)
    checkForParsingErrors("(1) + (2)", shouldFindErrors = false)
    checkForParsingErrors("1 + 3 - 4 * (12 / 22) == (3 < 7)", shouldFindErrors = false)
    checkForParsingErrors("true", shouldFindErrors = false)
    checkForParsingErrors("true < false", shouldFindErrors = false)
    checkForParsingErrors("true || (1 < 2 + 3)", shouldFindErrors = false)
  }

  it should "print an error if expression is not valid" in {
    checkForParsingErrors("(1", shouldFindErrors = true)
    checkForParsingErrors("(1 + 3))", shouldFindErrors = true)
    checkForParsingErrors("((1) - 3))", shouldFindErrors = true)
    checkForParsingErrors("1 + a", shouldFindErrors = true)
  }

  "Calculator" should "evaluate correctly primitive examples" in {
    evaluate("3 + 4") should be(IntCalcOperand(7))
    evaluate("3 - 4") should be(IntCalcOperand(-1))
    evaluate("3 * 4") should be(IntCalcOperand(12))
    evaluate("23 / 4") should be(IntCalcOperand(5))
    evaluate("23 % 4") should be(IntCalcOperand(3))
    evaluate("3 < 4") should be(BooleanCalcOperand(true))
    evaluate("3 > 4") should be(BooleanCalcOperand(false))
    evaluate("3 <= 4") should be(BooleanCalcOperand(true))
    evaluate("3 >= 4") should be(BooleanCalcOperand(false))
    evaluate("3 != 4") should be(BooleanCalcOperand(true))
    evaluate("3 == 4") should be(BooleanCalcOperand(false))
    evaluate("3 == 3") should be(BooleanCalcOperand(true))
    evaluate("true || false") should be(BooleanCalcOperand(true))
    evaluate("true && false") should be(BooleanCalcOperand(false))
  }

  it should "evaluate examples with parenthesis" in {
    evaluate("1 + (3 * 4)") should be(IntCalcOperand(13))
    evaluate("(1 - 2) * (3 + 4)") should be(IntCalcOperand(-7))
    evaluate("(1 < 2) || (3 * 4 == 12)") should be(BooleanCalcOperand(true))
    evaluate("((1 + 2) - 3 * 4) > 5") should be(BooleanCalcOperand(false))
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

  private def checkForParsingErrors(expression: String, shouldFindErrors: Boolean) = {
    val oldStderr = System.err
    val output = new ByteArrayOutputStream
    System.setErr(new PrintStream(output))

    val lexer = new CalcLexer(CharStreams.fromString(expression))
    new CalcParser(new BufferedTokenStream(lexer)).data()

    System.setErr(oldStderr)
    val result = output.toString
    if (!shouldFindErrors) {
      result should be("")
    } else {
      result should not be ""
    }
  }


  private def evaluate(expression: String): CalcOperand = {
    Calculator.run(expression)
  }
}
