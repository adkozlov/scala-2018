package ru.hse.tree

import ru.hse.iterable

trait MutableSet[A] extends iterable.Iterable[A] {
  def +=(elem: A): MutableSet.this.type

  def -=(elem: A): MutableSet.this.type

  def contains(elem: A): Boolean

  def ++=(xs: iterable.Iterable[A]): MutableSet.this.type = {
    for (x <- xs)
      this += x
    this
  }

  def --=(xs: iterable.Iterable[A]): MutableSet.this.type = {
    for (x <- xs)
      this -= x
    this
  }
}