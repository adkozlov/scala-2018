package ru.hse.spb.kazakov

import java.time.format.DateTimeFormatter
import java.time.{LocalDate, Month}

import scala.io.Source

object CurrencyConverter {

  object Currency extends Enumeration {
    val RUB, USD, EUR = Value
  }

  object at {
    def apply(date: LocalDate): LocalDate = date
  }

  class Conversion(amount: Double, from: Currency.Value) {
    def RUB(date: LocalDate): Double = convert(date, Currency.RUB)

    def USD(date: LocalDate): Double = convert(date, Currency.USD)

    def EUR(date: LocalDate): Double = convert(date, Currency.EUR)

    private def convert(date: LocalDate, to: Currency.Value): Double =
      getRateAt(date, to) match {
        case rate => amount * rate
        case 0 => throw ConversionException("Currency rate isn't available for this date")
      }

    private def getRateAt(date: LocalDate, to: Currency.Value): Double = {
      val url = s"${Conversion.API_URL}${date.format(Conversion.DATE_FORMATTER)}?base=${from.toString}&symbols=${to.toString}"
      try {
        val json = Source.fromURL(url).mkString
        json match {
          case Conversion.RESPONSE_PATTERN(rate) => rate.toDouble
          case _ => 0
        }
      } catch {
        case exception: Exception => throw ConversionException("Unable to get data from server", exception)
      }
    }

  }

  object Conversion {
    private val DATE_FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-dd")
    private val API_URL = "https://api.exchangeratesapi.io/"
    private val RESPONSE_PATTERN = """\{"date":"\d{4}-\d{2}-\d{2}","rates":\{"[A-Z]{3}":(\d+\.\d+)}."base":"[A-Z]{3}"\}""".r
  }

  object to

  implicit class ConvertibleDouble(value: Double) {
    def RUB(t: to.type): Conversion = new Conversion(value, Currency.RUB)

    def USD(t: to.type): Conversion = new Conversion(value, Currency.USD)

    def EUR(t: to.type): Conversion = new Conversion(value, Currency.EUR)
  }

  implicit class ConvertibleInt(value: Int) {
    def january(year: Int): LocalDate = LocalDate.of(year, Month.JANUARY, value)

    def february(year: Int): LocalDate = LocalDate.of(year, Month.FEBRUARY, value)

    def march(year: Int): LocalDate = LocalDate.of(year, Month.MARCH, value)

    def april(year: Int): LocalDate = LocalDate.of(year, Month.APRIL, value)

    def may(year: Int): LocalDate = LocalDate.of(year, Month.MAY, value)

    def june(year: Int): LocalDate = LocalDate.of(year, Month.JUNE, value)

    def july(year: Int): LocalDate = LocalDate.of(year, Month.JULY, value)

    def august(year: Int): LocalDate = LocalDate.of(year, Month.AUGUST, value)

    def september(year: Int): LocalDate = LocalDate.of(year, Month.SEPTEMBER, value)

    def october(year: Int): LocalDate = LocalDate.of(year, Month.OCTOBER, value)

    def november(year: Int): LocalDate = LocalDate.of(year, Month.NOVEMBER, value)

    def december(year: Int): LocalDate = LocalDate.of(year, Month.DECEMBER, value)
  }

}
