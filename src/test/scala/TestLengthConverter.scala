import LengthConverter._
import org.scalatest.{FlatSpec, Matchers}

class TestLengthConverter extends FlatSpec with Matchers {

  "To and from meters" should "be converted correctly" in {
    (1 m to m) should be(1)
    (100 m to km) should be(0.1)
    (1 ft to m) should be(0.30479 +- 0.00001)
    (1 yd to m) should be(0.9144 +- 0.0001)
    (1 mi to m) should be(1609.34 +- 0.01)
    (1 m to in) should be(39.3700 +- 0.0001)
  }

  it should "also work for other conversions" in {
    (1 km to mi) should be(0.621 +- 0.001)
    (1 in to ft) should be(0.0833 +- 0.0001)
  }
}
