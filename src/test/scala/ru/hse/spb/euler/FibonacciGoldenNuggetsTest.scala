package ru.hse.spb.euler

import nat._

import org.scalatest.{FlatSpec, Matchers}

/**
  * https://projecteuler.net/problem=137
  */
class FibonacciGoldenNuggetsTest extends FlatSpec with Matchers {

  type _15 = I[I[I[I[S]]]]
  val answer: Long = 1120149658760L

  "Type-level evaluate method" should "produce the correct answer" in {
    toLong[FibonacciGoldenNuggetsTypeLevel.Evaluate[_15]] shouldBe answer
  }

  "Value-level evaluate method" should "produce the correct answer" in {
    FibonacciGoldenNuggetsValueLevel.evaluate(15) shouldBe answer
  }
}
