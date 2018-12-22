package ru.hse.dkaznacheev

object ConverterUtils {

  sealed class ToType

  object to extends ToType

  implicit class IntExtension(private val i: Int) {
    
    private def converterOf: Double => MetricConverter = MetricConverter(i, _)
    private def partialCurrencyConverterOf: String => PartialCurrencyConverter = 
      PartialCurrencyConverter(i, _)
    
    def m (infix: to.type)  = converterOf(MetricConverter.METER_RATE)
    def km (infix: to.type) = converterOf(MetricConverter.KILOMETER_RATE)
    def in (infix: to.type) = converterOf(MetricConverter.INCH_RATE)
    def ft (infix: to.type) = converterOf(MetricConverter.FEET_RATE)
    def mi (infix: to.type) = converterOf(MetricConverter.MILE_RATE)
    def yd (infix: to.type) = converterOf(MetricConverter.YARD_RATE)

    def RUB(infix: to.type) = partialCurrencyConverterOf(Currencies.RUB)
    def USD(infix: to.type) = partialCurrencyConverterOf(Currencies.USD)
    def EUR(infix: to.type) = partialCurrencyConverterOf(Currencies.EUR)

    def january: Int => Date   = Date(i, 1, _)
    def february: Int => Date  = Date(i, 2, _)
    def march: Int => Date     = Date(i, 3, _)
    def april: Int => Date     = Date(i, 4, _)
    def may: Int => Date       = Date(i, 5, _)
    def june: Int => Date      = Date(i, 6, _)
    def july: Int => Date      = Date(i, 7, _)
    def august: Int => Date    = Date(i, 8, _)
    def september: Int => Date = Date(i, 9, _)
    def october: Int => Date   = Date(i, 10, _)
    def november: Int => Date  = Date(i, 11, _)
    def december: Int => Date  = Date(i, 12, _)
  }

  implicit class ConverterOps(private val converter: CurrencyConverter) extends AnyVal {
    def at(date: Date): Double = CurrencyConverter.convertAt(converter, date)
  }
}