package ru.hse.spb.scala

trait Iterator[T] {
  def next: T
  def hasNext: Boolean
}
