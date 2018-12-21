package ru.spbau.jvm.scala.task169

import org.junit
import org.junit.Assert._
import ru.spbau.jvm.scala.task169.Solution.{_1, _10, _100, _2, _25, _3, _4, toInt}


class Test {
  def solve(i : Int): Int = {
    if (i == 0) {
      return 1
    }
    if (i % 2 == 1) {
      return solve(i / 2)
    }
    solve(i / 2) + solve(i / 2 - 1)
  }

  @junit.Test
  def test(): Unit = {
    assertEquals(solve(1), toInt[_1#F])
    assertEquals(solve(2), toInt[_2#F])
    assertEquals(solve(3), toInt[_3#F])
    assertEquals(solve(10), toInt[_10#F])
    assertEquals(5, solve(10))
   // assertEquals(solve(100), toInt[_100]) // можно раскомментировать, закомментировав тесты к другим задачам
  }
}
