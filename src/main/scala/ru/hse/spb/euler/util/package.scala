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

  def upperFac(base: Int, n: Int): Long = n match {
    case 0 => 1L
    case _ => base * upperFac(base + 1, n - 1)
  }
}
