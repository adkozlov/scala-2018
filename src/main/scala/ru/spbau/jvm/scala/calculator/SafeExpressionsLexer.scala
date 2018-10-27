package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime.{CharStream, Token}
import ru.spbau.jvm.scala.calculator.ExpressionsLexer._

class SafeExpressionsLexer(input: CharStream) extends ExpressionsLexer(input) {

  override def emit(token: Token): Unit = token.getType match {
    case MismatchedSymbol =>
      println(token.getType + " " + token.getText)
      throw new ParsingExceptions.MismatchedSymbolException("invalid symbol: " + token.getText)
    case _ => super.emit(token)
  }
}
