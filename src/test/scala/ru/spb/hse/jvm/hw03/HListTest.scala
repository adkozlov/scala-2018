package ru.spb.hse.jvm.hw03

import org.junit.Assert._
import org.junit.Test
import ru.spb.hse.jvm.scala.hw03.HList._

class HListTest {

  import ru.spb.hse.jvm.scala.hw03.ChurchNumeral._

  private val list = "1" :: "0" :: HNil

  @Test def testZip1(): Unit = {
    assertEquals(HNil, HNil.zip(HNil))
  }

  @Test def testZip2(): Unit = {
    assertEquals(HNil, list.zip(HNil))
  }

  @Test def testZip3(): Unit = {
    assertEquals(list.zip(list), ("1", "1") :: ("0", "0") :: HNil)
  }

  @Test def testSplit1(): Unit = {
    assertEquals((HNil, HNil), HNil.split(zero))
  }

  @Test def testSplit2(): Unit = {
    val list = "2" :: "1" :: "0" :: HNil
    assertEquals((HNil, list), list.split(zero))
  }

}
