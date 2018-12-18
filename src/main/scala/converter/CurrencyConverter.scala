package converter

sealed trait CurrencyType

case object RUR extends CurrencyType
case object EUR extends CurrencyType

object CurrencyConverter {
  def convert(amount: Double, from: CurrencyType, to: CurrencyType, day: Int, month: Int, year: Int): Double = {
    ???
  }
}
