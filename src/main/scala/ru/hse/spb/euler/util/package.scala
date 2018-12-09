package ru.hse.spb.euler

package object util {

  def fib(n: Int): Long = {
    var (current: Long, next: Long) = (0L, 1L)
    for (_ <- 1 to n) {
      next += current
      current = next - current
    }
    current
  }
}
