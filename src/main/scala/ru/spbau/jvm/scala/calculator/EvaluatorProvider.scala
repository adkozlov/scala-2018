package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream, TokenStream}

object EvaluatorProvider {

  def applyLexer(expressionAsString : String): CommonTokenStream = {
    val lexer = new SafeExpressionsLexer(CharStreams.fromString(expressionAsString))
    new CommonTokenStream(lexer)
  }

  def applyParser(expressionTokens: TokenStream): ExpressionsParser.ExpressionContext = {
    val parser = new ExpressionsParser(expressionTokens)
    parser.setErrorHandler(new ParsingErrorStrategy())
    parser.expression()
  }
}
