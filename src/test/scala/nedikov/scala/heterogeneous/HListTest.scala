package nedikov.scala.heterogeneous

import nedikov.scala.heterogeneous.HList.HNil
import nedikov.scala.heterogeneous.HListTest._
import nedikov.scala.heterogeneous.NonNegative.{Succ, Zero}
import org.scalatest.{FlatSpec, Matchers}

object HListTest {
  private val list1 = 1 :: 2.1 :: "lol" :: HNil
  private val list2 = (1, 2) :: 'k' :: HNil
  private val nil = HNil
}

class HListTest extends FlatSpec with Matchers {
  "append" should "append two lists" in {
    nil:::list1 should be(list1)
    list1:::nil should be(list1)

    list1:::list2 should be(1 :: 2.1 :: "lol" :: list2)
  }

  "zip" should "zip lists" in {
    list1 zip list2 should be((1, (1, 2)) :: (2.1, 'k') :: nil)
    list2 zip list1 should be(((1, 2), 1) :: ('k', 2.1) :: nil)
    nil zip list1 should be(nil)
    list2 zip nil should be(nil)
  }

  "splitAt" should "split lists" in {
    val one = Succ(Zero)
    val two = Succ(one)

    list2.splitAt(Zero) should be((nil, list2))
    list2.splitAt(one) should be(((1, 2) :: nil, 'k' :: nil))
    list2.splitAt(two) should be((list2, nil))
  }
}

