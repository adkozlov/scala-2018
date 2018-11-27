package ru.spbau.jvm.scala

import org.junit.Test
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Assert.assertEquals

class TestTreeRB {

  @Test
  def emptyTree() : Unit = {
    val tree = new TreeRB[Int]
    assertEquals(0, tree.size)
    assertTrue(tree.isEmpty)
  }

  @Test
  def insertTree() : Unit = {
    val tree = new TreeRB[Int]
    tree.insert(1)
    assertEquals(1, tree.size)
    assertTrue(tree.contains(1))
    assertEquals(1, tree.min())
    assertEquals(1, tree.max())

    tree.insert(2)
    tree.insert(2)
    tree.insert(2)
    tree.insert(2)
    assertEquals(2, tree.size)
    assertTrue(tree.contains(1))
    assertTrue(tree.contains(2))
    assertEquals(1, tree.min())
    assertEquals(2, tree.max())
  }

  @Test
  def removeTree() : Unit = {
    val tree = new TreeRB[Int]
    tree.insert(1)
    tree.insert(2)
    tree.insert(3)

    assertEquals(3, tree.size)
    assertTrue(tree.contains(1))
    assertTrue(tree.contains(2))
    assertTrue(tree.contains(3))
    assertFalse(tree.contains(4))

    tree.remove(1)
    assertEquals(2, tree.size)
    assertFalse(tree.contains(1))
    assertTrue(tree.contains(2))
    assertTrue(tree.contains(3))
    assertFalse(tree.contains(4))

    tree.remove(4)
    assertEquals(2, tree.size)
    assertFalse(tree.contains(1))
    assertTrue(tree.contains(2))
    assertTrue(tree.contains(3))
    assertFalse(tree.contains(4))

    tree.remove(2)
    tree.remove(3)
    tree.remove(3)
    tree.remove(3)
    assertEquals(0, tree.size)
    assertTrue(tree.isEmpty)
    assertFalse(tree.contains(1))
    assertFalse(tree.contains(2))
    assertFalse(tree.contains(3))
    assertFalse(tree.contains(4))
  }

  @Test
  def minmaxTree() : Unit = {
    val tree = new TreeRB[Int]
    tree.insert(1)
    assertEquals(1, tree.min())
    assertEquals(1, tree.max())

    tree.insert(2)
    assertEquals(1, tree.min())
    assertEquals(2, tree.max())

    tree.insert(-1000)
    assertEquals(-1000, tree.min())
    assertEquals(2, tree.max())
  }

}