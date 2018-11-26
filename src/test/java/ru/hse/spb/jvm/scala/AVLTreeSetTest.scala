package ru.hse.spb.jvm.scala

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ListBuffer

class AVLTreeSetTest extends FlatSpec with Matchers {

  "Size method" should "return size of a tree" in {
    val set = new AVLTreeSet[Int]
    set.size should be(0)
    set.add(10)
    set.size should be(1)
    set.add(11)
    set.size should be(2)
    set.add(11)
    set.size should be(2)
    set.remove(10)
    set.size should be(1)
    set.remove(10)
    set.size should be(1)
    set.remove(11)
    set.size should be(0)
    set.remove(11)
    set.size should be(0)
  }

  "isEmpty method" should "return true iff size is 0" in {
    val set = new AVLTreeSet[Int]
    set.isEmpty should be(true)
    set.add(10)
    set.isEmpty should be(false)
    set.add(11)
    set.isEmpty should be(false)
    set.add(11)
    set.isEmpty should be(false)
    set.remove(10)
    set.isEmpty should be(false)
    set.remove(10)
    set.isEmpty should be(false)
    set.remove(11)
    set.isEmpty should be(true)
    set.remove(11)
    set.isEmpty should be(true)
  }

  "contains method" should "return true iff element exists in set" in {
    val set = new AVLTreeSet[Int]
    set.contains(10) should be(false)
    set.contains(11) should be(false)
    set.add(10)
    set.contains(10) should be(true)
    set.contains(11) should be(false)
    set.add(11)
    set.contains(10) should be(true)
    set.contains(11) should be(true)
    set.add(11)
    set.contains(10) should be(true)
    set.contains(11) should be(true)
    set.remove(10)
    set.contains(10) should be(false)
    set.contains(11) should be(true)
    set.remove(10)
    set.contains(10) should be(false)
    set.contains(11) should be(true)
    set.remove(11)
    set.contains(10) should be(false)
    set.contains(11) should be(false)
    set.remove(11)
    set.contains(10) should be(false)
    set.contains(11) should be(false)
  }

  "iterator method" should "return iterator over set to iterate in increasing order" in {
    val set = new AVLTreeSet[Int]
    var it = set.iterator
    it.hasNext should be(false)
    set.add(11)
    it = set.iterator
    it.hasNext should be(true)
    it.next should be(11)
    it.hasNext should be(false)
    set.add(10)
    set.add(10)
    it = set.iterator
    it.hasNext should be(true)
    it.next should be(10)
    it.hasNext should be(true)
    it.next should be(11)
  }

  "toArray method" should "return filled array containing set elements in increasing order" in {
    val set = new AVLTreeSet[Int]
    val array = new Array[Int](2)
    set.toArray(array) should be(Array(0, 0))
    set.add(11)
    set.toArray(array) should be(Array(11, 0))
    set.remove(11)
    set.add(12)
    set.add(10)
    set.toArray(array) should be(Array(10, 12))
  }

  "add method" should "insert element into set and return true if this element didn't exist in set" in {
    val set = new AVLTreeSet[Int]
    set.contains(10) should be(false)
    set.contains(9) should be(false)
    set.contains(11) should be(false)
    set.add(10) should be(true)
    set.contains(10) should be(true)
    set.contains(9) should be(false)
    set.contains(11) should be(false)
    set.add(10) should be(false)
    set.add(9) should be(true)
    set.contains(10) should be(true)
    set.contains(9) should be(true)
    set.contains(11) should be(false)
    set.add(11) should be(true)
    set.contains(10) should be(true)
    set.contains(9) should be(true)
    set.contains(11) should be(true)
  }

  "remove method" should "delete element from set and return true if this element existed in set" in {
    val set = new AVLTreeSet[Int]
    set.add(10)
    set.add(9)
    set.add(12)
    set.remove(10) should be(true)
    set.remove(9) should be(true)
    set.remove(12) should be(true)
    set.remove(10) should be(false)
    set.contains(10) should be(false)
    set.contains(9) should be(false)
    set.contains(11) should be(false)
  }

  "+= operator" should "insert element into set and return changed set containing this element" in {
    val set = new AVLTreeSet[Int]
    set.contains(10) should be(false)
    set.contains(9) should be(false)
    set.contains(11) should be(false)
    (set += 10) should be(set)
    set.contains(10) should be(true)
    set.contains(9) should be(false)
    set.contains(11) should be(false)
    ((set += 10) += 9) should be(set)
    set.contains(10) should be(true)
    set.contains(9) should be(true)
    set.contains(11) should be(false)
    (set += 11) should be(set)
    set.contains(10) should be(true)
    set.contains(9) should be(true)
    set.contains(11) should be(true)
  }

