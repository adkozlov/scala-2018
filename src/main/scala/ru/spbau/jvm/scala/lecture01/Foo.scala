package ru.spbau.jvm.scala.lecture01

trait Foo {
  def foo: Int
}

trait FooCompanion[F <: Foo] {
  def apply(): F
}