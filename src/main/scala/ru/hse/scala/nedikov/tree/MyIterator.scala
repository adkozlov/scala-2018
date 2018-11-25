package ru.hse.scala.nedikov.tree

trait MyIterator[A] {
  def hasNext: Boolean
  def next: A
}
