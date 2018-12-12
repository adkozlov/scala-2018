package ru.spbau.jvm.scala.tree

import scala.collection.mutable.ListBuffer
import org.junit.Assert._
import org.junit.{Before, Test}

class TreapTest {


  private def treapToList[T](treap: Treap[T]): List[T] = {
    val iterator = treap.iterator
    val result = ListBuffer.empty[T]
    while (iterator.hasNext) {
      result += iterator.next
    }
    result.toList
  }

  private def treapForTest = Treap(3, 2, 4, 1)

  private val expectedList = List(1, 2, 3, 4)

  private var treap: Treap[Int] = _

  @Before def before(): Unit = {
    treap = treapForTest
  }


  @Test def emptyTreap(): Unit = {
    treap = Treap.empty[Int]
    assertEquals(0, treap.size)
    assertFalse(treap.iterator.hasNext)
    assertTrue(treap.isEmpty)
  }

  @Test def oneElement(): Unit = {
    treap = Treap(1)
    assertEquals(1, treap.size)
    val iterator = treap.iterator
    assertTrue(iterator.hasNext)
    assertEquals(1, iterator.next)
    assertFalse(iterator.hasNext)
  }

  @Test def addToEmpty(): Unit = {
    treap = Treap.empty[Int]
    assertTrue(treap.add(1))
    assertEquals(1, treap.size)
    assertTrue(treap.contains(1))
  }

  @Test def add(): Unit = {
    assertTrue(treap.add(5))
    assertEquals(5, treap.size)
    assertTrue(treap.contains(5))
  }

  @Test def iterator(): Unit = {
    assertEquals(expectedList, treapToList(treap))
  }

  @Test def addDuplicate(): Unit = {
    assertTrue(treap.contains(1))
    assertFalse(treap.add(1))
    assertEquals(4, treap.size)
    assertEquals(expectedList, treapToList(treap))
  }

  @Test def remove(): Unit = {
    assertTrue(treap.contains(1))
    assertTrue(treap.remove(1))
    assertEquals(3, treap.size)
    assertEquals(List(2, 3, 4), treapToList(treap))
  }

  @Test def removeAll(): Unit = {
    for (i <- 0 to 10) {
      treap = treapForTest
      assertTrue(treap.contains(1))
      assertTrue(treap.remove(1))
      assertTrue(treap.remove(2))
      assertTrue(treap.remove(3))
      assertEquals(1, treap.size)
      assertEquals(List(4), treapToList(treap))
      assertTrue(treap.remove(4))
      assertEquals(0, treap.size)
    }
  }

  @Test def strangeComparator(): Unit = {
    val stringTreap = Treap("b", "aa", "ccc")((x, y) => x.length - y.length)
    assertEquals(List("b", "aa", "ccc"), treapToList(stringTreap))
  }

  @Test def removeNotExistant(): Unit = {
    assertFalse(treap.contains(5))
    assertFalse(treap.remove(5))
    assertEquals(4, treap.size)
    assertEquals(expectedList, treapToList(treap))
  }

  @Test def foreach(): Unit = {
    val actual = ListBuffer.empty[Int]
    treap.foreach(it => actual += it * it)
    assertEquals(List(1, 4, 9, 16), actual.toList)
  }

  @Test def map(): Unit = {
    val actual = treap.map(it => it.toString)
    assertEquals(List("1", "2", "3", "4"), treapToList(actual))
  }

  @Test def flatMap(): Unit = {
    val actual = treap.flatMap(it => Treap(-it, it * it))
    assertEquals(List(-4, -3, -2, -1, 1, 4, 9, 16), treapToList(actual))
  }

  @Test def forComprehantion(): Unit = {
    val result = ListBuffer.empty[Int]
    var sum = 0
    for (key <- treap) {
      result += key
      sum += key
    }
    assertEquals(expectedList, result.toList)
    assertEquals(10, sum)
  }
}
