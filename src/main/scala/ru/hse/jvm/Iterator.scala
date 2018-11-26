package ru.hse.jvm

trait Iterator[T] {
  def hasNext : Boolean
  def next : T
}
