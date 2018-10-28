package ru.spb.hse.tukh.hw01

import org.scalatest.{FlatSpec, Matchers}
import Main.getResult
import ru.spb.hse.tukh.hw01.Exception.EvaluatorArithmeticException

class CalculatorTest extends FlatSpec with Matchers {
  "Calculator" should "correctly calculate result of arithmetic operations" in {
    getResult("1 + 1") should equal(2)
    getResult("1 - 1") should equal(0)
    getResult("2 * 3") should equal(6)
    getResult("5 / 4") should equal(1)
    getResult("6 % 4") should equal(2)
  }

  it should "correctly compare numbers" in {
    getResult("1 > 1") should equal(0)
    getResult("1 >= 1") should equal(1)
    getResult("5 < 6") should equal(1)
    getResult("5 >= 4") should equal(1)
  }

  it should "correctly evaluate boolean expression" in {
    getResult("false && false") should equal(0)
    getResult("false && true") should equal(0)
    getResult("true && false") should equal(0)
    getResult("true && true") should equal(1)
  }

  it should "correctly calculate complex expressions" in {
    getResult("(1 + 2) * 3") should equal(9)
    getResult("(1 - 2) * 3 - 4") should equal(-7)
    getResult("(1 + 1) * 3 - 1 + 1 - 1 + 1 / 2") should equal(5)
    getResult("1 / 2 + (1 - 1) * 3 - 4") should equal(-4)
  }

  it should "correctly convert boolean numbers" in {
    getResult("false") should equal(0)
    getResult("true") should equal(1)
  }

  it should "correctly calculate values of expressions with boolean numbers" in {
    getResult("false + false") should equal(0)
    getResult("true + false") should equal(1)
    getResult("true + true") should equal(2)
  }

  it should "correctly calculate values of expressions with complex expressions" in {
    getResult("(1 > 2) && (1 > 2)") should equal(0)
    getResult("(1 > 2) * (1 < 2)") should equal(0)
    getResult("(2 >= 2) && ((3 - 1) >= (2 - 4))") should equal(1)
  }

  it should "throw exception" in {
    assertThrows[EvaluatorArithmeticException] {
      getResult("1/0")
    }
    assertThrows[EvaluatorArithmeticException] {
      getResult("1%0")
    }
  }
}
