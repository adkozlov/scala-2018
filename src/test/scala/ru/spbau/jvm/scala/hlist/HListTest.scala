package ru.spbau.jvm.scala.hlist

import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit
import ru.spbau.jvm.scala.hlist.HList.HNil

class HListTest extends AssertionsForJUnit {

  @Test
  def `test zip when left operand is HNil`(): Unit = {
    val right = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)
    assert((HNil zip right) == HNil)
  }

  @Test
  def `test zip when right operand is HNil`(): Unit = {
    val left = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)
    assert((left zip HNil) == HNil)
  }

  @Test
  def `test zip when both operands are not HNil`(): Unit = {
    val left = "hello" :: 42 :: false :: HNil
    val right = 0.45 :: (1 :: 2 :: HNil) :: "world" :: true :: HNil
    val expectedResult = ("hello", 0.45) :: (42, 1 :: 2 :: HNil) :: (false, "world") :: HNil
    assert((left zip right) == expectedResult)
  }

  @Test
  def `test split by zero index`(): Unit = {
    val list = "hello" :: 42 :: false :: HNil
    assert((list splitBy Z) == (HNil, list))
  }

  @Test
  def `test split by positive index`(): Unit = {
    val list = 0.45 :: (1 :: 2 :: HNil) :: "world" :: true :: HNil
    assert((list splitBy S(S(Z))) == (0.45 :: (1 :: 2 :: HNil) :: HNil, "world" :: true :: HNil))
  }
}
