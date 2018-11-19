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
  def testInsertDifferentNumbers(): Unit = {
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
  def testInsertSomeEqualNumbers(): Unit = {
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
}
