package ru.spb.hse.hw02

import org.scalatest.{FlatSpec, Matchers}

class LinkedListTest extends FlatSpec with Matchers {
  "LinkedList.size" should "return correct list's size in several cases" in {
    val list: LinkedList[Int] = new LinkedList[Int]()
    list.size should be(0)
    list.add(1)
    list.size should be(1)
    list.add(1)
    list.size should be(2)
    list.remove(1)
    list.size should be(0)
    list.add(2)
    list.size should be(1)
    list.add(2)
    list.size should be(2)
    list.add(3)
    list.size should be(3)
    list.remove(2)
    list.size should be(1)
  }

  "LinkedList forall, exists and count" should "return correct boolean results in several cases" in {
    val list: LinkedList[Int] = new LinkedList[Int]()
    list.add(1)
    list.add(-1)
    list.add(3)
    list.add(-3)
    list.add(2)
    list.add(-2)

    list.forall(Math.abs(_) < 4) should be(true)
    list.forall(Math.abs(_) < 3) should be(false)

    list.exists(Math.abs(_) < 4) should be(true)
    list.exists(Math.abs(_) < 3) should be(true)
    list.exists(Math.abs(_) < 0) should be(false)

    list.count(Math.abs(_) < 4) should be(6)
    list.count(Math.abs(_) < 3) should be(4)
    list.count(Math.abs(_) < 0) should be(0)
  }

  "LinkedList folds" should "return correct results in several cases" in {
    val list: LinkedList[Int] = new LinkedList[Int]()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    list.add(6)

    list.fold(0)((first, second) => first + second) should be(21)
    list.foldLeft("")((str, value) => str + " " + value.toString) should be(" 1 2 3 4 5 6")
    list.foldRight("")((value, str) => str + " " + value.toString) should be(" 6 5 4 3 2 1")
  }

  "LinkedList add, contains and remove" should "return correct boolean results in several cases" in {
    val list: LinkedList[Int] = new LinkedList[Int]()
    list.contains(1) should be(false)
    list.add(1) should be(true)
    list.add(1) should be(true)
    list.contains(1) should be(true)
    list.remove(1) should be(true)
    list.remove(1) should be(false)
    list.contains(1) should be(false)
  }

  "LinkedList.iterator" should "return correct iterator with element in the same order" in {
    val list: LinkedList[Int] = new LinkedList[Int]()
    list.add(1)
    list.add(3)
    list.add(2)
    list.add(4)

    val it: Iterator[Int] = list.iterator
    it.next should be(1)
    it.next should be(3)
    it.next should be(2)
    it.next should be(4)
  }

  "LinkedList.toLinkedList" should "return list with the same structure" in {
    val list: LinkedList[Int] = new LinkedList[Int]()
    list.add(2)
    list.add(3)
    list.add(9)

    val first: Iterator[Int] = list.iterator
    val second: Iterator[Int] = list.toLinkedList.iterator

    while (first.hasNext && second.hasNext) {
      first.next - second.next should be(0)
    }

    first.hasNext should be(false)
    second.hasNext should be(false)

    list.size - list.toLinkedList.size should be(0)
  }
}
