package converter

import scala.language.implicitConversions

class DistanceValue(amount: Double, from: DistanceType) {
  def to(to: DistanceType): Double = DistanceConverter.convert(amount, from, to)
}

class CurrencyValue(amount: Double, from: CurrencyType) {
  def to(to: CurrencyType): CurrencyConversion = new CurrencyConversion(amount, from, to)
}

class CurrencyConversion(amount: Double, from: CurrencyType, to: CurrencyType) {
  def at(day: Int): DayValue = new DayValue(amount, from, to, day)
}

class DayValue(amount: Double, from: CurrencyType, to: CurrencyType, day: Int) {
  def january(year: Int): Double = convert(0, year)
  def february(year: Int): Double = convert(1, year)
  def march(year: Int): Double = convert(2, year)
  def april(year: Int): Double = convert(3, year)
  def may(year: Int): Double = convert(4, year)
  def june(year: Int): Double = convert(5, year)
  def july(year: Int): Double = convert(6, year)
  def august(year: Int): Double = convert(7, year)
  def september(year: Int): Double = convert(8, year)
  def october(year: Int): Double = convert(9, year)
  def november(year: Int): Double = convert(10, year)
  def december(year: Int): Double = convert(11, year)

  private def convert(month: Int, year: Int): Double =
    CurrencyConverter.convert(amount, from, to, day, month, year)
}

class ConversionOperator(val i: Double) {
  def apply(t: DistanceType): DistanceValue = new DistanceValue(i, t)
  def apply(t: CurrencyType): CurrencyValue = new CurrencyValue(i, t)
}

object Converter {

  implicit def doubleToOperator(i: Double): ConversionOperator = new ConversionOperator(i)

}