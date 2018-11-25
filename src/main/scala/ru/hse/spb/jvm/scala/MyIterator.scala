package ru.hse.spb.jvm.scala

trait MyIterator[T] {
  def hasNext: Boolean

  def next: T
}