  "-= operator" should "delete element from set and return changed set without this element" in {
    val set = new AVLTreeSet[Int]
    set.add(10)
    set.add(9)
    set.add(12)
    (set -= 10) should be(set)
    (set -= 9) should be(set)
    (set -= 12) should be(set)
    (set -= 10) should be(set)
    set.contains(10) should be(false)
    set.contains(9) should be(false)
    set.contains(11) should be(false)
  }

  "foreach method" should "take a function and apply it to each element in set in increasing order" in {
    val set = new AVLTreeSet[Int]
    set.add(10)
    set.add(9)
    set.add(12)
    val elementsExpected = List(9, 10, 12)
    val elements = ListBuffer[Int]()
    set.foreach({ element: Int => elements += element })
    elements should be(elementsExpected)
  }

  "containsAll method" should "returns true iff all given elements exist in set" in {
    val set = new AVLTreeSet[Int]
    val set2 = new AVLTreeSet[Int]()
    set.add(10)
    set.add(9)
    set.add(12)
    set.containsAll(set2) should be(true)
    set2.add(10)
    set2.add(9)
    set.containsAll(set2) should be(true)
    set2.add(13)
    set.containsAll(set2) should be(false)
  }

  "foldLeft method" should "accumulate given function and initial value" in {
    val set = new AVLTreeSet[Int]
    set.foldLeft(0)((acc, el) => acc + el) should be(0)
    set.add(10)
    set.add(9)
    set.add(12)
    set.foldLeft(0)((acc, el) => acc - el) should be(-9 - 10 - 12)
  }

  "addAll method" should "add all given elements into set and return true iff set was changed" in {
    val set = new AVLTreeSet[Int]
    val setEmpty = new AVLTreeSet[Int]
    val setCheck = new AVLTreeSet[Int]
    set.add(10)
    set.add(9)
    set.add(12)
    setCheck.addAll(setEmpty) should be(false)
    setCheck.isEmpty should be(true)
    setCheck.addAll(set) should be(true)
    setCheck.size should be(3)
    setCheck.containsAll(set) should be(true)
  }

  "removeAll method" should "remove all given elements from set and return true iff set was changed" in {
    val set = new AVLTreeSet[Int]
    val setEmpty = new AVLTreeSet[Int]
    val setCheck = new AVLTreeSet[Int]
    setCheck.add(10)
    setCheck.add(9)
    setCheck.add(12)
    ((set += 10) += 12) += 2
    setCheck.removeAll(setEmpty) should be(false)
    setCheck.size should be(3)
    setCheck.removeAll(set) should be(true)
    setCheck.size should be(1)
    setCheck.contains(9) should be(true)
  }

  "removeIf method" should "remove from set all given elements that satisfies given predicate" in {
    val set = new AVLTreeSet[Int]
    val setCheck = new AVLTreeSet[Int]
    setCheck.add(10)
    setCheck.add(9)
    setCheck.add(12)
    ((set += 10) += 12) += 2
    setCheck.removeIf({ el => el > 20 }) should be(false)
    setCheck.size should be(3)
    setCheck.removeIf({ el => el > 9 }) should be(true)
    setCheck.size should be(1)
    setCheck.contains(9) should be(true)
  }

  "retainAll method" should "retains in set all given elements and removes all others" in {
    val set = new AVLTreeSet[Int]
    val setCheck = new AVLTreeSet[Int]
    setCheck.add(10)
    setCheck.add(9)
    setCheck.add(12)
    set.add(10)
    set.add(9)
    set.add(12)
    ((set += 10) += 12) += 2
    setCheck.retainAll(set) should be(false)
    setCheck.size should be(3)
    set.remove(10)
    set.remove(12)
    setCheck.retainAll(set) should be(true)
    setCheck.size should be(1)
    setCheck.contains(9) should be(true)
    setCheck.retainAll(new AVLTreeSet[Int]) should be(true)
    setCheck.isEmpty should be(true)
  }

  "map method" should "converts each element to a new one and returns new set" in {
    val set = new AVLTreeSet[Int]
    val setExpected = new AVLTreeSet[Double]
    setExpected.add(1.0)
    setExpected.add(0.9)
    set.add(10)
    set.add(9)
    val mapped = set.map(element => element * 0.1)
    mapped.containsAll(setExpected) should be(true)
  }
}
