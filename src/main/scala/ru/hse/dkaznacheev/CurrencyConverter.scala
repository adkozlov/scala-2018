package ru.hse.dkaznacheev

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

case class PartialCurrencyConverter(value: Int, fromCurrency: String) {
  def RUB = CurrencyConverter(value, fromCurrency, Currencies.RUB)
  def USD = CurrencyConverter(value, fromCurrency, Currencies.USD)
  def EUR = CurrencyConverter(value, fromCurrency, Currencies.EUR)
}

case class CurrencyConverter(value: Int, fromCurrency: String, toCurrency: String)

object CurrencyConverter {
  private val URL = "https://free.currencyconverterapi.com/api/v6/convert"
  private val formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd")
  private val regex = s"""\\:[0-9]+(\\.[0-9]+)?""".r // matches :66.82

  def convertAt(converter: CurrencyConverter, date: Date): Double = {
    val localDate = LocalDateTime.of(date.year, date.month, date.day, 0, 0)
    val formattedDate = localDate.format(formatter)
    val request = s"$URL?compact=ultra&q=${converter.fromCurrency}_${converter.toCurrency}&date=$formattedDate"
    println(request)
    val response = io.Source.fromURL(request).mkString
    regex
      .findFirstIn(response)
      .getOrElse(throw new CurrencyConverterAPIException)
      .substring(1) // :66.82 -> 66.62
      .toDouble
  }
}

