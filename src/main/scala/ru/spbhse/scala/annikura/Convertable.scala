package ru.spbhse.scala.annikura

sealed trait DistanceType

case object to

sealed trait Currency
case object Usd extends Currency {
  override def toString: String = "USD"
}
case object Rur extends Currency {
  override def toString: String = "RUB"
}
case object Eur extends Currency {
  override def toString: String = "EUR"
}

object Metre {
  val inMetre:     Double = 1
  val inKilometre: Double = 1000
  val inInch:      Double = 0.0254
  val inFoot:      Double = 0.3048
  val inYard:      Double = 0.9144
  val inMile:      Double = 1609.34

  val toMetre:     Double = 1 / inMetre
  val toKilometre: Double = 1 / inKilometre
  val toInch:      Double = 1 / inInch
  val toFoot:      Double = 1 / inFoot
  val toYard:      Double = 1 / inYard
  val toMile:      Double = 1 / inMile
}

object Convertable {
  implicit class ConvertableExt(private val value: Double) {
    def  m(t: to.type): DistanceConverter = new DistanceConverter(value * Metre.inMetre)
    def km(t: to.type): DistanceConverter = new DistanceConverter(value * Metre.inKilometre)
    def in(t: to.type): DistanceConverter = new DistanceConverter(value * Metre.inInch)
    def ft(t: to.type): DistanceConverter = new DistanceConverter(value * Metre.inFoot)
    def yd(t: to.type): DistanceConverter = new DistanceConverter(value * Metre.inYard)
    def mi(t: to.type): DistanceConverter = new DistanceConverter(value * Metre.inMile)

    class DistanceConverter(private val meters: Double) {
      def  m: Double = meters
      def km: Double = meters * Metre.toKilometre
      def in: Double = meters * Metre.toInch
      def ft: Double = meters * Metre.toFoot
      def yd: Double = meters * Metre.toYard
      def mi: Double = meters * Metre.toMile
    }

    def USD(t: to.type): CurrencyGetter = new CurrencyGetter(value, Usd)
    def RUR(t: to.type): CurrencyGetter = new CurrencyGetter(value, Rur)
    def EUR(t: to.type): CurrencyGetter = new CurrencyGetter(value, Eur)


    class CurrencyGetter(private val amount: Double, private val fromCurrency: Currency) {
      def USD(day: Int):MonthGetter = getMonthGetter(Usd, day)
      def RUR(day: Int):MonthGetter = getMonthGetter(Rur, day)
      def EUR(day: Int):MonthGetter = getMonthGetter(Eur, day)

      private def getMonthGetter(toCurrency: Currency, day: Int): MonthGetter = {
        new MonthGetter(toCurrency, day)
      }

      class MonthGetter(private val toCurrency: Currency,
                        private val day: Int) {
        def   january(year: Int):  Double = callMoneyConverter(1, year)
        def  february(year: Int):  Double = callMoneyConverter(2, year)
        def     march(year: Int):  Double = callMoneyConverter(3, year)
        def     april(year: Int):  Double = callMoneyConverter(4, year)
        def       may(year: Int):  Double = callMoneyConverter(5, year)
        def      june(year: Int):  Double = callMoneyConverter(6, year)
        def      july(year: Int):  Double = callMoneyConverter(7, year)
        def    august(year: Int):  Double = callMoneyConverter(8, year)
        def september(year: Int):  Double = callMoneyConverter(9, year)
        def   october(year: Int):  Double = callMoneyConverter(10, year)
        def  november(year: Int):  Double = callMoneyConverter(11, year)
        def  december(year: Int):  Double = callMoneyConverter(12, year)

        private def callMoneyConverter(month: Int, year: Int): Double = {
          MoneyConverter(amount, fromCurrency, toCurrency, day, month, year)
        }
      }
    }
  }
}

object MoneyConverter{
  def apply(amount: Double, fromCurrency: Currency, toCurrency: Currency,
            day: Int, month: Int, year: Int): Double = {
    val url = s"https://api.exchangeratesapi.io/${genDate(day, month, year)}?base=$fromCurrency&symbols=$toCurrency"
    val result = io.Source.fromURL(url).mkString
    val validJson = "\\{\"date\":\"\\d{4}-\\d{2}-\\d{2}\",\"rates\":\\{\"...\":(\\d+\\.?\\d*)\\},\"base\":\"...\"\\}".r
    val errorJson = "\\{\"error\":\"(.*)\"\\}".r
    result match {
      case validJson(rate) => amount * rate.toDouble
      case errorJson(error) => throw new RuntimeException(error)
    }
  }

  private def genDate(day: Int, month: Int, year: Int): String = {
    s"$year-$month-$day"
  }

}