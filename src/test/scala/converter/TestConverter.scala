package converter

import converter.Converter.doubleToOperator

import org.scalatest.{FlatSpec, Matchers}

class TestConverter extends FlatSpec with Matchers {

  "distance conversion from meters" should "be done correctly" in {
    (1(m) to m) should be(1)
    (2(m) to m) should be(2)
    (1(m) to km) should be(0.001 +- 0.0001)
    (2(m) to km) should be(0.002 +- 0.0001)
    (1(m) to in) should be(39.3701 +- 0.0001)
    (2(m) to in) should be(78.7402 +- 0.0001)
    (1(m) to mi) should be(0.00062 +- 0.0001)
    (2(m) to mi) should be(0.00124 +- 0.0001)
    (1(m) to ft) should be(3.28084 +- 0.0001)
    (2(m) to ft) should be(6.56168 +- 0.0001)
    (1(m) to yd) should be(1.09361 +- 0.0001)
    (2(m) to yd) should be(2.18722 +- 0.0001)
  }

  "distance conversion from miles" should "be done correctly" in {
    (2(mi) to m) should be(3218.69 +- 0.01)
    (2(mi) to km) should be(3.21869 +- 0.0001)
    (2(mi) to in) should be(126720.0 +- 1)
    (2(mi) to mi) should be(2)
    (2(mi) to ft) should be(10560.0 +- 1)
    (2(mi) to yd) should be(3520.0 +- 1)
  }

  "currency conversion" should "be done correctly" in {
    (100(RUB) to USD at 5 december 2018) should be(1.5032 +- 0.01)
    (100(RUB) to EUR at 1 june 2018) should be(1.3782 +- 0.01)
    (3(EUR) to RUB at 31 december 2017) should be(207.549213 +- 0.01)
    (3(USD) to RUB at 9 august 2018) should be(199.794603 +- 0.01)
    (3(EUR) to USD at 10 may 2018) should be(3.575601 +- 0.01)
    (3(USD) to EUR at 31 september 2018) should be(2.59131 +- 0.01)
  }

}