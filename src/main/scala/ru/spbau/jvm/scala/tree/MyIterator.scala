package ru.spbau.jvm.scala.tree

trait MyIterator[A] {
  def next: A
  def hasNext: Boolean
}
