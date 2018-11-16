package ru.hse

import org.scalatest.{FlatSpec, Matchers}

class CalculatorTest extends FlatSpec with Matchers {
  "A Calculator" should "evaluate atomic expressions" in {
    assert(Calculator.evaluate("true") === BoolValue(true))
    assert(Calculator.evaluate("false") === BoolValue(false))
    assert(Calculator.evaluate("1") === IntValue(1))
    assert(Calculator.evaluate("-1") === IntValue(-1))
    assert(Calculator.evaluate("(true)") === BoolValue(true))
    assert(Calculator.evaluate("(false)") === BoolValue(false))
    assert(Calculator.evaluate("(1)") === IntValue(1))
    assert(Calculator.evaluate("(-1)") === IntValue(-1))
  }

  "A Calculator" should "evaluate multiplicative expressions" in {
    assert(Calculator.evaluate("1 * (-1)") === IntValue(-1))
    assert(Calculator.evaluate("16 % 14 * 5") === IntValue(10))
    assertThrows[ArithmeticException](Calculator.evaluate("1 / 0"))
    assertThrows[BinaryOperationException](Calculator.evaluate("(5 > 6) * 1"))
  }

  "A Calculator" should "evaluate additive expressions" in {
    assert(Calculator.evaluate("1 - (-1)") === IntValue(2))
    assert(Calculator.evaluate("16 % 2 - 1 + (3 * 5)") === IntValue(14))
    assertThrows[BinaryOperationException](Calculator.evaluate("true % false"))
  }

  "A Calculator" should "evaluate relational expressions" in {
    assert(Calculator.evaluate("(1 < 1) <= (1 == -1)") === BoolValue(true))
    assert(Calculator.evaluate("(true != false) <= (16 % 2 > 0)") === BoolValue(false))
    assert(Calculator.evaluate("16 % 2 != false") === BoolValue(true))
    assertThrows[BinaryOperationException](Calculator.evaluate("true <= 1"))
  }

  "A Calculator" should "evaluate and expression" in {
    assert(Calculator.evaluate("(1 < 1) && (1 != -1)") === BoolValue(false))
    assert(Calculator.evaluate("(true != false) && (16 % 2 >= 0)") === BoolValue(true))
    assertThrows[BinaryOperationException](Calculator.evaluate("1 && 1"))
  }

  "A Calculator" should "evaluate or expression" in {
    assert(Calculator.evaluate("(1 < 1) || (1 != -1)") === BoolValue(true))
    assert(Calculator.evaluate("(true == false) && (16 % 2 > 0)") === BoolValue(false))
    assertThrows[BinaryOperationException](Calculator.evaluate("true || 1"))
  }
}
