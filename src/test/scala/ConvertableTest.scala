import org.scalatest._
import foo.Convertable.ConvertableExt
import foo.to

class ConvertableTest extends FlatSpec with Matchers{
  "Metre" should "convert to metre" in {
    (100 m to m) should be (100)
  }

  "Metre" should "convert to kilometer" in {
    (100 m to km) should be (0.1)
  }

  "Metre" should "convert to yard" in {
    (100 m to yd) should be (109.361 +- 0.001)
  }

  "Metre" should "convert to foot" in {
    (100 m to ft) should be (328.084 +- 0.001)
  }

  "Metre" should "convert to inch" in {
    (10 m to in) should be (393.7 +- 0.001)
  }

  "Metre" should "convert to mile" in {
    (10000 m to mi) should be (6.213 +- 0.001)
  }

  "Kilometre" should "convert to metre" in {
    (1 km to m) should be (1000)
  }

  "Yard" should "convert to metre" in {
    (100 yd to m) should be (91.44 +- 0.001)
  }

  "Foot" should "convert to metre" in {
    (100 ft to m) should be (30.48 +- 0.001)
  }

  "Inch" should "convert to metre" in {
    (100 in to m) should be (2.54 +- 0.001)
  }

  "Mile" should "convert to metre" in {
    (1 mi to m) should be (1609.34 +- 0.001)
  }

  "USD" should "convert to RUR at 18 dec 2018" in {
    (2 USD to RUR 18 december 2018) should be (133.897 +- 0.001)
  }

  "EUR" should "convert to RUR at 10 january 2010" in {
    (2 EUR to RUR 10 january 2010) should be (85)
  }

  "EUR" should "convert to USD at 10 january 2010" in {
    (5 EUR to USD 10 january 2010) should be (7.1365)
  }
}
