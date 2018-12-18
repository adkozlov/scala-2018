package ru.hse.spb.converters

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object CurrencyConverter {

  private val API_URL = "https://api.exchangeratesapi.io/history"
  private val BASE = "USD"

  // If we ask rates on weekend API that I use doesn't return any values. That's why
  // I have to request information for previous days too.
  private val DAYS_TO_LOOK_BACK = 10

  sealed trait Currency {
    val API_SHORT_NAME: String
  }

  class ConversionException(string: String) extends Exception(string)

  object RUR extends Currency {
    override val API_SHORT_NAME = "RUB"
  }

  object USD extends Currency {
    override val API_SHORT_NAME: String = "USD"
  }

  object EUR extends Currency {
    override val API_SHORT_NAME: String = "EUR"
  }

  implicit class Convertable(private val amount: Double) {
    def RUR: ConversionFrom = new ConversionFrom(CurrencyConverter.RUR)

    def USD: ConversionFrom = new ConversionFrom(CurrencyConverter.USD)

    def EUR: ConversionFrom = new ConversionFrom(CurrencyConverter.EUR)

    class ConversionFrom(val from: Currency) {
      def to(currency: Currency): Conversion = new Conversion(currency)

      class Conversion(to: Currency) {
        def at(day: Int): ConversionAtDay = new ConversionAtDay(day)

        class ConversionAtDay(val day: Int) {
          def january(year: Int): Double = convert(year, 1)

          private def convert(year: Int, month: Int): Double = {
            val date = LocalDateTime.of(year, month, day, 0, 0)
            val formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd")
            val exchangeRates = scala.io.Source.fromURL(
              s"""$API_URL
                 |?start_at=${date.minusDays(DAYS_TO_LOOK_BACK).format(formatter)}
                 |&end_at=${date.format(formatter)}
                 |&base=$BASE""".stripMargin.replaceAll("\n", "")
            ).mkString
            amount / getExchangeRate(from, exchangeRates) * getExchangeRate(to, exchangeRates)
          }

          private def getExchangeRate(currency: Currency, data: String): Double = {
            val shortForCurrency = currency.API_SHORT_NAME
            val currencyRegex = s"""(?<=$shortForCurrency":)(.*?)(?=,)""".r
            currencyRegex findFirstIn data match {
              case Some(v) => v.toDouble
              case _ => throw new ConversionException(s"Can't find exchange rate for $shortForCurrency at given date")
            }
          }

          def february(year: Int): Double = convert(year, 2)

          def march(year: Int): Double = convert(year, 3)

          def april(year: Int): Double = convert(year, 4)

          def may(year: Int): Double = convert(year, 5)

          def june(year: Int): Double = convert(year, 6)

          def july(year: Int): Double = convert(year, 7)

          def august(year: Int): Double = convert(year, 8)

          def september(year: Int): Double = convert(year, 9)

          def october(year: Int): Double = convert(year, 10)

          def november(year: Int): Double = convert(year, 11)

          def december(year: Int): Double = convert(year, 12)


        }

      }

    }

  }

}
