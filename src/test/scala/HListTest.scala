import hlist.HList.HNil
import hlist.NaturalNumber.Succ
import hlist.Zero
import org.scalatest._

class HListTest extends FlatSpec with Matchers {
  private val _0 = Zero
  private val _1 = Succ(_0)
  private val _2 = Succ(_1)
  private val _3 = Succ(_2)
  private val _4 = Succ(_3)

  private val emptyList = HNil
  private val shortList = 1 :: "x" :: 15 :: HNil
  private val anotherShortList = "t" :: "b" :: "con" :: HNil
  private val longList =  1 :: 2 :: 3 :: "a" :: 4 :: 5 :: "x" :: "y" ::  HNil

  "Zip with empty list" should "return empty list" in {
    emptyList zip shortList should be (emptyList)
  }

  "Zip of empty lists" should "return empty list" in {
    emptyList zip emptyList should be (emptyList)
  }

  "Zip of list of equal length" should "return list of pairs of the same length" in {
    shortList zip anotherShortList should be ((1, "t") :: ("x", "b") :: (15, "con") :: HNil)
  }

  "Zip of list of different lengths" should "return list of pairs of the lesser length" in {
    shortList zip longList should be ((1, 1) :: ("x", 2) :: (15, 3) :: HNil)
  }

  "Split at zero" should "return (empty list, original list) pair" in {
    shortList splitAt _0 should be (emptyList, shortList)
  }

  "Split of empty list at zero" should "return (empty list, empty list) pair" in {
    emptyList splitAt _0 should be (emptyList, emptyList)
  }

  "Split of empty list at one" should "not compile" in {
    // emptyList splitAt _1
  }

  "Split at position greater than list length" should "not compile" in {
    // shortList splitAt _4
  }

  "Split at position equal to list length" should "return (original list, empty list) pair" in {
    shortList splitAt _3 should be (shortList, emptyList)
  }

  "Split at inner list position" should "return pair of corresponding lists" in {
    longList splitAt _2 should be (1 :: 2 :: HNil, 3 :: "a" :: 4 :: 5 :: "x" :: "y" :: HNil)
  }
}
