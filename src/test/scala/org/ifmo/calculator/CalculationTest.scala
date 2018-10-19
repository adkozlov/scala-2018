package org.ifmo.calculator

import org.scalatest.{FlatSpec, Matchers}

class CalculationTest extends FlatSpec with Matchers {

  def eval(toEval: String): Either[Boolean, Long] = {
    Runner.run(toEval)
  }

  "Calculator" should "return 10" in {
    val value = Runner.run("9 + 1")
    val bool = value.right.exists(it => it.equals(10L))
    assert(
      bool
    )

  }

  "Calculator" should "return -2" in {
    val value = Runner.run("-2")
    assert(
      value.right.exists(it => it.equals(-2L)))

  }


  "Calculator" should "return true" in {
    val value = Runner.run("10 > 2 && true")
    assert(
      value.left.exists(it => it.equals(true)))

  }

  "Calculator" should "return fase" in {
    val value = Runner.run("10 > 2 && false")
    assert(
      value.left.exists(it => it.equals(false)))

  }


  "Calculator" should "return 99883" in {
    val value = Runner.run("1000 * 200 - (200234 * 1) / 2")
    assert(
      value.right.exists(it => it.equals(99883L)))

  }

  "Calculator" should "return true again" in {
    val value = Runner.run("false || true && (4 > 20 || 10 < 20) ")
    assert(
      value.left.exists(it => it.equals(true)))

  }
}

