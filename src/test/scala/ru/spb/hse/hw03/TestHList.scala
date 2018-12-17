package ru.spb.hse.hw03

import org.scalatest.{FlatSpec, Matchers}
import ru.spb.hse.hw03.HList._
import ru.spb.hse.hw03.Number._

class TestHList extends FlatSpec with Matchers {
  "zip" should "correctly return zipped lists" in {
    val firstList = "one" :: "two" :: "three" :: HNil
    val secondList = 1 :: 2 :: 3 :: HNil
    val thirdList = HNil
    val longList = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: HNil
    firstList zip secondList should be(("one", 1) :: ("two", 2) :: ("three", 3) :: HNil)
    firstList zip thirdList should be(HNil)
    thirdList zip secondList should be(HNil)
    thirdList zip thirdList should be(HNil)
    longList zip secondList should be((1, 1) :: (2, 2) :: (3, 3) :: HNil)
    secondList zip longList should be((1, 1) :: (2, 2) :: (3, 3) :: HNil)
  }

  "splitAt" should "correctly split lists" in {
    val list = 2 :: 3 :: 9 :: HNil
    list splitAt zero should be(HNil, list)
    list splitAt one should be(2 :: HNil, 3 :: 9 :: HNil)
    list splitAt two should be(2 :: 3 :: HNil, 9 :: HNil)
    list splitAt three should be(2 :: 3 :: 9 :: HNil, HNil)
    /*
    Could not find implicit value for parameter splittable:
    list splitAt minusOne should be(2 :: HNil, 3 :: 9 :: HNil)
    list splitAt four should be(2 :: HNil, 3 :: 9 :: HNil)
    list splitAt minusTwo should be(2 :: HNil, 3 :: 9 :: HNil)
    */
  }
}
