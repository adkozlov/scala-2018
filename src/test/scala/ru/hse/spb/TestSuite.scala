package ru.hse.spb

import ru.hse.spb.ast._

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

import org.scalatest.FunSuite
import org.scalatest.Matchers._

import scala.collection.JavaConverters._

class TestSuite extends FunSuite {

  private def getTokenStrings(input: String) = {
    val stream = new ANTLRInputStream(input)
    val lexer = new CalcLexer(stream)
    val tokens = lexer.getAllTokens().asScala
    tokens.map(_.getText())
  }

  private def getParsedTree(input: String): Expr = {
    val stream = new ANTLRInputStream(input)
    val lexer = new CalcLexer(stream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new CalcParser(tokens)
    parser.expression().value
  }

  test("Lexer") {
    assert(List("3", "+", "2") === getTokenStrings("3 + 2"))
    assert(List("0") === getTokenStrings("  0  "))
    assert(List("3", "+", "2", "*", "4") === getTokenStrings("3+2*4"))
    assert(List("(", "3", "+", "2", ")", "*", "4") ===
      getTokenStrings("(3+2)*4"))
  }

  test("Parser") {
    assert(Const(5) === getParsedTree("5"))
    assert(BinOp("+", Const(5), Const(6)) === getParsedTree("5 + 6"))
    assert(BinOp("||", BinOp("&&", BinOp("<", BinOp("-", BinOp("+",
      BinOp("/", BinOp("*", Const(1), Const(2)), Const(3)), Const(4)),
      Const(5)), Const(6)), Const(7)), Const(8)) ===
      getParsedTree("1 * 2 / 3 + 4 - 5 < 6 && 7 || 8"))
    assert(BinOp("*", BinOp("+", Const(3), Const(4)),
      BinOp("/", BinOp("-", Const(5), Const(6)), Const(2))) ===
      getParsedTree("(3 + 4) * ((5 - 6) / 2)"))
  }

  test("Evaluation") {
    assert(4 === Evaluator.eval(Const(4)))
    assert(28 === Evaluator.eval(BinOp("*", Const(14), Const(2))))
    assert(4 === Evaluator.eval(BinOp("/", Const(14), Const(3))))
    assert(2 === Evaluator.eval(BinOp("%", Const(14), Const(3))))
    assert(17 === Evaluator.eval(BinOp("+", Const(14), Const(3))))
    assert(11 === Evaluator.eval(BinOp("-", Const(14), Const(3))))
    assert(0 === Evaluator.eval(BinOp("<=", Const(14), Const(3))))
    assert(1 === Evaluator.eval(BinOp(">=", Const(14), Const(3))))
    assert(1 === Evaluator.eval(BinOp("<=", Const(3), Const(14))))
    assert(0 === Evaluator.eval(BinOp(">=", Const(3), Const(14))))
    assert(1 === Evaluator.eval(BinOp(">=", Const(14), Const(14))))
    assert(1 === Evaluator.eval(BinOp(">=", Const(14), Const(14))))
    assert(0 === Evaluator.eval(BinOp("<", Const(14), Const(3))))
    assert(1 === Evaluator.eval(BinOp(">", Const(14), Const(3))))
    assert(1 === Evaluator.eval(BinOp("<", Const(3), Const(14))))
    assert(0 === Evaluator.eval(BinOp(">", Const(3), Const(14))))
    assert(0 === Evaluator.eval(BinOp(">", Const(14), Const(14))))
    assert(0 === Evaluator.eval(BinOp(">", Const(14), Const(14))))
    assert(1 === Evaluator.eval(BinOp("==", Const(14), Const(14))))
    assert(0 === Evaluator.eval(BinOp("==", Const(14), Const(3))))
    assert(1 === Evaluator.eval(BinOp("!=", Const(14), Const(3))))
    assert(0 === Evaluator.eval(BinOp("!=", Const(14), Const(14))))
    assert(1 === Evaluator.eval(BinOp("&&", Const(14), Const(3))))
    assert(0 === Evaluator.eval(BinOp("&&", Const(0), Const(3))))
    assert(0 === Evaluator.eval(BinOp("&&", Const(3), Const(0))))
    assert(0 === Evaluator.eval(BinOp("&&", Const(0), Const(0))))
    assert(1 === Evaluator.eval(BinOp("||", Const(14), Const(3))))
    assert(1 === Evaluator.eval(BinOp("||", Const(0), Const(3))))
    assert(1 === Evaluator.eval(BinOp("||", Const(3), Const(0))))
    assert(0 === Evaluator.eval(BinOp("||", Const(0), Const(0))))
  }

  test("Integration") {
    assert(14 === Evaluator.eval(getParsedTree("((15 - 18) && 3 || 0) * 14")))
  }

}
