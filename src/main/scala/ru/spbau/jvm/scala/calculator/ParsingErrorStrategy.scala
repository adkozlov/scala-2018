package ru.spbau.jvm.scala.calculator

import org.antlr.v4.runtime._

class ParsingErrorStrategy extends DefaultErrorStrategy {

  override def recover(recognizer: Parser, recognitionException: RecognitionException) {
    throw recognitionException
  }

  override def reportMissingToken(recognizer: Parser) {
    val token = recognizer.getCurrentToken
    val message = String.format("expected one of " + recognizer.getExpectedTokens.toString(recognizer.getVocabulary) +
      " but " + token.getText + " was found")
    throw new RecognitionException(message, recognizer, recognizer.getInputStream, recognizer.getContext)
  }

  override def reportNoViableAlternative(recognizer: Parser, noViableAltException: NoViableAltException) {
    val token = noViableAltException.getOffendingToken
    val msg = "no viable alternative for symbol: " + getTokenErrorDisplay(token)
    val recognitionException = new RecognitionException(
      msg,
      recognizer,
      recognizer.getInputStream,
      recognizer.getContext
    )
    recognitionException.initCause(noViableAltException)
    throw recognitionException
  }

  override def reportInputMismatch(recognizer: Parser, inputMismatchException: InputMismatchException) {
    val token = inputMismatchException.getOffendingToken
    val msg = "mismatched symbol: " + getTokenErrorDisplay(token)
    val recognitionException = new RecognitionException(
      msg,
      recognizer,
      recognizer.getInputStream,
      recognizer.getContext
    )
    recognitionException.initCause(inputMismatchException)
    throw recognitionException
  }

  override def reportUnwantedToken(recognizer: Parser) {
    val token = recognizer.getCurrentToken
    val message = String.format("expected one of " + recognizer.getExpectedTokens.toString(recognizer.getVocabulary) +
      " but " + token.getText + " was found")
    throw new RecognitionException(message, recognizer, recognizer.getInputStream, recognizer.getContext)
  }

  override def reportError(recognizer: Parser, recognitionException: RecognitionException) {
    beginErrorCondition(recognizer)
    recognitionException match {
      case e: NoViableAltException => reportNoViableAlternative(recognizer, e)
      case e: InputMismatchException => reportInputMismatch(recognizer, e)
      case e: FailedPredicateException => reportFailedPredicate(recognizer, e)
      case _ => reportUnwantedToken(recognizer)
    }
  }
}