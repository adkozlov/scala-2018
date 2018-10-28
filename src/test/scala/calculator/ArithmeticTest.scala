package calculator

import org.scalatest.{FlatSpec, Matchers}

class ArithmeticTest extends FlatSpec with Matchers {

  "Calculator" should "evaluate number" in {
    assert(Calculator.evaluate("1") === 1)
    assert(Calculator.evaluate("0") === 0)
    assert(Calculator.evaluate("17") === 17)
  }

  "Calculator" should "evaluate signed number" in {
    assert(Calculator.evaluate("-1") === -1)
    assert(Calculator.evaluate("+17") === 17)
  }

  "Calculator" should "evaluate double signed number" in {
    assert(Calculator.evaluate("--1") === 1)
    assert(Calculator.evaluate("++17") === 17)
  }

  "Calculator" should "evaluate multiplier" in {
    assert(Calculator.evaluate("1 - 1") === 0)
    assert(Calculator.evaluate("17 - 10 - 7") === 0)
    assert(Calculator.evaluate("12 + 5") === 17)
    assert(Calculator.evaluate("10 + 5 + 2") === 17)
    assert(Calculator.evaluate("12 - 5 + 10") === 17)
  }

  "Calculator" should "evaluate addend" in {
    assert(Calculator.evaluate("23 * 1") === 23)
    assert(Calculator.evaluate("12 / 4") === 3)
    assert(Calculator.evaluate("12 * 5 * 2") === 120)
    assert(Calculator.evaluate("12 / 3 / 2") === 2)
    assert(Calculator.evaluate("12 / 3 * 5") === 20)
  }

  "Calculator" should "evaluate multiplication and addition" in {
    assert(Calculator.evaluate("17 + (-3) * 2") === 11)
    assert(Calculator.evaluate("25 / 5 + (-5)") === 0)
    assert(Calculator.evaluate("12 * 5 - 100") === -40)
    assert(Calculator.evaluate("14 / 2 - 10") === -3)
    assert(Calculator.evaluate("14 / 2 + 2 * 6 - 2") === 17)
  }

  "Calculator" should "evaluate addition with brackets and multiplication" in {
    assert(Calculator.evaluate("(17 + (-3)) * 2") === 28)
    assert(Calculator.evaluate("25 / (5 + (-4))") === 25)
    assert(Calculator.evaluate("12 * (5 - 10)") === -60)
    assert(Calculator.evaluate("16 / (2 - 10)") === -2)
    assert(Calculator.evaluate("16 / (2 + 2) * (6 - 3)") === 12)
  }

}