package ru.spbau.jvm.scala.homework1

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {

  @Test
  def test1(): Unit = assertEquals(4, Main.calculate("4"))

  @Test
  def test2(): Unit = assertEquals(3, Main.calculate("1+2"))

  @Test
  def test3(): Unit = assertEquals(12, Main.calculate("4*3"))

  @Test
  def test4(): Unit = assertEquals(0, Main.calculate("4 <= 1"))

  @Test
  def test5(): Unit = assertEquals(1, Main.calculate("4 >= 1"))

  @Test
  def test6(): Unit = assertEquals(1, Main.calculate("1 < 3"))

  @Test
  def test7(): Unit = assertEquals(1, Main.calculate("4 > 3"))

  @Test
  def test8(): Unit = assertEquals(1, Main.calculate("1 || 0"))

  @Test
  def test9(): Unit = assertEquals(0, Main.calculate("1 && 0"))

  @Test
  def test10(): Unit = assertEquals(0, Main.calculate("4 == 3"))

  @Test
  def test11(): Unit = assertEquals(1, Main.calculate("6 != 8"))

  @Test
  def test12(): Unit = assertEquals(14, Main.calculate("(3+4)*2"))

  @Test
  def test13(): Unit = assertEquals(9, Main.calculate("(12+6)/2"))

  @Test
  def test14(): Unit = assertEquals(66, Main.calculate("(4+2)*(5+6)"))

  @Test
  def test15(): Unit = assertEquals(-6, Main.calculate("(-3)*2"))

  @Test
  def test16(): Unit = assertEquals(9, Main.calculate("4 + 3    + 2"))

  @Test
  def test17(): Unit = assertEquals(17, Main.calculate("4*3 + 5"))

  @Test
  def test18(): Unit = assertEquals(22, Main.calculate("4/2 + 4*5"))

  @Test
  def test19(): Unit = assertEquals(70, Main.calculate("36 + 64 - 30"))

  @Test
  def test20(): Unit = assertEquals(0, Main.calculate("5 + 3 < 8"))

  @Test
  def test21(): Unit = assertEquals(9, Main.calculate("22 + 4 == 20 + 6"))

  @Test
  def test22(): Unit = assertEquals(33, Main.calculate("((2+4)*5)+3"))

  @Test
  def test23(): Unit = assertEquals(0, Main.calculate("3*3+5 <= 0"))
}
