package ru.spb.hse.hw02

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class TreapTest extends FlatSpec with Matchers with BeforeAndAfter {
  private def testLinkedList: LinkedList[Int] = {
    val list: LinkedList[Int] = new LinkedList[Int]()
    list.add(2)
    list.add(3)
    list.add(9)
    list.add(-1)
    list.add(5)
    list.add(6)
    list
  }

  private var treap: Treap[Int] = _

  before {
    treap = new Treap[Int]()
    testLinkedList.forEach(treap.add)
  }


  "Treap.size" should "return correct set's size in a simple case" in {
    val set: Treap[Int] = new Treap[Int]()
    set.size should be(0)
    set.add(1)
    set.size should be(1)
    set.remove(1)
    set.size should be(0)
  }

  it should "return correct set's size with duplicates" in {
    val set: Treap[Int] = new Treap[Int]()
    set.size should be(0)
    set.add(1)
    set.size should be(1)
    set.add(1)
    set.size should be(1)
    set.remove(1)
    set.size should be(0)
    set.remove(1)
    set.size should be(0)
  }

  it should "return correct set's size in a hard test case" in {
    val set: Treap[Int] = new Treap[Int]()
    set.size should be(0)
    set.add(1)
    set.size should be(1)
    set.add(1)
    set.size should be(1)
    set.add(2)
    set.size should be(2)
    set.add(2)
    set.size should be(2)
    set.add(3)
    set.size should be(3)
    set.remove(1)
    set.size should be(2)
    set.remove(3)
    set.size should be(1)
    set.add(3)
    set.size should be(2)
    set.add(3)
    set.size should be(2)
    set.remove(3)
    set.size should be(1)
    set.remove(2)
    set.size should be(0)
    set.remove(2)
    set.size should be(0)
  }


  "Treap.forall" should "return true for comparing predicates" in {
    treap.forall(_ < 10) should be(true)
    treap.forall(_ > -2) should be(true)
  }

  it should "return false for comparing predicates" in {
    treap.forall(_ < 9) should be(false)
    treap.forall(_ > -1) should be(false)
  }

  it should "return correct result for hard predicates" in {
    treap.forall(element => element < 7 || element == 9) should be(true)
    treap.forall(element => (element * element - 6 * element + 9) != 0) should be(false)
  }


  "Treap.exists" should "return correct results for complex predicates" in {
    treap.exists(_ * 2 > 10) should be(true)
    treap.exists(_ * 2 > 100) should be(false)
    treap.exists(element => element * element - 6 * element + 9 == 0) should be(true)
    treap.exists(_ == 7) should be(false)
  }


  "Treap.count" should "return correct results for complex predicates" in {
    treap.count(_ * 2 > 10) should be(2)
    treap.count(_ * 2 > 100) should be(0)
    treap.count(element => element * element - 6 * element + 9 == 0) should be(1)
    treap.count(element => element < 7 || element == 9) should be(6)
  }


  "Treap.foreach" should "return correct results for complex predicates" in {
    treap.forEach(element => treap.add(element - 1))
    treap.size should be(10)
    treap.contains(-2) should be(true)
    treap.contains(-1) should be(true)
    treap.contains(1) should be(true)
    treap.contains(2) should be(true)
    treap.contains(3) should be(true)
    treap.contains(4) should be(true)
    treap.contains(5) should be(true)
    treap.contains(6) should be(true)
    treap.contains(9) should be(true)
    treap.contains(9) should be(true)
  }


  "Different treap folds" should "return correct results" in {
    def gcd(first: Int, second: Int): Int = if (first == 0) second else gcd(second % first, first)

    treap.fold(0)((first, second) => first + second) should be(24)
    treap.fold(1)((first, second) => first * second) should be(-1620)
    treap.fold(10)((first, second) => first * gcd(first, Math.abs(second))) should be(200)

    treap.foldLeft(0)((first, _) => first + 1) should be(6)
    treap.foldLeft(0)((_, second) => second + 1) should be(10)
    treap.foldLeft(1)((first, second) => Math.abs(first * second) / gcd(first, Math.abs(second))) should be(90)
    treap.foldLeft("")((str, value) => value.toString + " " + str) should be("9 6 5 3 2 -1 ")

    treap.foldRight("")((value, str) => value.toString + " " + str) should be("-1 2 3 5 6 9 ")
    treap.foldRight(0)((first, second) => if (second == 0) first else second) should be(9)
  }


  "treap.toLinkedList" should "return increasing list" in {
    val outputList: LinkedList[Int] = treap.toLinkedList

    var previous: Int = -100
    val it: Iterator[Int] = outputList.iterator
    while (it.hasNext) {
      val current: Int = it.next
      current should be > previous
      previous = current
    }

    outputList.size should be(6)
    outputList.contains(-1) should be(true)
    outputList.contains(2) should be(true)
    outputList.contains(3) should be(true)
    outputList.contains(5) should be(true)
    outputList.contains(6) should be(true)
    outputList.contains(9) should be(true)
  }

  "treap add and remove" should "return correct boolean results" in {
    treap.remove(10) should be(false)
    treap.remove(9) should be(true)
    treap.add(-1) should be(false)
    treap.add(-2) should be(true)
    treap.remove(9) should be(false)
    treap.add(9) should be(true)
  }

  "treap.iterator" should "return increasing list" in {
    val values = Set(-1, 2, 3, 5, 6, 9)

    var previous: Int = -100
    var count: Int = 0
    val it: Iterator[Int] = treap.iterator
    while (it.hasNext) {
      val current: Int = it.next
      current should be > previous
      previous = current
      values.contains(current) should be(true)
      count += 1
    }

    count should be(6)
  }

  "treap.map" should "return treap containing squares" in {
    treap = treap.map(value => value * value)
    treap.size should be(6)
    treap.contains(1) should be(true)
    treap.contains(4) should be(true)
    treap.contains(9) should be(true)
    treap.contains(25) should be(true)
    treap.contains(36) should be(true)
    treap.contains(81) should be(true)
  }


  "treap.flatMap" should "return treap of all base values plus {-1, 0, 1}" in {
    treap = treap.flatMap(value => {
      val newTreap: Treap[Int] = new Treap[Int]()
      newTreap.add(value - 1)
      newTreap.add(value)
      newTreap.add(value + 1)
      newTreap
    })
    treap.size should be(13)
    treap.contains(-2) should be(true)
    treap.contains(-1) should be(true)
    treap.contains(0) should be(true)
    treap.contains(1) should be(true)
    treap.contains(2) should be(true)
    treap.contains(3) should be(true)
    treap.contains(4) should be(true)
    treap.contains(5) should be(true)
    treap.contains(6) should be(true)
    treap.contains(7) should be(true)
    treap.contains(8) should be(true)
    treap.contains(9) should be(true)
    treap.contains(10) should be(true)
  }
}
