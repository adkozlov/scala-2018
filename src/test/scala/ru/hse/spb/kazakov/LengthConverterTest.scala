package ru.hse.spb.kazakov

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.spb.kazakov.LengthConverter._

class LengthConverterTest extends FlatSpec with Matchers {

  "Meters" should "be convertible to kilometers" in {
    (10.5 m to km) shouldBe (0.0105 +- LengthConverterTest.ERROR)
  }

  it should "be convertible to miles" in {
    (1 m to mi) shouldBe (0.000621371 +- LengthConverterTest.ERROR)
  }

  it should "be convertible to meters" in {
    (45.1 m to m) shouldBe (45.1 +- LengthConverterTest.ERROR)
  }

  "Kilometers" should "be convertible to kilometers" in {
    (534 km to km) shouldBe (534.0 +- LengthConverterTest.ERROR)
  }

  it should "be convertible to miles" in {
    (2 km to mi) shouldBe (1.24274 +- LengthConverterTest.ERROR)
  }

  it should "be convertible to meters" in {
    (1.7 km to m) shouldBe (1700.0 +- LengthConverterTest.ERROR)
  }

  "Miles" should "be convertible to kilometers" in {
    (534 mi to km) shouldBe (859.389696 +- LengthConverterTest.ERROR)
  }

  it should "be convertible to miles" in {
    (10324.4 mi to mi) shouldBe (10324.4 +- LengthConverterTest.ERROR)
  }

  it should "be convertible to meters" in {
    (24 mi to m) shouldBe (38624.256 +- LengthConverterTest.ERROR)
  }
}

object LengthConverterTest {
  private val ERROR = 1E-5
}
