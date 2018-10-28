package ru.hse.scala

import org.junit.Test
import org.junit.Assert.assertEquals

class CalculatorNumberTest {
  @Test
  def intToInt(): Unit = assertEquals(4, IntNumber(4).toInt)

  @Test
  def intToDouble() : Unit = assertEquals(4.0, IntNumber(4).toDouble, 1e-9)

  @Test
  def addIntToInt() : Unit = assertEquals(1, IntNumber(0).add(IntNumber(1)).toInt)
}
