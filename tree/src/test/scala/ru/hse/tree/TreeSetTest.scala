package ru.hse.tree

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class TreeSetTest extends FlatSpec with Matchers with BeforeAndAfter {

  private var tree: TreeSet[Int] = _


  before {
    tree = new TreeSet[Int](0.57)
  }

  after {
    assertSorted(tree)
  }

  "A TreeSet" should "add elements" in {
    val array = Array(5, 2, 1, 4, 6)
    array.foreach(element => tree += element)
    array.foreach(element => assert(tree.contains(element)))
    assert(tree.size == array.length)
  }

  "A TreeSet" should "remove elements" in {
    val toInsert = Array(5, 2, 1, 4, 6)
    toInsert.foreach(element => tree += element)
    val toRemove = Array(2, 4, 4, 0)
    toRemove.foreach(element => tree -= element)
    toRemove.foreach(element => assert(!tree.contains(element)))
    val rest = Array(5, 1, 6)
    rest.foreach(element => assert(tree.contains(element)))
    assert(tree.size == rest.length)
  }

  "A TreeSet" should "be compatible with HOF" in {
    val toInsert = Array(5, 2, 1, 4, 6)
    toInsert.foreach(element => tree += element)

    val mapped = tree map { element: Int => element.toString }
    toInsert.foreach(element => assert(mapped.contains(element.toString)))
    assert(mapped.size == toInsert.length)
  }

  "A TreeSet" should "be correct Iterable" in {
    val toInsert = Array(5, 2, 1, 4, 6)
    toInsert.foreach(element => tree += element)

    val negated = for (element <- tree if element % 2 == 1) yield -element
    negated.foreach(element => assert(element == -1 || element == -5))
  }

  private def assertSorted[A](tree: TreeSet[A])(implicit ordering: Ordering[A]): Unit = {
    import ordering.mkOrderingOps

    val array= tree.toArray
    for (i <- Range(1, array.length)) assert(array(i - 1) < array(i))
  }
}
