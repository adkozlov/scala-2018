package ru.spb.hse.tukh.hw01.Exception

final case class EvaluatorArithmeticException(private val message: String = "",
    private val cause: Throwable = None.orNull) extends Exception(message, cause)
