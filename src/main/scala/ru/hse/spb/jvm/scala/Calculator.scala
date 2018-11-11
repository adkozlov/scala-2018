package ru.hse.spb.jvm.scala

import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}

object Calculator {
  def evaluate(expression: String): Double = {
    val expLexer = new CalculatorLexer(CharStreams.fromString(expression))
    val expParser = new CalculatorParser(new BufferedTokenStream(expLexer))
    new Visitor().visitExpr(expParser.expr())
  }
}
