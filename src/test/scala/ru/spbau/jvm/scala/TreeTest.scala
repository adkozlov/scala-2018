package ru.spbau.jvm.scala

import org.junit.Assert._
import org.junit.Test
import ru.spbau.jvm.scala.bst.Tree

class TreeTest {
  def assertTreeEquals[T <: Comparable[T]](expected: List[T], actual: Tree[T]): Unit = {
    var list = List[T]()
    actual.foreach((t : T) => list ::= t)
    assertEquals(expected, list.reverse)
  }

  @Test
  def add(): Unit = {
    val tree = Tree[Integer]
    val result = tree + 7
    assertTreeEquals[Integer](List(7), result)
    assertTreeEquals[Integer](List(), tree)
  }

  @Test
  def addMany(): Unit = {
    var tree = Tree[Integer]
    for (i <- 0 to 4) {
      tree += i
    }
    assertTreeEquals[Integer](List(0, 1, 2, 3, 4), tree)
  }

  @Test
  def addUnion() : Unit = {
    val tree = Tree[Integer](1, 2, 3)
    val other = Tree[Integer](6, 5, 4)
    val expected = List[Integer](1, 2, 3, 4, 5, 6)
    assertTreeEquals[Integer](expected, tree ++ other)
    assertTreeEquals[Integer](expected, tree | other)
    assertTreeEquals[Integer](expected, tree union other)
  }

  @Test
  def split() : Unit = {
    val tree : Tree[Integer] = Tree[Integer](2)
    val (left, right) = tree.split(1)
    assertTrue(left.isEmpty)
    assertTreeEquals[Integer](List(2), right)
  }

  @Test
  def addTreesWithSimilarElements() : Unit = {
    val tree = Tree[Integer](3, 1, 2)
    val other = Tree[Integer](2, 3, 1)
    assertTreeEquals[Integer](List(1, 2, 3), tree ++ other)
  }

  @Test
  def remove() : Unit = {
    val tree = Tree[Integer](5, 7, 1, 9, 8)
    assertTreeEquals[Integer](List(5, 7, 8, 9 ), tree - 1)
  }

  @Test
  def removeNotPresent() : Unit = {
    val tree = Tree[Integer](5, 7, 1, 9, 8)
    assertTreeEquals[Integer](List(1, 5, 7, 8, 9), tree - 4)
  }

  @Test
  def forComprehension() : Unit = {
    val tree = Tree[Integer](5, 7, 1, 9, 8)
    var list = List[Integer]()
    for (t <- tree) {
      list = t :: list
    }
    assertEquals(List(9, 8, 7, 5, 1), list)
  }

  @Test
  def map() : Unit = {
    val tree = Tree[Integer](1, 11, 100)
    val mappedTree = tree.map((s : Integer) => s.toString)
    assertTreeEquals[String](List("1", "100", "11"), mappedTree)
  }

  @Test
  def flatMap() : Unit = {
    val tree = Tree[Integer](1, 2, 2, 3)
    val mappedTree = tree.flatMap((x : Integer) => Tree[Integer](x, x + 1, x - 2))
    assertTreeEquals[Integer](List(-1, 0, 1, 2, 3, 4), mappedTree)
  }

  @Test
  def withFilter() : Unit = {
    val tree = Tree[Integer](1, 2, 3, 4, 5)
    val oddTree = tree.withFilter((x : Integer) => x % 2 == 1)
    assertTreeEquals[Integer](List(1, 3, 5), oddTree)
  }

  @Test
  def removeTree() : Unit = {
    val tree = Tree[String]("a", "b", "c", "d")
    val remove = Tree[String]("c", "d", "e", "f")
    assertTreeEquals[String](List("a", "b"), tree -- remove)
  }

  @Test
  def contains() : Unit = {
    val tree = Tree[Character]('a', 'b', 'c', 'd')
    for (c <- 'a' to 'd') {
      assertTrue(tree(c))
      assertTrue(tree.contains(c))
    }
    assertFalse(tree('z'))
  }

  @Test
  def diff() : Unit = {
    val tree1 = Tree[String]("a", "b", "c")
    val tree2 = Tree[String]("d", "b", "c")
    assertTreeEquals[String](List("a", "d"), tree1 diff tree2)
  }

  @Test
  def intersect() : Unit = {
    val tree1 = Tree[String]("a", "b", "c")
    val tree2 = Tree[String]("d", "b", "c")
    assertTreeEquals[String](List("b", "c"), tree1 & tree2)
  }

  @Test
  def merge() : Unit = {
    val tree1 = Tree[Integer](1, 3, 2)
    val tree2 = Tree[Integer](6, 8, 4)
    assertTreeEquals[Integer](List(1, 2, 3, 4, 6, 8), tree1.merge(tree2))
  }
}
