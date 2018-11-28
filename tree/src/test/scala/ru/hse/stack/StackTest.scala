package ru.hse.stack

import org.scalatest.{FlatSpec, Matchers}

class StackTest extends FlatSpec with Matchers {
  "A Stack" should "add and delete elements" in {
    val ints = new Stack[Int]
    for (i <- 0 to 10) {
      ints.push(i)
    }
    for (i <- Array.range(10, -1, -1)) {
      assert(ints.pop() == i)
    }
    assert(ints.isEmpty)
  }

  "A Stack" should "be iterable many times" in {
    val chars = new Stack[Char]
    for (i <- 'a' to 'z') {
      chars.push(i)
    }
    assert(chars.foldLeft('a')((_: Char, b: Char) => b: Char) === 'a')
    assert(chars.foldRight('a')((a: Char, _: Char) => a: Char) === 'z')
    assert(!chars.isEmpty)
  }

  "A Stack" should "prevent pop when empty" in {
    val stack = new Stack[Char]
    for (i <- 'a' to 'y') {
      stack.push(i)
    }
    assertThrows[NoSuchElementException](for (_ <- 'a' to 'z') stack.pop())
  }
}
