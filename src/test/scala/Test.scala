import org.scalatest.{FlatSpec, Matchers}

class Test extends FlatSpec with Matchers {
  import ru.hse.dkaznacheev.ConverterUtils._
  import Test._

  "metric conversions" should "be valid" in {
    (1000 m to mi) should be (MI_IN_THOUSAND_M +- 0.0001)
    (1000 m to km) should be (KM_IN_THOUSAND_M)
    (1000 in to m) should be (M_IN_THOUSAND_IN +- 0.1)
    (1000 in to ft) should be (FT_IN_THOUSAND_IN +- 0.01)
    (10 m to yd) should be (YD_IN_TEN_M +- 0.01)
  }

  "currency conversions" should "be valid" in {
    (1 USD to RUB) at (15 december 2018) should be (TEST_USD_RUB_RATE +- 0.01)
  }
}

object Test {
  val MI_IN_THOUSAND_M: Double = 0.6213
  val KM_IN_THOUSAND_M: Double = 1.0
  val M_IN_THOUSAND_IN: Double = 25.4
  val FT_IN_THOUSAND_IN: Double = 83.33
  val YD_IN_TEN_M: Double = 10.93
  val TEST_USD_RUB_RATE: Double = 66.82
}