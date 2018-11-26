package ru.hse.spb.kazakov

trait Iterator[A] {
  def hasNext: Boolean

  def isEmpty: Boolean = !hasNext

  def next(): A

  def remove(): Unit
}
