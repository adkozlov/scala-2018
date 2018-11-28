package ru.hse.iterable

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class IterableTest extends FlatSpec with Matchers with BeforeAndAfter {

  var iterable: Iterable[String] = _

  before {
    iterable = new Iterable[String] {
      override def iterator: Iterator[String] = new Iterator[String] {
        val size = 20
        private var cur = 0

        override def hasNext: Boolean = cur < size

        override def next(): String = if (cur < size) {
          cur += 1
          cur.toString
        } else {
          Iterator.empty.next()
        }
      }
    }

  }

  "An Iterable" should "yield correct values" in {
    val result = for (el <- iterable if el.length == 1) yield el
    var size = 0
    result.foreach { element: String => {
      size += 1
      assert(element == size.toString)
    }
    }

    assert(size == 9)
  }

  "An Iterable" should "have correct size" in {
    assert(iterable.size == 20)
  }
}
