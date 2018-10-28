import org.scalatest.{FlatSpec, Matchers}

  class CalcEvalTest extends FlatSpec with Matchers {

    "Calculator" should "eval single item" in {
      assert(Main.parse("1") === 1.0)
      assert(Main.parse("0") === 0.0)
      assert(Main.parse("151.52") === 151.52)
      assert(Main.parse("true") === 1.0)
      assert(Main.parse("false") === 0.0)
    }

    "Calculator" should "eval simple binary operation" in {
      assert(Main.parse("1 + 5") === 6.0)
      assert(Main.parse("3.4 - 9") === -5.6)
      assert(Main.parse("6 * 8") === 48.0)
      assert(Main.parse("9 / 3") === 3.0)
      assert(Main.parse("17 % 5") === 2.0)
      assert(Main.parse("2 ^ 3") === 8.0)
      assert(Main.parse("true || false") === 1.0)
      assert(Main.parse("true && false") === 0.0)
      assert(Main.parse("6 > 4") === 1.0)
      assert(Main.parse("6 < 4") === 0.0)
      assert(Main.parse("5 == 5") === 1.0)
      assert(Main.parse("5 >= 5") === 1.0)
      val i = Main.parse("9 / 0")
      assert(i.isInfinite)

    }

    "Calculator" should "eval unary operator" in {
      assert(Main.parse("-(1 - 4)") === 3.0)
      assert(Main.parse("!true") === 0.0)
      assert(Main.parse("!false") === 1.0)
    }

    "Calculator" should "follow rules of operator's precedence" in {
      assert(Main.parse("2 + 3*4") === 14.0)
      assert(Main.parse("(2 + 3) * 4") === 20.0)
      assert(Main.parse("2^3*5") === 40.0)
      assert(Main.parse("2 > 3 || false") === 0.0)
    }

    "Calculator" should "support bool to double and back convertion" in {
      assert(Main.parse("1.0 && 0.0") === 0.0)
      assert(Main.parse("true + false") === 1.0)
      assert(Main.parse("!true - false") === 0.0)
      assert(Main.parse("false || 7.0") === 1.0)
    }

    "Calculator" should "eval complex expressions" in {
      assert(Main.parse("(1 + (-9))*(6 % 4)/2.0") === -8.0)
      assert(Main.parse("5*7 - 30/2 - (81 - 3^3)") === -34.0)
      assert(Main.parse("true || false && true") === 1.0)
      assert(Main.parse(" 3.0 - 9 >= 5.0 - 6") === 0.0)
      assert(Main.parse("(true && !false) + 4.0") === 5.0)
      assert(Main.parse("(15/3)^2 + 4 - 7*7") === -20.0)
      assert(Main.parse("(7.05 - (-2)^2)") === 3.05)
      assert(Main.parse("4 % 3 > 4 % 2 && true") === 1.0)
    }


  }

