package calculator

import org.scalatest.{FlatSpec, Matchers}

class LogicTest extends FlatSpec with Matchers {

  "Calculator" should "evaluate literal" in {
    assert(Calculator.evaluate("true") === true)
    assert(Calculator.evaluate("false") === false)
  }

  "Calculator" should "evaluate negated literal" in {
    assert(Calculator.evaluate("!true") === false)
    assert(Calculator.evaluate("!false") === true)
    assert(Calculator.evaluate("!(true && false)") === true)
  }

  "Calculator" should "evaluate double negated literal" in {
    assert(Calculator.evaluate("!!true") === true)
    assert(Calculator.evaluate("!!false") === false)
  }

  "Calculator" should "evaluate conjunction" in {
    assert(Calculator.evaluate("true && true") === true)
    assert(Calculator.evaluate("true && false") === false)
    assert(Calculator.evaluate("false && true") === false)
    assert(Calculator.evaluate("false && false") === false)

    assert(Calculator.evaluate("true && true && true") === true)
    assert(Calculator.evaluate("true && true && false") === false)
  }

  "Calculator" should "evaluate disjunction" in {
    assert(Calculator.evaluate("true || true") === true)
    assert(Calculator.evaluate("true || false") === true)
    assert(Calculator.evaluate("false || true") === true)
    assert(Calculator.evaluate("false || false") === false)

    assert(Calculator.evaluate("false || false || true") === true)
    assert(Calculator.evaluate("false || false || false") === false)
  }

  "Calculator" should "evaluate conjunction and disjunction" in {
    assert(Calculator.evaluate("false && false || true") === true)
    assert(Calculator.evaluate("false && true || false") === false)
  }

  "Calculator" should "evaluate disjunction with brackets and conjunction" in {
    assert(Calculator.evaluate("true && (false || true)") === true)
    assert(Calculator.evaluate("true && (false || false)") === false)
  }

}