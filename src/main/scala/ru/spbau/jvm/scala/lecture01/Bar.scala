package ru.spbau.jvm.scala.lecture01

class Bar protected(val innerFoo: Int = 0,
                    var text: String = "") extends Foo with Serializable {

  override def foo: Int = fooImpl

  private[this] def fooImpl = innerFoo

  override def equals(obj: Any): Boolean = {
    if (!obj.isInstanceOf[Bar]) return false

    val bar = obj.asInstanceOf[Bar]
    //    innerFoo == bar.fooImpl // compilation error
    innerFoo == bar.innerFoo
  }

  Bar.bar()
}

final class Baz extends Bar

object Bar extends FooCompanion[Bar] {

  override def apply(): Bar = new Bar()

  def apply(foo: Int): Bar = new Bar(foo)

  def apply(double: Double) = new Bar(double.toInt)

  private def bar(): Unit = {

  }
}
