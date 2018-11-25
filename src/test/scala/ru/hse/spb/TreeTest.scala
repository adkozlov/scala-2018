package ru.hse.spb

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

class TreeTest extends FlatSpec with Matchers {

  def generateTree = Tree(7, 2, 8, 4, 5, 1, 3, 9, 6)

  def generateList = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  "Iterator" should "iterate in correct order" in {
    val tree = generateTree
    val treeIter = tree.iterator
    val list = mutable.MutableList[Int]()
    while (treeIter.hasNext) {
      list += treeIter.next
    }
    list shouldBe generateList
  }

  "Contains" should "return true on elements" in {
    val tree = generateTree
    for (elem <- generateList) {
      tree.contains(elem) shouldBe true
    }
  }

  "Contains" should "return false on extra elements" in {
    val tree = generateTree
    tree.contains(0) shouldBe false
    tree.contains(-1) shouldBe false
    tree.contains(11) shouldBe false
  }

  "SubsetOf" should "return true on a superset" in {
    val tree = generateTree
    val subtree = Tree(3, 5, 6, 7)
    subtree.subsetOf(tree) shouldBe true
  }

  "SubsetOf" should "return true on the same tree" in {
    val tree = generateTree
    tree.subsetOf(tree) shouldBe true
  }

  "SubsetOf" should "return true if the tree is empty" in {
    val tree = generateTree
    val emptyTree = Tree.empty[Int]
    emptyTree.subsetOf(tree) shouldBe true
  }

  "SubsetOf" should "return false on an intersecting tree" in {
    val tree = generateTree
    val anotherTree = Tree(1, 10, 11)
    anotherTree.subsetOf(tree) shouldBe false
  }

  "Add" should "add a new element" in {
    val tree = Tree[Int]()
    tree.add(1) shouldBe true
    tree.contains(1) shouldBe true
  }

  "Add" should "not add a duplicate element" in {
    val tree = generateTree
    tree.add(1) shouldBe false
  }

  "Remove" should "remove an element" in {
    val tree = generateTree
    tree.remove(1) shouldBe true
    tree.contains(1) shouldBe false
  }

  "Remove" should "not remove an extra element" in {
    val tree = generateTree
    tree.remove(1) shouldBe true
    tree.remove(1) shouldBe false
    tree.contains(1) shouldBe false
  }

  "Retain" should "retain all elements if the predicate is always true" in {
    val tree = generateTree
    tree.retain(_ => true)
    toList(tree) shouldBe generateList
  }

  "Retain" should "remove all elements if the predicate is always false" in {
    val tree = generateTree
    tree.retain(_ => false)
    toList(tree) shouldBe List()
  }

  "Retain" should "remove all even numbers" in {
    val tree = generateTree
    tree.retain(_ % 2 == 0)
    toList(tree) shouldBe List(2, 4, 6, 8)
  }

  "Copy" should "copy all elements" in {
    val tree = generateTree
    val copy = tree.copy
    toList(copy) shouldBe toList(tree)
  }

  "Copy of empty tree" should "be empty" in {
    val copy = Tree.empty.copy
    toList(copy) shouldBe List()
  }

  "Copied tree" should "not change the original one" in {
    val tree = generateTree
    val copy = tree.copy
    copy.retain(_ % 2 == 0)
    toList(tree) shouldBe generateList
  }

  "Plus" should "return a copy with a new element" in {
    val tree = generateTree
    toList(tree + 11) shouldBe (generateList ++ List(11))
  }

  "Plus" should "not change the original tree" in {
    val tree = generateTree
    tree + 11
    toList(tree) shouldBe generateList
  }

  "Minus" should "return a copy without an element" in {
    val tree = generateTree
    toList(tree - 7) shouldBe generateList.filter(_ != 7)
  }

  "Minus" should "not change the original tree" in {
    val tree = generateTree
    tree - 7
    toList(tree) shouldBe generateList
  }

  "PlusPlus" should "return a union of trees" in {
    val tree = generateTree
    toList(tree ++ Tree(0, 7, 11)) shouldBe (List(0) ++ generateList ++ List(11))
  }

  "PlusPlus" should "not change the original tree" in {
    val tree = generateTree
    tree ++ Tree(0, 7, 11)
    toList(tree) shouldBe generateList
  }

  "MinusMinus" should "return a subtraction of trees" in {
    val tree = generateTree
    toList(tree -- Tree(0, 7, 11)) shouldBe generateList.filter(_ != 7)
  }

  "MinusMinus" should "not change the original tree" in {
    val tree = generateTree
    tree -- Tree(0, 7, 11)
    toList(tree) shouldBe generateList
  }

  "PlusAssign" should "add a new element" in {
    val tree = Tree[Int]()
    toList(tree += 1) shouldBe List(1)
    toList(tree) shouldBe List(1)
  }

  "MinusAssign" should "add erase an element" in {
    val tree = Tree[Int](1, 2, 3)
    toList(tree -= 2) shouldBe List(1, 3)
    toList(tree) shouldBe List(1, 3)
  }

  "PlusPlusAssign" should "unite the trees" in {
    val tree = generateTree
    toList(tree ++= Tree(0, 7, 11)) shouldBe (List(0) ++ generateList ++ List(11))
    toList(tree) shouldBe (List(0) ++ generateList ++ List(11))
  }

  "MinusMinusAssign" should "subtract the trees" in {
    val tree = generateTree
    toList(tree --= Tree(0, 7, 11)) shouldBe generateList.filter(_ != 7)
    toList(tree) shouldBe generateList.filter(_ != 7)
  }

  "Clear" should "clear the tree" in {
    val tree = generateTree
    tree.clear()
    toList(tree) shouldBe List()
  }

