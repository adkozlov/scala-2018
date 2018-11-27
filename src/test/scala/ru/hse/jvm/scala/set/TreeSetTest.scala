package ru.hse.jvm.scala.set

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hse.jvm.scala.set.TreeSet.emptySet

object TreeSetTest {
  def generateSet(n: Int): TreeSet[Int] = new TreeSet[Int](ALVTreeTest.generateTree(n))
  def setOf[K](values: K*)(implicit keyOrdering: Ordering[K]): TreeSet[K] = values.foldLeft(emptySet[K])(_+_)
}

class TreeSetTest {
  @Test
  def testEmpty(): Unit = {
    val set = TreeSet.emptySet[Int]
    assertEquals(0, set.size)
    assertEquals(true, set.isEmpty)
    assertEquals(false, set.isNotEmpty)
  }

  @Test
  def testNonEmpty(): Unit = {
    val set = TreeSetTest.setOf(5)
    assertEquals(1, set.size)
    assertEquals(false, set.isEmpty)
    assertEquals(true, set.isNotEmpty)
  }

  @Test
  def testAdd(): Unit = {
    var set = TreeSet.emptySet[Int]
    set = set + 1
    set = set + 2
    assertEquals(2, set.size)
  }

  @Test
  def testContains(): Unit = {
    val set = TreeSetTest.generateSet(5)
    for (i <- 1 to 5)
      assertEquals(true, set.contains(i))

    assertEquals(false, set.contains(6))
  }

  @Test
  def testErase(): Unit = {
    var set = TreeSetTest.setOf(1, 3)
    set = set - 2
    assertEquals(true, set.contains(1))
    set = set - 1
    assertEquals(false, set.contains(1))
  }

  @Test
  def testAddAll(): Unit = {
    assertEquals(TreeSetTest.generateSet(5), TreeSetTest.setOf(5, 4) ++ TreeSetTest.generateSet(3))
  }

  @Test
  def testRemoveAll(): Unit = {
    assertEquals(TreeSetTest.generateSet(0), TreeSetTest.generateSet(5) -- TreeSetTest.generateSet(5))
  }

  @Test
  def testIntersection(): Unit = {
    assertEquals(TreeSetTest.setOf(2, 3), TreeSetTest.setOf(1, 2, 3) & TreeSetTest.setOf(4, 2, 3))
  }

  @Test
  def testDifference(): Unit = {
    assertEquals(TreeSetTest.setOf(1), TreeSetTest.setOf(1, 2, 3) &~ TreeSetTest.setOf(4, 2, 3))
  }

  @Test
  def testUnion(): Unit = {
    assertEquals(TreeSetTest.setOf(1, 3, 4, 2), TreeSetTest.setOf(1, 2, 3) | TreeSetTest.setOf(4, 2, 3))
  }

  @Test
  def testForeach(): Unit = {
    var sum = 0
    TreeSetTest.generateSet(5).foreach(key => sum = sum + key)
    assertEquals(15, sum)
  }

  @Test
  def testFoldLeft(): Unit = {
    assertEquals(-15, TreeSetTest.generateSet(5).foldLeft(0)((a, b) => a - b))
  }

  @Test
  def testFoldRight(): Unit = {
    assertEquals(3, TreeSetTest.generateSet(5).foldRight(0)((a, b) => a - b))
  }

  @Test
  def testFoldLeftDifferentTypes(): Unit = {
    assertEquals(true, TreeSetTest.setOf(0, 1).foldLeft(false)((zero, key) => key != 0))
  }

  @Test
  def testMap(): Unit = {
    assertEquals(TreeSetTest.setOf(-1, -3, -2), TreeSetTest.generateSet(3).map(-_))
  }

  @Test
  def testFlatMap(): Unit = {
    assertEquals(TreeSetTest.generateSet(6), TreeSetTest.setOf(1, 5, 3).flatMap(key => TreeSetTest.setOf(key, key + 1)))
  }

  @Test
  def testFilter(): Unit = {
    assertEquals(TreeSetTest.setOf(1, 3, 5), TreeSetTest.generateSet(6).filter(_ % 2 == 1))
  }

  @Test
  def testFilterNot(): Unit = {
    assertEquals(TreeSetTest.setOf(2, 4, 6), TreeSetTest.generateSet(6).filterNot(_ % 2 == 1))
  }

  @Test
  def testForComprehension(): Unit = {
    var j = 1
    for (i <- TreeSetTest.generateSet(5)) {
      assertEquals(j, i)
      j = j + 1
    }
    assertEquals(6, j)
  }

  @Test
  def testForComprehensionGuard(): Unit = {
    var j = 1
    for (i <- TreeSetTest.generateSet(5) if i % 2 == 1) {
      assertEquals(j, i)
      j = j + 2
    }
    assertEquals(j, 7)
  }
}
