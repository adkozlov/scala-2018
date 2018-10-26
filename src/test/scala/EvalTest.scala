import org.scalatest.FunSuite

class EvalTest extends FunSuite {
  test("primitive") {
    assert(Main.evalExpr("44") == 44)
    assert(Main.evalExpr("-102") == -102)
    assert(Main.evalExpr("true") == true)
    assert(Main.evalExpr("false") == false)
  }

  test("single arithmetic operations") {
    assert(Main.evalExpr("5 + 11") == 16)
    assert(Main.evalExpr("10 - 3") == 7)
    assert(Main.evalExpr("4 * 11") == 44)
    assert(Main.evalExpr("25 / 6") == 4)
    assert(Main.evalExpr("13 % 4") == 1)
    assert(Main.evalExpr("2 ^ 10") == 1024)
  }

  test("single logic operations") {
    assert(Main.evalExpr("!false") == true)
    assert(Main.evalExpr("true && false") == false)
    assert(Main.evalExpr("true || false") == true)
    assert(Main.evalExpr("true ^^ false") == true)
  }

  test("single compare operations") {
    assert(Main.evalExpr("10 == 10") == true)
    assert(Main.evalExpr("10 != 10") == false)
    assert(Main.evalExpr("23 < 24") == true)
    assert(Main.evalExpr("23 <= 24") == true)
    assert(Main.evalExpr("23 > 24") == false)
    assert(Main.evalExpr("23 >= 24") == false)
  }

  test("simple expretions with parens") {
    assert(Main.evalExpr("(((((9)))))") == 9)
    assert(Main.evalExpr("(((((true)))))") == true)
    assert(Main.evalExpr("(5 + 6) + (1 + 2)") == 14)
    assert(Main.evalExpr("(true && true) || false") == true)
  }

  test("complicated arithmetic operations") {
    assert(Main.evalExpr("-(-5)") == 5)
    assert(Main.evalExpr("50 - 63") == -13)
    assert(Main.evalExpr("6 * (5 + 5)") == 60)
    assert(Main.evalExpr("100 / 11 / 9") == 1)
    assert(Main.evalExpr("50 + -44") == 6)
    assert(Main.evalExpr("3 * -7") == -21)
    assert(Main.evalExpr("3 + 6 * 8") == 51)
    assert(Main.evalExpr("5 ^ 2 - 1 * 4") == 21)
    assert(Main.evalExpr("3 ^ (10 - 30 + 100 % 77)") == 27)
  }

  test("complicated logic operations") {
    assert(Main.evalExpr("!(!true)") == true)
    assert(Main.evalExpr("(true && true) && (false || true)") == true)
    assert(Main.evalExpr("((false && true) && true) ^^ (true ^^ false && (false || false))") == false)
  }

  test("complicated complex operations") {
    assert(Main.evalExpr("(5 == 10) && (3 < 7)") == false)
    assert(Main.evalExpr("4 <= 4 && (3 > 10 || 4 != (2 + 3))") == true)
    assert(Main.evalExpr("false || false || false ^^ ((5 != 6) && (102 / 3 == 34))") == true)
  }
}
