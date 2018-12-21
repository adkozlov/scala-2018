package ru.hse.spb.kazakov

object LengthConverter {

  object LengthUnit extends Enumeration {
    private val M_MULTIPLIER = 1
    private val KM_MULTIPLIER = 1000
    private val MI_MULTIPLIER = 1609.344


    case class Val(multiplier: Double) extends super.Val

    val mi: Val = Val(MI_MULTIPLIER)
    val m: Val = Val(M_MULTIPLIER)
    val km: Val = Val(KM_MULTIPLIER)
  }

  class Length(value: Double, lengthUnit: LengthUnit.Val) {
    private def toMeters = value * lengthUnit.multiplier

    def mi: Double = toMeters / LengthUnit.mi.multiplier

    def m: Double = toMeters / LengthUnit.m.multiplier

    def km: Double = toMeters / LengthUnit.km.multiplier
  }

  object to

  implicit class ConvertibleDouble(value: Double) {
    def m(t: to.type): Length = new Length(value, LengthUnit.m)

    def mi(t: to.type): Length = new Length(value, LengthUnit.mi)

    def km(t: to.type): Length = new Length(value, LengthUnit.km)
  }

}
