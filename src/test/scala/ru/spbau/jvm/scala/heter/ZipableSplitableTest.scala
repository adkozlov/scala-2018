package ru.spbau.jvm.scala.hlist

import org.scalatest.{FlatSpec, Matchers}
import ru.spbau.jvm.scala.heter.Nat.{Succ, Zero}

class ZipableSplitableTest extends FlatSpec with Matchers {

  import ru.spbau.jvm.scala.heter.HList._
  import ZipableSplitableTest._

  private val list1 = 1 :: 3.25 :: "smth1" :: 1000 :: HNil
  private val list2 = "smth" :: 42 :: "smth" :: HNil


  "zip" should "zip two lists" in {
    list1 zip list2 should be((1, "smth") :: (3.25, 42) :: ("smth1", "smth") :: HNil)
    list2 zip list1 should be(("smth", 1) :: (42, 3.25) :: ("smth", "smth1") :: HNil)
  }

  "zip" should "zip Nil correctly" in {
    list1 zip HNil should be(HNil)
    list2 zip HNil should be(HNil)
    HNil zip HNil should be(HNil)
  }

  "zip" should "zip lists of same length correctly" in {
    val (l, _) = list1 splitAt THREE
    l zip list2 should be((1, "smth") :: (3.25, 42) :: ("smth1", "smth") :: HNil)
    list2 zip l should be(("smth", 1) :: (42, 3.25) :: ("smth", "smth1") :: HNil)
  }

  "splitAt" should "split list correctly" in {
    list1 splitAt ZERO should be((HNil, list1))
    list1 splitAt ONE should be((1 :: HNil, 3.25 :: "smth1" :: 1000 :: HNil))
    list1 splitAt TWO should be((1 :: 3.25 :: HNil, "smth1" :: 1000 :: HNil))
    list1 splitAt THREE should be((1 :: 3.25 :: "smth1" :: HNil, 1000 :: HNil))
    list1 splitAt FOUR should be((1 :: 3.25 :: "smth1" :: 1000 :: HNil, HNil))
  }
}

object ZipableSplitableTest {
  private val ZERO = Zero
  private val ONE = Succ(ZERO)
  private val TWO = Succ(ONE)
  private val THREE = Succ(TWO)
  private val FOUR = Succ(THREE)
}