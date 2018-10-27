package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.{ParserRuleContext, RecognitionException}
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

import scala.collection.mutable.ListBuffer

class ParserTest extends AssertionsForJUnit {

  @Test
  def `test simple expressions`(): Unit = {
    assertResult("+ 1 2".split(" ")) { bfsAstAndGetTokens("1 + 2") }
    assertResult("- 1. .2".split(" ")) { bfsAstAndGetTokens("1. - .2") }
    assertResult("* 3.4 5".split(" ")) { bfsAstAndGetTokens("3.4 * 5") }
    assertResult("/ 0 0.0".split(" ")) { bfsAstAndGetTokens("0/0.0") }
    assertResult("+ + 1 1".split(" ")) { bfsAstAndGetTokens("+(1+1)") }
    assertResult("- 2".split(" ")) { bfsAstAndGetTokens("-(2)") }
    assertResult("! true".split(" ")) { bfsAstAndGetTokens("! true") }
    assertResult("&& true false".split(" ")) { bfsAstAndGetTokens("true && false") }
    assertResult("|| false false".split(" ")) { bfsAstAndGetTokens("false  ||false") }
    assertResult("^ true true".split(" ")) { bfsAstAndGetTokens("true^ true") }
    assertResult("== false true".split(" ")) { bfsAstAndGetTokens("false  ==  true") }
  }

  @Test
  def `test complex expressions`(): Unit = {
    assertResult("+ 2 * 2 2".split(" ")) { bfsAstAndGetTokens("2 + 2 * 2") }
    assertResult("* + 2 2 2".split(" ")) { bfsAstAndGetTokens("(2 + 2) * 2") }
    assertResult("/ + 2 2 - 2 2".split(" ")) { bfsAstAndGetTokens("(2 + 2) / (2 - 2)") }
  }

  @Test
  def `test simple expressions with grammar errors`(): Unit = {
    List(
      "9 && true",
      "3 == false",
      "1 || 1",
      "!8"
    ).foreach(
      s => intercept[RecognitionException] { Main.eval(s) }
    )
  }

  @Test
  def `test expression with unmatched braces`(): Unit = {
    List(
      "(1 + (2 + (3 + (4 + 5)))",
      "1 + (2 + (3 + (4 + 5))))"
    ).foreach(
      s => intercept[RecognitionException] { Main.eval(s) }
    )
  }

  private val traversedTokens = new ListBuffer[String]

  /*
  Dfs over expression tree gives the infix form, bfs will give prefix form.
  Prefix form allows to check correctness of operation priorities resolution.
   */
  private def bfsAstAndGetTokens(expressionAsString: String): List[String] = {
    traversedTokens.clear()
    val tokenStream = EvaluatorProvider.applyLexer(expressionAsString)
    val astRoot: ParserRuleContext = EvaluatorProvider.applyParser(tokenStream)
    bfs(astRoot)
    traversedTokens.toList
  }

  private def bfs(tree: ParseTree): Unit = {
    if (tree == null)
      return
    for (i <- 0 to tree.getChildCount) {
      if (tree.getChild(i) != null && tree.getChild(i).getChildCount == 0) {
        if (!List("<EOF>", "(", ")").contains(tree.getChild(i).getText)) {
          traversedTokens += tree.getChild(i).getText
        }
      }
    }
    for (i <- 0 to tree.getChildCount) {
      bfs(tree.getChild(i))
    }
  }
}