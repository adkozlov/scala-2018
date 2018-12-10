package ru.hse.spb.euler

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.spb.euler.nat._

/**
  * https://projecteuler.net/problem=321
  */
class SwappingCountersTest extends FlatSpec with Matchers {

  private type _40 = O[O[O[I[O[I[S]]]]]]

  private val answer: Long = 2470433131948040L

  "Value-level evaluate method" should "produce the correct answer" in {
    SwappingCountersValueLevel.evaluate(40) shouldEqual answer
  }

  "Type-level evaluate method" should "produce the correct answer" in {
    toLong[SwappingCountersTypeLevel.Evaluate[_40]] shouldEqual answer
  }
}
