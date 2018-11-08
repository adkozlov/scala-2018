package ru.hse

import org.scalatest.{FlatSpec, Matchers}

class CalculatorTest extends FlatSpec with Matchers {
  "A Calculator" should "evaluate atomic expressions" in {
    assert(Calculator.evaluate("true") === BoolLiteral(true))
    assert(Calculator.evaluate("false") === BoolLiteral(false))
    assert(Calculator.evaluate("1") === IntLiteral(1))
    assert(Calculator.evaluate("-1") === IntLiteral(-1))
    assert(Calculator.evaluate("(true)") === BoolLiteral(true))
    assert(Calculator.evaluate("(false)") === BoolLiteral(false))
    assert(Calculator.evaluate("(1)") === IntLiteral(1))
    assert(Calculator.evaluate("(-1)") === IntLiteral(-1))
  }

  "A Calculator" should "evaluate multiplicative expressions" in {
    assert(Calculator.evaluate("1 * (-1)") === IntLiteral(-1))
    assert(Calculator.evaluate("16 % 14 * 5") === IntLiteral(10))
    assertThrows[ArithmeticException](Calculator.evaluate("1 / 0"))
    assertThrows[BinaryOperationException](Calculator.evaluate("(5 > 6) * 1"))
  }

  "A Calculator" should "evaluate additive expressions" in {
    assert(Calculator.evaluate("1 - (-1)") === IntLiteral(2))
    assert(Calculator.evaluate("16 % 2 - 1 + (3 * 5)") === IntLiteral(14))
    assertThrows[BinaryOperationException](Calculator.evaluate("true % false"))
  }

  "A Calculator" should "evaluate relational expressions" in {
    assert(Calculator.evaluate("(1 < 1) <= (1 == -1)") === BoolLiteral(true))
    assert(Calculator.evaluate("(true != false) <= (16 % 2 > 0)") === BoolLiteral(false))
    assert(Calculator.evaluate("16 % 2 != false") === BoolLiteral(true))
    assertThrows[BinaryOperationException](Calculator.evaluate("true <= 1"))
  }

  "A Calculator" should "evaluate and expression" in {
    assert(Calculator.evaluate("(1 < 1) && (1 != -1)") === BoolLiteral(false))
    assert(Calculator.evaluate("(true != false) && (16 % 2 >= 0)") === BoolLiteral(true))
    assertThrows[BinaryOperationException](Calculator.evaluate("1 && 1"))
  }

  "A Calculator" should "evaluate or expression" in {
    assert(Calculator.evaluate("(1 < 1) || (1 != -1)") === BoolLiteral(true))
    assert(Calculator.evaluate("(true == false) && (16 % 2 > 0)") === BoolLiteral(false))
    assertThrows[BinaryOperationException](Calculator.evaluate("true || 1"))
  }
}
