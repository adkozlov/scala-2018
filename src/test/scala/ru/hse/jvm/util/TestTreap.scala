package ru.hse.jvm.util

import java.util

import org.junit.{Before, Test}
import org.junit.Assert.assertEquals

class TestTreap {
  private var treapInt : Treap[Int] = _
  private var treapString : Treap[String] = _

  @Test
  def testZeroSizeInt() : Unit = {
    treapInt = new Treap[Int]
    assertEquals(0, treapInt.getSize)
  }

  @Test
  def testZeroSizeString() : Unit = {
    treapString = new Treap[String]
    assertEquals(0, treapString.getSize)
  }

  @Test
  def testAddRemoveOneElementInt() : Unit = {
    treapInt = new Treap[Int]
    treapInt.insert(3)
    assertEquals(1, treapInt.getSize)
    assertEquals(true, treapInt.contains(3))
    assertEquals(false, treapInt.contains(4))
    assertEquals(false, treapInt.contains(2))
    treapInt.remove(3)
    assertEquals(0, treapInt.getSize)
    assertEquals(false, treapInt.contains(3))
  }

  @Test
  def testAddRemoveOneElementString() : Unit = {
    treapString = new Treap[String]
    treapString.insert("b")
    assertEquals(1, treapString.getSize)
    assertEquals(true, treapString.contains("b"))
    assertEquals(false, treapString.contains("a"))
    assertEquals(false, treapString.contains("ba"))
    treapString.remove("b")
    assertEquals(0, treapString.getSize)
    assertEquals(false, treapString.contains("b"))
  }

  @Test
  def testAddTheSameElementInt() : Unit = {
    treapInt = new Treap[Int]
    treapInt.insert(3)
    treapInt.insert(3)
    assertEquals(1, treapInt.getSize)
    assertEquals(true, treapInt.contains(3))
    assertEquals(false, treapInt.contains(4))
    assertEquals(false, treapInt.contains(2))
    treapInt.remove(3)
    assertEquals(0, treapInt.getSize)
    assertEquals(false, treapInt.contains(3))
  }

  @Test
  def testAddTheSameElementString() : Unit = {
    treapString = new Treap[String]
    treapString.insert("b")
    treapString.insert("b")
    assertEquals(1, treapString.getSize)
    assertEquals(true, treapString.contains("b"))
    assertEquals(false, treapString.contains("a"))
    assertEquals(false, treapString.contains("ba"))
    treapString.remove("b")
    assertEquals(0, treapString.getSize)
    assertEquals(false, treapString.contains("b"))
  }

  @Test
  def testSeveralElementsInt() : Unit = {
    treapInt = new Treap[Int]
    treapInt.insert(5)
    treapInt.insert(2)
    treapInt.insert(3)
    assertEquals(3, treapInt.getSize)
    assertEquals(true, treapInt.contains(2))
    assertEquals(true, treapInt.contains(3))
    assertEquals(true, treapInt.contains(5))
    treapInt.remove(3)
    assertEquals(2, treapInt.getSize)
    assertEquals(true, treapInt.contains(2))
    assertEquals(false, treapInt.contains(3))
    assertEquals(true, treapInt.contains(5))
    assertEquals("2, 5", treapInt.toArray.mkString(", "))
  }

  @Test
  def testSeveralElementsString() : Unit = {
    treapString = new Treap[String]
    treapString.insert("d")
    treapString.insert("a")
    treapString.insert("b")
    assertEquals(3, treapString.getSize)
    assertEquals(true, treapString.contains("a"))
    assertEquals(true, treapString.contains("b"))
    assertEquals(true, treapString.contains("d"))
    treapString.remove("b")
    assertEquals(2, treapString.getSize)
    assertEquals(true, treapString.contains("a"))
    assertEquals(false, treapString.contains("b"))
    assertEquals(true, treapString.contains("d"))
    assertEquals("a, d", treapString.toArray.mkString(", "))
  }
}
