package ru.hse.tree

import org.scalatest.{FlatSpec, Matchers}

class TreeSetTest extends FlatSpec with Matchers {
  "A TreeSet" should "add elements" in {
    val tree = new TreeSet[Int](0.57)
    val array = Array(5, 2, 1, 4, 6)
    array.foreach(element => tree += element)
    array.foreach(element => assert(tree.contains(element)))
  }
}
