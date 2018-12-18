import org.scalatest.{FlatSpec, Matchers}

class Test extends FlatSpec with Matchers {
  import ru.hse.dkaznacheev.ConverterUtils._

  "metric conversions" should "be valid" in {
    (1000 m to mi) should be (0.6213 +- 0.0001)
    (1000 m to km) should be (1.0)
    (1000 in to m) should be (25.4 +- 0.1)
    (1000 in to ft) should be (83.33 +- 0.01)
    (10 m to yd) should be (10.93 +- 0.01)
  }

  "currency conversions" should "be valid" in {
    (1 USD to RUB) at (15 december 2018) should be (66.82 +- 0.01)
  }
}
