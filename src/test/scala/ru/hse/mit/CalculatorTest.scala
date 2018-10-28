package ru.hse.mit

import org.antlr.v4.runtime.BufferedTokenStream
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


class CalculatorTest {

  private[hse] def run(expression: String) = {
    val lexer = new CalcLexer(CharStreams.fromString(expression))
    val parser = new CalcParser(new BufferedTokenStream(lexer))
    val calculator = new Calculator()
    calculator.visit(parser.file())
  }

  @Test private[hse] def testPrimitive(): Unit = {
    assertEquals(0, run("false"))
    assertEquals(1, run("true"))
  }

  @Test private[hse] def testBinary(): Unit = {
    assertEquals(3, run("1 + 2"))
    assertEquals(2, run("1 * 2"))
    assertEquals(-1, run("1 - 2"))
    assertEquals(0, run("1 / 2"))
    assertEquals(1, run("1 % 2"))

    assertEquals(1, run("1 || 2"))
    assertEquals(1, run("1 && 2"))
    assertEquals(1, run("0 || 2"))
    assertEquals(0, run("0 && 2"))
    assertEquals(1, run("2 || 0"))
    assertEquals(0, run("2 && 0"))
    assertEquals(0, run("0 || 0"))
    assertEquals(0, run("0 && 0"))
    assertEquals(1, run("true || true"))
    assertEquals(1, run("true || false"))
    assertEquals(1, run("false || true"))
    assertEquals(0, run("false || false"))
    assertEquals(1, run("true && true"))
    assertEquals(0, run("true && false"))
    assertEquals(0, run("false && true"))
    assertEquals(0, run("false && false"))

    assertEquals(0, run("1 == 2"))
    assertEquals(1, run("1 == 1"))
    assertEquals(1, run("1 != 2"))
    assertEquals(0, run("1 != 1"))
    assertEquals(0, run("true == false"))
    assertEquals(1, run("true == true"))
    assertEquals(1, run("true != false"))
    assertEquals(0, run("true != true"))
    assertEquals(0, run("true == 0"))
    assertEquals(1, run("true == 1"))
    assertEquals(1, run("true != 0"))
    assertEquals(0, run("true != 1"))
    assertEquals(1, run("false == 0"))
    assertEquals(0, run("false == 1"))
    assertEquals(0, run("false != 0"))
    assertEquals(1, run("false != 1"))

    assertEquals(0, run("1 > 2"))
    assertEquals(0, run("1 > 1"))
    assertEquals(1, run("1 > -1"))
    assertEquals(1, run("1 < 2"))
    assertEquals(0, run("1 < 1"))
    assertEquals(0, run("1 < -1"))
    assertEquals(0, run("1 >= 2"))
    assertEquals(1, run("1 >= 1"))
    assertEquals(1, run("1 >= -1"))
    assertEquals(1, run("1 <= 2"))
    assertEquals(1, run("1 <= 1"))
    assertEquals(0, run("1 <= -1"))
  }

  @Test private[hse] def testBinaryPriorityMulAdd() : Unit = {
    assertEquals(7, run("1 + 2 * 3"))
    assertEquals(-5, run("1 - 2 * 3"))
    assertEquals(4, run("4 + 2 / 3"))
    assertEquals(8, run("8 - 2 / 3"))
    assertEquals(5, run("4 + 4 % 3"))
    assertEquals(7, run("8 - 4 % 3"))

    assertEquals(7, run("2 * 3 + 1"))
    assertEquals(5, run("2 * 3 - 1"))
    assertEquals(4, run("2 / 3 + 4"))
    assertEquals(-8, run("2 / 3 - 8"))
    assertEquals(5, run("4 % 3 + 4"))
    assertEquals(-7, run("4 % 3 - 8"))
  }

  @Test private[hse] def testBinaryPriorityAddComp(): Unit = {
    assertEquals(1, run("8 + 2 >= 3"))
    assertEquals(1, run("8 - 2 >= 3"))
    assertEquals(0, run("8 + 2 <= 3"))
    assertEquals(0, run("8 - 2 <= 3"))
    assertEquals(1, run("8 + 2 > 3"))
    assertEquals(1, run("8 - 2 > 3"))
    assertEquals(0, run("8 + 2 < 3"))
    assertEquals(0, run("8 - 2 < 3"))

    assertEquals(0, run("2 >= 3 + 8"))
    assertEquals(1, run("2 >= 3 - 8"))
    assertEquals(1, run("2 <= 3 + 8"))
    assertEquals(0, run("2 <= 3 - 8"))
    assertEquals(0, run("2 >= 3 + 8"))
    assertEquals(1, run("2 >= 3 - 8"))
    assertEquals(1, run("2 <= 3 + 8"))
    assertEquals(0, run("2 <= 3 - 8"))
  }

  @Test private[hse] def testBinaryPriorityCompEq(): Unit = {
    assertEquals(0, run("10 > 0 == 11"))
    assertEquals(0, run("12 > 11 != 1"))
    assertEquals(0, run("11 == 0 < 10"))
    assertEquals(0, run("1 != 11 < 12"))
  }

  @Test private[hse] def testBinaryPriorityEqLogical(): Unit = {
    assertEquals(0, run("0 == 11 && 0"))
    assertEquals(0, run("1 == 11 || 0"))
    assertEquals(0, run("0 && 11 == 0"))
    assertEquals(0, run("0 && 11 == 1"))
  }

  @Test private[hse] def testBinaryPriorityBrackets(): Unit = {
    assertEquals(7, run("1 + (2 * 3)"))
    assertEquals(9, run("(1 + 2) * 3"))
  }

  @Test private[hse] def testBinaryChain(): Unit = {
    assertEquals(6, run("1 + 2 + 3"))
    assertEquals(24, run("2 * 3 * 4"))
    assertEquals(2, run("2 % 3 % 4"))
    assertEquals(0, run("2 > 3 > 4"))
    assertEquals(1, run("2 < 3 < 4"))
    assertEquals(1, run("2 == 3 == 0"))
    assertEquals(1, run("2 || 3 || 0"))
    assertEquals(1, run("true || false || 0"))
    assertEquals(0, run("false || false || 0"))
    assertEquals(0, run("true && false && 0"))
  }

}
