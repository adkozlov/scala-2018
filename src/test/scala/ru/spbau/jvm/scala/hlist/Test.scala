package ru.spbau.jvm.scala.hlist

import org.scalatest.FlatSpec
import ru.spbau.jvm.scala.hlist.HList.HNil


class Test extends FlatSpec {

  "Zip" should "return a list of pairs from left and right lists" in {
    val left = "hello" :: 42 :: false :: HNil
    val right = 6 :: true :: "world" :: HNil
    val res = left zip right
    assert(res.head == ("hello", 6))
    assert(res.tail.head == (42, true))
    assert(res.tail.tail.head == (false, "world"))
    assert(res.tail.tail.tail.isInstanceOf[HNil.type])
  }

   it should "cut the right if it is longer" in {
    val left = "hello" :: 42  :: HNil
    val right = 6 :: true :: "world" :: HNil
    val res = left zip right
    assert(res.head == ("hello", 6))
    assert(res.tail.head == (42, true))
    assert(res.tail.tail.isInstanceOf[HNil.type])
  }

  it should "cut the left if it is longer" in {
    val left = "hello" :: 42  :: HNil
    val right =  "world" :: HNil
    val res = left zip right
    assert(res.head == ("hello", "world"))
    assert(res.tail.isInstanceOf[HNil.type])
  }

  it should "return empty list on two empty lists" in {
    assert((HNil zip HNil).isInstanceOf[HNil.type])
  }

  it should "return empty list if one of the lists is empty" in {
    assert((("hello" :: 42  :: HNil) zip HNil).isInstanceOf[HNil.type])
  }

  "SplitAt" should "return two list with all elements less than given index and rest" in {
    val list = "hello" :: 42 :: false :: HNil
    val res = list splitAt new S[O]
    assert(res._1.head == "hello")
    assert(res._1.tail.isInstanceOf[HNil.type])
    assert(res._2.head == 42)
    assert(!res._2.tail.head)
    assert(res._2.tail.tail.isInstanceOf[HNil.type])
  }

  "SplitAt" should "return two list with all elements less than given index and rest" in {
    val list = "hello" :: 42 :: false :: HNil
    val res = list splitAt new S[O]
    assert(res._1.head == "hello")
    assert(res._1.tail.isInstanceOf[HNil.type])
    assert(res._2.head == 42)
    assert(!res._2.tail.head)
    assert(res._2.tail.tail.isInstanceOf[HNil.type])
  }
}
