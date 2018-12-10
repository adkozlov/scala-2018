package ru.hse.spb.euler

object SwappingCountersValueLevel {

  /* Последовательно ищем корни диафантова уравнения,
   * связывающего количество шагов алгоритма из задачи и "треугольные" числа
   * Коэффициенты положительные, значит решения будут перебираться в возрастающем порядке
   */
  private val (a, b, c, d, e, f) = (3, 4, 5, 2, 3, 3)

  private def solutions(n: Int, x0: Long, y0: Long): (Long, Long, Long) = n match {
    case 1 => (x0, y0, y0)
    case _ =>
      val (x, y, sum) = solutions(n - 1, x0, y0)
      val (newX, newY) = (a * x + b * y + c, d * x + e * y + f)
      (newX, newY, sum + newY)
  }

  def evaluate(n: Int): Long = {
    var (x1, y1): (Long, Long) = (2, 1)
    var (x2, y2): (Long, Long) = (5, 3)
    solutions(20, x1, y1)._3 + solutions(20, x2, y2)._3
  }
}
