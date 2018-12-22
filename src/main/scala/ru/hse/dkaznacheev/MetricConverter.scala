package ru.hse.dkaznacheev

object MetricConverter {
  val METER_RATE: Double     = 1.0
  val KILOMETER_RATE: Double = 1000.0 * METER_RATE
  val INCH_RATE: Double      = 0.0254
  val FEET_RATE: Double      = 12.0 * INCH_RATE
  val YARD_RATE: Double      = 3 * FEET_RATE
  val MILE_RATE: Double      = 1760.0 * YARD_RATE
}

case class MetricConverter(fromValue: Double, fromRate: Double) {
  
  private def convert(toRate: Double): Double = fromValue * fromRate / toRate

  import MetricConverter._
  
  def m:Double = convert(METER_RATE)
  def km:Double = convert(KILOMETER_RATE)
  def in:Double = convert(INCH_RATE)
  def ft:Double = convert(FEET_RATE)
  def mi:Double = convert(MILE_RATE)
  def yd:Double = convert(YARD_RATE)
}