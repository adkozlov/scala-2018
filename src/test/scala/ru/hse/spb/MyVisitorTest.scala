package ru.hse.spb

import org.scalatest.FunSuite

class MyVisitorTest extends FunSuite {
  test("simple plus and minus") {
    assert(Main.calculate("1 +1") == 2)
    assert(Main.calculate(" 2+ 1 ") == 3)
    assert(Main.calculate("3+39") == 42)
    assert(Main.calculate("( 1 )- 1") == 0)
    assert(Main.calculate("1- 7") == -6)
  }

  test("simple mult, div amd mod") {
    assert(Main.calculate("1 *1") == 1)
    assert(Main.calculate(" 2* 1 ") == 2)
    assert(Main.calculate("3/9") == 0)
    assert(Main.calculate("9/3") == 3)
    assert(Main.calculate("(1)/1") == 1)
    assert(Main.calculate("6%2") == 0)
  }

  test("simple equation") {
    assert(Main.calculate("1==1") == 1)
    assert(Main.calculate(" 2!=1 ") == 1)
    assert(Main.calculate("1==2") == 0)
    assert(Main.calculate(" 2!=2 ") == 0)
  }

  test("simple comparison") {
    assert(Main.calculate("1<1") == 0)
    assert(Main.calculate(" 1<=1 ") == 1)
    assert(Main.calculate("2 >2") == 0)
    assert(Main.calculate("1 < 2") == 1)
    assert(Main.calculate("2 > 33") == 0)
    assert(Main.calculate("44 >= 7") == 1)
  }

  test("simple and, or") {
    assert(Main.calculate("3 || 0") == 1)
    assert(Main.calculate(" 1 &&7 ") == 1)
    assert(Main.calculate("0 && 9") == 0)
    assert(Main.calculate("0 || 0") == 0)
  }

  test("complex") {
    assert(Main.calculate("1 + 7 * 6 - 1") == 42)
    assert(Main.calculate("9 + 1000 == 1009") == 1)
    assert(Main.calculate("(6 - 1 == 7) || (6 - 1 == 5)") == 1)
    assert(Main.calculate("(7*8 != 56) && (56 - 1 != 55)") == 0)
    assert(Main.calculate("1 * 1000 <= 9 * 1000 ") == 1)
  }
}