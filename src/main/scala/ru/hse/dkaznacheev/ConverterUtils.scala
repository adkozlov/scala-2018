package ru.hse.dkaznacheev

object ConverterUtils {

  sealed class ToType

  object to extends ToType

  implicit class IntExtension(val i: Int) {
    def m (to: ToType) = MetricConverter(i, MetricRates.METER_RATE)
    def km (to: ToType) = MetricConverter(i, MetricRates.KILOMETER_RATE)
    def in (to: ToType) = MetricConverter(i, MetricRates.INCH_RATE)
    def ft (to: ToType) = MetricConverter(i, MetricRates.FEET_RATE)
    def mi (to: ToType) = MetricConverter(i, MetricRates.MILE_RATE)
    def yd (to: ToType) = MetricConverter(i, MetricRates.YARD_RATE)

    def RUB(to: ToType) = PartialCurrencyConverter(i, Currencies.RUB)
    def USD(to: ToType) = PartialCurrencyConverter(i, Currencies.USD)
    def EUR(to: ToType) = PartialCurrencyConverter(i, Currencies.EUR)

    def january(year: Int)   = Date(i, 1, year)
    def february(year: Int)  = Date(i, 2, year)
    def march(year: Int)     = Date(i, 3, year)
    def april(year: Int)     = Date(i, 4, year)
    def may(year: Int)       = Date(i, 5, year)
    def june(year: Int)      = Date(i, 6, year)
    def july(year: Int)      = Date(i, 7, year)
    def august(year: Int)    = Date(i, 8, year)
    def september(year: Int) = Date(i, 9, year)
    def october(year: Int)   = Date(i, 10, year)
    def november(year: Int)  = Date(i, 11, year)
    def december(year: Int)  = Date(i, 12, year)
  }

  implicit class ConverterOps(private val converter: CurrencyConverter) extends AnyVal {
    def at(date: Date): Double = CurrencyConverter.convertAt(converter, date)
  }
}