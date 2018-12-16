package ru.spbau.jvm.scala.hlist

import org.scalatest.{FlatSpec, Matchers}

class TestHList extends FlatSpec with Matchers {

  import HList._
  import HNat._


  private val list1 = 1 :: 2.4 :: "a" :: HNil
  private val list2 = "b" :: 44 :: HNil

  "zip" should "return HNil" in {
    list1 zip HNil should be(HNil)
    HNil zip list1 should be(HNil)
    HNil zip HNil should be(HNil)
  }

  "zip" should "return list of pairs" in {
    list1 zip list2 should be((1, "b") :: (2.4, 44) :: HNil)
    list2 zip list1 should be(("b", 1) :: (44, 2.4) :: HNil)
  }

  private val zero = Zero
  private val one = Succ(zero)
  private val two = Succ(one)
  private val three = Succ(two)

  "splitAt" should "split list correctly" in {
    list1 splitAt zero should be((HNil, list1))
    list1 splitAt one should be((1 :: HNil, 2.4 :: "a" :: HNil))
    list1 splitAt two should be((1 :: 2.4 :: HNil, "a" :: HNil))
    list1 splitAt three should be((1 :: 2.4 :: "a" :: HNil, HNil))
  }
}