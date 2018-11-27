package tree

import org.scalatest.{FlatSpec, Matchers}

class ListTest extends FlatSpec with Matchers {
  "List.size" should "return correct initial list's size" in {
    var list: List[Int] = new Nil[Int]()
    list.size should be(0)
  }

  "List.size" should "return correct list's size in case of add" in {
    var list: List[Int] = new Nil[Int]()
    list.size should be(0)
    list = list.add(1)
    list.size should be(1)
    list = list.add(2)
    list.size should be(2)
    list = list.add(0)
    list.size should be(3)
    list = list.add(-13)
    list.size should be(4)
  }

  "List.size" should "return correct list's size in case of remove" in {
    var list: List[Int] = new Nil[Int]()
    list.size should be(0)
    list = list.add(1)
    list.size should be(1)
    list = list.add(2)
    list.size should be(2)
    list = list.remove(1)
    list.size should be(1)
    list = list.remove(2)
    list.size should be(0)
  }

  "List.size" should "return correct list's size in case of remove from empty" in {
    var list: List[Int] = new Nil[Int]()
    list.size should be(0)
    list = list.remove(1)
    list.size should be(0)
    list = list.remove(2)
    list.size should be(0)
    list = list.add(0)
    list.size should be(1)
    list = list.remove(0)
    list.size should be(0)
    list = list.remove(0)
    list.size should be(0)
  }

  "List.contains" should "should return true if element was added" in {
    var list: List[Int] = new Nil[Int]()
    list = list.add(1)
    list.contains(1) should be(true)
    list = list.add(1)
    list.contains(1) should be(true)
    list = list.add(2)
    list.contains(2) should be(true)
    list.contains(1) should be(true)
  }

  "List.contains" should "should return false if element was added and deleted" in {
    var list: List[Int] = new Nil[Int]()
    list = list.add(1)
    list = list.remove(1)
    list.contains(1) should be(false)
  }

  "List.contains" should "should return false if element was not added" in {
    var list: List[Int] = new Nil[Int]()
    list.contains(2) should be(false)
    list = list.add(1)
    list.contains(2) should be(false)
    list = list.add(3)
    list.contains(2) should be(false)
    list = list.remove(2)
    list.contains(2) should be(false)
  }

  "List.contains" should "should return true if element was added twice and deleted" in {
    var list: List[Int] = new Nil[Int]()
    list = list.add(2)
    list = list.add(2)
    list = list.remove(2)
    list.contains(2) should be(true)
  }

  "List.iterator" should "returns elements in right order" in {
    var list: List[Int] = new Nil[Int]()
    list = list.add(1)
    list = list.add(2)
    list = list.add(3)
    val it = list.iterator
    it.hasNext should be(true)
    it.next should be(3)
    it.hasNext should be(true)
    it.next should be(2)
    it.hasNext should be(true)
    it.next should be(1)
    it.hasNext should be(false)
  }

  "List.foreach" should "work correctly" in {
    var list: List[String] = new Nil[String]()
    list = list.add("1")
    list = list.add("2")
    list = list.add("3")
    var s = ""
    list.foreach(n => s += n)
    s should be("321")
  }

  "List.foldl" should "work correctly" in {
    var list: List[Int] = new Nil[Int]()
    list = list.add(1)
    list = list.add(2)
    list = list.add(3)
    list.foldl(10)((a, b) => a + b) should be(16)
    list.foldl(10)((a, b) => a - b) should be(4)
  }

}