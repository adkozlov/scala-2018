package converter

sealed trait DistanceType {
  def toMetersRate: Double
  def fromMetersRate: Double = 1 / toMetersRate
}

case object m extends DistanceType {
  override def toMetersRate: Double = 1
}

case object km extends DistanceType {
  override def toMetersRate: Double = 1000
}

case object mi extends DistanceType {
  override def toMetersRate: Double = 1609.34
}

case object in extends DistanceType {
  override def toMetersRate: Double = 0.0254
}

case object ft extends DistanceType {
  override def toMetersRate: Double = 0.3048
}

case object yd extends DistanceType {
  override def toMetersRate: Double = 0.9144
}

object DistanceConverter {
  def convert(amount: Double, from: DistanceType, to: DistanceType): Double = {
     amount * from.toMetersRate * to.fromMetersRate
  }
}
