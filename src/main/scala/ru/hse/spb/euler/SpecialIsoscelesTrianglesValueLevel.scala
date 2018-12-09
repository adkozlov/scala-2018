package ru.hse.spb.euler

object SpecialIsoscelesTrianglesValueLevel {

  def evaluate(n: Int): Long = {
    var result: Long = 0L
    for (i <- 1 to n) {
      result += util.fib(i * 6 + 3) / 2
    }
    result
  }
}
