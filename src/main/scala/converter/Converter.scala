package converter

import scala.language.implicitConversions

sealed trait DistanceType

case object m extends DistanceType

case object km extends DistanceType

sealed trait CurrencyType

case object RUR extends CurrencyType

case object EUR extends CurrencyType

class DistanceValue(amount: Int, from: DistanceType) {
  def to(to: DistanceType): Double = DistanceConverter.convert(amount, from, to)
}

class CurrencyValue(amount: Int, from: CurrencyType) {
  def to(to: CurrencyType): CurrencyConvertation = new CurrencyConvertation(amount, from, to)
}

class CurrencyConvertation(amount: Int, from: CurrencyType, to: CurrencyType) {
  def at(day: Int): DayValue = new DayValue(amount, from, to, day)
}

class DayValue(amount: Int, from: CurrencyType, to: CurrencyType, day: Int) {
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

object Converter {
  implicit def intToDistanceOperator(i: Int): DistanceType => DistanceValue = t => new DistanceValue(i, t)

  implicit def intToCurrencyOperator(i: Int): CurrencyType => CurrencyValue = t => new CurrencyValue(i, t)

  def main(args: Array[String]): Unit = {
    1 (EUR) to RUR at 12 december 2018
  }

}
