package ru.hse.spb.sharkova.treap

import org.junit.Test
import org.junit.Assert._

class ListTest {
  @Test
  def testEmptyList(): Unit = {
    val list = new List[Int]
    assertTrue(list.isEmpty)
    assertEquals(0, list.size)
  }

  @Test
  def testAdd(): Unit = {
    val list = new List[Int]
    list.add(3)
    list.add(4)
    assertEquals(2, list.size)
  }

  @Test
  def testContains(): Unit = {
    val list = new List[Int]
    list.add(3)
    list.add(4)
    assertTrue(list.contains(3))
    assertTrue(list.contains(4))
  }

  @Test
  def testAddAll(): Unit = {
    val list = new List[Int]
    list.addAll(1, 5, 8, 8)
    assertEquals(4, list.size)
    assertTrue(list.contains(1))
    assertTrue(list.contains(5))
    assertTrue(list.contains(8))
  }

  @Test
  def testIterator(): Unit = {
    val list = new List[Int]
    list.addAll(1, 5, 8, 8)
    val iterator = list.iterator
    assertTrue(iterator.hasNext)
    assertEquals(1, iterator.next())
    assertTrue(iterator.hasNext)
    assertEquals(5, iterator.next())
    assertTrue(iterator.hasNext)
    assertEquals(8, iterator.next())
    assertTrue(iterator.hasNext)
    assertEquals(8, iterator.next())
    assertFalse(iterator.hasNext)
  }

  @Test(expected = classOf[NoSuchElementException])
  def testIteratorNoNext(): Unit = {
    val list = new List[Int]
    list.addAll(1, 5)
    val iterator = list.iterator
    assertTrue(iterator.hasNext)
    iterator.next()
    assertTrue(iterator.hasNext)
    iterator.next()
    assertFalse(iterator.hasNext)
    iterator.next()
  }

  @Test
  def testReverse(): Unit = {
    val list = new List[Int]
    list.addAll(1, 2, 3, 4)
    val reversedList = new List[Int]
    reversedList.addAll(4, 3, 2, 1)
    assertTrue(reversedList.equals(list.reverse))
  }
}
