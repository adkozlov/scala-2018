package ru.hse.spb.euler

object FibonacciGoldenNuggetsValueLevel {

  def evaluate(n: Int): Long = {
    util.fib(2 * n) * util.fib(2 * n + 1)
  }
}
