package ru.hse.scala.hlist

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hse.scala.hlist.HList.HNil
import ru.hse.scala.hlist.Nat.{Succ, Zero}

class SplitAtTest {
  private val list = 2 :: "cat" :: 0.7 :: HNil
  private val _0 = Zero
  private val _1 = Succ(_0)
  private val _3 = Succ(Succ(_1))
  private val _4 = Succ(_3)

  def testNotCompiling(): Unit = {
    // not compiling
    //list.splitAt(_4)
  }

  @Test
  def testSplitNil(): Unit = {
    val result = HNil.splitAt(_0)
    assertEquals((HNil, HNil), result)
  }

  @Test
  def testSplitZero(): Unit = {
    val result = list.splitAt(_0)
    assertEquals((HNil, list), result)
  }

  @Test
  def testSplitMax(): Unit = {
    val result = list.splitAt(_3)
    assertEquals((list, HNil), result)
  }

  @Test
  def testSplit(): Unit = {
    val result = list.splitAt(_1)
    val expected = (2 :: HNil, "cat" :: 0.7 ::HNil)
    assertEquals(expected, result)
  }
}
