package ru.hse.spb

import org.junit

class Test {

  @junit.Test
  def testCreateTreap(): Unit = {
    val treap = new Treap[Int]()
    assert(treap.add(17))
  }

  @junit.Test
  def testAdd(): Unit = {
    val treap = new Treap[Int]()
    assert(treap.add(17))
    assert(treap.add(25))
    assert(!treap.add(17))
    assert(treap.contains(17))
    assert(treap.contains(25))

  }

  @junit.Test
  def testAddAll(): Unit = {
    val treap = new Treap[Int]()
    val list = new LinkedList[Int]()
    list.add(1)
    list.add(2)
    list.add(25)
    assert(treap.addAll(list))
    assert(treap.contains(25))
    assert(treap.contains(1))
    assert(treap.contains(2))
  }

  @junit.Test
  def testRemove(): Unit = {
    val treap = new Treap[Int]()
    treap.add(17)
    treap.add(125)
    treap.add(15)
    treap.add(1)
    treap.add(4)
    treap.remove(17)
    treap.remove(1)
    assert(!treap.contains(17))
    assert(treap.contains(125))
    assert(treap.contains(15))
    assert(treap.contains(4))
    assert(!treap.contains(1))
  }

  @junit.Test
  def testRemoveAll(): Unit = {
    val treap = new Treap[Int]()
    treap.add(137)
    treap.add(125)
    treap.add(1)
    treap.add(12)
    treap.add(3)
    val list = new LinkedList[Int]()
    list.add(1)
    list.add(2)
    list.add(125)
    treap.removeAll(list)
    assert(treap.contains(3))
    assert(!treap.contains(125))
    assert(treap.contains(137))
    assert(treap.contains(12))
    assert(!treap.contains(1))
  }

  @junit.Test
  def testIterator(): Unit = {
    val treap = new Treap[Int]()
    treap.add(17)
    treap.add(125)
    treap.add(15)
    treap.add(1)
    treap.add(4)
    val it = treap.iterator()
    var i = 0
    var prev = it.next()
    while (i < 4) {
      assert(it.hasNext)
      val next = it.next()
      assert(prev > next)
      prev = next
      i += 1
    }
  }

  @junit.Test
  def testFoldLeft(): Unit = {
    val treap = new Treap[Int]()
    treap.add(1)
    treap.add(2)
    treap.add(3)
    treap.add(4)
    treap.add(5)
    assert(treap.foldLeft((a:Int, b:Int) => {a + b}, 0) == 15)
  }
}