package ru.hse.scala.hlist

import org.junit.Assert.assertEquals
import org.junit.Test

class TestHlist {
  import HList._
  import Nat._

  private val list1 = "a" :: 1 :: true :: 0.1 :: HNil
  private val list2 = 2 :: false :: "b" :: HNil

  @Test
  def testZip(): Unit = {
    val res = list1 zip list2
    assertEquals(("a", 2), res.head)
    assertEquals((1, false), res.tail.head)
    assertEquals((true, "b"), res.tail.tail.head)
    assertEquals(0.1, res.tail.tail.tail.head, 1e-5)
    assertEquals(HNil, res.tail.tail.tail.tail)
  }
  
  @Test
  def testSplitAt(): Unit = {
    val (left, right) = list1 splitAt two
    
    assertEquals("a", left.head)
    assertEquals(1, left.tail.head)
    assertEquals(HNil, left.tail.tail)

    assertEquals(true, right.head)
    assertEquals(0.1, right.tail.head, 1e5)
    assertEquals(HNil, right.tail.tail)
  }
}
