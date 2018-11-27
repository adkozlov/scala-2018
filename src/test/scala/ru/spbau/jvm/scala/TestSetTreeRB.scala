package ru.spbau.jvm.scala

import org.junit.Test
import org.junit.Assert.assertEquals

class TestSetTreeRB {

  @Test
  def foreachTest(): Unit = {
    var result = 0
    val treeSet = SetTreeRB[Int](-1, 0, 1, 2, 3, -2)
    treeSet.foreach(node => {
      result = result + node
    })
    assertEquals(3, result)
  }

  @Test
  def mapTest(): Unit = {
    val treeSet = SetTreeRB[Int](-1, 0, 1, 2, 3, -2)
    val newTreeSet = treeSet.map(node => node + 1)

    var str = ""
    for (i <- newTreeSet) {
      str += i.toString + " "
    }

    assertEquals("-1 0 1 2 3 4 ", str)
  }

  @Test
  def filterTest(): Unit = {
    val treeSet = SetTreeRB[Int](-1, 0, 1, 2, 3, -2)
    val newTreeSet = treeSet.filter(node => node < 0)

    var str = ""
    for (i <- newTreeSet) {
      str += i.toString + " "
    }

    assertEquals("-2 -1 ", str)
  }

  @Test
  def foldLeftTest(): Unit = {
    val treeSet = SetTreeRB[Int](-1, 0, 1, 2, 3, -2)
    val sum = treeSet.foldLeft(0)((a, b) => a + b)
    assertEquals(3, sum)
  }

  @Test
  def forComprehensionsTest(): Unit  = {
    val treeSet = SetTreeRB[String]("a", "", "aa")
    val newTreeSet =
      for (node <- treeSet)
        yield node.length

    var str = ""
    for (i <- newTreeSet) {
      str += i + " "
    }

    assertEquals(3, newTreeSet.size)
    assertEquals("0 1 2 ", str)
  }

}