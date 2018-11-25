package ru.hse.scala.nedikov.tree

import org.scalatest.{FlatSpec, Matchers}

class TreapTest extends FlatSpec with Matchers {
  "count" should "return count of elements" in {
    var v = TreapSet(1, 2, 3, 4, 5, 6)
    v.count should be(6)

    v = v.remove(2)
    v.count should be(5)

    v = TreapSet.empty
    v.count should be(0)

    v = v + 42
    v.count should be(1)
  }

  "contains" should "return true if element is in the treap" in {
    val v = TreapSet(1, 20, 30, 40, 5)
    v.contains(1) should be(true)
    v.contains(20) should be(true)
    v.contains(30) should be(true)
    v.contains(40) should be(true)
    v.contains(5) should be(true)
  }


  "contains" should "return false if element is not in the treap" in {
    val v = TreapSet(1, 20, 30, 40, 5)
    v.contains(10) should be(false)
    v.contains(22) should be(false)
    v.contains(34) should be(false)
    v.contains(45) should be(false)
    v.contains(50) should be(false)
  }

  "containsAll" should "return true if all elements from the collection are in the treap" in {
    val v = TreapSet(1, 2, 3)
    v.containsAll(TreapSet.empty) should be(true)
    v.containsAll(TreapSet()) should be (true)
    v.containsAll(TreapSet(1)) should be (true)
    v.containsAll(TreapSet(1, 2)) should be (true)
    v.containsAll(TreapSet(1, 3)) should be (true)
    v.containsAll(TreapSet(2, 3)) should be (true)
    v.containsAll(TreapSet(1, 2, 3)) should be (true)
  }

  "add" should "create a new treap with this element" in {
    val v = TreapSet(10, 20, 30)
    v.count should be(3)
    val v2 = v.add(40)
    v.count should be(3)
    v2.count should be(4)

    v.contains(40) should be(false)
    v2.contains(40) should be(true)

    val v3 = v2.add(40)
    v3.count should be(4)
  }

  "addAll" should "create a new treap with elements from both collections" in {
    val v = TreapSet(1, 2, 3)
    val v2 = v.addAll(TreapSet(1, 4, 5))
    v2.count should be(5)
    v2.contains(1) should be(true)
    v2.contains(2) should be(true)
    v2.contains(3) should be(true)
    v2.contains(4) should be(true)
    v2.contains(5) should be(true)
    v2.contains(0) should be(false)
  }

  "remove" should "create a new treap without the element" in {
    var v = TreapSet(1, 2, 3)
    v = v.remove(1)
    v.count should be(2)
    v.contains(1) should be(false)

    v.contains(3) should be(true)
    v = v.remove(3)
    v.count should be(1)
    v.contains(3) should be(false)
  }

  //Я устал писать названия, честно, и так всё понятно
  "removeAll" should "remove all" in {
    var v = TreapSet(1, 2, 3)
    v = v.removeAll(TreapSet(1, 3))

    v.count should be(1)
    v.contains(2) should be(true)
  }

  "copyToArray" should "copy to array" in {
    val v = TreapSet(4, 3, 2, 1)
    var t = Array.ofDim[Int](4)
    v.copyToArray(t)
    t should be(Array(1, 2, 3, 4))
    t = Array.ofDim[Int](6)
    v.copyToArray(t, 1)
    t should be(Array(0, 1, 2, 3, 4, 0))
  }

  "map" should "map" in {
    val v = TreapSet("as", "das", "popadas")
    val v1 = v.map(_.length)
    v1.count should be(3)
    v1.containsAll(TreapSet(2, 3, 7))
  }

  "flatMap" should "flatMap" in {
    val v = TreapSet("ae", "da", "bc")
    val v2 = v.flatMap(_.foldLeft(TreapSet.empty[Char])(_ + _))
    v2.count should be(5)
    v2.containsAll(TreapSet('a', 'b', 'c', 'd', 'e'))
  }

  "filter" should "filter" in {
    var v = TreapSet(1, 2, 4, 5, 6)
    v = v.filter(_ % 2 == 0)
    v.count should be(3)
    v.containsAll(TreapSet(2, 4, 6))
  }

  "forEach" should "for each" in {
    val v = TreapSet(1, 3, 2, 4)
    val t = Array.ofDim[Int](4)
    var i = 0
    v.forEach(v => {t(i) = v; i = i + 1})
    t should be(Array(1, 2, 3, 4))
  }

  "foldLeft" should "fold left" in {
    val v = TreapSet(1, 2, 3)
    v.foldLeft(0)(_ + _) should be(6)
    v.foldLeft(3)(_ - _) should be(-3)
    v.foldLeft(0)((b, _) => b) should be(0)
    v.foldLeft(0)((_, a) => a) should be(3)
  }

}
