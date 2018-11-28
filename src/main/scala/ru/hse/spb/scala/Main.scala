package ru.hse.spb.scala

object Main {
  def main(args: Array[String]): Unit = {
    val f = AATreeSet(1, 2, 3)
    println(f.contains(1))
    println(f.contains(5))
    println(AATreeSet(1, 2, 4).foldLeft("")((s, t) => s + t.toString))
    println(AATreeSet(1, 2, 4).foldRight("")((t, s) => s + t.toString))
    val it = f.iterator
    while (it.hasNext) {
      println(it.next)
    }
    val s = AATreeSet(1, 2, 4) += 3
    val it1 = s.iterator
    while (it1.hasNext) {
      println(it1.next)
    }
  }
}
