package ru.spbau.jvm.scala.lecture02

import java.{util => ju}

object Main {

  private def printList[T](list: ju.List[T]): Unit = {
    val iterator = list.iterator
    while (iterator.hasNext) {
      println(iterator.next())
    }
  }

  def main(args: Array[String]): Unit = {
    if (args.length == 0) return
    // if (args.isEmpty) return

    args(0) = "hello"
    println(args(0))
    //    println(args.update(0, "hello")); args.apply(0)
  }
}
