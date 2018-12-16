package ru.hse.spb.kazakov

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.spb.kazakov.HList.{HCons, HNil}
import ru.hse.spb.kazakov.Nat.{O, S}

class HListTest extends FlatSpec with Matchers {
  private val _1 = S(O)
  private val _2 = S(_1)
  private val _3 = S(_2)

  "HList" should "be able to append elements" in {
    val list = 1 :: 'c' :: HNil
    list shouldBe HCons(1, HCons('c', HNil))
  }

  it should "be able to append a list" in {
    val list1 = 0.1 :: "qw" :: HNil
    val list2 = 'r' :: 1 :: -2 :: HNil
    list1 ::: list2 shouldBe HCons(0.1, HCons("qw", HCons('r', HCons(1, HCons(-2, HNil)))))
  }

  it should "be able to zip with list of the same size" in {
    val list1 = 0.1 :: "qw" :: HNil
    val list2 = 'r' :: 1 :: HNil
    list1.zip(list2) shouldBe HCons((0.1, 'r'), HCons(("qw", 1), HNil))
  }

  it should "be able to zip with list of the greater size" in {
    val list1 = 0.1 :: "qw" :: HNil
    val list2 = 'r' :: 1 :: -2 :: HNil
    list1.zip(list2) shouldBe HCons((0.1, 'r'), HCons(("qw", 1), HNil))
  }

  it should "be able to zip with list of the lesser size" in {
    val list1 = 0.1 :: "qw" :: HNil
    val list2 = 'r' :: HNil
    list1.zip(list2) shouldBe HCons((0.1, 'r'), HNil)
  }

  it should "be splittable at 0" in {
    val list = 0.1 :: "qw" :: 'c' :: HNil
    list.splitAt(O) shouldBe(HNil, list)
  }

  it should "be splittable in the middle" in {
    val list = 0.1 :: "qw" :: 'c' :: HNil
    list.splitAt(_2) shouldBe(0.1 :: "qw" :: HNil, 'c' :: HNil)
  }

  it should "be splittable at last element" in {
    val list = 0.1 :: "qw" :: 'c' :: HNil
    list.splitAt(_3) shouldBe(0.1 :: "qw" :: 'c' :: HNil, HNil)
  }
}