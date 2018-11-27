package ru.spbau.jvm.scala.mycollection

import org.scalatest.{FlatSpec, Matchers}

import scala.util.Random

class TreapTest extends FlatSpec with Matchers {
  private val RANGE = 100
  private val NUMBERS = Random.shuffle(Range(-RANGE, RANGE).toList)

  "Treap" should "be created for comparable types" in {
    new MyTreeSet[Int]()
    new MyTreeSet[String]()
    class A extends Ordered[A] {
      override def compare(that: A): Int = 1
    }
    new MyTreeSet[A]
  }

  "Empty and size" should "work correctly after adding" in {
    val set = new MyTreeSet[Int]
    set.size should be(0)
    set.isEmpty should be(true)

    set.add(3)
    set.add(1)

    set.size should be(2)
    set.isEmpty should be(false)
  }

  "Add" should "work correctly" in {
    val set = new MyTreeSet[Int]

    NUMBERS.foreach(elem => set(elem) should be(false))
    NUMBERS.foreach(elem => set += elem)

    set.size should be(2 * RANGE)
    NUMBERS.foreach(elem => set(elem) should be(true))
  }

  "Remove" should "work correctly" in {
    val set = prepareSet()
    NUMBERS.foreach(elem => {
      set -= elem
      set(elem) should be(false)
    })
    set.size should be(0)
  }

  "Iterator" should "return elements in increasing order" in {
    val set = prepareSet()

    val it = set.iterator
    for (i <- Range(-100, 100)) {
      it.next() should be(i)
    }
    it.hasNext should be(false)
  }

  "ToArray" should "work correctly" in {
    val set = prepareSet()

    set.toArray should be(Range(-RANGE, RANGE).toArray)
  }

  "Map" should "work correctly" in {
    val set = prepareSet()
    val result = set.map(_.toString)
    NUMBERS.foreach(elem => result(elem.toString) should be(true))
  }

  "FlatMap" should "work correctly" in {
    val set = new MyTreeSet[String]
    set += "abc" += "def"

    val flattedSet = set.flatMap(s => new Iterable[Char] {
      override def iterator: Iterator[Char] = new Iterator[Char] {
        var i = 0

        override def hasNext: Boolean = i < s.length

        override def next(): Char = {
          i += 1
          s(i - 1)
        }
      }
    })

    flattedSet.toArray should be(Array('a', 'b', 'c', 'd', 'e', 'f'))
  }

  "FoldLeft" should "work correctly" in {
    val set = prepareSet()
    set.foldLeft(0)(_ + _) should be(-RANGE)
  }

  "ReduceLeft" should "work correctly" in {
    val set = prepareSet()
    set.reduceLeft(_ + _) should be(-RANGE)
  }

  "Exists" should "work correctly" in {
    val set = prepareSet()
    set.exists(_ == RANGE) should be(false)
    set.exists(_ == (RANGE - 1)) should be(true)
  }

  "Clear" should "make set empty" in {
    val set = prepareSet()
    set.clear()
    set.size should be(0)
    set.isEmpty should be(true)
  }

  "For comprehension" should "work for treap" in {
    val set = prepareSet()
    var current = -RANGE
    val filtered = for (elem <- set if elem % 100 == 0) yield elem
    filtered.toArray should be(Array(-100, 0))
  }

  private def prepareSet(): MyTreeSet[Int] = {
    val set = new MyTreeSet[Int]
    NUMBERS.foreach(elem => set += elem)
    set
  }
}
