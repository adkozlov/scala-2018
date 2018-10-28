package ru.spbau.jvm.scala.lecture02

sealed trait IntList <: Serializable // extends Serializable

case object IntNil extends IntList

final case class IntCons(head: Int, tail: IntList = IntNil) extends IntList

object ListExample {

  def main(args: Array[String]): Unit = {
    val list: IntList = IntCons(1, IntCons(2, IntCons(3)))

    list match {
      case IntNil => println("nil")
      case IntCons(_, IntNil) => println("only one element")
      case cons: IntCons => println(cons.head)
      // case _ if list.isInstanceOf[IntCons] => println(list.asInstanceOf[IntCons].head)
    }
  }
}