package calculator

import org.scalatest.{FlatSpec, Matchers}

class LogicTest extends FlatSpec with Matchers {

  "Calculator" should "evaluate literal" in {
    assert(Calculator.parseAndEval("true") === true)
    assert(Calculator.parseAndEval("false") === false)
  }

  "Calculator" should "evaluate negated literal" in {
    assert(Calculator.parseAndEval("!true") === false)
    assert(Calculator.parseAndEval("!false") === true)
    assert(Calculator.parseAndEval("!(true && false)") === true)
  }

  "Calculator" should "evaluate double negated literal" in {
    assert(Calculator.parseAndEval("!!true") === true)
    assert(Calculator.parseAndEval("!!false") === false)
  }

  "Calculator" should "evaluate conjunction" in {
    assert(Calculator.parseAndEval("true && true") === true)
    assert(Calculator.parseAndEval("true && false") === false)
    assert(Calculator.parseAndEval("false && true") === false)
    assert(Calculator.parseAndEval("false && false") === false)

    assert(Calculator.parseAndEval("true && true && true") === true)
    assert(Calculator.parseAndEval("true && true && false") === false)
  }

  "Calculator" should "evaluate disjunction" in {
    assert(Calculator.parseAndEval("true || true") === true)
    assert(Calculator.parseAndEval("true || false") === true)
    assert(Calculator.parseAndEval("false || true") === true)
    assert(Calculator.parseAndEval("false || false") === false)

    assert(Calculator.parseAndEval("false || false || true") === true)
    assert(Calculator.parseAndEval("false || false || false") === false)
  }

  "Calculator" should "evaluate conjunction and disjunction" in {
    assert(Calculator.parseAndEval("false && false || true") === true)
    assert(Calculator.parseAndEval("false && true || false") === false)
  }

  "Calculator" should "evaluate disjunction with brackets and conjunction" in {
    assert(Calculator.parseAndEval("true && (false || true)") === true)
    assert(Calculator.parseAndEval("true && (false || false)") === false)
  }

}