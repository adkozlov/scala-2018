import org.scalatest._

class ExpressionTest extends FlatSpec with Matchers {
  "A number expression" should "be evaluated as a corresponding number" in {
    Evaluator.getStringResult("5") should be ("5")
  }

  "A simple boolean expression" should "be evaluated as true" in {
    Evaluator.getStringResult("true") should be ("true")
  }
  it should "be evaluated as false" in {
    Evaluator.getStringResult("false") should be ("false")
  }

  "A simple mul expression" should "multiply numbers correctly" in {
    Evaluator.getStringResult("2 * 3") should be ("6")
  }

  "A simple div expression" should "divide numbers correctly" in {
    Evaluator.getStringResult("6 / 2") should be ("3")
  }
  it should "ignore the remainder if divisor is not the factor of dividend" in  {
    Evaluator.getStringResult("8 / 3") should be ("2")
  }
  it should "throw ArithmeticException when trying to divide by zero" in {
    a [ArithmeticException] should be thrownBy {
      Evaluator.getStringResult("8 / 0")
    }
  }

  "A simple mod expression" should "get the remainder correctly" in  {
    Evaluator.getStringResult("6 % 4") should be ("2")
  }
  it should "throw ArithmeticException when trying to divide by zero" in {
    a [ArithmeticException] should be thrownBy {
      Evaluator.getStringResult("8 / 0")
    }
  }

  "A simple plus expression" should "sum up the numbers correctly" in  {
    Evaluator.getStringResult("6 + 2") should be ("8")
  }

  "A simple minus expression" should "subtract the numbers correctly" in  {
    Evaluator.getStringResult("6 - 2") should be ("4")
  }

  "A simple less than expression" should "return false when the left number is greater" in  {
    Evaluator.getStringResult("6 < 2") should be ("false")
  }
  it should "return true if the left number is smaller" in  {
    Evaluator.getStringResult("1 < 2") should be ("true")
  }

  "A simple greater than expression" should "return true when the left number is greater" in  {
    Evaluator.getStringResult("6 > 2") should be ("true")
  }
  it should "return false if the left number is smaller" in  {
    Evaluator.getStringResult("1 > 2") should be ("false")
  }

  "A simple le expression" should "return false when the left number is greater" in  {
    Evaluator.getStringResult("6 <= 2") should be ("false")
  }
  it should "return true if the left number is smaller" in  {
    Evaluator.getStringResult("1 <= 2") should be ("true")
  }
  it should "return true if numbers are equal" in  {
    Evaluator.getStringResult("2 <= 2") should be ("true")
  }

  "A simple ge expression" should "return true when the left number is greater" in  {
    Evaluator.getStringResult("6 >= 2") should be ("true")
  }
  it should "return false if the left number is smaller" in  {
    Evaluator.getStringResult("1 >= 2") should be ("false")
  }
  it should "return true if numbers are equal" in  {
    Evaluator.getStringResult("2 >= 2") should be ("true")
  }

  "A simple eq expression" should "return true when the numbers are equal" in  {
    Evaluator.getStringResult("2 == 2") should be ("true")
  }
  it should "return false if the numbers are not equal" in  {
    Evaluator.getStringResult("1 == 2") should be ("false")
  }

  "A simple neq expression" should "return false when the numbers are equal" in  {
    Evaluator.getStringResult("2 != 2") should be ("false")
  }
  it should "return true if the numbers are not equal" in  {
    Evaluator.getStringResult("5 != 2") should be ("true")
  }

  "A simple and expression" should "return false when at least one of arguments is false" in  {
    Evaluator.getStringResult("true && false") should be ("false")
  }
  it should "return true if both arguments are true" in  {
    Evaluator.getStringResult("true && true") should be ("true")
  }

  "A simple or expression" should "return false when both arguments is false" in  {
    Evaluator.getStringResult("false || false") should be ("false")
  }
  it should "return true if at least one of the arguments is true" in  {
    Evaluator.getStringResult("false || true") should be ("true")
  }

  "A parenthesized plus expression" should "make sum more prioritized than mul" in  {
    Evaluator.getStringResult("2 * (2 + 2)") should be ("8")
  }

  "An invalid expression" should "throw a ParsingException" in {
    a [ParsingException] should be thrownBy {
      Evaluator.getStringResult("783248nmfd")
    }
  }

  "A simple arithmetical mixed-type expression" should "treat true as 1" in {
    Evaluator.getStringResult("1 + true") should be ("2")
  }

  "A simple arithmetical mixed-type expression" should "treat false as 0" in {
    Evaluator.getStringResult("7 * false") should be ("0")
  }

  "A simple boolean mixed-type expression" should "treat 5 as true" in {
    Evaluator.getStringResult("5 && true") should be ("true")
  }

  "A simple boolean mixed-type expression" should "treat 0 as false" in {
    Evaluator.getStringResult("0 && true") should be ("false")
  }

  "A complex arithmetical expression" should "evaluate correctly" in {
    Evaluator.getStringResult("1 + 5 * 10 / (10 % 7)") should be ("17")
  }

  "A complex boolean expression" should "evaluate correctly" in {
    Evaluator.getStringResult("(5 >= 10 || 5 <= 10) && 1 < 2 == 2 > 1 && 3 != 4") should be ("true")
  }

  "A complex mixed expression" should "evaluate correctly" in {
    Evaluator.getStringResult("1 + 5 * (10 <= 14) / (2 + (3 == 5))") should be ("3")
  }
}
