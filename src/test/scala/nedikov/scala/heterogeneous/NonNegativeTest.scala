package nedikov.scala.heterogeneous

import nedikov.scala.heterogeneous.NonNegative._
import nedikov.scala.heterogeneous.NonNegativeTest._
import org.scalatest.{FlatSpec, Matchers}

//noinspection TypeAnnotation
object NonNegativeTest {
  val zero = Zero
  val one = Succ(Zero)
  val two = Succ(Succ(Zero))
  val three = Succ(Succ(Succ(Zero)))
}

class NonNegativeTest extends FlatSpec with Matchers {
  "apply" should "returns correct expected number" in {
    NonNegative(0) should be(zero)
    NonNegative(1) should be(one)
    NonNegative(2) should be(two)
    NonNegative(3) should be(three)
    assertThrows[IllegalArgumentException](NonNegative(-1))
  }

  "toInt" should "return correct int number" in {
    toInt(zero) should be(0)
    toInt(one) should be(1)
    toInt(two) should be(2)
    toInt(three) should be(3)
  }

  "implicit cast from Int" should "works" in {
    var value: NonNegative = 0
    value should be(zero)
    value = 1
    value should be(one)
    value = 2
    value should be(two)
  }

  "implicit cast to Int" should "works" in {
    var value: Int = zero
    value should be(0)
    value = one
    value should be(1)
    value = two
    value should be(2)
  }
}
