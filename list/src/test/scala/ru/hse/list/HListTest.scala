package ru.hse.list

import org.scalatest.{FlatSpec, Matchers}
import ru.hse.list.HList.HNil
import ru.hse.nat.Nat._

class HListTest extends FlatSpec with Matchers {
  "An HList" should "append elements" in {
    val list = ("hello" :: 42 :: false :: HNil) ::: ("world" :: HNil)

    val hello: String = list.head
    val world: String = list.tail.tail.tail.head
    assert(hello == "hello")
    assert(world == "world")
  }

  "An HList" should "zip with other list" in {
    val left = "hello" :: 42 :: false :: HNil
    val right = "world" :: HNil

    val zip = left zip right
    assert(zip.head._1 == "hello")
    assert(zip.head._2 == "world")
    assert(zip.tail == HNil)
  }

  "An empty HList" should "zip with other list" in {
    val left = HNil
    val right = "world" :: HNil

    val zip = left zip right
    assert(zip == HNil)
  }

  "An HList" should "split at any index in [0, size]" in {
    val list = "hello" :: 42 :: false :: "world" :: HNil
    val (l0, r0) = list.splitAt(_0)
    assert(l0 == HNil)
    assert(r0 == list)

    val (l1, r1) = list.splitAt(_1)
    assert(l1.head == "hello")
    assert(l1.tail == HNil)
    assert(r1.head == 42)
    assert(r1.tail.head == false)
    assert(r1.tail.tail.head == "world")

    val (l4, r4) = list.splitAt(_4)
    assert(l4 == list)
    assert(r4 == HNil)

    // Compilation errors
    // val (l10, r10) = list.splitAt(_10)
    // val (lm1, rm1) = list.splitAt(m1)
  }

  "An empty HList" should "split at zero only" in {
    val list = HNil
    val (l0, r0) = list.splitAt(_0)
    assert(l0 == HNil)
    assert(r0 == HNil)

    // Compilation errors
    // val (l12, r12) = list.splitAt(_12)
    // val (lm1, rm1) = list.splitAt(m1)
  }
}
