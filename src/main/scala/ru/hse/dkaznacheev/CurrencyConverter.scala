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

  def convertAt(converter: CurrencyConverter, date: Date): Double = {
    val localDate = LocalDateTime.of(date.year, date.month, date.day, 0, 0)
    val formattedDate = localDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))
    val url = s"$URL?compact=ultra&q=${converter.fromCurrency}_${converter.toCurrency}&date=$formattedDate"
    val response = scala.io.Source.fromURL(url).mkString
    val regex = s"""($formattedDate)\\":([^}]*)""".r
    var result: Double = 0
    for (regex(_, number) <- regex.findAllIn(response)) {
      result = number.toDouble
    }
    if (result != 0) converter.value * result else throw new IllegalArgumentException
  }
}

