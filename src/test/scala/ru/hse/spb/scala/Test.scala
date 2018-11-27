package ru.hse.spb.scala

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

class Test extends FlatSpec with Matchers {

  def asList[T](set: AATreeSet[T]): List[T] = {
    val iterator = set.iterator
    val list = new mutable.MutableList[T]()
    while (iterator.hasNext) {
      list += iterator.next
    }
    list.toList
  }

  "AATreeSet" should "map" in assert(asList(AATreeSet(1, 2, 3).map((t: Int) => t * t)) == List(1, 4, 9))
  "AATreeSet" should "contains true" in assert(AATreeSet(1, 2, 3).contains(1))
  "AATreeSet" should "contains false" in assert(!AATreeSet(1, 2, 3).contains(5))
  "AATreeSet" should "+=" in assert(asList(AATreeSet(1, 2, 4) += 3) == List(1, 2, 3, 4))
  "AATreeSet" should "-=" in assert(asList(AATreeSet(1, 2, 4) -= 2) == List(1, 4))
  "AATreeSet" should "foldLeft" in assert(AATreeSet(1, 2, 4).foldLeft("")((s:String, t:Int) => s + t.toString) == "124")
  "AATreeSet" should "foldRight" in assert(AATreeSet(1, 2, 4).foldRight("")((t:Int, s:String) => s + t.toString) == "421")
}
