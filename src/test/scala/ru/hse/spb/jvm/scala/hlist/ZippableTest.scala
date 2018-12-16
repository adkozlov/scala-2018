package ru.hse.spb.jvm.scala.hlist

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.spb.jvm.scala.hlist.HList.HNil


class ZippableTest extends FlatSpec with Matchers {
  "Zippable" should "zip empty lists returning empty list" in {
    val list1 = HNil
    val list2 = HNil
    val zippedLeft = list1.zip(list2)
    zippedLeft should be(HNil)
    val zippedRight = list2.zip(list1)
    zippedRight should be(HNil)
  }

  "Zippable" should "zip lists with equal lengths > 0 returning for right.zip(left) list of pairs [(left, right)]" in {
    val list1 = "same type" :: 22 :: "world" :: HNil
    val list2 = "same type" :: "hello" :: 11.22 :: HNil
    val zippedLeft = list1.zip(list2)
    val expectedResultLeft = ("same type", "same type") :: ("hello", 22) :: (11.22, "world") :: HNil
    zippedLeft should be(expectedResultLeft)
    val zippedRight = list2.zip(list1)
    val expectedResultRight = ("same type", "same type") :: (22, "hello") :: ("world", 11.22) :: HNil
    zippedRight should be(expectedResultRight)
  }

  "Zippable" should "zip lists with length > 0 and length = 0 returning empty list" in {
    val list1 = HNil
    val list2 = "same type" :: "hello" :: 11.22 :: HNil
    val zippedLeft = list1.zip(list2)
    val expectedResultLeft = HNil
    zippedLeft should be(expectedResultLeft)
    val zippedRight = list2.zip(list1)
    val expectedResultRight = HNil
    zippedRight should be(expectedResultRight)
  }

  "Zippable" should "zip lists with different lengths > 0 returning list of pairs ignoring bigger tail" in {
    val list1 = 11.22 :: HNil
    val list2 = "same type" :: "hello" :: 11.22 :: HNil
    val zippedLeft = list1.zip(list2)
    val expectedResultLeft = ("same type", 11.22) :: HNil
    zippedLeft should be(expectedResultLeft)
    val zippedRight = list2.zip(list1)
    val expectedResultRight = (11.22, "same type") :: HNil
    zippedRight should be(expectedResultRight)
  }
}
