package ru.hse.spb.jvm.scala.hlist

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.spb.jvm.scala.hlist.HList.HNil

class AppendableTest extends FlatSpec with Matchers {
  "::" should "append one element to the head of the list" in {
    val list1 = HNil
    val list2 = 22 :: list1
    list2.head should be(22)
    list2.tail should be(HNil)
    val list3 = "hello" :: list2
    list3.head should be("hello")
    list3.tail should be(list2)
  }

  "Appendable" should "append one list to another one" in {
    val list1 = HNil
    val list2 = (22 :: HNil) ::: list1
    list2 should be(22 :: HNil)
    val list3 = list2 ::: ("hello" :: 22.11 :: HNil)
    list3 should be(22 :: "hello" :: 22.11 :: HNil)
    val list4 = ("hello" :: 22.11 :: HNil) ::: list2
    list4 should be("hello" :: 22.11 :: 22 :: HNil)
  }
}