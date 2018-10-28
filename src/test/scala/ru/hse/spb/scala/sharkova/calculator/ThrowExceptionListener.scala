package ru.hse.spb.scala.sharkova.calculator

import org.antlr.v4.runtime.{BaseErrorListener, RecognitionException, Recognizer}

class ThrowExceptionListener extends BaseErrorListener {
  override def syntaxError(recognizer: Recognizer[_, _], offendingSymbol: Any,
                           line: Int, charPositionInLine: Int, msg: String, e: RecognitionException): Unit = {
    super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e)
    throw new CalculatorException(
      s"Incorrect symbol $offendingSymbol on line $line at position $charPositionInLine.\n$msg")
  }
}
