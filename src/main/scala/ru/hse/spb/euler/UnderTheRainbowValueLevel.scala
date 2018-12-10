package ru.hse.spb.euler

object UnderTheRainbowValueLevel {

  def evaluate(colors: Int, sameBalls: Int, attempts: Int): Double = {
    val num = util.upperFac((colors - 1) * sameBalls - attempts + 1, sameBalls)
    val denom = util.upperFac((colors - 1) * sameBalls + 1, sameBalls)
    colors * (denom - num).asInstanceOf[Double] / denom
  }
}
