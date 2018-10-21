import org.scalatest.FunSuite

class MathOperationsTest extends FunSuite {
  test("single integer is evaled") {
    assert(Main.eval("1") == 1)
    assert(Main.eval("2") == 2)
    assert(Main.eval("42") == 42)
  }

  test("plus and minus are evaled") {
    assert(Main.eval("1 + 2") == 3)
    assert(Main.eval("3 + 4 + 5") == 12)

    assert(Main.eval("1 - 2") == -1)
    assert(Main.eval("3 - 4 - 5") == -6)

    assert(Main.eval("1 + 2 - 3 + 4 - 5") === -1)
  }

  test("multiplication and division are evaled") {
    assert(Main.eval("1 * 2") === 2)
    assert(Main.eval("4 * 2 * 3") === 24)

    assert(Main.eval("3 / 1") === 3)
    assert(Main.eval("4 / 2 / 3") === 4d / 2 / 3)
  }

  test("multiplication and deletion have higher priority than plus and minus") {
    assert(Main.eval("1 + 2 * 3") === 7)
    assert(Main.eval("4 * 2 - 3") === 5)

    assert(Main.eval("3 + 4 / 2") === 5)
    assert(Main.eval("3 / 4 - 2") === 3d / 4 - 2)
  }

  test("braces change priorities of operations") {
    assert(Main.eval("(1 + 2) * 3") === 9)
    assert(Main.eval("4 * (2 - 3)") === -4)

    assert(Main.eval("(3 + 4) / 2") === 7d / 2)
    assert(Main.eval("3 / (4 - 2)") === 3d / 2)
  }

  test("nested braces do not matter") {
    assert(Main.eval("((((1))))") === 1)
  }

  test("negation changes value to -value") {
    assert(Main.eval("-1") === -1)
    assert(Main.eval("-(1 + 2 * 3)") === -7)
  }
}
