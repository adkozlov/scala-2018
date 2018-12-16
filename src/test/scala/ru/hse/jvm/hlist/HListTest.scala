package ru.hse.jvm.hlist
import HList.HNil
import org.junit.Test
import org.junit.Assert.assertEquals
import ru.hse.jvm.HNumber._

class HListTest {
  @Test
  def testZipWithEmpty(): Unit = {
    val list = 1 :: "Hello" :: true :: null :: HNil
    var result = list zip HNil
    assertEquals(HNil, result)
    result = HNil zip list
    assertEquals(HNil, result)
  }

  @Test
  def testZipEqualSizes(): Unit = {
    val list1 = "a" :: 23 :: HNil
    val list2 = 1 :: true :: HNil
    val result = list1 zip list2
    assertEquals("(a,1)", result.head.toString())
    assertEquals("(23,true)", result.tail.head.toString())
    assertEquals(HNil, result.tail.tail)
  }

  @Test
  def testZipDifferentSizes(): Unit = {
    val list1 = "a" :: 23 :: HNil
    val list2 = 1 :: HNil
    val result = list1 zip list2
    assertEquals("(a,1)", result.head.toString())
    assertEquals(HNil, result.tail)
  }

  @Test
  def testSplitAtZero(): Unit = {
    val list1 = "a" :: 23 :: true :: HNil
    val (a, b) = list1 splitAt _0
    assertEquals(HNil, a)
    assertEquals("a", b.head.toString)
    assertEquals("23", b.tail.head.toString)
    assertEquals("true", b.tail.tail.head.toString)
    assertEquals(HNil, b.tail.tail.tail)
  }

  @Test
  def testSplitAtSize(): Unit = {
    val list1 = "a" :: 23 :: true :: HNil
    val (b, a) = list1 splitAt _3
    assertEquals(HNil, a)
    assertEquals("a", b.head.toString)
    assertEquals("23", b.tail.head.toString)
    assertEquals("true", b.tail.tail.head.toString)
    assertEquals(HNil, b.tail.tail.tail)
  }

  @Test
  def testSplitAtOtherIndex(): Unit = {
    val list1 = "a" :: 23 :: true :: HNil
    val (a, b) = list1 splitAt _1
    /* does not compile:
    * val (c, d) = list1 splitAt m1
    * */
    assertEquals("a", a.head)
    assertEquals(HNil, a.tail)
    assertEquals("23", b.head.toString)
    assertEquals("true", b.tail.head.toString)
    assertEquals(HNil, b.tail.tail)
  }

  @Test
  def testSplitHNil(): Unit = {
    val (a, b) = HNil splitAt _0
    assertEquals(HNil, a)
    assertEquals(HNil, b)
    /* Does not compile:
    var (c, d) = HNil splitAt _1
    (c, d) = HNil splitAt m1
    */
  }
}
