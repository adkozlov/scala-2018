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

object DistanceConverter {
  def convert(amount: Double, from: DistanceType, to: DistanceType): Double = {
     amount * from.toMetersRate * to.fromMetersRate
  }
}
