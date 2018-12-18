package ru.hse.dkaznacheev

case class MetricConverter(fromValue: Double, fromRate: Double) {

  private def convert(toRate: Double): Double = fromValue * fromRate / toRate

  def m:Double = convert(MetricRates.METER_RATE)
  def km:Double = convert(MetricRates.KILOMETER_RATE)
  def in:Double = convert(MetricRates.INCH_RATE)
  def ft:Double = convert(MetricRates.FEET_RATE)
  def mi:Double = convert(MetricRates.MILE_RATE)
  def yd:Double = convert(MetricRates.YARD_RATE)
}