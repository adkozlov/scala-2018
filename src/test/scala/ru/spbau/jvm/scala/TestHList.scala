package ru.spbau.jvm.scala

import HList._
import org.junit.Test
import org.junit.Assert.assertEquals

class HListTest {

  private val zero: MyNumber.Z.type = MyNumber.Z
  private val one = MyNumber.S(zero)
  private val two = MyNumber.S(one)


  @Test
  def testZip(): Unit = {
    assertEquals(HNil, HNil.zip(HNil))

    val test1 = 1 :: 2 :: "c" :: HNil
    assertEquals(HNil, test1.zip(HNil))

    val test2 = "a" :: "b" :: 3 :: HNil
    assertEquals((1, "a") :: (2, "b") :: ("c", 3) :: HNil, test1.zip(test2))

    val test3 = "0" :: HNil
    assertEquals((1, 0) :: HNil, test1.zip(test3))
  }


  @Test
  def splitTest() : Unit = {
    assertEquals((HNil, HNil), HNil.splitAt(zero))

    val test1 = 1 :: 2 :: "c" :: HNil
    assertEquals((1 :: HNil, "two" :: 3 :: HNil), test1.splitAt(one))
    assertEquals((1 :: "two" :: HNil, 3 :: HNil), test1.splitAt(two))
  }
}
