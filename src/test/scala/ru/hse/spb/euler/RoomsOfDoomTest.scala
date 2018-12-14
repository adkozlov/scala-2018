package ru.hse.spb.euler

import org.scalatest.{FlatSpec, Matchers}
import nat._

/**
  * https://projecteuler.net/problem=327
  */
class RoomsOfDoomTest extends FlatSpec with Matchers {

  private val answer: Long = 34315549139516L

  "Value-level evaluate method" should "produce the correct answer" in {
    RoomsOfDoomValueLevel.evaluate(40, 30) shouldEqual answer
  }

  "Type-level evaluate method" should "produce the correct answer" in {
    toLong[RoomsOfDoomTypeLevel.Evaluate[_40, _30]] shouldEqual answer
  }
}
