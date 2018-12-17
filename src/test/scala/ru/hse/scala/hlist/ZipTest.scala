package ru.hse.scala.hlist

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hse.scala.hlist.HList.HNil

class ZipTest {
  private val firstList = 2 :: "cat" :: 0.7 :: HNil
  private val secondList = "dog" :: 1.1 :: HNil

  @Test
  def testZipBothNil(): Unit = {
    val result = HNil.zip(HNil)
    assertEquals(HNil, result)
  }

  @Test
  def testZipLeftNil(): Unit = {
    val result = HNil.zip(secondList)
    assertEquals(HNil, result)
  }

  @Test
  def testZipRightNil(): Unit = {
    val result = firstList.zip(HNil)
    assertEquals(HNil, result)
  }

  @Test
  def testZipLeftLargerList(): Unit = {
    val result = firstList zip secondList
    val expected = (2, "dog") :: ("cat", 1.1) :: HNil
    assertEquals(expected, result)
  }

  @Test
  def testZipRightLargerList(): Unit = {
    val result = secondList zip firstList
    val expected = ("dog", 2) :: (1.1, "cat") :: HNil
    assertEquals(expected, result)
  }
}
