package ru.spbau.jvm.scala.task169

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

  def main(args: Array[String]): Unit = {
    assert(toInt[_1#F] == solve(1))
    assert(toInt[_2#F] == solve(2))
    assert(toInt[_3#F] == solve(3))
    assert(toInt[_4#F] == solve(4))
    assert(toInt[_10#F] == solve(10))
    assert(toInt[_10#F] == 5)
    assert(toInt[_25#F] == solve(25))
    assert(toInt[_100#F] == solve(100))
  }
}
