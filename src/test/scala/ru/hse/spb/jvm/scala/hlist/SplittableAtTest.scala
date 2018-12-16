package ru.hse.spb.jvm.scala.hlist

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.spb.jvm.scala.hlist.HList.HNil
import ru.hse.spb.jvm.scala.numbers.NonNegativeNumber.{Suc, Zero}

class SplittableAtTest extends FlatSpec with Matchers {
  "SplittableAt" should "split empty list at 0 returning two empty lists and in other cases compilation error" in {
    val list = HNil
    list.splitAt(Zero) should be((HNil, HNil))
    /* Code below produces compilation errors and won't compile. And it is correct behaviour
      list.splitAt(Suc(Zero))
      list.splitAt(Suc(Suc(Zero)))
      ...
    */
  }

  "SplittableAt" should "split at 0 of non-empty list returning (HNil, list)" in {
    val list = "hello" :: 22 :: HNil
    list.splitAt(Zero) should be((HNil, list))
  }

  "SplittableAt" should "split at len(list) of non-empty list returning (list, HNil)" in {
    val list = "hello" :: 22 :: HNil
    list.splitAt(Suc(Suc(Zero))) should be((list, HNil))
    /* Cannot be compiled because 3 is out of range (> 2)
    list.splitAt(Suc(Suc(Suc(Zero)))) should be((list, HNil))
     */
  }

  "SplittableAt" should "split at entire index of non-empty list returning (list_first_n, list_others)" in {
    val list = 11.22 :: "hello" :: 22 :: HNil
    list.splitAt(Suc(Zero)) should be((11.22 :: HNil, "hello" :: 22 :: HNil))
    list.splitAt(Suc(Suc(Zero))) should be((11.22 :: "hello" :: HNil, 22 :: HNil))
    list.splitAt(Suc(Suc(Suc(Zero)))) should be((11.22 :: "hello" :: 22 :: HNil, HNil))
  }
}
