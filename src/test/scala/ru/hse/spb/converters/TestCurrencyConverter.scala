package ru.hse.spb.converters

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.spb.converters.CurrencyConverter._

class TestCurrencyConverter extends FlatSpec with Matchers {

  "CurrencyConverter" should " converted correctly" in {
    ((100 USD) to RUR at 10 february 2012) should be(2996.03 +- 0.01)
    ((1000 RUR) to EUR at 22 march 2018) should be(14.11 +- 0.01)
    ((20 EUR) to USD at 14 february 2010) should be(27.35 +- 0.01)
  }
}