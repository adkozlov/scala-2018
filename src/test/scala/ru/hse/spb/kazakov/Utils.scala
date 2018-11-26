package ru.hse.spb.kazakov

import scala.collection.mutable.ListBuffer

object Utils {
  def toList[A](collection: Collection[A]): List[A] = {
    var result = new ListBuffer[A]
    collection.foreach(result += _)
    result.toList
  }
}
