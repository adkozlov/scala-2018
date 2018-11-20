package ru.spbau.jvm.scala.tree

import org.junit.Assert.{assertEquals, assertTrue}
import org.junit.Test

import scala.util.Random

object AVLTreeTest {
  val MAX_DATA_VALUE = 10000
  val DATA_SIZE = 10000
}

class AVLTreeTest {
  private def generateData = Seq.fill(AVLTreeTest.DATA_SIZE)(Random.nextInt(AVLTreeTest.MAX_DATA_VALUE))

  private def getSets: (Set[Int], AVLTreeSet[Int]) = {
    val data = generateData
    (data.toSet, AVLTreeSet.fromSeq(data))
  }

  private def getMySet: AVLTreeSet[Int] = AVLTreeSet.fromSeq(generateData)

  private def getMySetWithData: (Seq[Int], AVLTreeSet[Int]) = {
    val data = generateData
    (data, AVLTreeSet.fromSeq(data))
  }
  @Test
  def testSet(): Unit = {
    val (set, mySet) = getSets
    assertTrue(mySet.contentEquals(set))
  }

  @Test
  def testContains(): Unit = {
    val (data, set) = getMySetWithData
    assertTrue(set.containsAll(data))
  }

  @Test
  def testAdd(): Unit = {
    var (set, mySet) = getSets
    for (value <- generateData) {
      set += value
      mySet += value
    }
    assertTrue(mySet.contentEquals(set))
  }

  @Test
  def testAddAll(): Unit = {
    var (set, mySet) = getSets
    val data = generateData
    set ++= data
    mySet ++= data
    assertTrue(mySet.contentEquals(set))
  }

  @Test
  def testRemove(): Unit = {
    var (set, mySet) = getSets
    val data = generateData
    set --= data
    mySet --= data
    assertTrue(mySet.contentEquals(set))
  }

  @Test
  def testSize(): Unit = {
    val (set, mySet) = getSets
    assertEquals(set.size, mySet.size)
  }

  @Test
  def testEmpty(): Unit = {
    assertTrue(AVLTreeSet.empty[Int].isEmpty)
    assertTrue(getMySet.nonEmpty)
  }

  private def testSetOperation(setOp: (Set[Int], Set[Int]) => Set[Int])(mySetOp: (AVLTreeSet[Int], AVLTreeSet[Int]) => AVLTreeSet[Int]): Unit = {
    val (set1, mySet1) = getSets
    val (set2, mySet2) = getSets
    val set3 = setOp(set1, set2)
    val mySet3 = mySetOp(mySet1, mySet2)
    assert(mySet3.contentEquals(set3))
  }

  @Test
  def testIntersect(): Unit = {
    testSetOperation(_ & _)(_ & _)
  }

  @Test
  def testUnion(): Unit = {
    testSetOperation(_ | _)(_ | _)
  }

  @Test
  def testDiff(): Unit = {
    testSetOperation(_ &~ _)(_ &~ _)
  }

  @Test
  def testFilter(): Unit = {
    var (set, mySet) = getSets
    val p = (x : Int) => x % 2 == 0
    set = set.filter(p)
    mySet = mySet.filter(p)
    assert(mySet.contentEquals(set))
  }

  @Test
  def testMap(): Unit = {
    val (set, mySet) = getSets
    val f = (x : Int) => x / 2
    val newSet = set.map(f)
    val newMySet = mySet.map(f)
    assert(newMySet.contentEquals(newSet))
  }


  @Test
  def testFlatMap(): Unit = {
    val (set, mySet) = getSets
    val setTransformer = (x : Int) => Set(x, x + 1, x + 2, x + 3)
    val mySetTransformer = (x : Int) => AVLTreeSet.from(x, x + 1, x + 2, x + 3)
    val newSet = set.flatMap(setTransformer)
    val newMySet = mySet.flatMap(mySetTransformer)
    assert(newMySet.contentEquals(newSet))
  }
}
