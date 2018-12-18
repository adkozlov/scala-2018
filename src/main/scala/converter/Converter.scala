package converter

import scala.language.implicitConversions

sealed trait DistanceType
case object km extends DistanceType
case object m extends DistanceType

sealed trait CurrencyType
case object RUR extends CurrencyType
case object EUR extends CurrencyType

class DistanceValue(val value: Int, val t: DistanceType) {
  def to(t: DistanceType) : Double = ???
}

class CurrencyValue(val value: Int, val t: CurrencyType) {
  def to(t: CurrencyType) : CurrencyResult = ???
}

class CurrencyResult(val amount: Double) {
  def at(day: Int) : DayValue = new DayValue(amount, day)
}

class DayValue(val amount: Double, val day: Int) {
  def december(year: Int) : Double = ???
}

object Main {

  implicit def intToDistanceOperator(i: Int): DistanceType => DistanceValue = t => new DistanceValue(i, t)

  implicit def intToCurrencyOperator(i: Int): CurrencyType => CurrencyValue = t => new CurrencyValue(i, t)

  def main(args: Array[String]): Unit = {
    1(EUR) to RUR at 12 december 2018
  }

}

class Converter
