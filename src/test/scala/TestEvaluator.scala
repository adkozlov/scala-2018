import main.scala.Main
import org.scalatest.FunSuite

class TestEvaluator extends FunSuite {
  test("literals") {
    assert(Main.eval("true") === 1)
    assert(Main.eval("false") === 0)
  }

  test("or table") {
    assert(Main.eval("true || false") === 1)
    assert(Main.eval("true || true") === 1)
    assert(Main.eval("false || true") === 1)
    assert(Main.eval("false || false") === 0)
  }

  test("and table") {
    assert(Main.eval("false && false") === 0)
    assert(Main.eval("false && true") === 0)
    assert(Main.eval("true && false") === 0)
    assert(Main.eval("true && true") === 1)
  }

  test("and has higher priority than or") {
    assert(Main.eval("false && false || true") === 1)
  }

  test("braces change priorities of operations") {
    assert(Main.eval("false && (false || true)") === 0)
  }

  test("negation changes value") {
    assert(Main.eval("!true") === 0)
    assert(Main.eval("!(true && false)") === 1)
  }

  test("single integer") {
    assert(Main.eval("1") == 1)
    assert(Main.eval("2") == 2)
    assert(Main.eval("42") == 42)
  }

  test("plus and minus") {
    assert(Main.eval("1 + 2") == 3)
    assert(Main.eval("3 + 4 + 5") == 12)

    assert(Main.eval("1 - 2") == -1)
    assert(Main.eval("3 - 4 - 5") == -6)

    assert(Main.eval("1 + 2 - 3 + 4 - 5") === -1)
  }

  test("multiplication and division") {
    assert(Main.eval("1 * 2") === 2)
    assert(Main.eval("4 * 2 * 3") === 24)

    assert(Main.eval("3 / 1") === 3)
    assert(Main.eval("4 % 2 % 3") === 0)
  }

  test("multiplication and deletion have higher priority than plus and minus") {
    assert(Main.eval("1 + 2 * 3") === 7)
    assert(Main.eval("4 * 2 - 3") === 5)

    assert(Main.eval("3 + 4 / 2") === 5)
    assert(Main.eval("3 / 4 - 2") === 3 / 4 - 2)
  }

  test("braces change priorities of operations for math") {
    assert(Main.eval("(1 + 2) * 3") === 9)
    assert(Main.eval("4 * (2 - 3)") === -4)

    assert(Main.eval("(3 + 4) / 2") === 7 / 2)
    assert(Main.eval("3 / (4 - 2)") === 3 / 2)
  }

  test("nested braces do not matter") {
    assert(Main.eval("((((1))))") === 1)
  }

  test("negation changes value to -value") {
    assert(Main.eval("-1") === -1)
    assert(Main.eval("-(1 + 2 * 3)") === -7)
  }
}
