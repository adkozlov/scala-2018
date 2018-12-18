package ru.hse.dkaznacheev.heterogenous

import org.scalatest.{FlatSpec, Matchers}

class Test extends FlatSpec with Matchers {

  import ru.hse.dkaznacheev.heterogenous.HList._
  import ru.hse.dkaznacheev.heterogenous.Natural._

  private val testList = "head" :: 1 :: "f" :: HNil
  private val one = Succ(Zero)

  "splitAt" should "return HNil and the list if index is 0" in {
    assert(testList.splitAt(Zero) == (HNil, testList))
  }

  "splitAt" should "split list correctly" in {
    assert(testList.splitAt(one) == ("head" :: HNil, 1 :: "f" :: HNil))
  }

  "zip" should "zip lists of same length correctly" in {
    assert(testList.zip(testList) == ("head", "head") :: (1, 1) :: ("f", "f") :: HNil)
  }

  "zip" should "zip empty lists" in {
    assert(HNil.zip(HNil) == HNil)
  }

  "zip" should "throw away tail of longer list" in {
    assert(testList.zip(1 :: HNil) == ("head", 1) :: HNil)
  }
}
