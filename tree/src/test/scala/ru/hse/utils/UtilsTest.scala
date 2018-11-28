package ru.hse.utils

import org.scalatest.FlatSpec

class UtilsTest extends FlatSpec {
  "A logarithm" should "calculate logarithm(3, 9)" in {
    val logarithm = Utils.logarithm(3, 9)
    assert(1.9999999 <= logarithm && logarithm <= 2.00000001)
  }
}
