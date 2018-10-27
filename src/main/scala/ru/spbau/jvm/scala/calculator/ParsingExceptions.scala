package ru.spbau.jvm.scala.calculator

import java.util.InputMismatchException

import org.antlr.v4.runtime.Token

object ParsingExceptions {

  class IncorrectOperationException(token: Token, opType: Operation.Type) extends InputMismatchException(
    s"Expected ${opType.toString} operation but ${token.getText} found"
  )

  class MismatchedSymbolException(message: String) extends InputMismatchException(message)

  class IncorrectTypeException(expectedType: String, actualType: String, value: String) extends InputMismatchException(
    s"Expected value of type $expectedType but $actualType value $value found"
  )

  class IncorrectOperationSignatureException extends InputMismatchException
}
