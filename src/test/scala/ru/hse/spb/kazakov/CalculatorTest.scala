package ru.hse.spb.kazakov

import org.scalatest._

class CalculatorTest extends FlatSpec {
  "Calculator" should "return 5 for 5" in {
    val calculator = new Calculator("5")
    assert(calculator.evaluate() == 5)
  }

  "Calculator" should "return 2 for 1 + 1" in {
    val calculator = new Calculator("1 + 1")
    assert(calculator.evaluate() == 2)
  }

  "Calculator" should "return 2 for 1+ 1" in {
    val calculator = new Calculator("1+ 1")
    assert(calculator.evaluate() == 2)
  }

  "Calculator" should "return -43 for 100 - 143" in {
    val calculator = new Calculator("100 - 143")
    assert(calculator.evaluate() == -43)
  }

  "Calculator" should "return 54 for (54)" in {
    val calculator = new Calculator("(54)")
    assert(calculator.evaluate() == 54)
  }

  "Calculator" should "return 44 for ((((44))))" in {
    val calculator = new Calculator("((((44))))")
    assert(calculator.evaluate() == 44)
  }

  "Calculator" should "return 1 for true" in {
    val calculator = new Calculator("true")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for false" in {
    val calculator = new Calculator("false")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 12 for 3 * 4" in {
    val calculator = new Calculator("3 * 4")
    assert(calculator.evaluate() == 12)
  }

  "Calculator" should "return 3 for 9 / 3" in {
    val calculator = new Calculator("9 / 3")
    assert(calculator.evaluate() == 3)
  }

  "Calculator" should "return 1 for 5 % 4" in {
    val calculator = new Calculator("5 % 4")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for 5 > 10" in {
    val calculator = new Calculator("5 > 10")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 1 for 65 > 10" in {
    val calculator = new Calculator("65 > 10")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for 5 < -10" in {
    val calculator = new Calculator("5 < -10")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 1 for -5 < 10" in {
    val calculator = new Calculator("-5 < 10")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for 5 >= 10" in {
    val calculator = new Calculator("5 >= 10")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 1 for 65 >= 10" in {
    val calculator = new Calculator("65 >= 10")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for 5 <= -10" in {
    val calculator = new Calculator("5 <= -10")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 1 for -5 <= 10" in {
    val calculator = new Calculator("-5 <= 10")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 1 for 1 <= 1" in {
    val calculator = new Calculator("1 <= 1")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 1 for -5 >= -5" in {
    val calculator = new Calculator("-5 <= -5")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for 1 == 11" in {
    val calculator = new Calculator("1 == 11")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 1 for -5 == -5" in {
    val calculator = new Calculator("-5 == -5")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for 111 != 111" in {
    val calculator = new Calculator("111 != 111")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 1 for -25 != 25" in {
    val calculator = new Calculator("-25 != 25")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 1 for -11 && 21" in {
    val calculator = new Calculator("-11 && 21")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for 0 && 32" in {
    val calculator = new Calculator("0 && 32")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 0 for 321 && 0" in {
    val calculator = new Calculator("321 && 0")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 0 for false && 31" in {
    val calculator = new Calculator("false && 31")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 1 for -11 || 21" in {
    val calculator = new Calculator("-11 || 21")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 1 for 0 || 32" in {
    val calculator = new Calculator("0 || 32")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 1 for false || 31" in {
    val calculator = new Calculator("false || 31")
    assert(calculator.evaluate() == 1)
  }

  "Calculator" should "return 0 for 0 || false" in {
    val calculator = new Calculator("0 || false")
    assert(calculator.evaluate() == 0)
  }

  "Calculator" should "return 6 for 2 + 2 * 2" in {
    val calculator = new Calculator("2 + 2 * 2")
    assert(calculator.evaluate() == 6)
  }

  "Calculator" should "return 0 for 3 + (4 - 5) * 6 / 3 != 1 || true && false" in {
    val calculator = new Calculator("3 + (4 - 5) * 6 / 3 != 1 || true && false")
    assert(calculator.evaluate() == 0)
  }

}
