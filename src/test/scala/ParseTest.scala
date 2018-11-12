import Main.{parse, visit}
import org.scalatest.FunSuite

class ParseTest extends FunSuite {

  def reflectExpr(expr: String): String = {
    visit(parse(expr), Mirror).asInstanceOf[String]
  }

  test("primitive") {
    assert(reflectExpr("44") == "44")
    assert(reflectExpr("-102") == "-102")
    assert(reflectExpr("true") == "true")
    assert(reflectExpr("false") == "false")
  }

  test("single arithmetic operations") {
    assert(reflectExpr("5 + 11") == "5 + 11")
    assert(reflectExpr("10 - 3") == "10 - 3")
    assert(reflectExpr("4 * 11") == "4 * 11")
    assert(reflectExpr("25 / 6") == "25 / 6")
    assert(reflectExpr("13 % 4") == "13 % 4")
    assert(reflectExpr("2 ^ 10") == "2 ^ 10")
  }

  test("single logic operations") {
    assert(reflectExpr("!false") == "!false")
    assert(reflectExpr("true && false") == "true && false")
    assert(reflectExpr("true || false") == "true || false")
    assert(reflectExpr("true ^^ false") == "true ^^ false")
  }

  test("single compare operations") {
    assert(reflectExpr("10 == 10") == "10 == 10")
    assert(reflectExpr("10 != 10") == "10 != 10")
    assert(reflectExpr("23 < 24") == "23 < 24")
    assert(reflectExpr("23 <= 24") == "23 <= 24")
    assert(reflectExpr("23 > 24") == "23 > 24")
    assert(reflectExpr("23 >= 24") == "23 >= 24")
  }

  test("complex operations") {
    assert(reflectExpr("-(-5)") == "-(-5)")
    assert(reflectExpr("6 * (5 + 5)") == "6 * (5 + 5)")
    assert(reflectExpr("3 * -7") == "3 * -7")
    assert(reflectExpr("3 ^ (10 - 30 + 100 % 77)") == "3 ^ (10 - 30 + 100 % 77)")
    assert(reflectExpr("!(!true)") == "!(!true)")
    assert(reflectExpr("(true && true) && (false || true)") == "(true && true) && (false || true)")
    assert(reflectExpr("(5 == 10) && (3 < 7)") == "(5 == 10) && (3 < 7)")
    assert(reflectExpr("4 <= 4 && (3 > 10 || 4 != (2 + 3))") == "4 <= 4 && (3 > 10 || 4 != (2 + 3))")
    assert(reflectExpr("false || false || true ^^ ((5 != 6) && (102 / 3 == 34))") ==
      "false || false || true ^^ ((5 != 6) && (102 / 3 == 34))")
  }

  test("indent insignificance") {
    assert(reflectExpr("     5  ") == "5")
    assert(reflectExpr("7+1") == "7 + 1")
    assert(reflectExpr("4 +         7 --6") == "4 + 7 - -6")
    assert(reflectExpr("true &&    (false||true)") == "true && (false || true)")
    assert(reflectExpr("4 <= 4+   5 && true      &&false") == "4 <= 4 + 5 && true && false")
  }
}
