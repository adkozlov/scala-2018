package ru.hse.spb.sharkova.treap

import org.junit.Test
import org.junit.Assert._

import scala.util.Random

class TreapTest {
  @Test
  def testEmptyTreap(): Unit = {
    val treap = new Treap[Int]()
    assertEquals(0, treap.size)
    assertTrue(treap.isEmpty)
    assertFalse(treap.contains(0))
    assertFalse(treap.contains(5))
  }

  @Test
  def testAdd(): Unit = {
    val treap = new Treap[String]()
    treap.add("string")
    assertEquals(1, treap.size)
    treap.add("another string")
    assertEquals(2, treap.size)
  }

  @Test
  def testContains(): Unit = {
    val treap = new Treap[String]()
    treap.add("string")
    assertTrue(treap.contains("string"))
    treap.add("strin")
    assertTrue(treap.contains("strin"))
    assertTrue(treap.contains("string"))

    assertFalse(treap.contains("String"))
    assertFalse(treap.contains("STRING"))
    assertFalse(treap.contains(""))
  }

  @Test
  def testRemove(): Unit = {
    val treap = new Treap[Int]()
    treap.add(3)
    treap.add(8)
    treap.add(1)
    treap.add(6)
    assertEquals(4, treap.size)
    assertTrue(treap.contains(3))

    treap.remove(3)
    assertEquals(3, treap.size)
    assertFalse(treap.contains(3))
    assertTrue(treap.contains(1))
    assertTrue(treap.contains(6))
    assertTrue(treap.contains(8))
  }

  @Test(expected = classOf[NoSuchElementException])
  def testRemoveNonexistentElement(): Unit = {
    val treap = new Treap[Int]()
    treap.add(3)
    treap.add(8)
    treap.add(1)
    treap.add(6)

    treap.remove(5)
  }

  @Test(expected = classOf[NoSuchElementException])
  def testDoubleRemoval(): Unit = {
    val treap = new Treap[Int]()
    treap.add(3)
    treap.add(8)
    treap.add(1)
    treap.add(6)

    treap.remove(3)
    treap.remove(3)
  }

  @Test
  def testLargerTreap(): Unit = {
    val treap = new Treap[Int]()
    val valuesList = Seq.fill(30)(Random.nextInt())

    valuesList.foreach(it => treap.add(it))
    valuesList.foreach(it => assertTrue(treap.contains(it)))
  }

  @Test
  def testAddAll(): Unit = {
    val treap = new Treap[Int]()
    treap.add(3)
    treap.add(8)

    val anotherTreap = new Treap[Int]()
    anotherTreap.add(6)
    anotherTreap.add(1)

    treap.addAll(anotherTreap)
    assertEquals(4, treap.size)
    assertEquals(2, anotherTreap.size) // anotherTreap remains unchanged
    assertTrue(treap.contains(6))
    assertTrue(treap.contains(1))
    assertTrue(treap.contains(3))
    assertTrue(treap.contains(8))

    treap.addAll(5, 7, 10)
    assertEquals(7, treap.size)
    assertTrue(treap.contains(5))
    assertTrue(treap.contains(7))
    assertTrue(treap.contains(10))
  }

  @Test
  def testContainsAll(): Unit = {
    val treap = new Treap[Int]()
    treap.add(3)
    treap.add(8)

    val anotherTreap = new Treap[Int]()
    anotherTreap.add(6)
    anotherTreap.add(1)

    treap.addAll(anotherTreap)
    assertTrue(treap.containsAll(anotherTreap))
    assertTrue(treap.containsAll(3, 8, 1, 6))
    assertFalse(treap.containsAll(3, 8, 2, 6))
  }

  @Test
  def testRemoveAll(): Unit = {
    val treap = new Treap[Int]()
    treap.add(3)
    treap.add(8)
    treap.add(6)
    treap.add(1)

    val anotherTreap = new Treap[Int]()
    anotherTreap.add(6)
    anotherTreap.add(1)

    treap.removeAll(anotherTreap)
    assertEquals(2, treap.size)
    assertFalse(treap.contains(6))
    assertFalse(treap.contains(1))
    assertTrue(treap.contains(3))
    assertTrue(treap.contains(8))

    treap.addAll(anotherTreap)
    assertEquals(4, treap.size)
    treap.removeAll(3, 8)
    assertEquals(2, treap.size)
    assertFalse(treap.contains(3))
    assertFalse(treap.contains(8))
    assertTrue(treap.contains(6))
    assertTrue(treap.contains(1))
  }

