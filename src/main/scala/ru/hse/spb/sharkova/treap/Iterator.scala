package ru.hse.spb.sharkova.treap

trait Iterator[T] {
  def hasNext: Boolean

  def next(): T
}
