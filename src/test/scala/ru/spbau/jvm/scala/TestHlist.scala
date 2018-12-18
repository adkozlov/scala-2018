package ru.spbau.jvm.scala

import org.junit.Test
import ru.spbau.jvm.scala.HList._
import org.junit.Assert._
import ru.spbau.jvm.scala.Nat.{Succ, _0}

class TestHlist {

  @Test
  def smokeTest(): Unit = {
    val list1 = 1 :: 2 :: "test" :: () :: HNil
    val list2 = 1 :: null :: HNil
    val list3 = list1 ::: list2
  }

  @Test
  def zipInt(): Unit = {
    val list1 = 1 :: 2 :: 3 :: 4 :: HNil
    val list2 = 4 :: 3 :: 2 :: 1 :: HNil
    val listRes = (1, 4) :: (2, 3) :: (3, 2) :: (4, 1) :: HNil
    assertEquals(list1.zip(list2), listRes)
  }

  @Test
  def zipDiffs(): Unit = {
    val list1 = 1 :: "test" :: null :: 4 :: HNil
    val list2 = 4 :: () :: 2 :: "string" :: HNil
    val listRes = (1, 4) :: ("test", ()) :: (null, 2) :: (4, "string") :: HNil
    assertEquals(list1.zip(list2), listRes)
  }

  @Test
  def zipLeftSize(): Unit = {
    val list1 = 1 :: "test" :: HNil
    val list2 = 4 :: () :: 2 :: "string" :: HNil
    val listRes = (1, 4) :: ("test", ()) :: HNil
    assertEquals(list1.zip(list2), listRes)
  }

  @Test
  def zipRightSize(): Unit = {
    val list1 = 1 :: "test" :: null :: 4 :: HNil
    val list2 = 4 :: "string" :: HNil
    val listRes = (1, 4) :: ("test", "string") :: HNil
    assertEquals(list1.zip(list2), listRes)
  }

  @Test
  def splitTest(): Unit = {
    val list1 = 1 :: 2 :: false :: "test" :: 6 :: 4 :: HNil
    val list2 = 1 :: 2 :: false :: HNil
    val list3 =  "test" :: 6 :: 4 :: HNil
    assertEquals(list1.splitAt(Succ(Succ(Succ(_0)))), (list2, list3))
  }
}
