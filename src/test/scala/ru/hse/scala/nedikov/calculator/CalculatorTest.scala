package ru.hse.scala.nedikov.calculator

import org.scalatest.{FlatSpec, Matchers}

object CalculatorTest {
  def main(args: Array[String]): Unit = {
  }
}

class CalculatorTest extends FlatSpec with Matchers {
  def test(expected: Boolean, input: String): Unit = {
    test(if (expected) "true" else "false", input)
  }

  def test(expected: Double, input: String): Unit = {
    test(expected.toString, input)
  }

  def test(expected: String, input: String): Unit = {
    Calculator.evaluate(input) should be(expected)
  }

  "Evaluate method" should "be able to evaluate boolean expression" in {
    test(true, "true")
    test(true, "TRUE")
    test(false, "false")
    test(false, "FALSE")
  }

  "Evaluate method" should "be able to evaluate double expression" in {
    test(0, "0")
    test(12312, "12312")
    test(123.0456789, "123.0456789")
    test(1, "001.000")
  }

  "Evaluate method" should "be able to evaluate plus" in {
    test(0, "0 + 0")
    test(135, "123 + 12")
    test(135.4, "123 + 12.4")
  }

  "Evaluate method" should "be able to evaluate multiplication" in {
    test(0, "0 * 5")
    test(144, "12 * 12")
    test(40.4, "20.2 * 2")
  }

  "Evaluate method" should "be able to evaluate minus" in {
    test(0, "0 - 0")
    test(111, "123 - 12")
    test(99.6, "123 - 23.4")
  }

  "Evaluate method" should "be able to evaluate division" in {
    test(0, "0 / 5")
    test(5, "5 / 1")
    test(4.5, "9 / 2")
  }

  "Evaluate method" should "be able to evaluate expression with braces" in {
    test(4, "0 + (1 + 3)")
    test(25, "(1) + 12 * 2")
    test(12, "(12 + 12) / 2")
  }

  "Evaluate method" should "evaluate expression with correct operations priority" in {
    test(22, "(1 + 2) * 4 + 10")
    test(22, "10 + 4 * (1 + 2)")
    test(19, "1 + 2 * 4 * 1 + 10")
    test(19, "2 * 4 + 1 + 10")
  }

  "Evaluate method" should "be able to evaluate equality" in {
    test(true, "1 == 1")
    test(false, "23 == 24")
    test(true, "false == false")
    test(false, "true == false")
    test(false, "false == true")

  }

  "Evaluate method" should "be able to evaluate inequality" in {
    test(true, "1 != 1.1")
    test(false, "24 != 24")
    test(true, "true != false")
    test(true, "false != true")
    test(false, "true != true")
  }

  "Evaluate method" should "be able to evaluate comparision" in {
    test(true, "1 < 1.1")
    test(false, "1 < 1")
    test(false, "1.1 < 1")
    test(true, "1 <= 1.1")
    test(true, "1 <= 1")
    test(false, "1.1 <= 1")

    test(true, "1.1 > 1")
    test(false, "1 > 1")
    test(false, "1 > 1.1")
    test(true, "1.1 >= 1")
    test(true, "1 >= 1")
    test(false, "1 >= 1.1")
  }

  "Evaluate method" should "be able to evaluate operator and" in {
    test(true, "true && true")
    test(false, "false && true")
    test(false, "true && false")
    test(false, "false && false")
    test(true, "true && true && (1 < 2)")
  }


  "Evaluate method" should "be able to evaluate operator or" in {
    test(true, "true || true")
    test(true, "false || true")
    test(true, "true || false")
    test(false, "false || false")
    test(false, "false || false && (1 < 2)")
  }

  "Evaluate method" should "evaluate 'operator or' and 'operator and' in correct order" in {
    test(true, "true || false && true")
    test(true, "true && false || true")
    test(true, "true && (false || true)")
  }
}
