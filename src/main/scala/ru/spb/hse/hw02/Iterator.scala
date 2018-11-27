package ru.spb.hse.hw02

trait Iterator[T] {
  def hasNext: Boolean

  def next: T
}
