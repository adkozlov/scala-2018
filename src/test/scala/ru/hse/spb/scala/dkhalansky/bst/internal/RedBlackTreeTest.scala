package ru.hse.spb.scala.dkhalansky.bst.internal

import org.scalatest.FunSuite
import org.scalatest.Matchers._

import scala.collection.JavaConverters._

class RedBlackTreeTest extends FunSuite {

  private def assertRedBlackTreeInvariants[T](tree: RedBlackTree[T]): Unit = {
    def leftLeafBlackHeight(tree: RedBlackTree[T]): Int = tree match {
      case Leaf => 0
      case Node(Red, leftTree, _, _) => leftLeafBlackHeight(leftTree)
      case Node(Black, leftTree, _, _) => 1 + leftLeafBlackHeight(leftTree)
    }
    val blackHeight = leftLeafBlackHeight(tree)

    def assertProperHeight(tree: RedBlackTree[T], height: Int): Unit = tree match {
      case Leaf => assert(blackHeight === height)
      case Node(Red, leftTree, _, rightTree) =>
        assertProperHeight(leftTree, height)
        assertProperHeight(rightTree, height)
      case Node(Black, leftTree, _, rightTree) =>
        assertProperHeight(leftTree, 1 + height)
        assertProperHeight(rightTree, 1 + height)
    }

    tree match {
      case Node(color, _, _, _) => assert(Black === color)
      case Leaf =>
    }

    assertProperHeight(tree, 0)
  }

  test("Red-black tree operations") {
    var t: RedBlackTree[Int] = Leaf
    for (x <- 1 to 10) {
      assert(RedBlackTree.elem(x, t).isEmpty)
      t = RedBlackTree.insert(x, t)
      assertRedBlackTreeInvariants(t)
      assert(!RedBlackTree.elem(x, t).isEmpty)
    }
    var td: RedBlackTree[Int] = t
    for (x <- 1 to 10) {
      assert(!RedBlackTree.elem(x, td).isEmpty)
      td = RedBlackTree.delete(x, td)
      assertRedBlackTreeInvariants(td)
      assert(RedBlackTree.elem(x, td).isEmpty)
    }
  }

}

