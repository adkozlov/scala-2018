package ru.hse.spb.converters

object LengthConverter {

  val M_TO_KM = 0.001
  val M_TO_MI = 0.000621371
  val M_TO_FT = 3.28084
  val M_TO_IN = 39.3701
  val M_TO_YD = 1.09361

  sealed trait Length

  class RatioWithMeter(private val amount: Double) {
    def m: Double = amount

    def km: Double = amount * M_TO_KM

    def mi: Double = amount * M_TO_MI

    def ft: Double = amount * M_TO_FT

    def in: Double = amount * M_TO_IN

    def yd: Double = amount * M_TO_YD
  }

  object to

  implicit class Convertable(private val amount: Double) extends AnyVal {
    def m(o: to.type): RatioWithMeter = new RatioWithMeter(amount)

    def km(o: to.type): RatioWithMeter = new RatioWithMeter(amount / M_TO_KM)

    def mi(o: to.type): RatioWithMeter = new RatioWithMeter(amount / M_TO_MI)

    def ft(o: to.type): RatioWithMeter = new RatioWithMeter(amount / M_TO_FT)

    def in(o: to.type): RatioWithMeter = new RatioWithMeter(amount / M_TO_IN)

    def yd(o: to.type): RatioWithMeter = new RatioWithMeter(amount / M_TO_YD)
  }

}