  "Intersect" should "intersect two sets" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    toList(tree.intersect(anotherTree)) shouldBe List(1, 3)
  }

  "Intersect" should "not change the original tree" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    tree.intersect(anotherTree)
    toList(tree) shouldBe generateList
  }

  "Ampersand" should "intersect two sets" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    toList(tree & anotherTree) shouldBe List(1, 3)
  }

  "Ampersand" should "not change the original tree" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    tree & anotherTree
    toList(tree) shouldBe generateList
  }

  "AmpersandAssign" should "intersect the tree with another one" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    toList(tree &= anotherTree) shouldBe List(1, 3)
    toList(tree) shouldBe List(1, 3)
  }

  "Union" should "unite two sets" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 14)
    toList(tree.union(anotherTree)) shouldBe (List(0) ++ generateList ++ List(14))
  }

  "Union" should "not change the original tree" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 14)
    tree.union(anotherTree)
    toList(tree) shouldBe generateList
  }

  "Line" should "unite two sets" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 14)
    toList(tree | anotherTree) shouldBe (List(0) ++ generateList ++ List(14))
  }

  "Line" should "not change the original tree" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 14)
    tree | anotherTree
    toList(tree) shouldBe generateList
  }

  "LineAssign" should "unite the tree with another one" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 14)
    toList(tree |= anotherTree) shouldBe (List(0) ++ generateList ++ List(14))
    toList(tree) shouldBe (List(0) ++ generateList ++ List(14))
  }

  "Diff" should "subtract a tree from this one" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    toList(tree.diff(anotherTree)) shouldBe List(2, 4, 5, 6, 7, 8, 9)
  }

  "Diff" should "not change the original tree" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    tree.diff(anotherTree)
    toList(tree) shouldBe generateList
  }

  "AmpersandTilde" should "subtract a tree from this one" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    toList(tree &~ anotherTree) shouldBe List(2, 4, 5, 6, 7, 8, 9)
  }

  "AmpersandTilde" should "not change the original tree" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    tree &~ anotherTree
    toList(tree) shouldBe generateList
  }

  "AmpersandTildeAssign" should "subtract a tree from this one" in {
    val tree = generateTree
    val anotherTree = Tree(0, 1, 3, 10, 14)
    toList(tree &~= anotherTree) shouldBe List(2, 4, 5, 6, 7, 8, 9)
    toList(tree) shouldBe List(2, 4, 5, 6, 7, 8, 9)
  }

  "Apply" should "return true on elements" in {
    val tree = generateTree
    for (elem <- generateList) {
      tree(elem) shouldBe true
    }
  }

  "Apply" should "return false on extra elements" in {
    val tree = generateTree
    tree(0) shouldBe false
    tree(-1) shouldBe false
    tree(11) shouldBe false
  }

  "Update" should "add an element then the parameter is true" in {
    val tree = Tree[Int]()
    tree(10) = true
    tree(10) shouldBe true
  }

  "Update" should "remove an element then the parameter is false" in {
    val tree = Tree[Int](10, 11, 12)
    tree(10) = false
    tree(10) shouldBe false
  }

  "ForEach" should "iterate in correct order" in {
    val tree = generateTree
    val list = mutable.MutableList[Int]()
    tree.foreach(list +=)
    list shouldBe generateList
  }

  "WithFilter" should "remove all even numbers" in {
    val tree = generateTree
    toList(tree.withFilter(_ % 2 == 0)) shouldBe List(2, 4, 6, 8)
  }

  "WithFilter" should "not change the tree" in {
    val tree = generateTree
    tree.withFilter(_ % 2 == 0)
    toList(tree) shouldBe generateList
  }

  "Map" should "return a tree of strings" in {
    val tree = generateTree
    val stringTree = tree.map(x => x.toString)
    toList(stringTree) shouldBe generateList.map(x => x.toString)
  }

  "FlatMap" should "return a tree of strings" in {
    val tree = generateTree
    val mappedTree = tree.flatMap(x => Tree(x, 2 * x))
    toList(mappedTree) shouldBe generateList ++ List(10, 12, 14, 16, 18)
  }

  "IsEmpty" should "return true on an empty tree" in {
    val tree = Tree[Int]()
    tree.isEmpty shouldBe true
  }

  "IsEmpty" should "return false on an nonempty tree" in {
    val tree = generateList
    tree.isEmpty shouldBe false
  }

  "Size" should "be zero on an empty tree" in {
    val tree = Tree[Int]()
    tree.size shouldBe 0
  }

  "Size" should "be equal to the number of tree elements" in {
    val tree = generateList
    tree.size shouldBe 9
  }

  "For" should "iterate in correct order" in {
    val tree = generateTree
    val list = mutable.MutableList[Int]()
    for (elem <- tree) {
      list += elem
    }
    list shouldBe generateList
  }

  "For with If" should "remove all even numbers" in {
    val tree = generateTree
    val list = mutable.MutableList[Int]()
    for (elem <- tree if elem % 2 == 0) {
      list += elem
    }
    list shouldBe List(2, 4, 6, 8)
  }

  "For with yield" should "return a tree of strings" in {
    val tree = generateTree
    toList(for (elem <- tree) yield elem.toString) shouldBe generateList.map(x => x.toString)
  }

  "For with multiple arrows" should "return a tree of concatenated strings" in {
    val tree = Tree("1", "2", "3")
    val anotherTree = Tree("a", "b", "c")
    val result = for {
      left <- tree
      right <- anotherTree
    } yield left + right
    toList(result) shouldBe List("1a", "1b", "1c", "2a", "2b", "2c", "3a", "3b", "3c")
  }

  private def toList[T](tree: Tree[T]): mutable.MutableList[T] = {
    val result = mutable.MutableList[T]()
    tree.foreach(result +=)
    result
  }
}
