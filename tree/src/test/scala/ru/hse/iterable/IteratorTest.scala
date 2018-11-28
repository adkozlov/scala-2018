package ru.hse.iterable

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class IteratorTest extends FlatSpec with BeforeAndAfter with Matchers {

  var iterator: Iterator[Int] = _

  before {
    iterator = new Iterator[Int] {
      val size = 10
      private var cur = 0

      override def hasNext: Boolean = cur < size

      override def next(): Int = if (cur < size) {
        cur += 1
        cur - 1
      } else {
        Iterator.empty.next()
      }
    }
  }

  "An Iterator" should "check if forall" in {
    assert(iterator.forall(e => 0 <= 10 && e < 10))
  }

  "An Iterator" should "check if exists" in {
    assert(!iterator.exists(e => e == 10))
  }

  "An Iterator" should "find element" in {
    assert(iterator.find(e => e == 8) == Option(8))
    assert(iterator.find(e => e == -1) == Option.empty)
  }

  "An Iterator" should "run foreach" in {
    var size = 0
    iterator.foreach(_ => size += 1)
    assert(size == 10)
  }

  "An Iterator" should "do mapping" in {
    assert(iterator map { e => e * 2 } forall { e => e % 2 == 0 })
  }

  "An Iterator" should "filter" in {
    assert(iterator filter { e => e % 2 == 0 } forall { e => e % 2 == 0 })
  }

  "An Iterator" should "yield correct values" in {
    val result = for (el <- iterator if el % 2 == 0) yield el
    var size = 0
    result.foreach { element => {
      assert(element == size * 2)
      size += 1
    }
    }

    assert(size == 5)
  }
}
