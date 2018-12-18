package ru.spbhse.scala.annikura

sealed trait DistanceType

sealed trait To
case object to extends To

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
    def  m(to: To): DistanceConverter = new DistanceConverter(value * Metre.inMetre)
    def km(to: To): DistanceConverter = new DistanceConverter(value * Metre.inKilometre)
    def in(to: To): DistanceConverter = new DistanceConverter(value * Metre.inInch)
    def ft(to: To): DistanceConverter = new DistanceConverter(value * Metre.inFoot)
    def yd(to: To): DistanceConverter = new DistanceConverter(value * Metre.inYard)
    def mi(to: To): DistanceConverter = new DistanceConverter(value * Metre.inMile)

    def USD(to: To): CurrencyGetter = new CurrencyGetter(value, Usd)
    def RUR(to: To): CurrencyGetter = new CurrencyGetter(value, Rur)
    def EUR(to: To): CurrencyGetter = new CurrencyGetter(value, Eur)
  }
}

class DistanceConverter(private val meters: Double) {
  def  m: Double = meters
  def km: Double = meters * Metre.toKilometre
  def in: Double = meters * Metre.toInch
  def ft: Double = meters * Metre.toFoot
  def yd: Double = meters * Metre.toYard
  def mi: Double = meters * Metre.toMile
}

class CurrencyGetter(private val amount: Double, private val currency: Currency) {
  def USD(day: Int):MonthGetter = new MonthGetter(amount, currency, Usd, day)
  def RUR(day: Int):MonthGetter = new MonthGetter(amount, currency, Rur, day)
  def EUR(day: Int):MonthGetter = new MonthGetter(amount, currency, Eur, day)
}

class MonthGetter(private val amount: Double,
                  private val fromCurrency: Currency,
                  private val toCurrency: Currency,
                  private val day: Int) {
  def   january(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 1, year)
  def  february(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 2, year)
  def     march(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 3, year)
  def     april(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 4, year)
  def       may(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 5, year)
  def      june(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 6, year)
  def      july(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 7, year)
  def    august(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 8, year)
  def september(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 9, year)
  def   october(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 10, year)
  def  november(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 11, year)
  def  december(year: Int):  Double = MoneyConverter(amount, fromCurrency, toCurrency, day, 12, year)
}

object MoneyConverter{
  def apply(amount: Double, fromCurrency: Currency, toCurrency: Currency,
            day: Int, month: Int, year: Int): Double = {
    val url = s"https://api.exchangeratesapi.io/${genDate(day, month, year)}?base=$fromCurrency&symbols=$toCurrency"
    val result = scala.io.Source.fromURL(url).mkString
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