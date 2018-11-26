package ru.hse.jvm

import org.junit.Test
import org.junit.Assert.assertEquals

class TestTreeSet {

  private var set : TreeSet[Int] = _

  @Test
  def testAddAndRemove() : Unit = {
    set = new TreeSet[Int]
    set.add(5)
    set.add(2)
    set.add(3)
    assertEquals(3, set.count)
    assertEquals(true, set.contains(2))
    assertEquals(true, set.contains(3))
    assertEquals(true, set.contains(5))
    set.remove(3)
    assertEquals(2, set.count)
    assertEquals(true, set.contains(2))
    assertEquals(false, set.contains(3))
    assertEquals(true, set.contains(5))
    assertEquals("2, 5", set.toArray.mkString(", "))
  }

  @Test
  def testIsEmpty() : Unit = {
    set = new TreeSet[Int]
    assertEquals(true, set.isEmpty)
  }

  @Test
  def testForEach() : Unit = {
    var s : String = ""
    set = TreeSet[Int](5, 6, 1, 2, 3)
    set.foreach(el => {
      s = s + " " + el
    })
    assertEquals(" 1 2 3 5 6", s)
  }

  @Test
  def testFold() : Unit = {
    set = TreeSet[Int](5, 6, 1, 2, 3)
    val sum = set.fold(0)((a : Int, b : Int) => a + b)
    assertEquals(17, sum)
  }

  @Test
  def testFoldLeft() : Unit = {
    set = TreeSet[Int](5, 6, 1, 2, 3)
    val sum = set.foldLeft(0)((a : Int, b : Int) => a - b)
    assertEquals(-17, sum)
  }

  @Test
  def testFoldRight() : Unit = {
    set = TreeSet[Int](5, 6, 1, 2, 3)
    val sum = set.foldRight(0)((a : Int, b : Int) => a - b)
    assertEquals(3, sum)
  }

  @Test
  def testMapToInt() : Unit = {
    set = TreeSet[Int](5, 6, 1, 2, 3)
    val answer = set.map(a => a * a)
    assertEquals("1, 4, 9, 25, 36", answer.toArray.mkString(", "))
    assertEquals("1, 2, 3, 5, 6", set.toArray.mkString(", "))
  }

  @Test
  def testMapToString() : Unit = {
    set = TreeSet[Int](5, 6, 1, 2, 3)
    val answer = set.map(a => a.toString)
    assertEquals("1, 2, 3, 5, 6", answer.toArray.mkString(", "))
  }

  @Test
  def testFlatMap() : Unit = {
    set = TreeSet[Int](5, 6, 1, 2, 3)
    val answer = set.flatMap(a => TreeSet(a - 1, a, a + 10))
    assertEquals("0, 1, 2, 3, 4, 5, 6, 11, 12, 13, 15, 16", answer.toArray.mkString(", "))
  }

  @Test
  def testForComprehension() : Unit = {
    set = TreeSet[Int](1, 2, 3)
    val other = TreeSet[Int](4, 5, 6)
    val answer = for {
      x <- set
      y <- other
    } yield x + y
    assertEquals("5, 6, 7, 8, 9", answer.toArray.mkString(", "))
  }

}
