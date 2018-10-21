import org.scalatest.FunSuite

class LogicOperationsTest extends FunSuite {
  test("literals are evaled") {
    assert(Main.eval("true") === true)
    assert(Main.eval("false") === false)
  }

  test("ORs are evaled") {
    assert(Main.eval("true || false") === true)
    assert(Main.eval("false || false") === false)
  }

  test("ANDs are evaled") {
    assert(Main.eval("true && false") === false)
    assert(Main.eval("true && true") === true)
  }

  test("ANDs have higher priority than ORs") {
    assert(Main.eval("false && false || true") === true)
  }

  test("braces change priorities of operations") {
    assert(Main.eval("false && (false || true)") === false)
  }

  test("negation changes value") {
    assert(Main.eval("!true") === false)
    assert(Main.eval("!(true && false)") === true)
  }

}
