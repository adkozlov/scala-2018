package nat

import org.scalatest.{FlatSpec, Matchers}

class TestNat extends FlatSpec with Matchers {

  "Zero" should "be equal to 0" in {
    val zero = ToInt[Zero]
    assert(zero() === 0)
  }

  "One" should "be equal to 1" in {
    type One = Succ[Zero]
    val one = ToInt[One]
    assert(one() === 1)
  }

  "ToInt" should "give correct number" in {
    type One = Succ[Zero]
    val one = ToInt[One]
    assert(one() === 1)

    type Two = Succ[One]
    val two = ToInt[Two]
    assert(two() === 2)

    type Three = Succ[Two]
    val three = ToInt[Three]
    assert(three() === 3)

    type Four = Succ[Three]
    val four = ToInt[Four]
    assert(four() === 4)

    type Five = Succ[Four]
    val five = ToInt[Five]
    assert(five() === 5)

    type Six = Succ[Five]
    val six = ToInt[Six]
    assert(six() === 6)
  }

}
