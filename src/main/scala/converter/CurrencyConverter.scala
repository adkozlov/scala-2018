package converter

import java.text.SimpleDateFormat
import java.util.Calendar

sealed trait CurrencyType

case object RUB extends CurrencyType
case object EUR extends CurrencyType
case object USD extends CurrencyType

object CurrencyConverter {

  private val dateFormat = new SimpleDateFormat("yyyy-MM-dd")

  def convert(amount: Double, from: CurrencyType, to: CurrencyType, day: Int, month: Int, year: Int): Double = {
    val date = getDate(day, month, year)
    val url = s"https://free.currencyconverterapi.com/api/v6/convert?compact=ultra&q=${from}_$to&date=$date"
    val response = scala.io.Source.fromURL(url).mkString
    val regex = s"""($date)\\":([^}]*)""".r
    var result: Double = 0
    for (regex(_, number) <- regex.findAllIn(response)) {
      result = number.toDouble
    }
    if (result != 0) amount * result else throw new IllegalArgumentException
  }

  private def getDate(day: Int, month: Int, year: Int) = {
    val calendar: Calendar = Calendar.getInstance()
    calendar.set(year, month, day)
    dateFormat.format(calendar.getTime)
  }
}
