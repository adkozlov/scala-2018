package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.{CommonTokenStream, Token}
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

import scala.collection.mutable.ListBuffer

class LexerTest extends AssertionsForJUnit {

  @Test
  def `test numbers`(): Unit = {
    assertResult(List("1")) { toTokensList("1") }
    assertResult(List("-", "2")) { toTokensList("-2") }
    assertResult(List("1.00002")) { toTokensList("1.00002") }
    assertResult(List("-", "2.01")) { toTokensList("-2.01") }
    assertResult(List(".1")) { toTokensList(".1") }
    assertResult(List("-", ".2")) { toTokensList("-.2") }
    assertResult(List("1.")) { toTokensList("1.") }
    assertResult(List("-", "2.")) { toTokensList("-2.") }
    assertResult(List("10e5")) { toTokensList("10e5") }
    assertResult(List("-", "20e-4")) { toTokensList("-20e-4") }
    assertResult(List("1.3E15")) { toTokensList("1.3E15") }
  }

  @Test
  def `test simple expressions`(): Unit = {
    assertResult(List("1", "+", "2")) { toTokensList("1 + 2") }
    assertResult(List("1.", "-", ".2")) { toTokensList("1. - .2") }
    assertResult(List("3.4", "*", "5")) { toTokensList("3.4 * 5") }
    assertResult(List("0", "/", "0.0")) { toTokensList("0/0.0") }
    assertResult(List("+", "(", "1", "+", "1", ")")) { toTokensList("+(1+1)") }
    assertResult(List("-", "(", "2", ")")) { toTokensList("-(2)") }
    assertResult(List("!", "true")) { toTokensList("! true") }
    assertResult(List("true", "&&", "false")) { toTokensList("true && false") }
    assertResult(List("false", "||", "false")) { toTokensList("false  ||false") }
    assertResult(List("true", "^", "true")) { toTokensList("true^ true") }
    assertResult(List("false", "==", "true")) { toTokensList("false  ==  true") }
  }

  @Test
  def `test expression with unmatched braces`(): Unit = {
    assertResult(List("(", "1", "+", "(", "2", "+", "(", "3", "+", "(", "4", "+", "5", ")", ")", ")")) { toTokensList("(1 + (2 + (3 + (4 + 5)))") }
    assertResult(List("1", "+", "(", "2", "+", "(", "3", "+", "(", "4", "+", "5", ")", ")", ")", ")")) { toTokensList("1 + (2 + (3 + (4 + 5))))") }
  }

  @Test
  def `test expressions with illegal symbols`(): Unit = {
    List(
      "a[3]",
      "1 $ 2",
      "3x + 1"
    ).map(EvaluatorProvider.applyLexer)
  }

  private def toTokensList(expressionAsString: String): List[String] = {
    val tokenStream = EvaluatorProvider.applyLexer(expressionAsString)
    tokenStream.fill()
    val tokens = new ListBuffer[String]()
    tokenStream.getTokens.forEach(token => if (token.getText != "<EOF>") tokens += token.getText)
    tokens.toList
  }
}
