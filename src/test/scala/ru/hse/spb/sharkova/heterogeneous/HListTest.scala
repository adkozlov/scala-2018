package ru.hse.spb.sharkova.heterogeneous

import org.junit.Test
import org.junit.Assert._
import ru.hse.spb.sharkova.NonNegativeNumber.{Zero, Next}
import ru.hse.spb.sharkova.heterogeneous.HList._

class HListTest {
  private val one = Next(Zero)
  private val two = Next(one)
  private val three = Next(two)

  @Test
  def testListConstruction(): Unit = {
    val emptyList = HNil
    val singleElementList = 1 :: emptyList
    val multipleElementsList = 2 :: "word" :: true :: singleElementList
    assertEquals(2, multipleElementsList.head)
    assertEquals("word", multipleElementsList.tail.head)
    assertEquals(true, multipleElementsList.tail.tail.head)
    assertEquals(1, multipleElementsList.tail.tail.tail.head)
    assertEquals(HNil, multipleElementsList.tail.tail.tail.tail)
  }

  @Test
  def testListConcatenation(): Unit = {
    val list1 = 1 :: 2 :: 3 :: HNil
    val list2 = 4 :: 5 :: HNil
    val list = list1 ::: list2
    val exampleList = 1 :: 2 :: 3 :: 4 :: 5 :: HNil
    assertEquals(exampleList, list)
  }

  @Test
  def testSplitAtZero(): Unit = {
    val list = 1 :: "word" :: false :: HNil
    val splitAtZeroList = list.splitAt(Zero)
    assertEquals(HNil, splitAtZeroList._1)
    assertEquals(list, splitAtZeroList._2)
  }

  @Test
  def testSplitAtLastElement(): Unit = {
    val list = 1 :: false :: "word" :: HNil
    val splitList = list.splitAt(three)
    assertEquals(list, splitList._1)
    assertEquals(HNil, splitList._2)
  }

  @Test
  def testSplitAt(): Unit = {
    val list = true :: 2.22 :: "word" :: one :: HNil
    val splitAt1 = list.splitAt(one)
    val splitAt2 = list.splitAt(two)
    val splitAt3 = list.splitAt(three)
    assertEquals(true :: HNil, splitAt1._1)
    assertEquals(2.22, splitAt1._2.head, 0.00)
    assertEquals(true :: 2.22 :: HNil, splitAt2._1)
    assertEquals("word" :: one :: HNil, splitAt2._2)
    assertEquals(one :: HNil, splitAt3._2)
  }

  @Test
  def testSplitEmptyList(): Unit = {
    val list = HNil
    val splitList = list.splitAt(Zero)
    assertEquals((HNil, HNil), splitList)
  }

  @Test
  def testZipEmptyLists(): Unit = {
    val list1 = HNil
    val list2 = HNil
    assertEquals(HNil, list1.zip(list2))
  }

  @Test
  def testZipEmptyLeftList(): Unit = {
    val list1 = HNil
    val list2 = 3 :: 3.33 :: "3.333" :: HNil
    assertEquals(HNil, list1.zip(list2))
  }

  @Test
  def testZipEmptyRightList(): Unit = {
    val list1 = "list" :: HNil
    val list2 = HNil
    assertEquals(HNil, list1.zip(list2))
  }

  @Test
  def testZipEqualSizes(): Unit = {
    val list1 = "word" :: false :: 3.4 :: one :: HNil
    val list2 = true :: Zero :: "string" :: 2.9 :: HNil
    val list = list1.zip(list2)
    assertEquals(("word", true), list.head)
    assertEquals((false, Zero), list.tail.head)
    assertEquals((3.4, "string"), list.tail.tail.head)
    assertEquals((one, 2.9), list.tail.tail.tail.head)
    assertEquals(HNil, list.tail.tail.tail.tail)
  }

  @Test
  def testZipDifferentSizes(): Unit = {
    val list1 = "word" :: false :: HNil
    val list2 = 3.4 :: Zero :: true :: HNil
    val list1to2 = list1.zip(list2)
    val list2to1 = list2.zip(list1)
    assertEquals(("word", 3.4) :: (false, Zero) :: HNil, list1to2)
    assertEquals((3.4, "word") :: (Zero, false) :: HNil, list2to1)
  }
}
