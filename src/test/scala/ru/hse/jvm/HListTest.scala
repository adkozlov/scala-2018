package ru.hse.jvm

import HList.HNil
import org.junit.Test
import org.junit.Assert.assertEquals
import ru.hse.jvm.HNumber._

class HListTest {
  private val list = 1 :: "two" :: 3 :: HNil
  private val list1 = 2 :: "one" :: 43 :: HNil
  private val bigList = list ::: list1
  private val smallList = 1 :: HNil

  @Test
  def testZipEmpty(): Unit = {
    val result1 = list.zip(HNil)
    assertEquals(HNil, result1)
    val result2 = HNil.zip(list)
    assertEquals(HNil, result2)
  }

  @Test
  def testBothEmptyZip(): Unit = {
    val result = HNil.zip(HNil)
    assertEquals(HNil, result)
  }

  @Test
  def testNormalZip(): Unit = {
    val result = list.zip(list)
    assertEquals((1, 1) :: ("two", "two") :: (3, 3) :: HNil, result)
  }

  @Test
  def testDifferentListZip(): Unit = {
    val result1 = list.zip(list1)
    assertEquals((1, 2) :: ("two", "one") :: (3, 43) :: HNil, result1)
    val result2 = list1.zip(list)
    assertEquals((2, 1) :: ("one", "two") :: (43, 3) :: HNil, result2)
  }

  @Test
  def testZipDifferentSizes(): Unit = {
    val result1 = smallList.zip(list1)
    assertEquals((1, 2) :: HNil, result1)
    val result2 = list1.zip(smallList)
    assertEquals((2, 1) :: HNil, result2)
  }

  @Test
  def testNormalSplit(): Unit = {
    val result = list.splitAt(_1)
    assertEquals((1 :: HNil, "two" :: 3 :: HNil), result)
  }

  @Test
  def testNilSplit(): Unit = {
    val result = HNil.splitAt(_0)
    assertEquals((HNil, HNil), result)
  }

  @Test
  def testLeftEmptySplit(): Unit = {
    val result = list.splitAt(_0)
    assertEquals((HNil, 1 :: "two" :: 3 :: HNil), result)
  }

  @Test
  def testRightEmptySplit(): Unit = {
    val result = list.splitAt(_3)
    assertEquals((1 :: "two" :: 3 :: HNil, HNil), result)
  }

  @Test
  def testBigListSplit(): Unit = {
    val result = bigList.splitAt(_3)
    assertEquals((list, list1), result)
  }
}