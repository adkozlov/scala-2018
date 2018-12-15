package ru.hse.spb.hlist

import org.scalatest.{FlatSpec, Matchers}

class TestHList extends FlatSpec with Matchers {

  import HList._

  private val list1 = 1 :: 2 :: "hello" :: 3.14 :: HNil
  private val list2 = "world" :: 239 :: HNil

  "Zip" should "return HNil if one of lists is HNil" in {
    zip(list1, HNil) should be(HNil)
    zip(HNil, list1) should be(HNil)
    zip(HNil, HNil) should be(HNil)
  }

  it should "work as expected for non empty lists" in {
    zip(list1, list2) should be((1, "world") :: (2, 239) :: HNil)
    zip(list2, list1) should be(("world", 1) :: (239, 2) :: HNil)
  }

  "SplitAt" should "work correctly" in {
    list1.SplitAt(Number._0) should be((HNil, list1))
    list1.SplitAt(Number._1) should be((1 :: HNil, 2 :: "hello" :: 3.14 :: HNil))
    list1.SplitAt(Number._2) should be((1 :: 2 :: HNil, "hello" :: 3.14 :: HNil))

    // Compilation error should occur
    // list1.SplitAt(ru.hse.spb.hlist.Number._5)
    // list1.SplitAt(ru.hse.spb.hlist.Number._M1)
  }
}