package ru.hse.jvm.scala.set

import org.junit.Assert.assertEquals
import org.junit.Test

class AVLIteratorTest {
  @Test
  def testEmptyTree(): Unit = {
    val iterator = new TreeSet[Int]().iterator
    assertEquals(false, iterator.hasNext)
  }

  @Test
  def testHasNextTrue(): Unit = {
    val iterator = TreeSetTest.generateSet(1).iterator
    assertEquals(true, iterator.hasNext)
  }

  @Test
  def testNext(): Unit = {
    val iterator = TreeSetTest.generateSet(1).iterator
    assertEquals(1, iterator.next())
    assertEquals(false, iterator.hasNext)
  }

  @Test
  def testSorted(): Unit = {
    val iterator = new TreeSet(AVLNil.add(5).add(1)).iterator
    assertEquals(1, iterator.next())
    assertEquals(5, iterator.next())
  }

  @Test
  def testSeveralElements(): Unit = {
    val iterator = TreeSetTest.generateSet(5).iterator
    for (i <- 1 to 5) {
      assertEquals(true, iterator.hasNext)
      assertEquals(i, iterator.next())
    }
    assertEquals(false, iterator.hasNext)
  }
}
