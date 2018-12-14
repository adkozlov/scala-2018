package ru.hse.spb.euler


object RoomsOfDoomValueLevel {

  private def needCards(cards: Int, rooms: Int): Long = rooms match {
    case 0 => 1L
    case _ =>
      var current = needCards(cards, rooms - 1)
      if (cards < current + 1) {
        current += ((current - cards) / (cards - 2) + 1) * 2
      }
      current + 1
  }

  def evaluate(maxCards: Int, rooms: Int): Long = {
    var result = 0L
    for (c <- 3 to maxCards) {
      result += needCards(c, rooms)
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(needCards(20, 30))
  }
}
