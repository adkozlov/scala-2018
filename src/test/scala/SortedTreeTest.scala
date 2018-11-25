import org.scalatest.FunSuite

import scala.collection.mutable.ListBuffer
import scala.util.Random

class SortedTreeTest extends FunSuite {
  test("Leaf has size 0") {
    assert(Leaf.size == 0)
  }

  test("Leaf depth is 0") {
    assert(Leaf.depth == 0)
  }

  test("Node with two leafs has size 1") {
    assert(Node(1, Leaf, Leaf).size == 1)
  }

  test("Node with two leafs has depth 1") {
    assert(Node(1, Leaf, Leaf).depth == 1)
  }

  test("Tree with 10 different numbers has size 10") {
    val n = 1000
    var tree: Tree[Int] = Leaf

    for (i <- 1 to n) {
      tree = Tree.add(i, tree)
      assert(isBalanced(tree))
    }

    assert(tree.size == n)
    assert(isBalanced(tree))
  }

  test("Tree is balanced when building from backward sorted numbers") {
    val n = 1000
    var tree: Tree[Int] = Leaf

    for (i <- n to 1 by -1) {
      tree = Tree.add(i, tree)
      assert(isBalanced(tree))
    }

    assert(tree.size == n)
    assert(isBalanced(tree))
  }

  test("Tree is balanced when building from randomly shuffled numbers at each step") {
    val n = 1000
    var tree: Tree[Int] = Leaf

    for (i <- Random.shuffle((1 to n).toList)) {
      tree = Tree.add(i, tree)
      assert(isBalanced(tree))
    }

    assert(tree.size == n)
    assert(isBalanced(tree))
  }

  test("You can remove elements from tree") {
    val tree = Tree(1, 2, 3, 4, 5, 6)

    val treeWithoutThree = Tree.remove(3, tree)

    assert(!Tree.contains(3, treeWithoutThree))
    assert(isBalanced(treeWithoutThree))
  }

  test("After each removal tree is balanced") {
    val n = 1000
    val numbers = Random.shuffle((1 to n).toList).toArray
    var tree: Tree[Int] = Tree(numbers: _*)

    for (i <- numbers) {
      assert(Tree.contains(i, tree))
      tree = Tree.remove(i, tree)
      assert(!Tree.contains(i, tree))
      assert(isBalanced(tree))
    }

    assert(tree.size == 0)
    assert(isBalanced(tree))
  }

  test("Tree can be collected into sorted list with for comprehension") {
    val tree = Tree(3, 1, 5, 9, 0)

    val list = ListBuffer[Int]()
    for (i <- tree) {
      list += i
    }

    assert(list === List(0, 1, 3, 5, 9))
    assert(isBalanced(tree))
  }

  test("Tree can be mapped over with a for comprehension") {
    val tree = Tree("one", "two", "three", "eleven")

    val lengths = for (s <- tree) yield s.length

    assert(lengths.size == 3)
    assert(lengths === Tree(3, 5, 6))
    assert(isBalanced(lengths))
  }

  test("Tree can be flat-mapped with a for comprehension") {
    val names = Tree("Jonh", "Alice")
    val drinks = Tree("beer", "vodka", "whiskey")

    val slogans = for {
      name <- names
      drink <- drinks
    } yield s"$name drinks $drink"

    assert(slogans.size === 6)
  }

  test("You cannot insert same value into the tree twice") {
    val tree = Tree(1, 2, 3, 4)

    assert(tree == Tree.add(1, tree))
    assert(tree == Tree.add(3, tree))
  }

  private def isBalanced[T](tree: Tree[T]): Boolean = {
    tree match {
      case Node(_, left, right) => Math.abs(left.depth - right.depth) <= 1 && isBalanced(left) && isBalanced(right)
      case Leaf => true
    }
  }

}
