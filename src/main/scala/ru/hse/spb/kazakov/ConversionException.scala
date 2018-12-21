package ru.hse.spb.kazakov

case class ConversionException(private val message: String = "",
                               private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
