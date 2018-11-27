package ru.hse.jvm.scala.set

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.hse.jvm.scala.set.TreeSet.emptySet

object ALVTreeTest {
  def generateTree(n: Int): AVLTree[Int] = {
    var result: AVLTree[Int] = AVLNil
    for (i <- 1 to n)
      result = result.add(i)
    result
  }
}

class AVLTreeTest {
  @Test
  def testEmptyTree(): Unit = {
    val tree: AVLTree[Int] = AVLNil
  }

  @Test
  def testAddElement(): Unit = {
    val tree = AVLNil.add(5)
  }

  @Test
  def testContains(): Unit = {
    var tree: AVLTree[Int] = AVLNil
    assertEquals(false, tree.contains(5))
    tree = tree.add(5)
    assertEquals(true, tree.contains(5))
  }

  @Test
  def testAddManyElements(): Unit = {
    val tree = ALVTreeTest.generateTree(1000)
    assertTrue(tree.height <= math.log(1000) / 0.2)
  }

  @Test
  def testSizeEmpty(): Unit = {
    assertEquals(0, AVLNil.size)
  }

  @Test
  def testSize(): Unit = {
    assertEquals(3, ALVTreeTest.generateTree(3).size)
  }

  @Test
  def testAddSame(): Unit = {
    assertEquals(1, AVLNil.add(1).add(1).size)
  }

  @Test
  def testEraseNothing(): Unit = {
    val tree = AVLNil.add(5).erase(4)
    assertEquals(true, tree.contains(5))
  }

  @Test
  def testErase(): Unit = {
    val tree = AVLNil.add(5).erase(5)
    assertEquals(false, tree.contains(5))
  }

  @Test
  def testEraseMany(): Unit = {
    var tree = ALVTreeTest.generateTree(3)
    assertEquals(true, tree.contains(2))
    tree = tree.erase(2)
    assertEquals(false, tree.contains(2))
    assertEquals(true, tree.contains(1))
    tree = tree.erase(1)
    assertEquals(false, tree.contains(1))
    assertEquals(true, tree.contains(3))
    tree = tree.erase(3)
    assertEquals(false, tree.contains(3))
    assertEquals(0, tree.size)
  }

  @Test(expected = classOf[NoSuchElementException])
  def testMaxEmpty(): Unit = {
    AVLNil.max()
  }

  @Test
  def testMax(): Unit = {
    assertEquals(10, ALVTreeTest.generateTree(10).max())
  }
}
