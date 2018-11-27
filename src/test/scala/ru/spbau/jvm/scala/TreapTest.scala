package ru.spbau.jvm.scala

import org.junit.Test
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals

import scala.collection.mutable.ListBuffer

class TreapTest {

  def toList[A](t: Treap[A]): List[A] = {
    var result = new ListBuffer[A]
    t.forEach(result += _)
    result.toList
  }

  @Test
  def testAdd(): Unit = {
    val treap: Treap[Int] = Treap()
    assertTrue(treap.add(1).contains(1))
  }

  @Test
  def testSize(): Unit = {
    val treap: Treap[Int] = Treap()
    assertEquals(0, treap.size)
    assertEquals(1, treap.add(1).size)
    assertEquals(2, treap.add(1).add(2).size)
  }

  @Test
  def testOrder(): Unit = {
    val treap: Treap[Int] = Treap().add(1).add(2).add(3)
    assertEquals(List(1, 2, 3), toList(treap))
  }

  @Test
  def testRemove(): Unit = {
    val treap: Treap[Int] = Treap().add(1).add(2).add(3).remove(2)
    assertEquals(List(1, 3), toList(treap))
  }

  @Test
  def testRemoveSize(): Unit = {
    val treap: Treap[Int] = Treap().add(1).add(2).add(3).remove(2)
    assertEquals(2, treap.size)
  }

  @Test
  def testMap(): Unit = {
    val treap: Treap[Int] = Treap().add(1).add(2).add(3)
    assertEquals(List(-3, -2, -1), toList(treap.map(-_)))
  }

  @Test
  def testFlatMap(): Unit = {
    val treap: Treap[Int] = Treap().add(1).add(2).add(3)
    assertEquals(List(-3, -2, -1), toList(treap.flatMap(
      x => Treap().add(-x)
    )))
  }

  @Test
  def addAll(): Unit = {
    val treap: Treap[Int] = Treap().add(1).add(2).add(3)
    val empty: Treap[Int] = Treap()
    assertEquals(List(1, 2, 3), toList(empty.addAll(treap)))
  }

  @Test
  def containsAll(): Unit = {
    val treap: Treap[Int] = Treap().add(1).add(2).add(3)
    assertTrue(treap.containsAll(treap))
  }

  @Test
  def removeAll():  Unit = {
    val treap: Treap[Int] = Treap().add(1).add(2).add(3)
    val empty: Treap[Int] = Treap()
    assertEquals(List(), toList(empty.addAll(treap).removeAll(treap)))
  }
}
