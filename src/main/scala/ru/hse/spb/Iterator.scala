package ru.hse.spb

trait Iterator[T] {
  def hasNext: Boolean

  def next: T
}