  @Test
  def testForEach(): Unit = {
    val treap = new Treap[String]()
    treap.add("abc")
    treap.add("Abc")
    treap.add("abC")
    treap.add("abcd")

    val stringBuilder = new StringBuilder
    treap.foreach(it => stringBuilder.append(it + " "))
    assertEquals("Abc abC abc abcd ", stringBuilder.toString())
  }

  @Test
  def testEquals(): Unit = {
    val treap = new Treap[Int]()
    assertTrue(treap.equals(new Treap[Int]))

    treap.add(3)

    val anotherTreap = new Treap[Int]()
    anotherTreap.add(3)
    assertTrue(treap.equals(anotherTreap))
    assertFalse(treap.equals(new Treap[Int]))

    treap.add(4)
    treap.add(6)
    anotherTreap.add(5)
    anotherTreap.add(6)
    assertFalse(treap.equals(anotherTreap))

    anotherTreap.remove(5)
    assertFalse(treap.equals(anotherTreap))

    treap.remove(4)
    assertTrue(treap.equals(anotherTreap))
  }

  @Test
  def testHashCode(): Unit = {
    val treap = new Treap[Int]()
    treap.addAll(30, 40)
    val anotherTreap = new Treap[Int]()
    anotherTreap.addAll(40, 30)
    assertTrue(treap.equals(anotherTreap))
    assertEquals(treap.hashCode(), anotherTreap.hashCode())

    treap.add(50)
    anotherTreap.add(59)
    assertFalse(treap.equals(anotherTreap))
    assertFalse(treap.hashCode() == anotherTreap.hashCode())
  }

  @Test
  def testMapEmptyTreap(): Unit = {
    val treap = new Treap[String]()
    assertTrue(treap.equals(treap.map(it => it + "a")))
  }

  @Test
  def testMap(): Unit = {
    val treap = new Treap[String]()
    treap.addAll("one", "two", "three")
    val mappedTreap = treap.map(it => it + "a")
    assertEquals(treap.size, mappedTreap.size)
    assertTrue(mappedTreap.containsAll("onea", "twoa", "threea"))
    assertTrue(treap.containsAll("one", "two", "three"))
  }

  @Test
  def testFlatMapEmptryTreap(): Unit = {
    val treap = new Treap[String]()
    assertTrue(treap.equals(treap.flatMap(_ => new Treap[String]())))
  }

  @Test
  def testFlatMap(): Unit = {
    val treap = new Treap[Int]()
    treap.addAll(30, 59, 100, 111)
    var cnt = 0

    def sampleTreap(key: Int): Treap[Int] = {
      val treap = new Treap[Int]()
      treap.addAll(13 + cnt, 17 + cnt, key)
      cnt += 1
      treap
    }

    val mappedTreap = treap.flatMap(sampleTreap)
    assertEquals(12, mappedTreap.size)
    assertTrue(mappedTreap.containsAll(13, 17, 14, 18, 15, 19, 16, 20, 30, 59, 100, 111))
    assertEquals(4, treap.size)
    assertTrue(treap.containsAll(30, 59, 100, 111))
    assertFalse(treap.contains(17))
  }

  @Test
  def testFilter(): Unit = {
    val treap = new Treap[String]()
    treap.addAll("string", "String", "sTrinG", "STRING", "strin", "stringg")
    val treapBeforeMap = treap

    val upperCaseTreap = treap.filter(it => it.exists(_.isUpper))
    val allUpperCaseTreap = treap.filter(it => it.forall(_.isUpper))
    val allLowerCaseTreap = treap.filter(it => it.forall(_.isLower))
    val sixCharacterStringTreap = treap.filter(it => it.length == 6)

    assertEquals(3, upperCaseTreap.size)
    assertTrue(upperCaseTreap.containsAll("String", "sTrinG", "STRING"))

    assertEquals(1, allUpperCaseTreap.size)
    assertTrue(allUpperCaseTreap.contains("STRING"))

    assertEquals(3, allLowerCaseTreap.size)
    assertTrue(allLowerCaseTreap.containsAll("string", "strin", "stringg"))

    assertEquals(4, sixCharacterStringTreap.size)
    assertTrue(sixCharacterStringTreap.containsAll("string", "String", "sTrinG", "STRING"))

    assertTrue(treap.equals(treapBeforeMap))
  }

  @Test
  def testIterator(): Unit = {
    val treap = new Treap[Int]()
    treap.addAll(5, 1, 9, 3)
    val iterator = treap.iterator
    assertTrue(iterator.hasNext)
    assertEquals(1, iterator.next())
    assertTrue(iterator.hasNext)
    assertEquals(3, iterator.next())
    assertTrue(iterator.hasNext)
    assertEquals(5, iterator.next())
    assertTrue(iterator.hasNext)
    assertEquals(9, iterator.next())
  }
}
