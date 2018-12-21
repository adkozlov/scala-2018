package ru.hse.spb.kazakov

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.spb.kazakov.CurrencyConverter._

class CurrencyConverterTest extends FlatSpec with Matchers {
  "USD" should "be convertible to RUB" in {
    (12 USD to RUB at (20 december 2018)) shouldBe (812.102 +- CurrencyConverterTest.ERROR)
  }

  it should "be convertible to EUR" in {
    (5 USD to EUR at (1 december 2018)) shouldBe (4.401 +- CurrencyConverterTest.ERROR)
  }

  it should "be convertible to USD" in {
    (1 USD to USD at (1 december 2010)) shouldBe (1.0 +- CurrencyConverterTest.ERROR)
  }

  "EUR" should "be convertible to RUB" in {
    (0 EUR to RUB at (4 august 2018)) shouldBe (0.0 +- CurrencyConverterTest.ERROR)
  }

  "RUB" should "be convertible to USD" in {
    (1000 RUB to USD at (1 december 2010)) shouldBe (31.798 +- CurrencyConverterTest.ERROR)
  }
}

object CurrencyConverterTest {
  private val ERROR = 1E-3
}
