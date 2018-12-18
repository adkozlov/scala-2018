import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object CurrencyConverter {

  private val API_URL = "https://api.exchangeratesapi.io/history"
  private val BASE = "USD"

  // If we ask rates on weekend API that I use doesn't return any values. That's why
  // I have to request information for previous days too.
  private val DAYS_TO_LOOK_BACK = 10

  sealed trait Currency

  class ConversionException(string: String) extends Exception(string)

  object RUR extends Currency

  object USD extends Currency

  object EUR extends Currency

  implicit class Convertable(private val amount: Double) {
    def RUR: ConversionFrom = new ConversionFrom(CurrencyConverter.RUR)

    def USD: ConversionFrom = new ConversionFrom(CurrencyConverter.USD)

    def EUR: ConversionFrom = new ConversionFrom(CurrencyConverter.EUR)

    class ConversionFrom(val from: Currency) {
      def to(currency: Currency): Convertation = new Convertation(currency)

      class Convertation(to: Currency) {
        def at(day: Int): ConvertationAtDay = new ConvertationAtDay(day)

        class ConvertationAtDay(val day: Int) {
          def january(year: Int): Double = convert(year, 1)

          def february(year: Int): Double = convert(year, 2)

          def march(year: Int): Double = convert(year, 3)

          def april(year: Int): Double = convert(year, 4)

          def may(year: Int): Double = convert(year, 5)

          def june(year: Int): Double = convert(year, 6)

          def july(year: Int): Double = convert(year, 7)

          private def convert(year: Int, month: Int): Double = {
            val date = LocalDateTime.of(year, month, day, 0, 0)
            val formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd")
            val exchangeRates = scala.io.Source.fromURL(
              s"""$API_URL
                 |?start_at=${date.minusDays(10).format(formatter)}
                 |&end_at=${date.format(formatter)}
                 |&base=$BASE""".stripMargin.replaceAll("\n", "")
            ).mkString
            println(exchangeRates)
            amount / getExchangeRate(from, exchangeRates) * getExchangeRate(to, exchangeRates)
          }

          private def getExchangeRate(currency: Currency, data: String): Double = {
            val SHORT_FOR_RUBLE = "RUB"
            val SHORT_FOR_EURO = "EUR"
            val SHORT_FOR_USD = "USD"
            val shortForCurrency = currency match {
              case CurrencyConverter.RUR => SHORT_FOR_RUBLE
              case CurrencyConverter.EUR => SHORT_FOR_EURO
              case CurrencyConverter.USD => SHORT_FOR_USD
            }
            val currencyRegex = s"""(?<=$shortForCurrency":)(.*?)(?=,)""".r
            currencyRegex findFirstIn data match {
              case Some(v) => v.toDouble
              case _ => throw new ConversionException(s"Can't find exchange rate for $shortForCurrency at given date")
            }
          }

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
