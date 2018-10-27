package ru.hse

import org.scalatest.{FlatSpec, Matchers}

class ExpressionVisitorTest extends FlatSpec with Matchers {
  "A Calculator" should "evaluate atomic expressions" in {
    val calculator = new Calculator
    assert(calculator.evaluate("true") === BoolLiteral(true))
    assert(calculator.evaluate("false") === BoolLiteral(false))
    assert(calculator.evaluate("1") === IntLiteral(1))
    assert(calculator.evaluate("-1") === IntLiteral(-1))
    assert(calculator.evaluate("(true)") === BoolLiteral(true))
    assert(calculator.evaluate("(false)") === BoolLiteral(false))
    assert(calculator.evaluate("(1)") === IntLiteral(1))
    assert(calculator.evaluate("(-1)") === IntLiteral(-1))
  }

  "A Calculator" should "evaluate multiplicative expressions" in {
    val calculator = new Calculator
    assert(calculator.evaluate("1 * (-1)") === IntLiteral(-1))
    assert(calculator.evaluate("16 % 14 * 5") === IntLiteral(10))
    assertThrows[ArithmeticException](calculator.evaluate("1 / 0"))
    assertThrows[BinaryOperationException](calculator.evaluate("(5 > 6) * 1"))
  }

  "A Calculator" should "evaluate additive expressions" in {
    val calculator = new Calculator
    assert(calculator.evaluate("1 - (-1)") === IntLiteral(2))
    assert(calculator.evaluate("16 % 2 - 1 + (3 * 5)") === IntLiteral(14))
    assertThrows[BinaryOperationException](calculator.evaluate("true % false"))
  }

  "A Calculator" should "evaluate relational expressions" in {
    val calculator = new Calculator
    assert(calculator.evaluate("(1 < 1) <= (1 == -1)") === BoolLiteral(true))
    assert(calculator.evaluate("(true != false) <= (16 % 2 > 0)") === BoolLiteral(false))
    assert(calculator.evaluate("16 % 2 != false") === BoolLiteral(true))
    assertThrows[BinaryOperationException](calculator.evaluate("true <= 1"))
  }

  "A Calculator" should "evaluate and expression" in {
    val calculator = new Calculator
    assert(calculator.evaluate("(1 < 1) && (1 != -1)") === BoolLiteral(false))
    assert(calculator.evaluate("(true != false) && (16 % 2 >= 0)") === BoolLiteral(true))
    assertThrows[BinaryOperationException](calculator.evaluate("1 && 1"))
  }

  "A Calculator" should "evaluate or expression" in {
    val calculator = new Calculator
    assert(calculator.evaluate("(1 < 1) || (1 != -1)") === BoolLiteral(true))
    assert(calculator.evaluate("(true == false) && (16 % 2 > 0)") === BoolLiteral(false))
    assertThrows[BinaryOperationException](calculator.evaluate("true || 1"))
  }
}
