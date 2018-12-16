package ru.hse.spb.kazakov

import org.scalatest._

class CalculatorTest extends FlatSpec {
  "Calculator" should "return 5 for 5" in {
    val calculator = new Calculator("5")
    assert(calculator.evaluate() == 5)
  }

  it should "return 2 for 1 + 1" in {
    val calculator = new Calculator("1 + 1")
    assert(calculator.evaluate() == 2)
  }

  it should "return 2 for 1+ 1" in {
    val calculator = new Calculator("1+ 1")
    assert(calculator.evaluate() == 2)
  }

  it should "return -43 for 100 - 143" in {
    val calculator = new Calculator("100 - 143")
    assert(calculator.evaluate() == -43)
  }

  it should "return 54 for (54)" in {
    val calculator = new Calculator("(54)")
    assert(calculator.evaluate() == 54)
  }

  it should "return 44 for ((((44))))" in {
    val calculator = new Calculator("((((44))))")
    assert(calculator.evaluate() == 44)
  }

  it should "return true for true" in {
    val calculator = new Calculator("true")
    assert(calculator.evaluate() == true)
  }

  it should "return true for ((true))" in {
    val calculator = new Calculator("((true))")
    assert(calculator.evaluate() == true)
  }

  it should "return false for (!(true))" in {
    val calculator = new Calculator("(!(true))")
    assert(calculator.evaluate() == false)
  }

  it should "return false for false" in {
    val calculator = new Calculator("false")
    assert(calculator.evaluate() == false)
  }

  it should "return false for (((false)))" in {
    val calculator = new Calculator("(((false)))")
    assert(calculator.evaluate() == false)
  }

  it should "return true for ((!(false)))" in {
    val calculator = new Calculator("((!(false)))")
    assert(calculator.evaluate() == true)
  }

  it should "return 12 for 3 * 4" in {
    val calculator = new Calculator("3 * 4")
    assert(calculator.evaluate() == 12)
  }

  it should "return 3 for 9 / 3" in {
    val calculator = new Calculator("9 / 3")
    assert(calculator.evaluate() == 3)
  }

  it should "return 1 for 5 % 4" in {
    val calculator = new Calculator("5 % 4")
    assert(calculator.evaluate() == 1)
  }

  it should "return false for false && true" in {
    val calculator = new Calculator("false && true")
    assert(calculator.evaluate() == false)
  }

  it should "return false for true && false" in {
    val calculator = new Calculator("true && false")
    assert(calculator.evaluate() == false)
  }

  it should "return false for false && false" in {
    val calculator = new Calculator("false && false")
    assert(calculator.evaluate() == false)
  }

  it should "return true for true && true" in {
    val calculator = new Calculator("true && true")
    assert(calculator.evaluate() == true)
  }

  it should "return true for false || true" in {
    val calculator = new Calculator("false || true")
    assert(calculator.evaluate() == true)
  }

  it should "return true for true || false" in {
    val calculator = new Calculator("true || false")
    assert(calculator.evaluate() == true)
  }

  it should "return false for false || false" in {
    val calculator = new Calculator("false || false")
    assert(calculator.evaluate() == false)
  }

  it should "return true for true || true" in {
    val calculator = new Calculator("true || true")
    assert(calculator.evaluate() == true)
  }

  it should "return 10 for 2 + 2 * 4" in {
    val calculator = new Calculator("2 + 2 * 4")
    assert(calculator.evaluate() == 10)
  }

  it should "return 16 for (2 + 2) * 4" in {
    val calculator = new Calculator("(2 + 2) * 4")
    assert(calculator.evaluate() == 16)
  }

  it should "return true for false && false || true" in {
    val calculator = new Calculator("false && false || true")
    assert(calculator.evaluate() == true)
  }

  it should "return false for false && (false || true)" in {
    val calculator = new Calculator("false && (false || true)")
    assert(calculator.evaluate() == false)
  }
}
