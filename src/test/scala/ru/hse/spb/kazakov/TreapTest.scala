package ru.hse.spb.kazakov

import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer

class TreapTest extends FlatSpec {

  "An empty Treap" should "have size 0" in {
    assert(new Treap[Int].size == 0)
  }

  "A zero size Treap" should "be empty" in {
    assert(new Treap[Int].isEmpty)
    assert(!new Treap[Int].isNotEmpty)
  }

  "A Treap" should "be non-empty after add" in {
    val treap = new Treap[Int]
    assert(treap.add(5))
    assert(!treap.isEmpty)
    assert(treap.isNotEmpty)
  }

  it should "have correct size after adds" in {
    val treap = new Treap[Int]
    assert(treap.add(5))
    assert(treap.size == 1)
    assert(treap.add(1))
    assert(treap.add(2))
    assert(treap.size == 3)
  }

  it should "contain added element" in {
    val treap = new Treap[Int]
    assert(treap.add(5))
    assert(treap.contains(5))
  }

  it should "not contain not added element" in {
    val treap = new Treap[Int]
    treap.add(5)
    assert(!treap.contains(4))
  }

  it should "be able to contain multiple copies of the same element" in {
    val treap = new Treap[Int]
    assert(treap.add(5))
    assert(treap.add(5))
    assert(treap.contains(5))
    assert(treap.size == 2)
  }

  "A cleared Treap" should "be empty" in {
    val treap = new Treap[Int]
    treap.add(42342)
    treap.add(-214)
    treap.clear()
    assert(treap.isEmpty)
  }

  it should "not contain elements" in {
    val treap = new Treap[Int]
    treap.add(42342)
    treap.add(-214)
    treap.clear()
    assert(!treap.contains(42342))
    assert(!treap.contains(-214))
    assert(!treap.contains(0))
  }

  "A Treap" should "have non-negative size after remove" in {
    val treap = new Treap[Int]
    treap.remove(-5)
    assert(treap.size == 0)
  }

  it should "not remove not existing element" in {
    val treap = new Treap[Int]
    treap.add(5)
    assert(!treap.remove(-1))
    assert(treap.size == 1)
  }

  it should "be able to remove added element" in {
    val treap = new Treap[Int]
    treap.add(5)
    assert(treap.remove(5))
    assert(treap.size == 0)
  }

  it should "remove only one copy of an element" in {
    val treap = new Treap[Int]
    treap.add(5)
    treap.add(5)
    assert(treap.remove(5))
    assert(treap.contains(5))
    assert(treap.size == 1)
  }

  it should "work with custom ordering" in {
    val treap = new Treap[Int]()(Ordering.by[Int, Int](_ % 2))
    assert(treap.add(5))
    assert(treap.contains(1))
    assert(!treap.contains(2))
    assert(treap.remove(3))
    assert(treap.isEmpty)
  }

  it should "be iterable in sorted order with for comprehension" in {
    val treap = new Treap[String]()(Ordering.by[String, Int](_.length))
    treap.add("max value")
    treap.add("min")
    treap.add("mean2")
    treap.add("mean")

    var foreach = new ListBuffer[String]
    for (element <- treap) {
      foreach += element
    }

    assert(foreach.toList == List("min", "mean", "mean2", "max value"))
  }

  it should "build correct treap using map" in {
    val treap = fromList(List("azqwe", "xanm", "bcfgre", "xzdc"))
    val mapped = treap.map(_.codePointAt(1))
    assert(toList(mapped) == List(97, 99, 122, 122))
  }

  it should "not be modified by map" in {
    val treap = fromList(List("az", "xa", "bc", "xz"))
    treap.map(_.codePointAt(0))
    assert(toList(treap) == List("az", "bc", "xa", "xz"))
  }

  it should "build correct treap using flatMap" in {
    val treap = fromList(List("az", "xa", "bc"))
    val mapped = treap.flatMap[Char]((s: String) => fromList(s.seq.toList))
    assert(toList(mapped) == List('a', 'a', 'b', 'c', 'x', 'z'))
  }

  it should "not be modified by flatMap" in {
    val treap = fromList(List("b", "tr", "aa"))
    treap.flatMap[Char]((s: String) => fromList(s.seq.toList))
    assert(toList(treap) == List("aa", "b", "tr"))
  }

  it should "build correct treap using filter" in {
    val treap = fromList(List(0, -100, 55, -1011))
    val filtered = treap.filter((n: Int) => n % 2 == 0)
    assert(toList(filtered) == List(-100, 0))
  }

  it should "not be modified by filter" in {
    val treap = fromList(List(0, -100, 5, -101))
    treap.filter((n: Int) => n < 0)
    assert(toList(treap) == List(-101, -100, 0, 5))
  }

  it should "have the same hashcode with identical treap" in {
    val treap1 = fromList(List(0, -100, 5, -101))
    val treap2 = fromList(List(-100, -101, 0, 5))
    assert(treap1.hashCode() == treap2.hashCode())
  }

  it should "be equal to identical treap" in {
    val treap1 = fromList(List("s", "a", "v", "e"))
    val treap2 = fromList(List("e", "a", "s", "v"))
    assert(treap1 == treap2)
  }

  it should "not be equal to not identical treap" in {
    val treap1 = fromList(List("s", "a", "v", "e"))
    val treap2 = fromList(List("e", "q", "s", "v"))
    assert(!(treap1 == treap2))
  }

  it should "not be equal to treap with identical set of elements but different size" in {
    val treap1 = fromList(List(1, 2, 3, 4, 5))
    val treap2 = fromList(List(1, 1, 2, 3, 4, 5))
    assert(!(treap1 == treap2))
  }

  it should "not be equal to object of another class" in {
    val treap1 = fromList(List(1, 2, 3, 4, 5))
    val list = List(1, 2, 3, 4, 5)
    //noinspection ComparingUnrelatedTypes
    assert(!(treap1 == list))
  }

  it should "remove collection of elements correctly" in {
    val treap = fromList(List(1.0, -2.1, -23, 43.03, 5))
    val toRemove = fromList(List(5, -2.1, -1))
    assert(!treap.removeAll(toRemove))
    assert(toList(treap) == List(-23, 1.0, 43.03))
  }

  it should "add collection of elements correctly" in {
    val treap = fromList(List('a', 'e'))
    val toAdd = fromList(List('a', 'q'))
    assert(treap.addAll(toAdd))
    assert(toList(treap) == List('a', 'a', 'e', 'q'))
  }

  it should "contain all elements from collection with added elements" in {
    val treap = fromList(List('a', 'e', 'z'))
    val added = fromList(List('a', 'z'))
    assert(treap.containsAll(added))
  }

  it should "not contain all elements from collection that has unique element" in {
    val treap = fromList(List('a', 'e', 'z'))
    val unique = fromList(List('a', 'e', 'x'))
    assert(!treap.containsAll(unique))
  }

  private def toList[A](treap: Treap[A]): List[A] = {
    var result = new ListBuffer[A]
    treap.foreach(result += _)
    result.toList
  }

  private def fromList[A](list: List[A])(implicit ordering: Ordering[A]): Treap[A] = {
    val treap = new Treap[A]()(ordering)
    list.foreach(treap.add)
    treap
  }
}
