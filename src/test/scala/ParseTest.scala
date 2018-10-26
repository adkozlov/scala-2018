import org.scalatest.FunSuite

class ParseTest extends FunSuite {
  test("primitive") {
    assert(Main.toBeautyString("44") == "44")
    assert(Main.toBeautyString("-102") == "-102")
    assert(Main.toBeautyString("true") == "true")
    assert(Main.toBeautyString("false") == "false")
  }

  test("single arithmetic operations") {
    assert(Main.toBeautyString("5 + 11") == "5 + 11")
    assert(Main.toBeautyString("10 - 3") == "10 - 3")
    assert(Main.toBeautyString("4 * 11") == "4 * 11")
    assert(Main.toBeautyString("25 / 6") == "25 / 6")
    assert(Main.toBeautyString("13 % 4") == "13 % 4")
    assert(Main.toBeautyString("2 ^ 10") == "2 ^ 10")
  }

  test("single logic operations") {
    assert(Main.toBeautyString("!false") == "!false")
    assert(Main.toBeautyString("true && false") == "true && false")
    assert(Main.toBeautyString("true || false") == "true || false")
    assert(Main.toBeautyString("true ^^ false") == "true ^^ false")
  }

  test("single compare operations") {
    assert(Main.toBeautyString("10 == 10") == "10 == 10")
    assert(Main.toBeautyString("10 != 10") == "10 != 10")
    assert(Main.toBeautyString("23 < 24") == "23 < 24")
    assert(Main.toBeautyString("23 <= 24") == "23 <= 24")
    assert(Main.toBeautyString("23 > 24") == "23 > 24")
    assert(Main.toBeautyString("23 >= 24") == "23 >= 24")
  }

  test("complex operations") {
    assert(Main.toBeautyString("-(-5)") == "-(-5)")
    assert(Main.toBeautyString("6 * (5 + 5)") == "6 * (5 + 5)")
    assert(Main.toBeautyString("3 * -7") == "3 * -7")
    assert(Main.toBeautyString("3 ^ (10 - 30 + 100 % 77)") == "3 ^ (10 - 30 + 100 % 77)")
    assert(Main.toBeautyString("!(!true)") == "!(!true)")
    assert(Main.toBeautyString("(true && true) && (false || true)") == "(true && true) && (false || true)")
    assert(Main.toBeautyString("(5 == 10) && (3 < 7)") == "(5 == 10) && (3 < 7)")
    assert(Main.toBeautyString("4 <= 4 && (3 > 10 || 4 != (2 + 3))") == "4 <= 4 && (3 > 10 || 4 != (2 + 3))")
    assert(Main.toBeautyString("false || false || true ^^ ((5 != 6) && (102 / 3 == 34))") ==
      "false || false || true ^^ ((5 != 6) && (102 / 3 == 34))")
  }

  test("indent insignificance") {
    assert(Main.toBeautyString("     5  ") == "5")
    assert(Main.toBeautyString("7+1") == "7 + 1")
    assert(Main.toBeautyString("4 +         7 --6") == "4 + 7 - -6")
    assert(Main.toBeautyString("true &&    (false||true)") == "true && (false || true)")
    assert(Main.toBeautyString("4 <= 4+   5 && true      &&false") == "4 <= 4 + 5 && true && false")
  }
}
