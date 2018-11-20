package ru.spbau.jvm.scala.impl

import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit
import ru.spbau.jvm.scala.avl.BinarySearchTree

class BinarySearchTreeTest extends AssertionsForJUnit {

  /*
        3
       / \
      1   5
      \  /
      2 4
   */
  @Test
  def `insert some different numbers`(): Unit = {
    var tree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree.insert(i) match { case Left(a) => a; case _ => tree })
    assert(tree.find(1).nonEmpty)
    assert(tree.find(0).isEmpty)

    assert(tree.size == 5)
    assert(tree.depth == 3)
    assert(tree.min.contains(1))
    assert(tree.max.contains(5))
    assert(tree.nearestLower.contains(2))
    assert(tree.nearestUpper.contains(4))
  }

  /*
        1
         \
          2
           \
            3
             \
              4
               \
                5
   */
  @Test
  def `insert some equal numbers`(): Unit = {
    var tree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    Array(1, 2, 3, 4, 5, 1, 2, 3, 4, 5).foreach(i => tree = tree.insert(i) match { case Left(a) => a; case _ => tree })
    assert(tree.find(1).nonEmpty)
    assert(tree.find(0).isEmpty)

    assert(tree.size == 5)
    assert(tree.depth == 5)
    assert(tree.min.contains(1))
    assert(tree.max.contains(5))
    assert(tree.nearestLower.isEmpty)
    assert(tree.nearestUpper.contains(2))
  }

  @Test
  def `remove present numbers`(): Unit = {
    var tree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree.insert(i) match { case Left(a) => a; case _ => tree })
    Array(1, 2, 3).foreach(i => tree = tree.removeKey(i) match { case Left(a) => a; case _ => tree })
    assert(tree.size == 2)
    assert(tree.depth == 2)
    assert(tree.min.contains(4))
    assert(tree.max.contains(5))
    assert(!tree.contains(1))
  }

  @Test
  def `remove non-present numbers`(): Unit = {
    var tree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree.insert(i) match { case Left(a) => a; case _ => tree })
    Array(3, 7, 8).foreach(i => tree = tree.removeKey(i) match { case Left(a) => a; case _ => tree })
    assert(tree.size == 4)
    assert(tree.depth == 3)
    assert(tree.min.contains(1))
    assert(tree.max.contains(5))
    assert(!tree.contains(3))
  }
}
