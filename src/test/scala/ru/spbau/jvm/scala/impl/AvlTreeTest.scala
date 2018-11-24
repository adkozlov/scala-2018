package ru.spbau.jvm.scala.impl

import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit
import ru.spbau.jvm.scala.avl.AvlTree

class AvlTreeTest extends AssertionsForJUnit {

  /*
        3                      2
       / \                    / \
      1  5  --- balance -->  1  4
      \  /                     / \
      2 4                     3  5
   */
  @Test
  def `insert some different numbers`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    assert(tree.find(1).nonEmpty)
    assert(tree.find(0).isEmpty)

    assert(tree.size == 5)
    assert(tree.height == 3)
    assert(tree.key.contains(2))
    assert(tree.min.contains(1))
    assert(tree.max.contains(5))
    assert(tree.nearestLower.contains(1))
    assert(tree.nearestUpper.contains(3))
  }

  /*
        1
         \
          2                            2
           \                          / \
            3       --- balance -->  1  4
             \                         / \
              4                       3  5
               \
                5
   */
  @Test
  def `insert some equal numbers`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(1, 2, 3, 4, 5, 1, 2, 3, 4, 5).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    assert(tree.find(1).nonEmpty)
    assert(tree.find(0).isEmpty)

    assert(tree.size == 5)
    assert(tree.height == 3)
    assert(tree.key.contains(2))
    assert(tree.min.contains(1))
    assert(tree.max.contains(5))
    assert(tree.nearestLower.contains(1))
    assert(tree.nearestUpper.contains(3))
  }

  /*
      2            4
     / \          / \          4        4
    1  4    -->  2  5   -->   / \  -->   \
      / \        \           3  5        5
     3  5        3
   */
  @Test
  def `remove present numbers`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    tree = tree - 1 match { case Left(a) => a; case _ => tree }
    assert(tree.size == 4)
    assert(tree.height == 3)
    assert(tree.key.contains(4))
    assert(tree.nearestLower.contains(3))
    assert(tree.nearestUpper.contains(5))
    assert(tree.max.contains(5))
    assert(!tree.contains(1))

    tree = tree - 2 match { case Left(a) => a; case _ => tree }
    assert(tree.size == 3)
    assert(tree.height == 2)
    assert(tree.key.contains(4))
    assert(tree.nearestLower.contains(3))
    assert(tree.nearestUpper.contains(5))
    assert(tree.max.contains(5))

    tree = tree - 3 match { case Left(a) => a; case _ => tree }
    assert(tree.size == 2)
    assert(tree.height == 2)
    assert(tree.key.contains(4))
    assert(tree.nearestLower.isEmpty)
    assert(tree.nearestUpper.contains(5))
    assert(tree.max.contains(5))
  }

  /*
      2            2
     / \          / \
    1  4    -->  1  4
      / \            \
     3  5            5
   */
  @Test
  def `remove non-present numbers`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    Array(3, 7, 8).foreach(i => tree = tree - i match { case Left(a) => a; case _ => tree })

    assert(tree.size == 4)
    assert(tree.height == 3)
    assert(tree.key.contains(2))
    assert(tree.min.contains(1))
    assert(tree.max.contains(5))
    assert(!tree.contains(3))
  }

  @Test
  def `test inorder function`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    assertResult(Some(List(1, 2, 3, 4, 5)))  { AvlTree.unapplySeq(tree) }
  }

  @Test
  def `test map function`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    assertResult(Some(List("2", "4", "6", "8", "10"))) { AvlTree.unapplySeq(tree.map(i => (i * 2).toString)) }
  }

  /*
      2            2
     / \          / \
    1  4    -->  1  4
      / \            \
     3  5            5
   */
  @Test
  def `test filter function`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    assertResult(Some(List(2, 4))) { AvlTree.unapplySeq(tree.withFilter(i => i % 2 == 0)) }
    assertResult(Some(List.empty)) { AvlTree.unapplySeq(tree.withFilter(i => i > 5)) }
  }

  @Test
  def `test foldLeft function`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    val add: (Int, Int) => Int = _ + _
    val sub: (Int, Int) => Int = _ - _

    assertResult(15) { tree.foldLeft(add)(0) }
    assertResult(16) { tree.foldLeft(add)(1) }
    // ((((0 - 1) - 2) - 3) - 4) - 5 = -15
    assertResult(-15) { tree.foldLeft(sub)(0) }
  }

  @Test
  def `test foldRight function`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    val add: (Int, Int) => Int = _ + _
    val sub: (Int, Int) => Int = _ - _

    assertResult(15) { tree.foldRight(add)(0) }
    assertResult(16) { tree.foldRight(add)(1) }
    // (1 - (2 - (3 - (4 - 5)))) - 0 = 3
    assertResult(3) { tree.foldRight(sub)(0) }
  }

  @Test
  def `test foldRight is lazy by second argument`(): Unit = {
    var tree: AvlTree[Int] = new AvlTree[Int]()
    Array(3, 1, 2, 5, 4).foreach(i => tree = tree + i match { case Left(a) => a; case _ => tree })
    val `+?`: (Int, Int) => Int = (a, b) => if (a % 2 == 0) a else a + b

    // foldr +? 0 [1, 2, 3, 4, 5] = 1 +? (foldr +? 0 [2, 3, 4, 5]) = 1 +? (2 +? (foldr +? 0 [3, 4, 5])) = 1 +? 2 = 3
    assertResult(3) { tree.foldRight(+?)(0) }
  }

  @Test
  def `test trees merging`(): Unit = {
    var tree1: AvlTree[Int] = new AvlTree[Int]()
    Array(6, 7, 2, 9, 1).foreach(i => tree1 = tree1 + i match { case Left(a) => a; case _ => tree1 })
    var tree2: AvlTree[Int] = new AvlTree[Int]()
    Array(4, 8, 5, 3, 10).foreach(i => tree2 = tree2 + i match { case Left(a) => a; case _ => tree2 })
    val tree3 = tree1 ++ tree2
    val tree4 = tree2 ++ tree1
    assertResult(Some(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) { AvlTree.unapplySeq(tree3) }
    assertResult(Some(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) { AvlTree.unapplySeq(tree4) }
  }
}
