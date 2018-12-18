package hlist

import hlist.HList.HNil
import hlist.Nat._
import org.scalatest.FunSuite

class HListTest extends FunSuite {

  test("zip works with empty lists") {
    assert(HNil.zip(HNil) == HNil)
  }

  test("nil can be left zip argument") {
    val list = 1 :: 2 :: 3 :: HNil

    assert(HNil.zip(list) == HNil)
  }

  test("nil can be right zip argument") {
    val list = 1 :: 2 :: 3 :: HNil

    assert(list.zip(HNil) == HNil)
  }

  test("zip result is as long as the shortest of two lists") {
    val first = 1 :: 2 :: 3 :: HNil
    val second = "1" :: "2" :: HNil

    assert(first.zip(second) == (1, "1") :: (2, "2") :: HNil)
  }

  test("two same sized lists can be zipped") {
    val first = "1" :: 2 :: 3.0 :: HNil
    val second = "one" :: List("two") :: 3 :: HNil

    assert(
      first.zip(second) == ("1", "one") :: (2, List("two")) :: (3.0, 3) :: HNil)
  }

  test("empty list can be split at zero") {
    val (front, back) = HNil.splitAt[_0]

    assert(front == HNil)
    assert(back == HNil)
  }

  test("empty list cannot be split at any number more than zero") {
    assertDoesNotCompile("HNil.splitAt[_1]")
    assertDoesNotCompile("HNil.splitAt[_2]")
  }

  test("list correctly splits up on existing index") {
    val list = 1 :: "two" :: 3.0 :: HNil

    val (front, back) = list.splitAt[_2]

    assert(front == 1 :: "two" :: HNil)
    assert(back == 3.0 :: HNil)
  }

  test("list cannot be split up on non-existing index") {
    val list = 1 :: "two" :: 3.0 :: HNil

    assertDoesNotCompile("(1 :: \"two\" :: 3.0 :: HNil).splitAt[_4]")
    assertDoesNotCompile("(1 :: \"two\" :: 3.0 :: HNil).splitAt[_5]")
  }
}
