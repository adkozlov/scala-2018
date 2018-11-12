import Main.{parse, visit}
import org.scalatest.FunSuite

class EvalTest extends FunSuite {

  def evalExpr(expr: String): Any = {
    visit(parse(expr))
  }


  test("primitive") {
    assert(evalExpr("44") == 44)
    assert(evalExpr("-102") == -102)
    assert(evalExpr("true") == true)
    assert(evalExpr("false") == false)
  }

  test("single arithmetic operations") {
    assert(evalExpr("5 + 11") == 16)
    assert(evalExpr("10 - 3") == 7)
    assert(evalExpr("4 * 11") == 44)
    assert(evalExpr("25 / 6") == 4)
    assert(evalExpr("13 % 4") == 1)
    assert(evalExpr("2 ^ 10") == 1024)
  }

  test("single logic operations") {
    assert(evalExpr("!false") == true)
    assert(evalExpr("true && false") == false)
    assert(evalExpr("true || false") == true)
    assert(evalExpr("true ^^ false") == true)
  }

  test("single compare operations") {
    assert(evalExpr("10 == 10") == true)
    assert(evalExpr("10 != 10") == false)
    assert(evalExpr("23 < 24") == true)
    assert(evalExpr("23 <= 24") == true)
    assert(evalExpr("23 > 24") == false)
    assert(evalExpr("23 >= 24") == false)
  }

  test("simple expretions with parens") {
    assert(evalExpr("(((((9)))))") == 9)
    assert(evalExpr("(((((true)))))") == true)
    assert(evalExpr("(5 + 6) + (1 + 2)") == 14)
    assert(evalExpr("(true && true) || false") == true)
  }

  test("complicated arithmetic operations") {
    assert(evalExpr("-(-5)") == 5)
    assert(evalExpr("50 - 63") == -13)
    assert(evalExpr("6 * (5 + 5)") == 60)
    assert(evalExpr("100 / 11 / 9") == 1)
    assert(evalExpr("50 + -44") == 6)
    assert(evalExpr("3 * -7") == -21)
    assert(evalExpr("3 + 6 * 8") == 51)
    assert(evalExpr("5 ^ 2 - 1 * 4") == 21)
    assert(evalExpr("3 ^ (10 - 30 + 100 % 77)") == 27)
  }

  test("complicated logic operations") {
    assert(evalExpr("!(!true)") == true)
    assert(evalExpr("(true && true) && (false || true)") == true)
    assert(evalExpr("((false && true) && true) ^^ (true ^^ false && (false || false))") == false)
  }

  test("complicated complex operations") {
    assert(evalExpr("(5 == 10) && (3 < 7)") == false)
    assert(evalExpr("4 <= 4 && (3 > 10 || 4 != (2 + 3))") == true)
    assert(evalExpr("false || false || false ^^ ((5 != 6) && (102 / 3 == 34))") == true)
  }
}
