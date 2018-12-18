package hlist

import org.scalatest.{FlatSpec, Matchers}
import nat._
import hlist.HList._

class TestList extends FlatSpec with Matchers {

  type One = Succ[Zero]
  type Two = Succ[One]
  type Three = Succ[Two]

  private val list = 1 :: false :: -12 :: Some(17) :: "kek" :: HNil
  private val list2 = -1 :: true :: HNil

  "List" should "contains different types" in {
    assert(list.head === 1)
    assert(list.tail.head === false)
    assert(list.tail.tail.tail.tail.head === "kek")
  }

  "zip" should "return HNil if both operands are HNil" in {
    assert((HNil zip HNil) === HNil)
  }

  "zip" should "return HNil if the left operand is HNil" in {
    assert((HNil zip list) == HNil)
  }

  "zip" should "return HNil if the right operand is HNil" in {
    assert((list zip HNil) == HNil)
  }

  "zip" should "return correct result if both operands are not HNil" in {
    val correctResult = (1, -1) :: (false, true) :: HNil
    assert((list zip list2) === correctResult)
  }

  "splitAt" should "return head if index is Zero" in {
    assert((list splitAt new Zero) === (HNil, list))
  }

  "splitAt" should "return correct result if index is not Zero" in {
    val correctResult = (1 :: false :: HNil, -12 :: Some(17) :: "kek" :: HNil)
    assert((list splitAt new Two) === correctResult)
  }

}
