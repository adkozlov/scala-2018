package ru.hse.jvm.scala.set

import org.junit.Assert.assertEquals
import org.junit.Test

import java.util.NoSuchElementException

class TestStack {
  @Test
  def testNil(): Unit = {
    val stack: Stack[Int] = StackNil
  }

  @Test
  def testAdd(): Unit = {
    val stack: Stack[Int] = StackNil.add(5)
  }

  @Test
  def testEmptyTrue(): Unit = {
    assertEquals(true, StackNil.isEmpty)
    assertEquals(false, StackNil.isNotEmpty)
  }

  @Test
  def testEmptyFalse(): Unit = {
    val stack: Stack[Int] = StackNil.add(5)
    assertEquals(false, stack.isEmpty)
    assertEquals(true, stack.isNotEmpty)
  }

  @Test
  def testPop(): Unit = {
    val stack: Stack[Int] = StackNil.add(5).pop()
    assertEquals(true, StackNil.isEmpty)
    assertEquals(false, StackNil.isNotEmpty)
  }

  @Test(expected = classOf[NoSuchElementException])
  def testTopEmpty(): Unit = {
    StackNil.top
  }

  @Test(expected = classOf[NoSuchElementException])
  def testPopEmpty(): Unit = {
    StackNil.pop()
  }

  @Test
  def testTop(): Unit = {
    assertEquals(5, StackNil.add(5).top)
  }

  @Test
  def testSeveralAdd(): Unit = {
    var stack: Stack[Int] = StackNil.add(1)
    assertEquals(1, stack.top)
    stack = stack.add(2)
    assertEquals(2, stack.top)
    assertEquals(false, stack.isEmpty)
    stack = stack.pop()
    assertEquals(1, stack.top)
    assertEquals(false, stack.isEmpty)
    stack = stack.pop()
    assertEquals(true, stack.isEmpty)
  }
}
