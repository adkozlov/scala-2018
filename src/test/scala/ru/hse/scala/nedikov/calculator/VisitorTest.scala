package ru.hse.scala.nedikov.calculator

import org.antlr.v4.runtime.BufferedTokenStream
import org.antlr.v4.runtime.CharStreams
import org.scalatest.{FlatSpec, Matchers}

object VisitorTest {
  def main(args: Array[String]): Unit = {
  }
}

class VisitorTest extends FlatSpec with Matchers {
  def toTree(in: String): Expression =  {
    val calculatorLexer = new CalculatorLexer(CharStreams.fromString(in))
    new CalculatorParser(new BufferedTokenStream(calculatorLexer)).eval().accept(new Visitor)
  }

  def const(x: Double) = new DoubleConst(x)
  def const(x: Boolean) = new BooleanConst(x)

  def binop(op: String, left: Double, right: Double) = new DoubleBinop(op, const(left), const(right))
  def binop(op: String, left: DoubleExpression, right: Double) = new DoubleBinop(op, left, const(right))
  def binop(op: String, left: Double, right: DoubleExpression) = new DoubleBinop(op, const(left), right)
  def binop(op: String, left: DoubleExpression, right: DoubleExpression) = new DoubleBinop(op, left, right)

  def binop(op: String, left: Boolean, right: Boolean) = new BooleanBinop(op, const(left), const(right))
  def binop(op: String, left: BooleanExpression, right: Boolean) = new BooleanBinop(op, left, const(right))
  def binop(op: String, left: Boolean, right: BooleanExpression) = new BooleanBinop(op, const(left), right)
  def binop(op: String, left: BooleanExpression, right: BooleanExpression) = new BooleanBinop(op, left, right)

  def comp(op: String, left: DoubleExpression, right: DoubleExpression) = new BooleanCompare(op, left, right)

  "Visitor" should "create correct tree with double expression" in {
    toTree("1 + 2 * 3") should be (binop("+", 1, binop("*", 2, 3)))
    toTree("(1 + 2) * 3") should be (binop("*", binop("+", 1, 2), 3))
  }

  "Visitor" should "create correct tree with boolean expression" in {
    toTree("true || true && false") should be (binop("||",true, binop("&&", true, false)))
    toTree("(true || true) && false") should be (binop("&&", binop("||", true, true), false))
  }

  "Visitor" should "create correct tree with boolean comparison" in {
    toTree("1 + 1 <= 2 * 3") should be (comp("<=", binop("+", 1, 1), binop("*", 2, 3)))
    toTree("1 / 3 != 3 - 1") should be (comp("&&", binop("/", 1, 3), binop("-", 1, 3)))
  }
}
