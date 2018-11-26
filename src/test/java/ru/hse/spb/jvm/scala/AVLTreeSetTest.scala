package ru.hse.spb.jvm.scala

import org.scalatest.{FlatSpec, Matchers}

class AVLTreeSetTest extends FlatSpec with Matchers {

  "Size method" should "be able to evaluate size of a tree correctly" in {
    val set = new AVLTreeSet[Int]
    set.size should be(0)
    set.add(10)
    set.size should be(1)
    set.add(11)
    set.size should be(2)
    set.add(11)
    set.size should be(2)
    set.remove(10)
    set.size should be(1)
    set.remove(10)
    set.size should be(1)
    set.remove(11)
    set.size should be(0)
    set.remove(11)
    set.size should be(0)
  }
}
