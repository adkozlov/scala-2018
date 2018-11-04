package ru.hse.spb

import java.io.{ByteArrayOutputStream, PrintStream}

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest._

class CalcTest extends FlatSpec with BeforeAndAfter with Matchers {

  var err = new ByteArrayOutputStream()


  before {
    err.reset()
    System.setErr(new PrintStream(err))
  }

  def check(input: String, expected: Double): Unit = {
    Main.calculate(input) should be(expected)
    err.size() should be(0)
  }

  "Calc" should "sum" in check("1+1", 2)

  "Calc" should "return 0 on empty input" in check("", 0)

  "Calc" should "understand brackets" in check("(1+32)*3+(3+53)+9", 164)

  "Calc" should "multiply" in check("1321*4324", 5712004)

  "Calc" should "be able to take pow of negative number" in check("(-1)^4324", 1)

  "Calc" should "" in check("(-1)^4324", 1)
}
