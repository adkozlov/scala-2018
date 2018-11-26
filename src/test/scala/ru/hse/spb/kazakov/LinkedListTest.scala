package ru.hse.spb.kazakov

import java.util.ConcurrentModificationException

import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer

class LinkedListTest extends FlatSpec {

  "An empty LinkedList" should "have size 0" in {
    assert(new LinkedList[Int].size == 0)
  }

  "A zero size LinkedList" should "be empty" in {
    assert(new LinkedList[Int].isEmpty)
    assert(!new LinkedList[Int].isNotEmpty)
  }

  "A LinkedList" should "be non-empty after add" in {
    val list = new LinkedList[Int]
    assert(list.add(5))
    assert(!list.isEmpty)
    assert(list.isNotEmpty)
  }

  it should "have correct size after adds" in {
    val list = new LinkedList[Int]
    assert(list.add(5))
    assert(list.size == 1)
    assert(list.add(1))
    assert(list.add(2))
    assert(list.size == 3)
  }

  it should "contain added element" in {
    val list = new LinkedList[Int]
    assert(list.add(5))
    assert(list.contains(5))
  }

  it should "not contain not added element" in {
    val list = new LinkedList[Int]
    list.add(5)
    assert(!list.contains(4))
  }

  it should "be able to contain multiple copies of the same element" in {
    val list = new LinkedList[Int]
    assert(list.add(5))
    assert(list.add(5))
    assert(list.contains(5))
    assert(list.size == 2)
  }

  "A cleared LinkedList" should "be empty" in {
    val list = new LinkedList[Int]
    list.add(42342)
    list.add(-214)
    list.clear()
    assert(list.isEmpty)
  }

  it should "not contain elements" in {
    val list = new LinkedList[Int]
    list.add(42342)
    list.add(-214)
    list.clear()
    assert(!list.contains(42342))
    assert(!list.contains(-214))
    assert(!list.contains(0))
  }

  "A LinkedList" should "have non-negative size after remove" in {
    val list = new LinkedList[Int]
    list.remove(-5)
    assert(list.size == 0)
  }

  it should "not remove not existing element" in {
    val list = new LinkedList[Int]
    list.add(5)
    assert(!list.remove(-1))
    assert(list.size == 1)
  }

  it should "be able to remove added element" in {
    val list = new LinkedList[Int]
    list.add(5)
    assert(list.remove(5))
    assert(list.size == 0)
  }

  it should "remove only one copy of an element" in {
    val list = new LinkedList[Int]
    list.add(5)
    list.add(5)
    assert(list.remove(5))
    assert(list.contains(5))
    assert(list.size == 1)
  }

  it should "be iterable using for comprehension" in {
    val list = new LinkedList[Int]
    list.add(-32)
    list.add(543)
    list.add(12)
    list.add(45)

    val foreach = new ListBuffer[Int]
    for (element <- list) {
      foreach += element
    }

    assert(Utils.toList(list) == foreach.toList)
  }

  it should "have the same hashcode with identical list" in {
    val list1 = fromList(List(0, -100, 5, -101))
    val list2 = fromList(List(0, -100, 5, -101))
    assert(list1.hashCode() == list2.hashCode())
  }

  it should "be equal to identical list" in {
    val list1 = fromList(List("s", "a", "v", "e"))
    val list2 = fromList(List("s", "a", "v", "e"))
    assert(list1 == list2)
  }

  it should "not be equal to not identical list" in {
    val list1 = fromList(List("s", "a", "v", "e"))
    val list2 = fromList(List("e", "q", "s", "v"))
    assert(!(list1 == list2))
  }

  it should "not be equal to list with identical set of elements but different size" in {
    val list1 = fromList(List(1, 2, 3, 4, 5))
    val list2 = fromList(List(1, 1, 2, 3, 4, 5))
    assert(!(list1 == list2))
  }

  it should "not be equal to object of another class" in {
    val list1 = fromList(List(1, 2, 3, 4, 5))
    val list = List(1, 2, 3, 4, 5)
    //noinspection ComparingUnrelatedTypes
    assert(!(list1 == list))
  }

  it should "remove collection of elements correctly" in {
    val list = fromList(List(1.0, -2.1, -23, 43.03, 5))
    val toRemove = fromList(List(5, -2.1, -1))
    assert(!list.removeAll(toRemove))
    assert(Utils.toList(list) == List(1.0, -23, 43.03))
  }

  it should "add collection of elements correctly" in {
    val list = fromList(List('a', 'e'))
    val toAdd = fromList(List('a', 'q'))
    assert(list.addAll(toAdd))
    assert(Utils.toList(list) == List('a', 'e', 'a', 'q'))
  }

  it should "contain all elements from collection with added elements" in {
    val list = fromList(List('a', 'e', 'z'))
    val added = fromList(List('a', 'z'))
    assert(list.containsAll(added))
  }

  it should "not contain all elements from collection that has unique element" in {
    val list = fromList(List('a', 'e', 'z'))
    val unique = fromList(List('a', 'e', 'x'))
    assert(!list.containsAll(unique))
  }

  it should "be iterable using iterator" in {
    val list = new LinkedList[Int]
    list.add(-32)
    list.add(543)
    list.add(12)
    list.add(45)

    val iterated = new ListBuffer[Int]
    val iterator = list.iterator
    while (iterator.hasNext) {
      iterated += iterator.next()
    }

    assert(Utils.toList(list) == iterated.toList)
  }

  "Iterator" should "be able to remove an element" in {
    val list = new LinkedList[Char]
    list.add(5)
    list.add(1332)
    list.add(41)

    val iterator = list.iterator
    iterator.next()
    iterator.next()
    iterator.remove()

    assert(Utils.toList(list) == List(5, 41))
  }

  "Remove" should "throw NoSuchElementException if next() has not been called" in {
    val list = new LinkedList[Char]
    list.add(5)
    intercept[NoSuchElementException] {
      list.iterator.remove()
    }
  }

  it should "throw NoSuchElementException after second call in a pow" in {
    val list = new LinkedList[Char]
    list.add(56)
    list.add(5)
    list.add(521)

    val iterator = list.iterator
    iterator.next()
    iterator.remove()
    intercept[NoSuchElementException] {
      list.iterator.remove()
    }
  }

  it should "throw ConcurrentModificationException if list has been modified" in {
    val list = new LinkedList[Char]
    list.add(56)
    val iterator = list.iterator
    iterator.next()
    list.add(1)

    intercept[ConcurrentModificationException] {
      iterator.remove()
    }
  }

  "Next" should "throw NoSuchElementException if there is no next element" in {
    val list = new LinkedList[Char]
    list.add(56)
    val iterator = list.iterator
    iterator.next()
    intercept[NoSuchElementException] {
      iterator.next()
    }
  }

  it should "throw ConcurrentModificationException if list has been modified" in {
    val list = new LinkedList[Char]
    list.add(56)
    val iterator = list.iterator
    iterator.next()
    list.add(1)

    intercept[ConcurrentModificationException] {
      iterator.next()
    }
  }

  private def fromList[A](list: List[A]): LinkedList[A] = {
    val linkedList = new LinkedList[A]()
    list.foreach(linkedList.add)
    linkedList
  }

}
