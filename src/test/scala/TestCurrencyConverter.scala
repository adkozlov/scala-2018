import CurrencyConverter._
import org.scalatest.{FlatSpec, Matchers}

class TestCurrencyConverter extends FlatSpec with Matchers {

  "CurrencyConverter" should " converted correctly" in {
    ((100 USD) to RUR at 10 february 2012) should be(2996.03 +- 0.01)
  }
}