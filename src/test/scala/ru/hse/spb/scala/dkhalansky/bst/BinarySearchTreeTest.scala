package ru.hse.spb.scala.dkhalansky.bst
import scala.collection.mutable.ListBuffer

import org.scalatest.FunSuite
import org.scalatest.Matchers._

import scala.collection.JavaConverters._

class BinarySearchTreeTest extends FunSuite {

  test("Insertion, deletion, presence") {
    var tree = BinarySearchTree(1, 2, 5, 10)
    assert(tree.contains(1))
    assert(tree.contains(2))
    assert(tree.contains(5))
    assert(tree.contains(10))
    assert(!tree.contains(11))
    assert(!tree.contains(3))
    tree = tree - 5
    assert(tree.contains(1))
    assert(tree.contains(2))
    assert(!tree.contains(5))
    assert(tree.contains(10))
    assert(!tree.contains(11))
    assert(!tree.contains(3))
    tree = tree + 5
    assert(tree.contains(1))
    assert(tree.contains(2))
    assert(tree.contains(5))
    assert(tree.contains(10))
    assert(!tree.contains(11))
    assert(!tree.contains(3))
    tree = tree - 5
    tree = tree - 1
    tree = tree - 10
    assert(!tree.contains(1))
    assert(tree.contains(2))
    assert(!tree.contains(5))
    assert(!tree.contains(10))
    assert(!tree.contains(11))
    assert(!tree.contains(3))
  }

  test("Test for-comprehensions with filter") {
    val tree = BinarySearchTree(1, 100, 5, 6, 10, 10000)
    val buffer = new ListBuffer[Int]()
    for (s <- tree if s < 1000) {
      buffer.append(s)
    }
    assert(List(1, 5, 6, 10, 100) === buffer)
  }

  test("Test for-comprehensions with map") {
    val tree = BinarySearchTree(1, 100, 5, 6, 10, 10000)
    val newTree = for (s <- tree if s < 1000) yield s * 2
    assert(244 === newTree.fold(((a: Int, b: Int) => a + b), 0))
  }

}
