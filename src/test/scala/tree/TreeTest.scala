package tree

import org.scalatest.{FlatSpec, Matchers}

class TreeTest extends FlatSpec with Matchers {
  "Tree.size" should "return correct initial tree's size" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree.size should be(0)
  }

  "Tree.size" should "return correct tree's size in case of add" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree.size should be(0)
    tree = tree.add(1)
    tree.size should be(1)
    tree = tree.add(2)
    tree.size should be(2)
    tree = tree.add(0)
    tree.size should be(3)
    tree = tree.add(-13)
    tree.size should be(4)
  }

  "Tree.size" should "return correct tree's size in case of remove" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree.size should be(0)
    tree = tree.add(1)
    tree.size should be(1)
    tree = tree.add(2)
    tree.size should be(2)
    tree = tree.remove(1)
    tree.size should be(1)
    tree = tree.remove(2)
    tree.size should be(0)
  }

  "Tree.size" should "return correct tree's size in case of remove from empty" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree.size should be(0)
    tree = tree.remove(1)
    tree.size should be(0)
    tree = tree.remove(2)
    tree.size should be(0)
    tree = tree.add(0)
    tree.size should be(1)
    tree = tree.remove(0)
    tree.size should be(0)
    tree = tree.remove(0)
    tree.size should be(0)
  }

  "Tree.contains" should "should return true if element was added" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree = tree.add(1)
    tree.contains(1) should be(true)
    tree = tree.add(1)
    tree.contains(1) should be(true)
    tree = tree.add(2)
    tree.contains(2) should be(true)
    tree.contains(1) should be(true)
  }

  "Tree.contains" should "should return false if element was added and deleted" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree = tree.add(1)
    tree = tree.remove(1)
    tree.contains(1) should be(false)
  }

  "Tree.contains" should "should return false if element was not added" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree.contains(2) should be(false)
    tree = tree.add(1)
    tree.contains(2) should be(false)
    tree = tree.add(3)
    tree.contains(2) should be(false)
    tree = tree.remove(2)
    tree.contains(2) should be(false)
  }

  "Tree.contains" should "should return true if element was added twice and deleted" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree = tree.add(2)
    tree = tree.add(2)
    tree = tree.remove(2)
    tree.contains(2) should be(true)
  }

  "Tree.iterator" should "returns elements in right order" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree = tree.add(1)
    tree = tree.add(2)
    tree = tree.add(3)
    val it = tree.iterator
    it.hasNext should be(true)
    it.next should be(1)
    it.hasNext should be(true)
    it.next should be(2)
    it.hasNext should be(true)
    it.next should be(3)
    it.hasNext should be(false)
  }

  "Tree.min" should "should return minimum" in {
    var tree: Tree[Int] = new Leaf[Int]()
    tree = tree.add(1)
    tree.min() should be(1)
    tree = tree.add(4)
    tree.min() should be(1)
    tree = tree.add(-2)
    tree.min() should be(-2)
    tree = tree.add(3)
    tree.min() should be(-2)
    tree = tree.remove(-2)
    tree.min() should be(1)
    tree = tree.remove(1)
    tree.min() should be(3)
  }


}