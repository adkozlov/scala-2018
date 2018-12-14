package ru.hse.spb.euler

import org.scalatest.{FlatSpec, Matchers}
import nat._

/**
  * https://projecteuler.net/problem=493
  */
class UnderTheRainbowTest extends FlatSpec with Matchers {

  private val answer: Double = 6.818741802019762

  "Value-level evaluate method" should "produce the correct answer" in {
    UnderTheRainbowValueLevel.evaluate(7, 10, 20) shouldEqual answer
  }

  "Type-level evaluate method" should "produce the correct answer" in {
    type Answer = UnderTheRainbowTypeLevel.Evaluate[_7, _10, _20]
    toLong[Answer#GetNum].asInstanceOf[Double] / toLong[Answer#GetDenom] shouldEqual answer
  }
}
