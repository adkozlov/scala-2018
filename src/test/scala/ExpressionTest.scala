import org.scalatest._

class ExpressionTest extends FlatSpec with Matchers {
  "A number expression" should "be evaluated as a corresponding number" in {
    Evaluator.evaluate("5") should be ("5")
  }

  "A simple boolean expression" should "be evaluated as true" in {
    Evaluator.evaluate("true") should be ("true")
  }
  it should "be evaluated as false" in {
    Evaluator.evaluate("false") should be ("false")
  }

  "A simple mul expression" should "multiply numbers correctly" in {
    Evaluator.evaluate("2 * 3") should be ("6")
  }

  "A simple div expression" should "divide numbers correctly" in {
    Evaluator.evaluate("6 / 2") should be ("3")
  }
  it should "ignore the remainder if divisor is not the factor of dividend" in  {
    Evaluator.evaluate("8 / 3") should be ("2")
  }

  "A simple mod expression" should "get the remainder correctly" in  {
    Evaluator.evaluate("6 % 4") should be ("2")
  }

  "A simple plus expression" should "sum up the numbers correctly" in  {
    Evaluator.evaluate("6 + 2") should be ("8")
  }

  "A simple minus expression" should "subtract the numbers correctly" in  {
    Evaluator.evaluate("6 - 2") should be ("4")
  }

  "A simple less than expression" should "return false when the left number is greater" in  {
    Evaluator.evaluate("6 < 2") should be ("false")
  }
  it should "return true if the left number is smaller" in  {
    Evaluator.evaluate("1 < 2") should be ("true")
  }

  "A simple greater than expression" should "return true when the left number is greater" in  {
    Evaluator.evaluate("6 > 2") should be ("true")
  }
  it should "return false if the left number is smaller" in  {
    Evaluator.evaluate("1 > 2") should be ("false")
  }

  "A simple le expression" should "return false when the left number is greater" in  {
    Evaluator.evaluate("6 <= 2") should be ("false")
  }
  it should "return true if the left number is smaller" in  {
    Evaluator.evaluate("1 <= 2") should be ("true")
  }
  it should "return true if numbers are equal" in  {
    Evaluator.evaluate("2 <= 2") should be ("true")
  }

  "A simple ge expression" should "return true when the left number is greater" in  {
    Evaluator.evaluate("6 >= 2") should be ("true")
  }
  it should "return false if the left number is smaller" in  {
    Evaluator.evaluate("1 >= 2") should be ("false")
  }
  it should "return true if numbers are equal" in  {
    Evaluator.evaluate("2 >= 2") should be ("true")
  }

  "A simple eq expression" should "return true when the numbers are equal" in  {
    Evaluator.evaluate("2 == 2") should be ("true")
  }
  it should "return false if the numbers are not equal" in  {
    Evaluator.evaluate("1 == 2") should be ("false")
  }

  "A simple neq expression" should "return false when the numbers are equal" in  {
    Evaluator.evaluate("2 != 2") should be ("false")
  }
  it should "return true if the numbers are not equal" in  {
    Evaluator.evaluate("5 != 2") should be ("true")
  }

  "A simple and expression" should "return false when at least one of arguments is false" in  {
    Evaluator.evaluate("true && false") should be ("false")
  }
  it should "return true if both arguments are true" in  {
    Evaluator.evaluate("true && true") should be ("true")
  }

  "A simple or expression" should "return false when both arguments is false" in  {
    Evaluator.evaluate("false || false") should be ("false")
  }
  it should "return true if at least one of the arguments is true" in  {
    Evaluator.evaluate("false || true") should be ("true")
  }

  "A parenthesized plus expression" should "make sum more prioritized than mul" in  {
    Evaluator.evaluate("2 * (2 + 2)") should be ("8")
  }
}
