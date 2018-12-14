package ru.hse.spb.euler

import nat._

import org.scalatest.{FlatSpec, Matchers}

/**
  * https://projecteuler.net/problem=138
  */
class SpecialIsoscelesTrianglesTest extends FlatSpec with Matchers {

  private val answer: Long = 1118049290473932L

  "Type-level evaluate method" should "produce the correct answer" in {
    toLong[SpecialIsoscelesTrianglesTypeLevel.Evaluate[_12]] shouldBe answer
  }

  "Value-level evaluate method" should "produce the correct answer" in {
    SpecialIsoscelesTrianglesValueLevel.evaluate(12) shouldBe answer
  }
}
